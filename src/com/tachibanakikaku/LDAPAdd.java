package com.tachibanakikaku;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: mryoshio
 * Date: 12/04/06
 * Time: 17:19
 * To change this template use File | Settings | File Templates.
 */
public class LDAPAdd extends LDAPWorkBase {

    public static final String DEFAULT_PROP_PATH = "./add.properties";

    public LDAPAdd() throws NamingException, IOException {
        super(DEFAULT_PROP_PATH);
    }

    public LDAPAdd(String propPath) throws IOException, NamingException {
        super(propPath);

    }

    @java.lang.Override
    public void execute() {
        log.debug("LDAPAdd#execute");

        // set properties
        Attribute objectClass = new BasicAttribute(OBJECTCLASS_ATTRIBUTE);
        for (String o : properties.getProperty(OBJECTCLASS_ATTRIBUTE).split(",")) {
            objectClass.add(o);
        }
        Attributes attrs = new BasicAttributes(false);
        attrs.put(objectClass);
        attrs.put(LAST_NAME_ATTRIBUTE, properties.getProperty(LAST_NAME_ATTRIBUTE));
        attrs.put(MAIL_ATTRIBUTE, properties.getProperty(MAIL_ATTRIBUTE));

        // add entry
        try {
            ldapContext.bind(USER_ID_ATTRIBUTE + "=" + properties.getProperty(USER_ID_ATTRIBUTE) + "," + USER_SEARCH_BASE_DN, null, attrs);
        } catch (NamingException e) {
            e.printStackTrace();
        }


    }
}
