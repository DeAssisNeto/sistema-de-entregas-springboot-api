package sistema.entregas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.entregas.models.CustomerModel;
import sistema.entregas.repositories.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    public List<CustomerModel> getAll() {
        return customerRepository.findAll();
    }
}
