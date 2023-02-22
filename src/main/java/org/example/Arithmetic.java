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
        if (Calculator.CalculationType==2)
            if (result<1) {
                System.out.println("Резальтатом работы калькулятора с римскими числами могут быть только положительные целые числа и не равные нулю.");
                Restart.YesNoQestion();
            }
        return result;
    }
}
