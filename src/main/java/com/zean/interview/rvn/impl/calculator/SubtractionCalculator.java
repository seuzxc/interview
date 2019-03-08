package com.zean.interview.rvn.impl.calculator;

import com.zean.interview.rvn.CalculatorStore;
import com.zean.interview.rvn.OperatorBackup;
import com.zean.interview.rvn.impl.backup.BinocularOperatorBackup;

import java.math.BigDecimal;

public class SubtractionCalculator extends AbstractCalculator {

    @Override
    public OperatorBackup calculateInternal(CalculatorStore store) {
        String firstElem = store.getCalculatorStack().pop();
        String secondElem = store.getCalculatorStack().pop();
        BigDecimal minuend = new BigDecimal(firstElem);
        BigDecimal subtrahend = new BigDecimal(secondElem);
        BigDecimal result = subtrahend.subtract(minuend);
        store.getCalculatorStack().push(result.toPlainString());
        return new BinocularOperatorBackup(firstElem,secondElem);
    }

    @Override
    public boolean checkOperand(CalculatorStore store) {
        return store.getCalculatorStack().size()>=2;
    }
}
