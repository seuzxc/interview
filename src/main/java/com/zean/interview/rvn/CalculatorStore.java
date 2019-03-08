package com.zean.interview.rvn;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Stack;

@Getter
@Setter
public class CalculatorStore {
    private Stack<String> calculatorStack = new Stack();
    private Stack<OperatorBackup> backupStack = new Stack();
    private String currentElem;

    public String calculatorStackToString() {
        StringBuffer printResult = new StringBuffer();
        int stackSize = calculatorStack.size();
        for (int i = 0; i < stackSize; i++) {
            //如果精度超过15位数，显示10位
            BigDecimal decimal = new BigDecimal(calculatorStack.elementAt(i));
            String strElem =decimal.setScale(10,BigDecimal.ROUND_DOWN).stripTrailingZeros().toPlainString();
            printResult.append(strElem + " ");
        }
        return "stack: " + printResult.toString().trim();
    }
    public void pushNumber(String str){
        calculatorStack.push(str);
    }

    public void pushBackup(OperatorBackup backup){
        backupStack.push(backup);
    }
}
