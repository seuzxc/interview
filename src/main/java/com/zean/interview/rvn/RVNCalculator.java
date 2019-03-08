package com.zean.interview.rvn;

import com.zean.interview.rvn.enums.OPERATOR;
import com.zean.interview.rvn.impl.backup.ErrorBackup;
import com.zean.interview.rvn.impl.backup.NoneOperatorBackup;
import com.zean.interview.rvn.impl.calculator.*;

import java.util.HashMap;
import java.util.Map;


public class RVNCalculator {
    private CalculatorStore store = new CalculatorStore();
    private Map<String, OperatorCalculator> calculatorMap = new HashMap<>();


    public RVNCalculator() {
        calculatorMap.put(OPERATOR.ADD.getDisplay(), new AddCalculator());
        calculatorMap.put(OPERATOR.SUBTRACTION.getDisplay(), new SubtractionCalculator());
        calculatorMap.put(OPERATOR.MULTIPLICATION.getDisplay(), new MultiplyCalculator());
        calculatorMap.put(OPERATOR.DIVISION.getDisplay(), new DivisionCalculator());
        calculatorMap.put(OPERATOR.SQRT.getDisplay(), new SqrtCalculator());
        calculatorMap.put(OPERATOR.CLEAR.getDisplay(), new ClearCalculator());
        calculatorMap.put(OPERATOR.UNDO.getDisplay(), new UndoCalculator());
        calculatorMap.put(OPERATOR.DEFAULT.getDisplay(), new DefaultPushCalculator());
    }


    public String addExpression(String expressionInput) {
        StringBuffer buffer = new StringBuffer();

        //split expressionInput to numbers or operators
        String[] splitElemArray = expressionInput.split(" ");
        //add element to stack, calculate when encounter a operator
        int errorPos = 0;
        for (String elem : splitElemArray) {
            errorPos++;
            store.setCurrentElem(elem);
            OperatorCalculator operatorCalculator = getCalculator(elem);
            OperatorBackup backup = operatorCalculator.calculate(store);
            if (backup instanceof ErrorBackup) {
                //error print error msg
                buffer.append("operator " + elem + " (position: " + errorPos + "): insufficient parameters");
                buffer.append("\n"+store.calculatorStackToString());
                return buffer.toString();
            } else if (backup instanceof NoneOperatorBackup) {
                //do nothing
            } else {
                //add undo operator info
                store.pushBackup(backup);
            }
            errorPos++;
        }

        buffer.append(store.calculatorStackToString());
        return buffer.toString();
    }

    private OperatorCalculator getCalculator(String elem) {
        OperatorCalculator operatorCalculator = calculatorMap.get(elem);
        if (operatorCalculator == null) {
            return calculatorMap.get(OPERATOR.DEFAULT.getDisplay());
        }
        return operatorCalculator;
    }


}
