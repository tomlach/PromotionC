package pl.lach.promo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import pl.lach.promo.customer.Customer;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
    @SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
    public class CustomerControllerTest {

        @LocalServerPort
        private int port;

        @Autowired
        private TestRestTemplate restTemplate;

        @Test
        public void customerShouldBeSaved(){
            Customer customer= new Customer();
            customer.setName("Tom");
            customer.setLastName("Lach");
            customer.setBrand("brand");

              ResponseEntity<Customer> response= restTemplate.postForEntity("http://localhost:" + port + "/customers", customer, Customer.class);
              assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
              response.getBody();

        }


    }


