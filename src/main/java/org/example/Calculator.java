package org.example;

import java.util.Scanner;

public class Calculator {
    //индекс типа чисел: 1 - arabic; 2 - roman
    static int CalculationType;
    public static void calculate() {
        Scanner input_obj = new Scanner(System.in);
        //Ввод данных от пользователя
        String input = input_obj.nextLine();
        //Создание объекта с атрибутами расчетной пары
        Variables CalculationPair = new Variables();
        //Проверка введеных данных на корректнось
        Process.GeneralErrorCheck(input);
        //Получение первого и второго операндов
        CalculationPair.setVar1(Process.getVar1(input));
        CalculationPair.setVar2(Process.getVar2(input));
        //Расчет
        int result =  Arithmetic.Operation(CalculationPair.getVar1(),CalculationPair.getVar2(),input);
        if (Calculator.CalculationType==1)
            System.out.println(input + " = " +result);
        else {
            System.out.println(input + " = " + RomArabTransfer.ArabToRom(result));
        }
        Restart.YesNoQestion();
    }
}