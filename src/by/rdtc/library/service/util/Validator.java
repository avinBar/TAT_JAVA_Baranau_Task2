package by.rdtc.library.service.util;

import java.util.regex.Matcher;

public class Validator {
	private static final String REGEXP = "[\\w\\W]{1,4000}";
    private static final String TITLE = "[a-zA-Z0-9_ \\-]{4,64}";
    private static final String NUMBER = "[\\d]+";
    private static final String YEAR = "[1|2]{1}[9|0|1]{1}[\\d]{2}";
    private static final String LOGIN = "[a-zA-Z_0-9]{3,16}";
    private static final Pattern PATTERN_LOGIN = Pattern.compile(LOGIN);
    private static final String EMAIL = "\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6}";
	
    public static boolean validate(String... data) {
        Matcher matcher;
        for (String arg : data) {
            matcher = PATTERN_REGEXP.matcher(arg);
            if (!matcher.matches()) {
                return false;
            }
        }
        return true;
    }
}
