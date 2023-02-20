package org.example;

public class SymbTest {
    public static void main(String[] args) {

        String input = "VIII*IX";
        String var1 ="VIII";
        String var2 ="IX";

        CheckWrongInputTextAndValue(var1,var2);
/*
        boolean A = RomanSymbUseCheck(var1);
        System.out.println("var1 roman - " + A);
        A = RomanSymbUseCheck(var2);
        System.out.println("var2 roman - " + A);

        boolean A = ArabSymbUseCheck(var1);
        System.out.println("var1 arab - " + A);
        A = ArabSymbUseCheck(var2);
        System.out.println("var2 arab - " + A);
*/

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
    public static boolean RomanSymbUseCheck (String input){
        String[] RomSymb = new String[]{"I", "V", "X"};
        int NotRomSymbOrWrongCase = 0;
        boolean TrFls;
        for (int i = 0; i < input.length(); i++){
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
        if (NotRomSymbOrWrongCase>0)
            TrFls=false;
        else
            TrFls=true;

        return TrFls;
    }
    public static boolean ArabSymbUseCheck (String input){
        String[] RomSymb = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        int NotRomSymbOrWrongCase = 0;
        boolean TrFls;
        for (int i = 0; i < input.length(); i++){
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
        if (NotRomSymbOrWrongCase>0)
            TrFls=false;
        else
            TrFls=true;

        return TrFls;
    }
    public static void ValueCheck(int var1, int var2) {
        if (var1 >= 1 && var1 <= 10 && var2 >= 1 && var2 <= 10) {
        } else {
            System.out.println("Калькулятор принимает на вход числа от 1 до 10 включительно, не более.");
            Restart.YesNoQestion();
        }
    }

}
