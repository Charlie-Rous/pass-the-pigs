package test;

import org.junit.*;

import GameManager;


public class GameManagerTest {
    @Test
    public void test() {
        GameManager gm = new GameManager(100);
        assertEquals(20, gm.calcScore({"Razorback", "Razorback"}));
    }
}