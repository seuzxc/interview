package com.zean.interview.rvn.impl.calculator;

import com.zean.interview.rvn.CalculatorStore;
import com.zean.interview.rvn.OperatorBackup;
import com.zean.interview.rvn.impl.backup.NoneOperatorBackup;

public class UndoCalculator extends AbstractCalculator {

    @Override
    public OperatorBackup calculateInternal(CalculatorStore store) {
        OperatorBackup backup = store.getBackupStack().pop();
        backup.undo(store.getCalculatorStack());
        return new NoneOperatorBackup();
    }

    @Override
    public boolean checkOperand(CalculatorStore store) {
        return store.getBackupStack().size()>=1;
    }
}
