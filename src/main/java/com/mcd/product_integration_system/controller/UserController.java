package com.mcd.product_integration_system.controller;

import com.mcd.product_integration_system.model.Product;
import com.mcd.product_integration_system.model.User;
import com.mcd.product_integration_system.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author mahmutcandurak
 */

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/new_user")
    public ModelAndView showNewUserForm(Model model) {
        User user = new User();
        ModelAndView mav = new ModelAndView("add_user");
        mav.addObject("user",user);
        return mav;
    }

    @RequestMapping(value="/user_save",method= RequestMethod.POST)
    public String saveNewUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/home";
    }

    @GetMapping("/users")
    public ModelAndView getUsers (Model model) {
        ModelAndView mav = new ModelAndView("users");
        List<User> userList = userService.getUsers();

        mav.addObject("userList",userList);

        return mav;
    }


    @RequestMapping("/user/edit/{id}")
    public ModelAndView editUser(@PathVariable(name="id") Long id) {
        ModelAndView mav=new ModelAndView("edit_user");
        User user = userService.getUserById(id);
        mav.addObject("user",user);
        return mav;
    }


    @RequestMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable(name="id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/home";
    }



}
