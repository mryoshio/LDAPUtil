package com.tachibanakikaku;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: mryoshio
 * Date: 12/04/06
 * Time: 18:43
 * To change this template use File | Settings | File Templates.
 */
public class MainTest {
    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test(expected = RuntimeException.class)
    public void mainTestWithNoArguments() {
        Main.main(new String[]{});
    }

    @Test(expected = RuntimeException.class)
    public void mainTestWithBadArguments() {
        Main.main(new String[]{"e", "mryoshio", "newValue"});
    }

    @Test
    public void mainTestAdd() {
        Main.main(new String[]{"a", "mryoshio", "newValue"});
    }


}
