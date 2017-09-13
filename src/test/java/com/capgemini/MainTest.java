package com.capgemini;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void myFirstTest(){
        Main test = new Main();
        test.main();
        assertEquals(2, 1 + 1);
    }
}