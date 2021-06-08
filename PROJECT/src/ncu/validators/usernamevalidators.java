package ncu.validators;

import java.util.regex.Matcher;
import java.io.*;
import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class usernamevalidators{

    public static Pattern pattern;
    public static Matcher matcher;


    public static void validationDispaly(){

        System.out.println(" ============================================================ ");
        System.out.println(" ---> choose a username between 3 to 15 characters.           ");
        System.out.println(" ---> Makesure it does not contain any special character.");
        System.out.println(" ---> Note : You can use '_  and - ' in your username         ");
        System.out.println(" ============================================================ ");

    }


    private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";ko9

    public static boolean validate(String username) {

        pattern = Pattern.compile(USERNAME_PATTERN);
        matcher = pattern.matcher(username);
        return matcher.matches();

    }
    }

