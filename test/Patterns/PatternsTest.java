/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patterns;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kamil
 */
public class PatternsTest {
    
    /**
     * Test of Patterns method, of class Patterns.
     */
    @Test
    public void testPatterns() {
        String nameOfPattern = "";
        int x = 0;
        int y = 0;
        Patterns instance = new Patterns();
        boolean[][] expResult = new boolean[100][100];
        boolean[][] result = instance.Patterns(nameOfPattern, x, y);
        assertEquals(expResult, result);  
        
        nameOfPattern = "queen";
        x = 2;
        y = 2;
        expResult[2][2] = true;
        expResult[2][3] = true;
        expResult[3][4] = true;
        expResult[4][5] = true;
        expResult[5][5] = true;
        expResult[6][5] = true;
        expResult[7][4] = true;
        expResult[8][3] = true;
        expResult[9][2] = true;

        result = instance.Patterns(nameOfPattern, x, y);
        assertEquals(expResult, result);
    }
    
}
