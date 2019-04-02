package pl.lach.promo.PromoCampaign;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class PromoCampaignService {

    private List<PromoCampaign> campaigns = new ArrayList<>();
    private PromoCampaignRepository repository;

    @Autowired
    public PromoCampaignService(PromoCampaignRepository repository) {
        this.repository = Objects.requireNonNull(repository, "Customer must be definied");
    }


    public void save(PromoCampaign campaign) {
        repository.save(campaign);
//        campaigns.add(campaign);
    }

    public List<PromoCampaign> getAll() {
        return repository.findAll();
    }

    public List<PromoCampaign> getCurrenByBrands(String brand) {
        
        return repository.findByBrandAndStartBefore(brand, LocalDate.now());
        }
//        return campaigns.stream()
//                .filter(campaign -> campaign.getBrand().equals(brand))
//                .filter(campaign -> campaign.getStart().isBefore(LocalDate.now()))
//                .filter(campaign -> campaign.getEnd().isAfter(LocalDate.now()))
//                .collect(Collectors.toList());
    }


