package org.example;

public class Arithmetic {
    public static int Operation (int var1, int var2, String input){
        String operator = input.substring(Process.OperatorDivisionIndex(input),Process.OperatorDivisionIndex(input)+1);
        int result = 0;
        switch (operator){
            case "*": result = var1*var2; break;
            case "/": result = var1/var2; break;
            case "+": result = var1+var2; break;
            case "-": result = var1-var2; break;
        }
        return result;
    }
}
