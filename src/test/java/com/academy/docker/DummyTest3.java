package com.academy.docker;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DummyTest3 {

    @Test
    public void dummyTestForBoolean(){

        boolean b = true;
        assertTrue( b);

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

    @Test
    public void dummyTestForFloat(){

        Float f = 0.5F;
        assertEquals( 0.4F,f);

    }

    @Test
    public void dummyTestForSum(){

        int i1 = 2;
        int i2 = 4;

        assertEquals( 6,i1 + i2);

    }

}
