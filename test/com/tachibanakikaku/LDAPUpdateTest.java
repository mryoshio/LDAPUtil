package com.tachibanakikaku;

import org.junit.Test;

import javax.naming.NamingException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: mryoshio
 * Date: 12/04/07
 * Time: 23:37
 * To change this template use File | Settings | File Templates.
 */
public class LDAPUpdateTest {
    @Test
    public void testConstructorWithGoodPath() throws NamingException, IOException {
        LDAPUpdate ldapUpdate = new LDAPUpdate("./update.properties");
    }

    @Test(expected = FileNotFoundException.class)
    public void testConstructorWithBadPath() throws NamingException, IOException {
        LDAPUpdate ldapUpdate = new LDAPUpdate("./notfound.properties");
    }

    @Test
    public void testConstructorWithoutArguments() throws NamingException, IOException {
        LDAPUpdate ldapUpdate = new LDAPUpdate();
    }

    @Test
    public void testDeleteEntry() {
        LDAPUpdate ldapUpdate = null;
        try {
            ldapUpdate = new LDAPUpdate("./update.properties");
            ldapUpdate.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
