package sistema.entregas.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistema.entregas.models.CustomerModel;
import sistema.entregas.services.CustomerService;
import sistema.entregas.services.impl.CustomerServiceImpl;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerModel>> findAll(){
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping
    public ResponseEntity<CustomerModel> findById(@PathVariable UUID id){
        return ResponseEntity.ok(customerService.getById(id));
    }
}
