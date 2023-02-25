package org.example;

import java.util.Scanner;

public class Calculator {
    //индекс типа чисел: 1 - arabic; 2 - roman
    static int CALCULATION_TYPE;
    public static void calculate() {
        String input; //Ввод данных пользователя
        int result; //Поле результата расчета

        Scanner input_obj = new Scanner(System.in);
        input = input_obj.nextLine();

        Variables CalculationPair = new Variables(); //Создание объекта с атрибутами расчетной пары
        Process.GeneralErrorCheck(input); //Проверка введеных данных на корректнось

        CalculationPair.setVar1(Process.getVar1(input));//Получение первого операнда
        CalculationPair.setVar2(Process.getVar2(input));//Получение второго операнда

        result =  Arithmetic.Operation(CalculationPair.getVar1(),CalculationPair.getVar2(),input);//Расчет

        if (Calculator.CALCULATION_TYPE==1) {
            System.out.println(input + " = " + result);
        } else {
            System.out.println(input + " = " + RomArabTransfer.ArabToRom(result));
        }
        Restart.YesNoQestion();
    }
}