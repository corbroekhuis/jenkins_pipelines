package com.academy.docker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyTest {

    @Test
    public void dummyTestForBoolean(){

        boolean b = true;
        assertEquals( true, b);

    }

    @Test
    public void dummyTestForInteger(){

        Integer i = 9;
        assertEquals( 9, i);

    }

    @Test
    public void dummyTestForString(){

        String s = "Hello";
        assertEquals( "Hello",s);

    }


}
