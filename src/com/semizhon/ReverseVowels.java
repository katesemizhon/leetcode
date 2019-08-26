package com.semizhon;

import java.util.*;

public class ReverseVowels {
    private static Set<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'A', 'e', 'E','o','O','i','I','u','U'));

    private boolean isVowel(Character character) {
        return vowels.contains(character);
    }

    public String reverseVowels(String s) {

        StringBuilder reverseString = new StringBuilder (s);
        Map<Character, Integer> charSet = new HashMap<Character, Integer>();

        Stack<ListNode> stack  = new Stack<ListNode>();


        int startIndex = 0;
        int endIndex = s.length() - 1;

        while (startIndex < endIndex) {
            int vowel1Index = getFirstVowel(startIndex, endIndex, s);
            int vowel2Index = getLastVowel(endIndex, startIndex, s);

            if (vowel1Index >= 0 && vowel2Index >= 0 && vowel2Index > vowel1Index) {
                swap(vowel1Index, vowel2Index, reverseString);
            }
            startIndex = vowel1Index + 1 ;
            endIndex = vowel2Index - 1;
        }

        return reverseString.toString();
    }

    public int getLastVowel (int endIndex, int startIndex, String s) {
        int vowelPosition = -1;
        int i = endIndex;
        while (vowelPosition < 0 && i >= startIndex) {
            if (isVowel(s.charAt(i))) {
                vowelPosition = i;
            }
            i--;
        }
        return vowelPosition;
    }
    public int getFirstVowel (int startIndex, int endIndex, String s) {
        int vowelPosition = -1;
        int i = startIndex;
        while (vowelPosition < 0 && i < endIndex) {
            if (isVowel(s.charAt(i))) {
                vowelPosition = i;
            }
            i ++;
        }




        return vowelPosition;
    }

    public StringBuilder swap (int vowel1Position, int vowel2Position, StringBuilder s) {
        char vowel1 = s.charAt(vowel1Position);
        s.setCharAt(vowel1Position, s.charAt(vowel2Position));
        s.setCharAt(vowel2Position, vowel1);
        return s;
    }
}
