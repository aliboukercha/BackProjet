package com.nab.core.auth.basic;

import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicAuthToken {

    public final String login;
    public final String password;

    public BasicAuthToken(String login, String password
    ) {
        this.login = login;
        this.password = password;
    }

    public static boolean isBasicAuthToken(String token) {
        if (token == null) {
            return false;
        }

        try {
            parse(token);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static BasicAuthToken parse(String token) {

        String auth = new String(Base64.getDecoder().decode(token.replaceFirst("(Basic|basic)\\s*", "")));

        Matcher matcher = Pattern.compile("^(?<login>.*):(?<password>.*)$").matcher(auth);

        if (!matcher.matches())  {
            throw new IllegalArgumentException("Received token is not a valid Basic Auth token");
        } else {
            return new BasicAuthToken(matcher.group("login"), matcher.group("password"));
        }




    }
}
