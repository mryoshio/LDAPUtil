package com.tachibanakikaku;

import org.junit.Test;

import javax.naming.NamingException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: mryoshio
 * Date: 12/04/07
 * Time: 23:00
 * To change this template use File | Settings | File Templates.
 */
public class LDAPDeleteTest {
    @Test
    public void testConstructorWithGoodPath() throws NamingException, IOException {
        LDAPDelete ldapDelete = new LDAPDelete("./delete.properties");
    }

    @Test(expected = FileNotFoundException.class)
    public void testConstructorWithBadPath() throws NamingException, IOException {
        LDAPDelete ldapDelete = new LDAPDelete("./notfound.properties");
    }

    @Test
    public void testConstructorWithoutArguments() throws NamingException, IOException {
        LDAPDelete ldapDelete = new LDAPDelete();
    }

    @Test
    public void testDeleteEntry() {
        LDAPDelete ldapDelete = null;
        try {
            ldapDelete = new LDAPDelete("./delete.properties");
            ldapDelete.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

}
