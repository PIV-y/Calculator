package org.example;

import java.util.Scanner;

public class Calculator {
    //calculation types: 1 - arabic; 2 - roman
    static int CalculationType;

    public static void calculate() {
        Scanner input_obj = new Scanner(System.in);
        String input = input_obj.nextLine();
        Variables CalculationPair = new Variables();
        Process.GeneralErrorCheck(input);
        CalculationPair.setVar1(Process.getVar1(input));
        CalculationPair.setVar1(Process.getVar2(input));

        int result =  Arithmetic.Operation(CalculationPair.getVar1(),CalculationPair.getVar2(),input);
        if (Calculator.CalculationType==1)
            System.out.println(input + " = " +result);
        else {
            System.out.println(input + " = " + RomArabTransfer.ArabToRom(result));
        }
    }
}