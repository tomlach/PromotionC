package pl.lach.promo.customer;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@Api(value = "/", description = "Main Controller on application")
public class CustomerController {

    private CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = Objects.requireNonNull(service, "Customer must be definied");
    }

    @PostMapping("/customers")
    public ResponseEntity <Customer> save(@RequestBody Customer customer){
        return ResponseEntity.ok(service.save(customer));
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }


    }


