package com.apress.prospring4.ch4.profiles.highScool;

import com.apress.prospring4.ch4.profiles.Food;
import com.apress.prospring4.ch4.profiles.FoodProviderService;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@Profile("highschool")
public class FoodProviderServiceImp implements FoodProviderService {


    public List<Food> providerLunchSet() {
        List<Food> lunchset = new ArrayList<Food>();
        lunchset.add(new Food("Coke"));
        lunchset.add(new Food("Hamburger"));
        lunchset.add(new Food("French Fries"));
       
        return lunchset;
    }
}
