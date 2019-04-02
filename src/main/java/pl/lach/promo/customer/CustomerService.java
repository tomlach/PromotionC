package pl.lach.promo.customer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import pl.lach.promo.customer.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class CustomerService {


    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = Objects.requireNonNull(repository, "Customer must be definied");
    }

    private CustomerRepository repository;

    public Customer save(Customer customer) {
        return repository.save(customer);
    }


    public Optional<Customer> getCustomerByID(Integer id) {
        return repository.findById(id);
    }

    public List<Customer> getAll(){
        return (List<Customer>) repository.findAll();
    }


}
