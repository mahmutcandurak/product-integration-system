package com.mcd.product_integration_system.controller;

import com.mcd.product_integration_system.model.User;
import com.mcd.product_integration_system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author mahmutcandurak
 */

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;


    @GetMapping(value = {"/login", "/"})
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new User());
        return mav;
    }


    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user) {

        User authUser = loginService.login(user.getUsername(), user.getPassword());
        String auth = authUser.getAuth();

        System.out.print(authUser);
        System.out.println(auth);

        if (auth.equals("1"))
            return "redirect:/home";
        else if (auth.equals("2"))
            return "redirect:/userHome";
        else
            return "redirect:/login";
    }


    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
        return "redirect:/login";
    }
}

