package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class ProcessTest {

    @Test
    void generalErrorCheck() {
        String input = "VIII*IX";

        OperatorsAmountCheck(input);
        int DivisionIndex = OperatorDevisionIndex(input);
        String VarTemp1 = input.substring(0,DivisionIndex);
        String VarTemp2 = input.substring(DivisionIndex+1,input.length());
        CheckWrongInputTextAndValue(VarTemp1,VarTemp2);
    //    DigitsAmountAndValueCheck(VarTemp1);
    //    DigitsAmountAndValueCheck(VarTemp2);

        System.out.println(VarTemp1);
        System.out.println(VarTemp2);
    }

    public static void OperatorsAmountCheck (String input) {
        String operators = "+-/*";
        int amount = 0;
        for (int i = 0; i < operators.length(); i++) {
            for (int j = 0; j < input.length(); j++)
            {
                if (operators.substring(i,i+1).equals(input.substring(j,j+1)))
                {
                    amount++;
                    if (amount > 1) System.out.println("stop");
                }
            }
        }
    }
    public static void CheckWrongInputTextAndValue(String var1, String var2) {
        if (ArabSymbUseCheck(var1)) {
            if (ArabSymbUseCheck(var2)) {
                Calculator.CalculationType = 1;
                ValueCheck(Integer.parseInt(var1), Integer.parseInt(var2));
            } else {
                System.out.println("Калькулятор умеет работать только с арабскими или римскими цифрами одновременно.");
                Restart.YesNoQestion();
            }
        } else {
            if (RomanSymbUseCheck(var1)) {
                if (RomanSymbUseCheck(var2)) {
                    Calculator.CalculationType = 2;
                    ValueCheck(RomArabTransfer.RomToArab(var1), RomArabTransfer.RomToArab(var2));
                } else {
                    System.out.println("Калькулятор умеет работать только с арабскими или римскими цифрами одновременно.");
                    Restart.YesNoQestion();
                }
            } else {
                System.out.println("Калькулятор умеет работать только с арабскими или римскими цифрами одновременно.");
                Restart.YesNoQestion();
            }
        }
    }
    public static void DigitsAmountAndValueCheck (String input) {
   }
    public static int OperatorDevisionIndex (String input) {
        int indx = 0;
        String operators = "+-/*";
        //поиск оператора как разделитель операндов
        for (int i = 0; i <input.length(); i++) {
            for (int j = 0; j <operators.length(); j++) {
                if (input.substring(i,i+1).equals(operators.substring(j,j+1))) {
                        indx=i;
                }
            }
        }
        return indx;
    }
    public static boolean RomanSymbUseCheck(String input) {
        String[] RomSymb = new String[]{"I", "V", "X"};
        int TempVar = 0;
        for (int i = 0; i < input.length(); i++)
            for (int j = 0; j < RomSymb.length; j++) {
                if (input.substring(i).equals(RomSymb[j]))
                    continue;
                else
                    TempVar++;
            }

        return true;
    }
    public static boolean ArabSymbUseCheck(String input) {
        boolean isFullyArab = false;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(Integer.parseInt(input.substring(i))))
                isFullyArab = true;
            else
                isFullyArab = false;
        }
        return isFullyArab;
    }
    public static void ValueCheck(int var1, int var2) {
        if (var1 >= 1 && var1 <= 10 && var2 >= 1 && var2 <= 10) {
        } else {
            System.out.println("Калькулятор принимает на вход числа от 1 до 10 включительно, не более.");
            Restart.YesNoQestion();
        }
    }

}