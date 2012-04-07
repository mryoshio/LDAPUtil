package com.tachibanakikaku;

/**
 * Created with IntelliJ IDEA.
 * User: mryoshio
 * Date: 12/04/06
 * Time: 17:16
 * To change this template use File | Settings | File Templates.
 */
public interface LDAPWork {

    final static String USER_SEARCH_BASE_DN = "ou=Users,dc=tachibanakikaku,dc=com";
    final static String USER_ID_ATTRIBUTE = "cn";
    final static String LAST_NAME_ATTRIBUTE = "sn";
    final static String MAIL_ATTRIBUTE = "mail";
    final static String OBJECTCLASS_ATTRIBUTE = "objectClass";

    final static String LDAP_INITIAL_CONTEXT_FACTORY = "INITIAL_CONTEXT_FACTORY";
    final static String LDAP_PROVIDER_URL = "PROVIDER_URL";
    final static String LDAP_SECURITY_AUTHENTICATION = "SECURITY_AUTHENTICATION";
    final static String LDAP_SECURITY_PRINCIPAL = "SECURITY_PRINCIPAL";
    final static String LDAP_SECURITY_CREDENTIALS = "SECURITY_CREDENTIALS";

    final static String ERR_MSG_MUST_NOT_PASS_HERE = "This logic MUST NOT be executed!";


    final static String LDAP_PROPERTIES = "./ldap.properties";

    void execute();

}
