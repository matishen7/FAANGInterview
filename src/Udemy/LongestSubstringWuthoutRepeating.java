package Udemy;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWuthoutRepeating {
    public static int Solution(String s) {
        int longest = 0;
        if (s.length() == 1) return 1;
        HashSet<Character> currSet = new HashSet<>();
        int currLongest = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (!currSet.contains(s.charAt(j))) {
                    currSet.add(s.charAt(j));
                    currLongest++;
                    if (currLongest > longest) longest = currLongest;
                } else {
                    currLongest = 0;
                    currSet.clear();
                    break;
                }

            }
        }
        return longest;
    }

    public static int SolutionOPtimal(String s) {
        int longest = 0;
        if (s.length() == 1) return 1;
        HashMap<Character, Integer> currSet = new HashMap<Character, Integer>();
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char currChar = s.charAt(r);
             Integer prevSeen = currSet.get(currChar);
             if (prevSeen!=null) prevSeen = (int) prevSeen;
            if (prevSeen >= l) {
                l = prevSeen + 1;
            }
            currSet.put(currChar, r);
            if (longest < r - l + 1)
                longest = r - l + 1;
        }
        return longest;
    }
}
