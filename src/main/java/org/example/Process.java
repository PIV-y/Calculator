package org.example;

public class Process {
    public static void GeneralErrorCheck(String input) {
        OperatorsAmountCheck(input);
        String VarTemp1 = null;
        String VarTemp2 = null;
        int DivisionIndex = 0;
        int AmountOperators = 0;
        String operators = "+-/*";
        //поиск оператора как разделитель операндов
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < operators.length(); j++) {
                if (input.substring(i) == operators.substring(j)) {
                    if (AmountOperators > 1) {
                        System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                        Restart.YesNoQestion();
                    } else {
                        DivisionIndex = i;
                        AmountOperators++;
                        VarTemp1 = input.substring(0, i);
                    }
                }
            }
        }
        VarTemp2 = input.substring((input.length() - DivisionIndex), input.length() - 1);

        //проверка переменных на лишние символы в выражении и на однотипность
        CheckWrongInputTextAndValue(VarTemp1, VarTemp2);
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

    public static int getVar1(String input) {
        String VarTemp1 = null;
        String operators = "+-/*";
        int Var1ForCalc;
        //поиск оператора как разделитель операндов
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < operators.length(); j++) {
                if (input.substring(i) == operators.substring(j)) {
                    VarTemp1 = input.substring(0, i);
                }
            }
        }
        if (Calculator.CalculationType == 1)
            Var1ForCalc = Integer.parseInt(VarTemp1);
        else {
            Var1ForCalc = RomArabTransfer.RomToArab(VarTemp1);
        }
        return Var1ForCalc;
    }

    public static int getVar2(String input) {
        String VarTemp2 = null;
        String operators = "+-/*";
        int Var2ForCalc;
        //поиск оператора как разделитель операндов
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < operators.length(); j++) {
                if (input.substring(i) == operators.substring(j)) {
                    VarTemp2 = input.substring(i, input.length());
                }
            }
        }
        if (Calculator.CalculationType == 1)
            Var2ForCalc = Integer.parseInt(VarTemp2);
        else {
            Var2ForCalc = RomArabTransfer.RomToArab(VarTemp2);
        }
        return Var2ForCalc;
    }

    public static void OperatorsAmountCheck(String input) {
        String operators = "+-/*";
        int amount = 0;
        for (int i = 0; i < operators.length(); i++) {
            for (int j = 0; j < input.length(); j++) {
                if (operators.substring(i, i + 1).equals(input.substring(j, j + 1))) {
                    amount++;
                    if (amount > 1) {
                        System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                        Restart.YesNoQestion();
                    }
                }
            }
        }
    }
}