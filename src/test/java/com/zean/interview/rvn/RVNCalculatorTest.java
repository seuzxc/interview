package com.zean.interview.rvn;

import org.junit.Assert;
import org.junit.Test;


public class RVNCalculatorTest {

    @Test
    public void given_additionExpression_then_sumResult() {
        RVNCalculator calculator = new RVNCalculator();
        String result = calculator.addExpression("3 4 +");
        Assert.assertEquals("stack: 7", result);
    }

    @Test
    public void given_subtractionExpression_then_subtractedResult() {
        RVNCalculator calculator = new RVNCalculator();
        String result = calculator.addExpression("3 4 -");
        Assert.assertEquals("stack: -1", result);
    }

    @Test
    public void given_multiplyExpression_then_correctResult() {
        RVNCalculator calculator = new RVNCalculator();
        String result = calculator.addExpression("3 4 *");
        Assert.assertEquals("stack: 12", result);
    }

    @Test
    public void given_divideExpression_then_correctResult() {
        RVNCalculator calculator = new RVNCalculator();
        String result = calculator.addExpression("3 4 /");
        Assert.assertEquals("stack: 0.75", result);
    }

    @Test
    public void given_sqrtExpression_then_correctResult() {
        RVNCalculator calculator = new RVNCalculator();
        String result = calculator.addExpression("4 sqrt");
        Assert.assertEquals("stack: 2", result);
    }

    @Test
    public void given_clearExpression_then_correctResult() {
        RVNCalculator calculator = new RVNCalculator();
        String result = calculator.addExpression("3 4 clear");
        Assert.assertEquals("stack: ", result);
    }

    @Test
    public void given_undoExpression_then_correctResult() {
        RVNCalculator calculator = new RVNCalculator();
        String result = calculator.addExpression("3 4 undo");
        Assert.assertEquals("stack: 3", result);
    }

    @Test
    public void given_example1Input_then_expectedResult() {
        RVNCalculator calculator = new RVNCalculator();
        String result = calculator.addExpression("5 2");
        Assert.assertEquals("stack: 5 2", result);
    }

    @Test
    public void given_example2Input_then_expectedResult() {
        RVNCalculator calculator = new RVNCalculator();
        String result = calculator.addExpression("2 sqrt");
        Assert.assertEquals("stack: 1.4142135623", result);

        result = calculator.addExpression("clear 9 sqrt");
        Assert.assertEquals("stack: 3", result);
    }

    @Test
    public void given_example3Input_then_expectedResult() {
        RVNCalculator calculator = new RVNCalculator();
        String result = calculator.addExpression("5 2 -");
        Assert.assertEquals("stack: 3", result);

        result = calculator.addExpression("3 -");
        Assert.assertEquals("stack: 0", result);

        result = calculator.addExpression("clear");
        Assert.assertEquals("stack: ", result);
    }

    @Test
    public void given_example4Input_then_expectedResult() {
        RVNCalculator calculator = new RVNCalculator();
        String result = calculator.addExpression("5 4 3 2");
        Assert.assertEquals("stack: 5 4 3 2", result);

        result = calculator.addExpression("undo undo *");
        Assert.assertEquals("stack: 20", result);

        result = calculator.addExpression("5 *");
        Assert.assertEquals("stack: 100", result);

        result = calculator.addExpression("undo");
        Assert.assertEquals("stack: 20 5", result);
    }
    @Test
    public void given_example5Input_then_expectedResult() {
        RVNCalculator calculator = new RVNCalculator();
        String result = calculator.addExpression("7 12 2 /");
        Assert.assertEquals("stack: 7 6", result);

        result = calculator.addExpression("*");
        Assert.assertEquals("stack: 42", result);

        result = calculator.addExpression("4 /");
        Assert.assertEquals("stack: 10.5", result);
    }
    @Test
    public void given_example6Input_then_expectedResult() {
        RVNCalculator calculator = new RVNCalculator();
        String result = calculator.addExpression("1 2 3 4 5");
        Assert.assertEquals("stack: 1 2 3 4 5", result);

        result = calculator.addExpression("*");
        Assert.assertEquals("stack: 1 2 3 20", result);

        result = calculator.addExpression("clear 3 4 -");
        Assert.assertEquals("stack: -1", result);
    }
    @Test
    public void given_example7Input_then_expectedResult() {
        RVNCalculator calculator = new RVNCalculator();
        String result = calculator.addExpression("1 2 3 4 5");
        Assert.assertEquals("stack: 1 2 3 4 5", result);

        result = calculator.addExpression("* * * *");
        Assert.assertEquals("stack: 120", result);
    }

    @Test
    public void given_example8Input_then_expectedResult() {
        RVNCalculator calculator = new RVNCalculator();
        String result = calculator.addExpression("1 2 3 * 5 + * * 6 5");
        Assert.assertTrue(result.contains("insufficient parameters"));
    }
}
