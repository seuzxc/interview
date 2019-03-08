package com.zean.interview.rvn;

/***
 * to operate the single Operator(+-*\/ sqrt clear undo etc) function
 */
public interface OperatorCalculator {

    OperatorBackup calculate(CalculatorStore store);

}
