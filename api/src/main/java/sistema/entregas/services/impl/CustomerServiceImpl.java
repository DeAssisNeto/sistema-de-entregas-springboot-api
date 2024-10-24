package sistema.entregas.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return null;
    }


}
