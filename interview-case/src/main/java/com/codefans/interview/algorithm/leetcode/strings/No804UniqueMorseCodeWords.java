package com.codefans.interview.algorithm.leetcode.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: codefans
 * @date: 2019-08-17 18:00
 *
 * Runtime: 2 ms, faster than 75.78% of Java online submissions for Unique Morse Code Words.
 * Memory Usage: 35.8 MB, less than 100.00% of Java online submissions for Unique Morse Code Words.
 *
 */
public class No804UniqueMorseCodeWords {

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> uniqueCode = new HashSet<String>();
        StringBuilder sb = null;
        for(String w : words) {
            char[] chars = w.toCharArray();
            sb = new StringBuilder();
            for(char c : chars) {
                sb.append(letterToMorseCode(c));
            }
            uniqueCode.add(sb.toString());
        }
        return uniqueCode.size();
    }

    public String letterToMorseCode(char c) {
        String morseCode = "";
        if(c == 'a') {
            morseCode = ".-";
        } else if(c == 'b') {
            morseCode = "-...";
        } else if(c == 'c') {
            morseCode = "-.-.";
        } else if(c == 'd') {
            morseCode = "-..";
        } else if(c == 'e') {
            morseCode = ".";
        } else if(c == 'f') {
            morseCode = "..-.";
        } else if(c == 'g') {
            morseCode = "--.";
        } else if(c == 'h') {
            morseCode = "....";
        } else if(c == 'i') {
            morseCode = "..";
        } else if(c == 'j') {
            morseCode = ".---";
        } else if(c == 'k') {
            morseCode = "-.-";
        } else if(c == 'l') {
            morseCode = ".-..";
        } else if(c == 'm') {
            morseCode = "--";
        } else if(c == 'n') {
            morseCode = "-.";
        } else if(c == 'o') {
            morseCode = "---";
        } else if(c == 'p') {
            morseCode = ".--.";
        } else if(c == 'q') {
            morseCode = "--.-";
        } else if(c == 'r') {
            morseCode = ".-.";
        } else if(c == 's') {
            morseCode = "...";
        } else if(c == 't') {
            morseCode = "-";
        } else if(c == 'u') {
            morseCode = "..-";
        } else if(c == 'v') {
            morseCode = "...-";
        } else if(c == 'w') {
            morseCode = ".--";
        } else if(c == 'x') {
            morseCode = "-..-";
        } else if(c == 'y') {
            morseCode = "-.--";
        } else if(c == 'z') {
            morseCode = "--..";
        }
        return morseCode;
    }


}
