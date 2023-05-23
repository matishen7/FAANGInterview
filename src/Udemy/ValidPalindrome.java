package Udemy;

import java.util.Locale;
import java.util.Stack;

public class ValidPalindrome {
    public static boolean Solution1(String s) {
        //s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int r = s.length() - 1, l = 0;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public static boolean Solution2(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int r, l;
        if (s.length() % 2 == 0) {
            r = s.length() / 2;
            l = r - 1;
        } else {
            r = s.length() / 2;
            l = s.length() / 2;
        }

        while (l >= 0) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l--;
            r++;
        }
        return true;
    }

    public static boolean Solution3(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String a = "";
        for (int i = s.length() - 1; i >= 0; i--)
            a = a + s.charAt(i);

        for (int j = 0; j< s.length();j++)
            if (a.charAt(j)!= s.charAt(j)) return false;

        //System.out.println(a);
        return true;
    }
}
