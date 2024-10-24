package sistema.entregas.services;

import sistema.entregas.models.CustomerModel;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<CustomerModel> getAll();
    CustomerModel getById(UUID id);
}
