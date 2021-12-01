package by.tms.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Component
public class Operation {
    private long id;
    
    @NotBlank(message = "Field number is empty")
    @Pattern(regexp = "^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$", message = "Incorrect number input")
    private String num1;
    
    @NotBlank(message = "Field number is empty")
    @Pattern(regexp = "^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$", message = "Incorrect number input")
    private String num2;

    @NotBlank(message = "Choose some operation")
    private String manipulation;

    private String result;
    private long userId;

    @Autowired
    public Operation() {
    }

    public Operation(String num1, String num2, String manipulation, String result, long userId) {
        this.num1 = num1;
        this.num2 = num2;
        this.manipulation = manipulation;
        this.result = result;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getManipulation() {
        return manipulation;
    }

    public void setManipulation(String operation) {
        this.manipulation = operation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
