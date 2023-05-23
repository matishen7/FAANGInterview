package Udemy;

import java.util.ArrayList;
import java.util.List;

public class AlmostPalindrome {
    public static boolean Solution(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int r = s.length() - 1, l = 0;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return (ValidSubPalindrome(s, l + 1, r) || ValidSubPalindrome(s, l, r - 1));
            }
            l++;
            r--;
        }
        return true;
    }

    private static boolean ValidSubPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {

        String s = "aabbccc";

        System.out.println(partition(s));
        // System.out.println(s.substring(4,6));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> palindromes = new ArrayList<>();
        String sub = "";
        int end;
        for (int length = 1; length <= s.length(); length++) {
            List<String> list = new ArrayList<>();
            for (int begin = 0; begin < s.length(); begin++) {
                end = begin + length;
                if (end < s.length())
                    sub = s.substring(begin, end);
                else sub = s.substring(begin);
                if (ValidPalindrome.Solution1(sub)) {
                   list.add(sub);
                }
            }
            palindromes.add(list);
        }
        return palindromes;
    }
}
