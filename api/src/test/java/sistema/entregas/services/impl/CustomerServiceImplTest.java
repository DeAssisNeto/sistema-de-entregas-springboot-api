package sistema.entregas.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import sistema.entregas.Exceptions.ResourceNotFoundException;
import sistema.entregas.models.CustomerModel;
import sistema.entregas.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

class CustomerServiceImplTest {
    public static final String CUSTOMER_1 = "Customer1";
    public static final String CPF1 = "11111111111";
    public static final String CUSTOMER_2 = "Customer2";
    public static final String CPF2 = "22222222222";
    public static final UUID id1 = UUID.randomUUID();
    public static final UUID id2 = UUID.randomUUID();
    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;

    private CustomerModel customer1;
    private CustomerModel customer2;
    private Optional<CustomerModel> customerOptional;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        startCustomers();
    }

    @Test
    void whenGetAllThenReturnListOfCustomers() {
        List<CustomerModel> mockCustomers = List.of(customer1, customer2);
        Mockito.when(customerRepository.findAll()).thenReturn(mockCustomers);

        List<CustomerModel> result = customerService.getAll();
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(customer1, result.get(0));
        Assertions.assertEquals(customer2, result.get(1));

        Mockito.verify(customerRepository).findAll();
    }

    @Test
    void whenGetCustomerByIdThenReturnCustomerModel() {
        Mockito.when(customerRepository.findById(id1)).thenReturn(customerOptional);

        CustomerModel result = customerService.getById(id1);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(CustomerModel.class, result.getClass());
        Assertions.assertEquals(id1, result.getId());
        Assertions.assertEquals(CUSTOMER_1, result.getName());
        Assertions.assertEquals(CPF1, result.getCpf());

    }

    @Test
    void whenGetCustomerByIdThenReturnResourceNotFoundException() {
        UUID uuid = UUID.randomUUID();
        Mockito.when(customerRepository.findById(uuid))
                .thenThrow(new ResourceNotFoundException("Customer", "ID", uuid.toString()));

        try {
            customerService.getById(uuid);
        }catch (ResourceNotFoundException e){
            Assertions.assertEquals(ResourceNotFoundException.class, e.getClass());
            Assertions.assertEquals(String
                    .format("Recurso %s não encontrado com %s = %s", "Customer", "ID", uuid), e.getMessage());
            Assertions.assertThrows(ResourceNotFoundException.class, () -> customerService.getById(uuid));

        }

    }

    void startCustomers(){
        customer1 = new CustomerModel(id1, CUSTOMER_1, CPF1);
        customer2 = new CustomerModel(id2, CUSTOMER_2, CPF2);
        customerOptional = Optional.of(new CustomerModel(id1, CUSTOMER_1, CPF1));
    }
}