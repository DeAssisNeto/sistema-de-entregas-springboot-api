package sistema.entregas.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.entregas.Exceptions.RecordAlreadsExistsException;
import sistema.entregas.Exceptions.ResourceNotFoundException;
import sistema.entregas.dtos.CustomerRecordDto;
import sistema.entregas.models.CustomerModel;
import sistema.entregas.repositories.CustomerRepository;
import sistema.entregas.services.CustomerService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerModel> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerModel getById(UUID id) {
        Optional<CustomerModel> customer = customerRepository.findById(id);
        if (customer.isPresent()) return customer.get();
        throw new ResourceNotFoundException("Customer", "ID", id.toString());
    }

    @Override
    public CustomerModel save(CustomerRecordDto dto) {
        if (customerRepository.existsByCpf(dto.cpf())) {
            throw new RecordAlreadsExistsException("Customer", "CPF", dto.cpf());
        }
        return customerRepository.save(new CustomerModel(dto.name(), dto.cpf()));
    }


}
