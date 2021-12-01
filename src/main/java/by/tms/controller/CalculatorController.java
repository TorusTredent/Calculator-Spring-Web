package by.tms.controller;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/calculate")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping()
    public String calculate(Model model) {
        model.addAttribute("newOperation", new Operation());
        return "calc";
    }

    @PostMapping()
    public String calculate(@ModelAttribute("newOperation") @Valid Operation operation,
                            BindingResult bindingResult, HttpSession session, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("newOperation", operation);
            return "calc";
        }
        User user = (User) session.getAttribute("user");
        operation.setId(user.getId());
        double result = calculatorService.calculate(operation);
        model.addAttribute("message", operation.getManipulation() + "(" + operation.getNum1() +
                ", " + operation.getNum2() + ") " + " = " + result);
        List<String> operationList = calculatorService.getOperationList(user.getId());
        session.setAttribute("operationList", operationList);
        return "calc";
    }
}
