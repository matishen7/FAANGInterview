package Udemy;

import java.util.*;

public class StringsProblems {
    public static void main(String[] args) {
        String word1 = "abcd";
        String word2 = "pq";
        System.out.println(mergeAlternately(word1, word2));
    }

    public static String mergeAlternately(String word1, String word2) {
        int j = 0;
        int jlen = word2.length();
        String s = "";
        int i = 0;
        int ilen = word1.length();
        while (i < ilen && j < jlen)
        {
            s = s + word1.charAt(i) + word2.charAt(j);
            j++;
            i++;
        }
        while (i < ilen)
        {
            s = s + word1.charAt(i);
            i++;
        }
        while (j < jlen)
        {
            s = s + word2.charAt(j);
            j++;
        }
        return s;
    }

    public static String largestPalindromic(String num) {
        int[] digits = new int[10];
        for (int i = 0; i < digits.length - 1; i++) {
            int ascii = (int) num.charAt(i);
            digits[ascii - 48]++;
        }
        String res = "";
        int times = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
                while (digits[i] >= 2){
                    char cc = (char) ((char) i + 48);
                    res = res + cc + cc + res;
                    digits[i] -=2;
                }
            }
        return res;
    }

    public static boolean IsomorphicStrings(String s, String t) {
        HashMap<Character, Character> seen = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        char cc;
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (!seen.containsKey(s.charAt(i))) {

                seen.put(s.charAt(i), t.charAt(i));
                cc = seen.get(s.charAt(i));
                set.add(cc);
                // if (cc != seen.get(s.charAt(i))) return false;

            } else {
                cc = seen.get(s.charAt(i));
                if (cc != t.charAt(i)) return false;
            }
        }
        if (set.size() != seen.size()) return false;
        return true;
    }

    public static boolean Subsequence(String s, String t) {
        if (s.length() > t.length())
            return false;
        if (s.equals(t))
            return true;
        char[] c = s.toCharArray();
        int i = -1;
        for (char ch : c) {
            i = t.indexOf(ch, i + 1);
            if (i == -1)
                return false;
        }
        return true;
    }

    public static String[] KeyboardRow(String[] words) {
        //words = {"Hello","Alaska","Dad","Peace"};
        //String[] keyboard = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        //for (int i = 0; i < words.length; i++)
        //    words[i] = words[i].toLowerCase();

        List<Integer> ff = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                int foundInrow = FindInRow(words[i].charAt(j));
                ff.add(foundInrow);
                System.out.println(foundInrow);
            }
            System.out.println("*****");

            int num = ff.get(0);
            boolean tobeAdded = true;
            for (int k = 0; k < ff.size(); k++) {
                if (ff.get(k) != num) {
                    tobeAdded = false;
                    break;
                }
            }
            if (tobeAdded) result.add(words[i]);
            ff.clear();
        }
        String[] array = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
            System.out.println(array[i]);
        }
        return array;
    }

    private static int FindInRow(char cc) {
        String[] keyboard = {"qQwWeErRtTyYuUiIoOpP", "aAsSdDfFgGhHjJkKlL", "zZxXcCvVbBnNmM"};
        for (int i = 0; i < keyboard.length; i++) {
            int found = keyboard[i].indexOf(cc);
            if (found != -1) return i;
        }
        return -1;
    }

    public static String[] FindRestaurants(String[] list1, String[] list2) {
        HashMap<String, Integer> result = new HashMap<>();
        int leastIndexSum = list1.length - 1 + list2.length - 1;
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list2[j].equals(list1[i])) {
                    int currSum = j + i;
                    if (currSum <= leastIndexSum) {
                        leastIndexSum = currSum;
                    }
                    //System.out.println("currSum = " + currSum);
                    // System.out.println("leastIndexSum = " + leastIndexSum);
                    result.put(list2[j], currSum);
                    //System.out.println(list2[j]);
                }
            }
        }
        List<String> outputList = new ArrayList<>();
        for (Map.Entry<String, Integer> set : result.entrySet()) {
            if (set.getValue() == leastIndexSum) {
                outputList.add(set.getKey());
                System.out.println(set.getKey());
            }
        }
        String[] array = new String[outputList.size()];
        for (int i = 0; i < outputList.size(); i++) {
            array[i] = outputList.get(i);
            System.out.println(array[i]);
        }
        return array;

    }
}
