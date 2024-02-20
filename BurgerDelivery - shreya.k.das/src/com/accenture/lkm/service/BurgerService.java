package com.accenture.lkm.service;

import com.accenture.lkm.business.bean.BurgerBean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BurgerService {
    private final Map<String, Double> burgers;
    private final Map<String, Double> toppings;

    public BurgerService() {
        // Initialize burger details
        burgers = new HashMap<>();
        burgers.put("Veg-Burger", 100.0);
        burgers.put("Chicken-Burger", 200.0);
        burgers.put("Veg-CrunchBurger", 150.0);
        burgers.put("Chicken-CrunchBurger", 250.0);

        // Initialize topping details
        toppings = new HashMap<>();
        toppings.put("Cheese", 70.0);
        toppings.put("Dip", 50.0);
        toppings.put("Sauce", 30.0);
    }

    // Method to get burger details
    public Map<String, Double> getBurgerDetails() {
        return burgers;
    }

    // Method to get topping details
    public Map<String, Double> getToppingDetails() {
        return toppings;
    }

    // Method to calculate the total cost of the order
 
    public double calculateTotalCost(BurgerBean burgerBean) {
        double burgerCost = burgers.getOrDefault(burgerBean.getBurgerType(), 0.0);
        double toppingCost = burgerBean.getToppings().stream()
                .mapToDouble(topping -> toppings.getOrDefault(topping, 0.0))
                .sum();

        return (burgerCost + toppingCost) * burgerBean.getTotalBurgers();
    }

}

	
