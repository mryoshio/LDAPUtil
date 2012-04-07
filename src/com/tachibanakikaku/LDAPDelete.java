package com.tachibanakikaku;

import javax.naming.NamingException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: mryoshio
 * Date: 12/04/06
 * Time: 17:41
 * To change this template use File | Settings | File Templates.
 */
public class LDAPDelete extends LDAPWorkBase {
    public static final String DEFAULT_PROP_PATH = "./delete.properties";

    public LDAPDelete() throws NamingException, IOException {
        super(DEFAULT_PROP_PATH);
    }

    public LDAPDelete(String propPath) throws IOException, NamingException {
        super(propPath);
    }

    @Override
    public void execute() {
        log.debug("LDAPDelete#execute");
        String deleteDN = USER_ID_ATTRIBUTE + "=" + properties.getProperty(USER_ID_ATTRIBUTE) + "," + USER_SEARCH_BASE_DN;
        log.debug("delete DN: " + deleteDN);
        try {
            ldapContext.destroySubcontext(deleteDN);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
