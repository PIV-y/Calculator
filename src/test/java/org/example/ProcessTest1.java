package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessTest1 {
    @Test
    void Start(){
        String input = "IV"
        arabSymbUseCheck(input);
    }
    @Test
    void romanSymbUseCheck() {
    }

    @Test
    void arabSymbUseCheck(String input) {
        boolean isFullyArab = false;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(Integer.parseInt(input.substring(i))))
                isFullyArab = true;
            else
                isFullyArab = false;
        }
        System.out.println(isFullyArab);

    }
}