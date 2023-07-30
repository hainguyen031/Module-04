package com.hainguyen.demospring.controller;

import com.hainguyen.demospring.model.User;
import com.hainguyen.demospring.service.IUserService;
import com.hainguyen.demospring.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public ModelAndView showList() {
        List<User> userList = userService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject(userList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping ("/create")
    public ModelAndView saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("message", "New user created successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user != null) {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("user", user);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("list");
            modelAndView.addObject("message", "User does not exist");
            return modelAndView;
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("user") User user) {
        userService.remove(user.getId());
        return "redirect:/user/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user != null) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("user", user);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("list");
            modelAndView.addObject("message", "User does not exist");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateCustomer(@ModelAttribute("customer") User user) {
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("user", user);
        modelAndView.addObject("message", "User updated successfully");
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam String username){
        List<User> userList = userService.searchByName(username);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject(userList);
        return modelAndView;
    }
}
