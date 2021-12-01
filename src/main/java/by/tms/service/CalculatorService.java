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

    public double calculate(Operation operation) {
        double numDouble1 = Double.parseDouble(operation.getNum1());
        double numDouble2 = Double.parseDouble(operation.getNum2());
        switch (operation.getManipulation()) {
            case "sum": {
                double result = numDouble1 + numDouble2;
                operation.setResult(String.valueOf(result));
                calcRepository.saveOperation(operation);
                return result;
            }
            case "sub": {
                double result = numDouble1 - numDouble2;
                operation.setResult(String.valueOf(result));
                calcRepository.saveOperation(operation);
                return result;
            }
            case "div": {
                double result = numDouble1 / numDouble2;
                operation.setResult(String.valueOf(result));
                calcRepository.saveOperation(operation);
                return result;
            }
            case "multiply": {
                double result = numDouble1 * numDouble2;
                operation.setResult(String.valueOf(result));
                calcRepository.saveOperation(operation);
                return result;
            }
         }
         return 0;
    }

    public List<String> getOperationList(long userId) {
        return calcRepository.getOperationList(userId);
    }
}
