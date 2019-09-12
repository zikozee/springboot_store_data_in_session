package com.zikozee.srpingboot.sessionstorage.controller;

import com.zikozee.srpingboot.sessionstorage.model.Grocery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ItemsController {
    @GetMapping("/listItem")
    public String listItems(@SessionAttribute("groceryData") Grocery grocery, Model model){
        model.addAttribute("cart", grocery);

        return "itemList";
    }
}
