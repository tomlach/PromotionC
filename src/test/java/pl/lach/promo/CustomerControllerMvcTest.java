package pl.lach.promo;

import org.h2.engine.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.lach.promo.customer.Customer;
import pl.lach.promo.customer.CustomerController;
import pl.lach.promo.customer.CustomerService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService service;

    @Test
    public void getAll () throws Exception{
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Tom", "Lach", "brand1" ));
        customers.add(new Customer("Tom", "Lach", "brand2" ));
        customers.add(new Customer("Tom", "Lach", "brand3" ));

        when(service.getAll()).thenReturn(customers);

        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk());


}
}
