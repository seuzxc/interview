package com.zean.interview.rvn.impl.backup;

import com.zean.interview.rvn.OperatorBackup;
import lombok.AllArgsConstructor;

import java.util.Stack;

/***
 * 双目操作符备份
 */

@AllArgsConstructor
public class BinocularOperatorBackup  implements OperatorBackup {
    private String firstElem;
    private String secondElem;
    public void undo(Stack<String> currentStack){
        //remove top result, redo expression
        currentStack.pop();
        currentStack.push(secondElem);
        currentStack.push(firstElem);
    }
}
