package com.zean.interview.rvn.impl.calculator;

import com.zean.interview.rvn.CalculatorStore;
import com.zean.interview.rvn.OperatorBackup;
import com.zean.interview.rvn.impl.backup.UnaryOperatorBackup;

import java.math.BigDecimal;

public class SqrtCalculator extends AbstractCalculator {


    @Override
    public OperatorBackup calculateInternal(CalculatorStore store) {
        String elem = store.getCalculatorStack().pop();
        double sqrtResult = Math.sqrt(Double.valueOf(elem));
        store.getCalculatorStack().push(String.valueOf(sqrtResult));
        return new UnaryOperatorBackup(elem);
    }

    @Override
    public boolean checkOperand(CalculatorStore store) {
        String elem = store.getCalculatorStack().peek();
        if(BigDecimal.ZERO.compareTo(new BigDecimal(elem))>0){
            return false;
        }
        return store.getCalculatorStack().size()>=1;
    }
}
