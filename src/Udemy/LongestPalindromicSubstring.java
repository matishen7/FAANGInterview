package Udemy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {

        int[] coins = {186,419,83,408};
        System.out.println(coinChange(coins, 6249));
    }

    static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int index = coins.length - 1;
        Arrays.sort(coins);
        int count = 0;
        while (amount != 0) {
            if (index  < 0) return -1;
            int currLargestCoin = coins[index];
            while (amount >= currLargestCoin) {
                amount = amount - currLargestCoin;
                count++;
            }
            index--;
        }
        return count;
    }

    static int PalindromicSubstrings(String s) {
        int count = 0;
        //HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j <= s.length() - i; j++) {
                String substring = s.substring(i, i + j);
                if (ValidPalindrome.Solution1(substring)) {
                    System.out.println(substring);
                    // set.add(substring);
                    count++;
                }
            }
        }
        return count;
    }

    public static String Solution(String s) {
        int longest = s.length();
        String longestPal = s;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= 0; j--) {
                if (ValidPalindrome.Solution1(s.substring(i, j + 1))) {
                    if (longest < j - i + 1) {
                        longest = j - i + 1;
                        longestPal = s.substring(i, j + 1);
                    }
                }
            }
        }
        return longestPal;
    }
}
