package com.mcd.product_integration_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author mahmutcandurak
 */

@Controller
public class HomePageController {

    @GetMapping("/home")
    public String getHomePage() {
        return "home_page";
    }


}
