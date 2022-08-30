/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qldl.controllers;

import com.qldl.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Lenovo
 */
@Controller
public class run {

    @RequestMapping("/")						// Phương thức "get" | CallWith /?first_name=jjj&last_name=xxx
    public String index(Model model) {
        model.addAttribute("user_j", new User());
        return "baseLayout";
    }

    @RequestMapping("/homee")
    public String homee(Model model){
        return "home";
    }

}
