package sistema.entregas.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.entregas.models.CustomerModel;
import sistema.entregas.repositories.CustomerRepository;
import sistema.entregas.services.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerModel> getAll() {
        return customerRepository.findAll();
    }
}
