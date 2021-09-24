package com.exam.footballleague.controllers;

import com.exam.footballleague.config.StaticConfig;
import com.exam.footballleague.entities.DbUser;
import com.exam.footballleague.entities.Role;
import com.exam.footballleague.models.LiveSoccer.LiveSoccer;
import com.exam.footballleague.models.UserModel;
import com.exam.footballleague.services.RestSoccerService;
import com.exam.footballleague.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    private final UserService userService;

    public WebController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "login")
    public String loginPage() {
        return "login";
    }

    @GetMapping(value = "register")
    public String registerPage(Model model) {
        model.addAttribute("userModel", new UserModel());
        return "register";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN','ROLE_MODERATOR')")
    @GetMapping(value = "logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response,auth);
        }
        return "login";
    }

    @PostMapping(value = "register")
    public String registerUser(@ModelAttribute UserModel userModel) {
        if (userModel.getPassword().equals(userModel.getConfirmPassword())) {
            List<Role> roles = new ArrayList<>();
            roles.add(StaticConfig.ROLE_USER);
            DbUser dbUser =     new DbUser(userModel.getEmail(), userModel.getPassword(), userModel.getFullName(), roles);
            userService.registerUser(dbUser);
            return "redirect:/login";
        }
        else {
            return "redirect:/register?error=1";
        }
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN','ROLE_MODERATOR')")
    @GetMapping(value = "/profile")
    public String profile(){
        return "profile";
    }

    @ModelAttribute
    public void addUser(Model model) {
        model.addAttribute("user", getUser());
    }

    private DbUser getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User securityUser = (User) authentication.getPrincipal();
            DbUser user = userService.getUser(securityUser.getUsername());
            return user;
        }
        return null;

    }
}
