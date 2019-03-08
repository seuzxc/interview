package com.zean.interview.rvn.impl.calculator;

import com.zean.interview.rvn.CalculatorStore;
import com.zean.interview.rvn.OperatorBackup;
import com.zean.interview.rvn.impl.backup.PushBackup;

import java.math.BigDecimal;

public class DefaultPushCalculator extends AbstractCalculator {
    @Override
    public OperatorBackup calculateInternal(CalculatorStore store) {
        store.getCalculatorStack().push(store.getCurrentElem());
        return new PushBackup();
    }

    @Override
    public boolean checkOperand(CalculatorStore store) {
        return isValidNumber(store.getCurrentElem());
    }


    private boolean isValidNumber(String elem) {
        try {
            new BigDecimal(elem);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
