package sistema.entregas.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistema.entregas.dtos.CustomerRecordDto;
import sistema.entregas.models.CustomerModel;
import sistema.entregas.services.CustomerService;

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

    @GetMapping("{id}")
    public ResponseEntity<CustomerModel> findById(@PathVariable UUID id){
        return ResponseEntity.ok(customerService.getById(id));
    }

    @PostMapping
    public ResponseEntity<CustomerModel> save(@RequestBody CustomerRecordDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(dto));
    }
}
