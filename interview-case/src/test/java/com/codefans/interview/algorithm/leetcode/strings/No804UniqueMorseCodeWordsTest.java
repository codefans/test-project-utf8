package com.codefans.interview.algorithm.leetcode.strings;

import org.junit.Before;
import org.junit.Test;

/**
 * @author: codefans
 * @date: 2019-08-17 18:01
 */
public class No804UniqueMorseCodeWordsTest {

    private String[] words;

    @Before
    public void before() {

        words = new String[]{
            "gin", "zen", "gig", "msg"
        };

    }

    @Test
    public void uniqueMorseCodeTest() {

        No804UniqueMorseCodeWords uniqueMorseCodeWords = new No804UniqueMorseCodeWords();
        int uniqueMorseCode = uniqueMorseCodeWords.uniqueMorseRepresentations(words);
        System.out.println("uniqueMorseCode=" + uniqueMorseCode);

    }


}
