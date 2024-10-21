package sistema.entregas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import sistema.entregas.models.CustomerModel;

@Configuration
@Profile(("local"))
public class LocalConfig {

    @Bean
    public void startDB(){
        CustomerModel customer1 = new CustomerModel("Klayvert","12345678912");
        CustomerModel customer2 = new CustomerModel("Leonardo", "98765432198");
    }
}
