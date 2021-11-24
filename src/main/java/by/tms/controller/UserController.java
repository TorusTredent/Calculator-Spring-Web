package by.tms.controller;

import by.tms.entity.User;
import by.tms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/authorization")
    public String authorization() {
        return "authorization";
    }

    @PostMapping("/authorization")
    public String authorization(String username, String password, HttpSession httpSession, Model model) {
        User user = userService.getUserUsername(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                httpSession.setAttribute("user", user);
                return "redirect:/";
            } else {
                model.addAttribute("alert", "Incorrect password entered");
            }
        } else {
            model.addAttribute("alert", "User not found");
        }
        return "authorization";
    }


    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(User user, Model model) {
        if (!userService.isExistUsername(user.getUsername())){
            userService.registrationUser(user);
            return "redirect:/user/authorization";
        } else {
            model.addAttribute("alert", "Username is already used");
        }
        return "registration";
    }
}
