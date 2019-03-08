package com.zean.interview;

import com.zean.interview.rvn.RVNCalculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

@Slf4j
public class CalculatorCommandLineStarter {
    public static void main(String[] args) {
        System.err.println("**********************************************");
        System.err.println("****** this is a RVN model calculator ********");
        System.err.println("****** the support operator is (+ - * /)******");
        System.err.println("****** press quit or q will exit        ******");
        System.err.println("**********************************************");
        System.err.println("\nPlease enter the rvn expression and end with enter: \n");
        RVNCalculator calculator = new RVNCalculator();
//        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while (true) {
            try {
                line = reader.readLine();
            } catch (Exception e) {
                log.error("read line error", e);
                System.exit(1);
            }
            if ("q".equalsIgnoreCase(line) || "quit".equalsIgnoreCase(line)) {
                System.err.println("exit successfully.");
                System.exit(1);
            }
            if (StringUtils.isEmpty(line) || StringUtils.isEmpty(line.trim())) {
                continue;
            }
            String result = calculator.addExpression(line.trim());
            System.err.println(result);
            if(result.contains("insufficient parameters")){
                System.exit(-1);
            }

        }
    }
}
