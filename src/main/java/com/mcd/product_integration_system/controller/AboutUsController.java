package com.mcd.product_integration_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author mahmutcandurak
 */

@Controller
public class AboutUsController {

    @GetMapping("/about")
    public ModelAndView aboutUs() {
        ModelAndView mav = new ModelAndView("about");
        return mav;
    }

    @GetMapping("/user_about")
    public ModelAndView aboutUsUser() {
        ModelAndView mav = new ModelAndView("user_about");
        return mav;
    }


}
