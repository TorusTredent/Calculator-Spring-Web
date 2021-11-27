package by.tms.repository;

import by.tms.entity.Operation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class CalculatorRepository {

    private final LinkedList<Operation> operationList = new LinkedList<>();

    public void saveOperation(Operation operation) {
        operationList.addLast(operation);
    }

    public List<String> getOperationList(long userId) {
        List<String> list = new ArrayList<>();
        for(Operation operation : operationList) {
            if (operation.getUserId() == userId) {
                String oper = operation.getOperation() + "(" + operation.getNum1() + ", " + operation.getNum2() + ") "
                        + " = " + operation.getResult();
                list.add(oper);
            }
        }
        return list;
    }
}
