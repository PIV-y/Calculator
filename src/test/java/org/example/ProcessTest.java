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
   //     DigitsAmountAndValueCheck(VarTemp1);
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

}