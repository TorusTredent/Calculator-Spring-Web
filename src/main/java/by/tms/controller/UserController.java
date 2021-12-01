package by.tms.controller;

import by.tms.dto.GetUserDto;
import by.tms.dto.SaveUserDto;
import by.tms.entity.User;
import by.tms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/authorization")
    public String authorization(Model model) {
        model.addAttribute("newUser", new User());
        return "authorization";
    }

    @PostMapping("/authorization")
    public String authorization(@ModelAttribute("newUser") @Valid GetUserDto getUserDto,
                                BindingResult bindingResult, HttpSession httpSession, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("newUser", getUserDto);
            return "authorization";
        }
        User receivedUser = userService.getUserUsername(getUserDto.getUsername());
        if (receivedUser != null) {
            if (receivedUser.getPassword().equals(getUserDto.getPassword())) {
                httpSession.setAttribute("user", receivedUser);
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
    public String registration(Model model) {
        model.addAttribute("newUser", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("newUser") @Valid SaveUserDto saveUserDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("newUser", saveUserDto);
            return "registration";
        }
        if (!userService.isExistUsername(saveUserDto.getUsername())){
            User user = new User(saveUserDto.getName(), saveUserDto.getUsername(), saveUserDto.getPassword());
            userService.registrationUser(user);
            return "redirect:authorization";
        } else {
            model.addAttribute("alert", "Username is already used");
        }
        return "registration";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/";
    }
}
