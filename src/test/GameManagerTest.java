package test;


import static org.junit.Assert.*;		

import org.junit.Test;

import GameManager;


public class GameManagerTest {
    
    public void testCalcScore() {
        GameManager gm = new GameManager(100);
        String[] roll = {"Razorback", "Razorback"};
        int result = gm.calcScore(roll);
        assertEquals(20, result);
       
    }
}