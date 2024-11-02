package sistema.entregas.services;

import sistema.entregas.dtos.CustomerRecordDto;
import sistema.entregas.models.CustomerModel;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<CustomerModel> getAll();
    CustomerModel getById(UUID id);
    CustomerModel save(CustomerRecordDto dto);
}
