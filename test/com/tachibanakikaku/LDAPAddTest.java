package com.tachibanakikaku;

import org.junit.Before;
import org.junit.Test;

import javax.naming.NamingException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: mryoshio
 * Date: 12/04/07
 * Time: 13:46
 * To change this template use File | Settings | File Templates.
 */
public class LDAPAddTest {


    @Before
    public void setUp() {
//        ldapAdd = new LDAPAdd();
//        ldapAdd.setUserName("ki2y");
    }

    @Test
    public void testConstructorWithGoodPath() throws NamingException, IOException {
        LDAPAdd ldapAdd = new LDAPAdd("./add.properties");
    }

    @Test(expected = FileNotFoundException.class)
    public void testConstructorWithBadPath() throws NamingException, IOException {
        LDAPAdd ldapAdd = new LDAPAdd("./notfound.properties");
    }

    @Test
    public void testConstructorWithoutArguments() throws NamingException, IOException {
        LDAPAdd ldapAdd = new LDAPAdd();
    }

    @Test
    public void testAddEntry() throws NamingException, IOException {
        LDAPAdd ldapAdd = new LDAPAdd("./add.properties");
        ldapAdd.execute();
    }
}
