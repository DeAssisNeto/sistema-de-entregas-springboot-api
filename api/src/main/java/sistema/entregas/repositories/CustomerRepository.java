package sistema.entregas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema.entregas.models.CustomerModel;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerModel, UUID> {
}
