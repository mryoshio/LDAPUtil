package com.tachibanakikaku;

import java.util.Formatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mryoshio
 * Date: 12/04/06
 * Time: 17:21
 * To change this template use File | Settings | File Templates.
 */
public class Main {


    private static final Map<String, Class<LDAPWork>> works = new HashMap() {{
        put("a", LDAPAdd.class);
        put("u", LDAPUpdate.class);
        put("d", LDAPDelete.class);
    }};

    private static final String CHANGE_ATTRIBUTE = "sn";
    private static final String USAGE_MSG = "Usage: java %s (a|u|d)\n";


    public static void main(String[] args) {
        Formatter formatter = new Formatter(Locale.UK);
        if (args.length < 1 || (!works.containsKey(args[0]))) {
            System.err.printf(USAGE_MSG, new Object[]{"Main", CHANGE_ATTRIBUTE});
            throw new RuntimeException(String.format(USAGE_MSG, new Object[]{"Main"}));
        }
        LDAPWork work = null;
        try {
            work = works.get(args[0]).newInstance();
            work.execute();
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}

