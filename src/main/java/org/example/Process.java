package org.example;

public class Process {
    public static void GeneralErrorCheck(String input) {
        //Проверка колличества операторов в вырожении
        OperatorsAmountCheck(input);
        //Определение индекса оператора для разделения операндов
        int DivisionIndex = OperatorDivisionIndex(input);
        //Деление введеного выражение на операнды вокруг оператора с созданием строковвых полей
        String VarTemp1 = input.substring(0,DivisionIndex);
        String VarTemp2 = input.substring(DivisionIndex+1, input.length());
        //Проверка на однотипность введеных данных и их значени в рамках от 1 до 10 включительно
        CheckWrongInputTextAndValue(VarTemp1,VarTemp2);
    }
    public static void CheckWrongInputTextAndValue(String var1, String var2) {
        if (ArabSymbUseCheck(var1)) {
            if (ArabSymbUseCheck(var2)) {
                Calculator.CALCULATION_TYPE = 1;
                isEmptyString(var1,var2);
                ValueCheck(Integer.parseInt(var1), Integer.parseInt(var2));
            } else {
                System.out.println("Калькулятор умеет работать только с арабскими или римскими символами одновременно.");
                Restart.YesNoQestion();
            }
        } else {
            if (RomanSymbUseCheck(var1)) {
                if (RomanSymbUseCheck(var2)) {
                    Calculator.CALCULATION_TYPE = 2;
                    ValueCheck(RomArabTransfer.RomToArab(var1), RomArabTransfer.RomToArab(var2));
                } else {
                    System.out.println("Калькулятор умеет работать только с арабскими или римскими символами одновременно.");
                    Restart.YesNoQestion();
                }
            } else {
                System.out.println("Калькулятор умеет работать только с арабскими или римскими символами одновременно.");
                Restart.YesNoQestion();
            }
        }
    }

    public static boolean RomanSymbUseCheck(String input) {
        String[] RomSymb = new String[]{"I", "V", "X"};
        int NotRomSymbOrWrongCase = 0;
        boolean TrFls;
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < RomSymb.length; j++) {
                if (input.substring(i,i+1).equals(RomSymb[j])){
                    break;
                }
                else {
                    if (j==RomSymb.length-1)
                        NotRomSymbOrWrongCase++;
                }
            }
        }
        if (NotRomSymbOrWrongCase>0) {
            TrFls=false;
        }
        else {
            TrFls=true;
        }
        return TrFls;
    }

    public static boolean ArabSymbUseCheck(String input) {
        String[] RomSymb = new String[]{"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        int NotRomSymbOrWrongCase = 0;
        boolean TrFls;
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < RomSymb.length; j++) {
                if (input.substring(i,i+1).equals(RomSymb[j])){
                    break;
                }
                else {
                    if (j==RomSymb.length-1) {
                        NotRomSymbOrWrongCase++;
                    }
                }
            }
        }
        if (NotRomSymbOrWrongCase>0) {
            TrFls = false;
        }
        else {
            TrFls = true;
        }
        return TrFls;
    }

    public static void ValueCheck(int var1, int var2) {
        if (var1 >= 1 && var1 <= 10 && var2 >= 1 && var2 <= 10) {}
        else {
            System.out.println("Калькулятор принимает на вход числа по значению от 1 до 10 включительно, не более.");
            Restart.YesNoQestion();
        }
    }

    public static int getVar1(String input) {
        int Var1ForCalc = 0;
        if (Calculator.CALCULATION_TYPE == 1)
            Var1ForCalc = Integer.parseInt(input.substring(0,OperatorDivisionIndex(input)));
        else if (Calculator.CALCULATION_TYPE == 2)
            Var1ForCalc = RomArabTransfer.RomToArab(input.substring(0,OperatorDivisionIndex(input)));
        else {
            System.out.println("Введенные данные не корректны.");
            Restart.YesNoQestion();
        }
        return Var1ForCalc;
    }

    public static int getVar2(String input) {
        int Var2ForCalc = 0;
        if (Calculator.CALCULATION_TYPE == 1) {
            Var2ForCalc = Integer.parseInt(input.substring(OperatorDivisionIndex(input) + 1, input.length()));
        }
        else if (Calculator.CALCULATION_TYPE == 2) {
            Var2ForCalc = RomArabTransfer.RomToArab(input.substring(OperatorDivisionIndex(input) + 1, input.length()));
        }
        else {
            System.out.println("Введенные данные не корректны.");
            Restart.YesNoQestion();
        }
        return Var2ForCalc;
    }

    public static void OperatorsAmountCheck(String input) {
        String operators = "+-/*";
        int amount = 0;
        for (int i = 0; i < operators.length(); i++) {
            for (int j = 0; j < input.length(); j++) {
                if (operators.substring(i,i+1).equals(input.substring(j,j+1))) {
                    amount++;
                    if (amount > 1) {
                        System.out.println("Выражения принимаются по формату a+b, a-b, a*b, a/b, где 1 оператор и 2 операнда.");
                        Restart.YesNoQestion();
                    }
                }
                else{
                    if (i==operators.length()-1 && j==input.length()-1 && amount<1) {
                        System.out.println("Выражения принимаются по формату a+b, a-b, a*b, a/b, где 1 оператор и 2 операнда.");
                        Restart.YesNoQestion();
                    }
                }
            }
        }
    }

    public static int OperatorDivisionIndex(String input) {
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

    public static void isEmptyString(String var1, String var2) {
        if (var1.equals("")){
            System.out.println("Выражения принимаются по формату a+b, a-b, a*b, a/b, где 1 оператор и 2 операнда.");
            Restart.YesNoQestion();
        }
        if (var2.equals("")){
            System.out.println("Выражения принимаются по формату a+b, a-b, a*b, a/b, где 1 оператор и 2 операнда.");
            Restart.YesNoQestion();
        }
    }
}