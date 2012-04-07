package com.tachibanakikaku;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: mryoshio
 * Date: 12/04/06
 * Time: 17:44
 * To change this template use File | Settings | File Templates.
 */
public class LDAPWorkBase implements LDAPWork {

    protected Logger log = Logger.getLogger(LDAPWorkBase.class);
    protected DirContext ldapContext = null;
    protected Properties properties = new Properties();

    @Override
    public void execute() {
        throw new RuntimeException("com.tachibanakikaku.LDAPWorkBase#execute() MUST NOT be called!");
    }


    public LDAPWorkBase(String propertyPath) throws IOException, NamingException {
        setLDAPContext();
        setProperties(propertyPath);
    }

    public LDAPWorkBase() {
        throw new RuntimeException(ERR_MSG_MUST_NOT_PASS_HERE);
    }

    private void setProperties(String propertyPath) throws IOException {
        File f = new File(propertyPath);
        properties.load(new FileInputStream(f));
    }

    private void setLDAPContext() throws IOException, NamingException {
        Properties props = new Properties();
        File f = new File(LDAP_PROPERTIES);
        props.load(new FileInputStream(f));
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, props.getProperty(LDAP_INITIAL_CONTEXT_FACTORY));
        env.put(Context.PROVIDER_URL, props.getProperty(LDAP_PROVIDER_URL));
        env.put(Context.SECURITY_AUTHENTICATION, props.getProperty(LDAP_SECURITY_AUTHENTICATION));
        env.put(Context.SECURITY_PRINCIPAL, props.getProperty(LDAP_SECURITY_PRINCIPAL));
        env.put(Context.SECURITY_CREDENTIALS, props.getProperty(LDAP_SECURITY_CREDENTIALS));
        ldapContext = new InitialDirContext(env);
    }
}
