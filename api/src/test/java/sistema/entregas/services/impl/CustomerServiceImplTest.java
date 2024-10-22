package sistema.entregas.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import sistema.entregas.models.CustomerModel;
import sistema.entregas.repositories.CustomerRepository;

import java.util.List;

class CustomerServiceImplTest {
    public static final String CUSTOMER_1 = "Customer1";
    public static final String CPF1 = "11111111111";
    public static final String CUSTOMER_2 = "Customer2";
    public static final String CPF2 = "22222222222";
    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;

    private CustomerModel customer1;
    private CustomerModel customer2;

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

    void startCustomers(){
        customer1 = new CustomerModel(CUSTOMER_1, CPF1);
        customer2 = new CustomerModel(CUSTOMER_2, CPF2);
    }
}