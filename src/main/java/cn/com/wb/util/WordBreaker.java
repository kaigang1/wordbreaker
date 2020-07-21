package cn.com.wb.util;

import java.util.*;

public class WordBreaker {

    // static hash set to store the given list of English words
    private static Set<String> dictionary = new HashSet<String>();
    private static List<String> output;

    private WordBreaker() {
    }

    /**
     * Initialize the dict and return work breaker instance.
     *
     * @param words The given list of valid words in English
     */
    public static WordBreaker getInstance(String[] words) {

        if (words == null || words.length == 0) {
            return null;
        }
        for (String word : words) {
            dictionary.add(word.toLowerCase());
        }
        return new WordBreaker();
    }

    /**
     * Entry to break the sentence.
     *
     * @param str The given sentence to be broke
     */
    public List<String> breakWord(String str) {

        output = new ArrayList<String>();
        if (str != null) {
            breakWordEntry(str, str.length(), "");
        }
        return output;
    }

    /**
     * Internal entry to break the sentence recursively.
     *
     * @param str    The rest of current word
     * @param n      The length of current word
     * @param result The result to be printed with space separated
     */
    private void breakWordEntry(String str, int n, String result) {

        for (int i = 1; i <= n; i++) {

            String prefix = str.substring(0, i);

            // to check if the prefix is in dictionary. If yes, then check the remaining string,
            // otherwise, will ignore the prefix.
            if (dictionary.contains(prefix)) {
                // if it reaches the end of the rest sentence
                if (i == n) {
                    result += prefix;
                    System.out.println(result);
                    output.add(result);
                    return;
                }
                breakWordEntry(str.substring(i, n), n - i, result + prefix + " ");
            }
        }
    }
}



