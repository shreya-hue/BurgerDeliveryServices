package com.accenture.lkm.web.controller;

import com.accenture.lkm.business.bean.BurgerBean;
import com.accenture.lkm.service.BurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Set;

@Controller
@RequestMapping("/burger")
public class BurgerController {
    private final BurgerService burgerService;

    @Autowired
    public BurgerController(BurgerService burgerService) {
        this.burgerService = burgerService;
    }

    @RequestMapping(value = "/showPage",method=RequestMethod.GET)
    public ModelAndView showPage() {
        ModelAndView modelAndView = new ModelAndView("orderpage");
        modelAndView.addObject("burger", new BurgerBean());
        return modelAndView;
    }

    @ModelAttribute("burgerList")
    public Set<String> getBurgers() {
        return burgerService.getBurgerDetails().keySet();
    }

    @ModelAttribute("toppingList")
    public Set<String> getToppings() {
        return burgerService.getToppingDetails().keySet();
    }

    @RequestMapping(value = "/orderBurger",method = RequestMethod.POST)
    public ModelAndView orderBurger(@ModelAttribute("burger") @Valid BurgerBean burger, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("resultpage");

        if (result.hasErrors()) {
            modelAndView.setViewName("orderpage");
            return modelAndView;
        }

        int totalBurgers = burger.getTotalBurgers();
        double totalCost = burgerService.calculateTotalCost(burger, totalBurgers);

        modelAndView.addObject("burger", burger);
        modelAndView.addObject("totalCost", totalCost);

        return modelAndView;
    }
}
