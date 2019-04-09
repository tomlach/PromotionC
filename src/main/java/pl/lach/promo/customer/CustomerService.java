package pl.lach.promo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lach.promo.role.Role;
import pl.lach.promo.role.RoleRepository;

import java.util.*;


@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private RoleRepository roleRepository;



    @Autowired
    public CustomerService(CustomerRepository repository, RoleRepository roleRepository) {
        this.repository = Objects.requireNonNull(repository, "Customer must be definied");
        this.roleRepository = Objects.requireNonNull(roleRepository, "Role must be difnied");
    }

    public Customer save (Customer customer){
        Optional<Role> role = roleRepository.findByName("ROLE_USER");
        role.ifPresent(roleUser -> customer.setRoles(new HashSet<>(Arrays.asList(roleUser))));

        return repository.save(customer);
    }

    private CustomerRepository repository;

//    public Customer save(Customer customer) {
//        return repository.save(customer);
//    }


    public Optional<Customer> getCustomerByID(Integer id) {
        return repository.findById(id);
    }

    public List<Customer> getAll(){
        return (List<Customer>) repository.findAll();
    }

    public boolean existByEmail(String email){
        return repository.existsByEmail(email);
    }

    public Customer getCustomerByEmail (String email){
        return repository.findByEmail(email);
    }


}
