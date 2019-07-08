package com.codefans.basicjava.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: codefans
 * @date: 2019-07-08 10:58
 */
public class RegexForSplit {

    public String split(String text, String regex) {
        String result = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            result = matcher.group(0);
        }
        return result;
    }

}
