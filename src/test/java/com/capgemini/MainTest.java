package com.capgemini;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.capgemini.Main;

class MainTest {

    @Test
    public void myFirstTest(){
        Main test = new Main();
        test.main();
        assertEquals(2, 1 + 1);
    }
}