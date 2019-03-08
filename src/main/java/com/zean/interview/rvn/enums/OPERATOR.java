package com.zean.interview.rvn.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum OPERATOR {
    ADD("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    SQRT("sqrt"),
    UNDO("undo"),
    CLEAR("clear"),
    DEFAULT("push"); //push element

    OPERATOR(String display) {
        this.display = display;
    }

    //private static List<String> supportOperators = Arrays.stream(OPERATOR.values()).map(elem -> elem.getDisplay()).collect(Collectors.toList());

    private String display;

//    public static boolean isOperator(String operator) {
//        return supportOperators.contains(operator);
//    }
}
