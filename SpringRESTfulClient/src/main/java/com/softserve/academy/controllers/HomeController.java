package com.softserve.academy.controllers;

//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
public class HomeController {

    @RequestMapping({"/", "/home"})
    public String homePage() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

//    @RequestMapping(value="/logout", method = RequestMethod.GET)
//    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/home";
//    }
//
//    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
//    public String accessDenied(Principal user, ModelMap model) {
//        if (user != null) {
//            model.addAttribute("message", "Hi " + user.getName() + ", you do not have permission to access this page!");
//        } else {
//            model.addAttribute("message", "You do not have permission to access this page!");
//        }
//
//        return "accessDenied";
//    }
}