package ncu.validators;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class passwordvalidators {

    public static Pattern pattern;
    public static Matcher matcher;

    private static final String USERNAME_PATTERN = "^[a-z0-9_  - @ - # -$ -% - ^ -& -* - (-)-+-=-> -) -]{6,12}$";

    public static boolean validate(String password) {

        pattern = Pattern.compile(USERNAME_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

