package sistema.entregas.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sistema.entregas.models.CustomerModel;
import sistema.entregas.services.impl.CustomerServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @GetMapping
    public ResponseEntity<List<CustomerModel>> findAll(){
        return ResponseEntity.ok(customerServiceImpl.getAll());
    }
}
