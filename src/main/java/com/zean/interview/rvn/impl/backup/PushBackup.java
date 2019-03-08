package com.zean.interview.rvn.impl.backup;

import com.zean.interview.rvn.OperatorBackup;

import java.util.Stack;

public class PushBackup implements OperatorBackup {
    @Override
    public void undo(Stack<String> currentStack) {
        currentStack.pop();
    }
}
