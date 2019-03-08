package com.zean.interview.rvn.impl.calculator;

import com.zean.interview.rvn.CalculatorStore;
import com.zean.interview.rvn.OperatorBackup;
import com.zean.interview.rvn.impl.backup.BinocularOperatorBackup;

import java.math.BigDecimal;

public class AddCalculator extends AbstractCalculator {


    @Override
    public OperatorBackup calculateInternal(CalculatorStore store) {
        String firstElem = store.getCalculatorStack().pop();
        String secondElem = store.getCalculatorStack().pop();
        BigDecimal addElemOne = new BigDecimal(firstElem);
        BigDecimal addElemTwo= new BigDecimal(secondElem);
        BigDecimal result = addElemOne.add(addElemTwo);
        store.getCalculatorStack().push(result.toPlainString());

        //出栈两个元素，+，保存结果(second,firstElem,+ --> result)，如果undo的话需要做如下处理：
        //result 出栈，second入栈，first入栈，+ 不做处理

        return new BinocularOperatorBackup(firstElem,secondElem);
    }

    @Override
    public boolean checkOperand(CalculatorStore store) {
        return store.getCalculatorStack().size()>=2;
    }
}
