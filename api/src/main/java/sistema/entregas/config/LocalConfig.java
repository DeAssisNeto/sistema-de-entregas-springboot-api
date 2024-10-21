package sistema.entregas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import sistema.entregas.models.CustomerModel;
import sistema.entregas.repositories.CustomerRepository;

import java.util.List;

@Configuration
@Profile(("local"))
public class LocalConfig {
    @Autowired
    private CustomerRepository customerRepository;

    @Bean
    public void startDB(CustomerRepository customerRepository){
        CustomerModel customer1 = new CustomerModel("Klayvert","12345678912");
        CustomerModel customer2 = new CustomerModel("Leonardo", "98765432198");

        customerRepository.saveAll(List.of(customer1, customer2));
    }
}
