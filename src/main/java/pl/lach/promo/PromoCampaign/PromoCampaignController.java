package pl.lach.promo.PromoCampaign;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lach.promo.customer.Customer;
import pl.lach.promo.customer.CustomerService;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@Api(value = "/", description = "Main Controller on application")
public class PromoCampaignController {


    private PromoCampaignService service;
    private CustomerService customerService;

    @Autowired
    public PromoCampaignController(PromoCampaignService service, CustomerService customerService) {
        this.service = Objects.requireNonNull(service, "Campaign Service must be definied");
        this.customerService = Objects.requireNonNull(customerService, "Customer Service must be definied");
    }

    @PostMapping("/campaigns")
    public ResponseEntity save(@RequestBody PromoCampaign campaign) {
        Optional<Customer> customer = customerService.getCustomerByID(campaign.getCustomerID());

        if (customer.isPresent()) {
            if (customer.get().getBrand().equals(campaign.getBrand())) {
                service.save(campaign);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.badRequest().body("Invalid customer brand");
            }
        } else {
            return ResponseEntity.badRequest().body("Invalid customer id");
        }
//        return ResponseEntity.ok().build();
    }

    @GetMapping("/campaigns")
    public ResponseEntity<List<PromoCampaign>> getAll() {
        return ResponseEntity.ok(service.getAll());

    }

    @GetMapping("/campaigns/current/{brand}")
    public ResponseEntity<List<PromoCampaign>> getByBrand(@PathVariable String brand) {
        return ResponseEntity.ok(service.getCurrenByBrands(brand));
//@GetMapping("/campaigns/current/{brand}")
//public ResponseEntity<List<PromoCampaign>> getByBrand(@PathVariable String brand,@PathVariable String when) {
//    if (when.equals("current")) {
//        return ResponseEntity.ok(service.getCurrenByBrands(brand, LocalDate.now(), LocalDate.now() ));
//    }else if(when.equals("past")){
//    return ResponseEntity.ok(service.getCurrenByBrands(brand, LocalDate.now(), LocalDate.now()));
//    }else if(when.equals("future")){
//        return ResponseEntity.ok(service.getCurrenByBrands(brand, LocalDate.now());
    }
}
