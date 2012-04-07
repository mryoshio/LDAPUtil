package com.tachibanakikaku;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: mryoshio
 * Date: 12/04/06
 * Time: 17:41
 * To change this template use File | Settings | File Templates.
 */
public class LDAPUpdate extends LDAPWorkBase {
    public static final String DEFAULT_PROP_PATH = "./update.properties";

    public LDAPUpdate() throws NamingException, IOException {
        super(DEFAULT_PROP_PATH);
    }

    public LDAPUpdate(String propPath) throws IOException, NamingException {
        super(propPath);
    }

    @Override
    public void execute() {
        log.debug("LDAPUpdate#execute");

//         set properties
        Attributes attrs = new BasicAttributes();
        attrs.put(LAST_NAME_ATTRIBUTE, properties.getProperty(LAST_NAME_ATTRIBUTE));

        // update entry
        String updateDN = USER_ID_ATTRIBUTE + "=" + properties.getProperty(USER_ID_ATTRIBUTE) + ","
                + USER_SEARCH_BASE_DN;
        log.debug("update DN: " + updateDN + " using " + attrs);
        try {
            ldapContext.modifyAttributes(updateDN, DirContext.REPLACE_ATTRIBUTE, attrs);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
