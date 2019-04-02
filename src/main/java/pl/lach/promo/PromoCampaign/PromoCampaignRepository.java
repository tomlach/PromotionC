package pl.lach.promo.PromoCampaign;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface PromoCampaignRepository extends CrudRepository<PromoCampaign, Integer>{

    List<PromoCampaign> findAll ();

    List<PromoCampaign> findByBrandAndStartBefore(String brand, LocalDate data);


}
