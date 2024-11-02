package sistema.entregas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistema.entregas.models.CustomerModel;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, UUID> {
    boolean existsByCpf(String cpf);
}
