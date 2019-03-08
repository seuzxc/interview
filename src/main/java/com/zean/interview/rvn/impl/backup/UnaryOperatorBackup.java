package com.zean.interview.rvn.impl.backup;

import com.zean.interview.rvn.OperatorBackup;
import lombok.AllArgsConstructor;

import java.util.Stack;

/***
 * 单目操作符备份
 */

@AllArgsConstructor
public class UnaryOperatorBackup implements OperatorBackup {

    private String firstElem;

    @Override
    public void undo(Stack<String> currentStack) {
        currentStack.pop();
        currentStack.push(firstElem);
    }
}
