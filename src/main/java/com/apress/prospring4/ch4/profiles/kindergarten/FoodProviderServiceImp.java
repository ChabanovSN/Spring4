package com.apress.prospring4.ch4.profiles.kindergarten;

import com.apress.prospring4.ch4.profiles.Food;
import com.apress.prospring4.ch4.profiles.FoodProviderService;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@Profile("kindergarten")
public class FoodProviderServiceImp implements FoodProviderService {


    public List<Food> providerLunchSet() {
        List<Food> lunchset = new ArrayList<Food>();
        lunchset.add(new Food("Milk"));
        lunchset.add(new Food("Biscuits"));

        return lunchset;
    }
}
