package com.zikozee.srpingboot.sessionstorage.controller;

import com.zikozee.srpingboot.sessionstorage.model.Grocery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("groceryData")
public class GroceryController {

    @GetMapping("/")
    public String LandingPage(){
        return "redirect:/groceryItemPage";
    }

    @PostMapping("/add")
    public String addToGroceryList(Model model, @ModelAttribute("groceryData") Grocery grocery){


        model.addAttribute("cart", grocery);
        return "redirect:/groceryItemPage";
    }

    @GetMapping("/groceryItemPage")
    public String viewPage(Model model, @ModelAttribute("groceryData") Grocery grocery){
        if(grocery != null){
            model.addAttribute("cart", grocery);
        }else{
            model.addAttribute("cart", new Grocery());
        }
        return "grocery";
    }

    @ModelAttribute("groceryData")
    public Grocery grocery(){
        return  new Grocery();
    }

}
