package com.zean.interview.rvn.impl.calculator;

import com.zean.interview.rvn.CalculatorStore;
import com.zean.interview.rvn.OperatorBackup;
import com.zean.interview.rvn.OperatorCalculator;
import com.zean.interview.rvn.impl.backup.ErrorBackup;

public  abstract class AbstractCalculator implements OperatorCalculator {
    @Override
    public OperatorBackup calculate(CalculatorStore store) {
        if(checkOperand(store)){
            return calculateInternal(store);
        }else{
            return new ErrorBackup();
        }
    }

    public abstract OperatorBackup calculateInternal(CalculatorStore store);


    public abstract boolean checkOperand(CalculatorStore store);
}
