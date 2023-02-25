package org.example;

import java.util.Scanner;

public class Restart {
    public static void YesNoQestion() {
        Scanner AnswVar = new Scanner(System.in);

        System.out.println("Приступить к расчету заново? \ny - да; \nn - работа будет завершена.");
        String AnswTxt = AnswVar.nextLine();

        if (AnswTxt.equalsIgnoreCase("y")) {
            Calculator.calculate();
        }
        else {
                System.out.println("Расчет будет завершен");
                System.exit(0);
        }
    }
}