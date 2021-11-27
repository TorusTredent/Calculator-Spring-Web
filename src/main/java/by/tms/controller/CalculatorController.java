package by.tms.controller;

import by.tms.entity.User;
import by.tms.service.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }


    @GetMapping("/calculate")
    public String calculate() {
        return "calc";
    }

    @PostMapping("/calculate")
    public String calculate(String num1, String num2, String operation, HttpSession session, Model model) {
        if (num1 != null && num2 != null && operation != null) {
            if (isValueDouble(num1, num2)) {
                User user = (User) session.getAttribute("user");
                double result = calculatorService.calculate(num1, num2, operation, user.getId());
                model.addAttribute("message", operation + "(" + num1 + ", " + num2 + ") "
                        + " = " + result);
            } else {
                model.addAttribute("alert", "Incorrect numbers input");
            }
        } else {
            model.addAttribute("alert", "Fields is empty");
        }
        return "calc";
    }

    @GetMapping("/showHistory")
    public String showHistory(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<String> operationList = calculatorService.getOperationList(user.getId());
        model.addAttribute("operationList", operationList);
        return "calc";
    }

    @GetMapping("/hideHistory")
    public String hideHistory(Model model) {
        model.addAttribute("operationList", null);
        return "calc";
    }


    private boolean isValueDouble(String num1, String num2) {
        try {
            double num1Double = Double.parseDouble(num1);
            double num2Double = Double.parseDouble(num2);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
