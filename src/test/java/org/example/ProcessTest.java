package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessTest {
   // @Test

    @Test
    void ArabSymbUseCheck_For10byString_isTrue (){
        Process input = new Process();
        assertTrue(input.ArabSymbUseCheck("10"));
    }
    @Test
    void ArabSymbUseCheck_ForMinus7byString_isFalse (){
        Process input = new Process();
        assertFalse(input.ArabSymbUseCheck("-7"));
    }
    @Test
    void ArabSymbUseCheck_ByText_isFalse (){
        Process input = new Process();
        assertFalse(input.ArabSymbUseCheck("qwerty"));
    }
    @Test
    void ArabSymbUseCheck_ByRomanSymbls_isFalse (){
        Process input = new Process();
        assertFalse(input.ArabSymbUseCheck("IV"));
    }
    @Test
    void RomanSymbUseCheck_DigTest (){
        Process input = new Process();
        assertFalse(input.RomanSymbUseCheck("7"));
    }

}