package com.zean.interview.rvn.impl.calculator;

import com.zean.interview.rvn.CalculatorStore;
import com.zean.interview.rvn.OperatorBackup;
import com.zean.interview.rvn.constants.ConstantsForCalculator;
import com.zean.interview.rvn.impl.backup.BinocularOperatorBackup;

import java.math.BigDecimal;

public class MultiplyCalculator extends AbstractCalculator {

    @Override
    public OperatorBackup calculateInternal(CalculatorStore store) {
        String firstElem = store.getCalculatorStack().pop();

        String secondElem = store.getCalculatorStack().pop();
        BigDecimal multiplyFactorOne = new BigDecimal(firstElem);
        BigDecimal multiplyFactorTwo = new BigDecimal(secondElem);
        BigDecimal result = multiplyFactorTwo.multiply(multiplyFactorOne).setScale(ConstantsForCalculator.STACK_NUMBER_STORE_PRECISION,BigDecimal.ROUND_HALF_UP);
        store.getCalculatorStack().push(result.toPlainString());
        return new BinocularOperatorBackup(firstElem, secondElem);
    }

    @Override
    public boolean checkOperand(CalculatorStore store) {
        return store.getCalculatorStack().size()>=2;
    }

}
