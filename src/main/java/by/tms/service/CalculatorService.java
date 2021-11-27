package by.tms.service;

import by.tms.entity.Operation;
import by.tms.repository.CalculatorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService {

    private final CalculatorRepository calcRepository;

    public CalculatorService(CalculatorRepository calcRepository) {
        this.calcRepository = calcRepository;
    }

    public double calculate(String num1, String num2, String operation, long userid) {
        double numDouble1 = Double.parseDouble(num1);
        double numDouble2 = Double.parseDouble(num2);
        switch (operation) {
            case "sum": {
                double result = numDouble1 + numDouble2;
                calcRepository.saveOperation(new Operation(num1, num2, operation, String.valueOf(result), userid));
                return result;
            }
            case "sub": {
                double result = numDouble1 - numDouble2;
                calcRepository.saveOperation(new Operation(num1, num2, operation, String.valueOf(result), userid));
                return result;
            }
            case "div": {
                double result = numDouble1 / numDouble2;
                calcRepository.saveOperation(new Operation(num1, num2, operation, String.valueOf(result), userid));
                return result;
            }
            case "multiply": {
                double result = numDouble1 * numDouble2;
                calcRepository.saveOperation(new Operation(num1, num2, operation, String.valueOf(result), userid));
                return result;
            }
         }
         return 0;
    }

    public List<String> getOperationList(long userId) {
        return calcRepository.getOperationList(userId);
    }
}
