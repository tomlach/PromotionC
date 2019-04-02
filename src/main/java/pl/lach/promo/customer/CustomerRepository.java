package pl.lach.promo.customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository <Customer, Integer> {

    List<Customer> findAll();

}

