/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameOfLife;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kamil
 */
public class gameTest {
    /**
     * Test of run_nextMove method, of class game.
     */
    @Test
    public void testRun_nextMove() {
        game instance = new game();
        boolean[][] expResult = new boolean[100][100];
        expResult[1][0] = true;
        expResult[1][1] = true;
        expResult[1][2] = true;
        boolean[][] result = instance.run_nextMove();
        assertEquals(expResult, result);
    }
    @Test
    protected void testTransitions(){
        boolean[][] move = new boolean[100][100];
        move[1][0] = true;
        move[1][1] = true;
        move[1][2] = true;
        game intance = new game();
        boolean result = intance.transitions(1, 1);
        boolean expResult = true;
        assertEquals(expResult, result);
    }
}
