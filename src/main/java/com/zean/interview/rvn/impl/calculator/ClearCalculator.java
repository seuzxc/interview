package com.zean.interview.rvn.impl.calculator;

import com.zean.interview.rvn.CalculatorStore;
import com.zean.interview.rvn.OperatorBackup;
import com.zean.interview.rvn.impl.backup.NoneOperatorBackup;

/***
 * 不支持undo
 */
public class ClearCalculator extends AbstractCalculator {


    @Override
    public OperatorBackup calculateInternal(CalculatorStore store) {
        store.getCalculatorStack().clear();
        return new NoneOperatorBackup();
    }

    @Override
    public boolean checkOperand(CalculatorStore store) {
        return true;
    }
}
