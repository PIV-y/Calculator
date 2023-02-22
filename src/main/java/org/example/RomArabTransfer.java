package org.example;

public class RomArabTransfer {
    public static int RomToArab(String input){
        String[] RomanSymb = new String[]{"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        int ArabDigOfRomanSymb=0;
        for (int i = 0; i < RomanSymb.length; i++) {
            if (input.equals(RomanSymb[i])) {
                ArabDigOfRomanSymb = i + 1;
                break;
            }
            else {
                if (i==RomanSymb.length-1){
                    break;
                }
            }
        }
        return ArabDigOfRomanSymb;
    }
    public static String ArabToRom(int input){
        String[] RomanSymb = new String[]{"I","II","III","IV","V","VI","VII","VIII","IX","X","XL","L","X","XC"};
        String RomSymbOfArabDig = null;
        if
        (input<0){System.out.println("stop");
        } else if (input==0){ RomSymbOfArabDig="0";
        } else if (input>0 && input<=10){ RomSymbOfArabDig=ArabToRom_1to10(input);
        } else if (input>10 && input<=20){ RomSymbOfArabDig=ArabToRom_11to20(input);
        } else if (input>20 && input<=39){ RomSymbOfArabDig=ArabToRom_21to39(input);
        } else if (input>=40 && input<50){ RomSymbOfArabDig=ArabToRom_40to49(input);
        } else if (input>=50 && input<=89){ RomSymbOfArabDig=ArabToRom_50to89(input);
        } else if (input>=90 && input<=99){ RomSymbOfArabDig=ArabToRom_90to99(input);
        } else if (input==100){RomSymbOfArabDig="C";
        }
        return RomSymbOfArabDig;
    }
    public static String ArabToRom_1to10 (int input) {
        String[] RomanSymb = new String[]{"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        return RomanSymb[input-1];
    }
    public static String ArabToRom_11to20 (int input) {
        int dozen = 10;
        return "X"+ArabToRom_1to10(input-dozen);
    }
    public static String ArabToRom_21to39 (int input) {
        int dozens = input/10;
        String dozensStr = "";
        for (int i = 0; i < dozens; i++) {
            dozensStr = dozensStr + "X";
        }
        return dozensStr + ArabToRom_1to10(input-(10*dozens));
    }
    public static String ArabToRom_40to49 (int input) {
        int dozen = 40;
        String out = null;
        if (input==40)
            out="XL";
        else
            out = "XL" + ArabToRom_1to10(input-dozen);
        return out;
    }
    public static String ArabToRom_50to89 (int input) {
        int dozen50 = 50;
        int dozens = (input-dozen50)/10;
        String out = "L";
        if (input!=50) {
            for (int i = 0; i < dozens; i++) {
                out = out + ArabToRom_1to10(10);
            }
            out = out + ArabToRom_1to10(input-dozen50-(10*dozens));
        }
        return out;
    }
    public static String ArabToRom_90to99 (int input) {
        int dozen = 90;
        String out = null;
        if (input==90)
            out="XC";
        else
            out = "XC" + ArabToRom_1to10(input-dozen);
        return out;
    }}
