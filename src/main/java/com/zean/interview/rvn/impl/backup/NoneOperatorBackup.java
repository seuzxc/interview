package com.zean.interview.rvn.impl.backup;

import com.zean.interview.rvn.OperatorBackup;

import java.util.Stack;

/**
 * 什么都不做的操作backup( like clear operator)
 */
public class NoneOperatorBackup implements OperatorBackup {
    @Override
    public void undo(Stack<String> currentStack) {

    }
}
