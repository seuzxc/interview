package com.zean.interview.rvn.impl.calculator;

import com.zean.interview.rvn.CalculatorStore;
import com.zean.interview.rvn.OperatorBackup;
import com.zean.interview.rvn.constants.ConstantsForCalculator;
import com.zean.interview.rvn.impl.backup.BinocularOperatorBackup;

import java.math.BigDecimal;

public class DivisionCalculator extends AbstractCalculator {

    @Override
    public OperatorBackup calculateInternal(CalculatorStore store) {
        String firstElem = store.getCalculatorStack().pop();
        String secondElem = store.getCalculatorStack().pop();
        BigDecimal numerator = new BigDecimal(firstElem); //被除数
        BigDecimal denominator = new BigDecimal(secondElem);//除数
        BigDecimal result = denominator.divide(numerator, ConstantsForCalculator.STACK_NUMBER_STORE_PRECISION, BigDecimal.ROUND_HALF_UP);
        store.getCalculatorStack().push(result.toPlainString());
        return new BinocularOperatorBackup(firstElem, secondElem);
    }

    @Override
    public boolean checkOperand(CalculatorStore store) {
        if (store.getCalculatorStack().size() < 2) {
            return false;
        }
        //被除数为0
        String elem = store.getCalculatorStack().peek();
        if (BigDecimal.ZERO.compareTo(new BigDecimal(elem)) == 0) {
            return false;
        }
        return true;
    }

}
