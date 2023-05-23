package LeetCodeEasy;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Contest4 {
    public static void main(String[] args) {
        String[] s = {"pay", "attention", "practice", "attend"};
        String num = "1210";
        System.out.println(digitCount(num));
    }

    public static boolean digitCount(String num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length(); i++) {
            int cc = num.charAt(i) - 48;
            if (map.containsKey(cc)) {
                int count = map.get(cc);
                map.put(cc, count + 1);
            } else map.put(cc, 1);
        }

        for (int i = 0; i < num.length(); i++) {
            int count = num.charAt(i) - 48;
            int actCount;
            actCount = map.getOrDefault(i, 0);
            if (count != actCount) return false;
        }
        return true;
    }

    public static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int num1 = summation(firstWord);
        int num2 = summation(secondWord);
        int target = summation(targetWord);
        return num1 + num2 == target;
    }

    static int summation(String word) {
        int power = word.length() - 1;
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            int num = word.charAt(i) - 97;
            sum += num * Math.pow(10, power);
            power--;
        }
        return sum;
    }

    public static boolean judgeCircle(String moves) {
        int x = 0, y = 0;

        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U':
                    x += 1;
                    break;
                case 'D':
                    x -= 1;
                    break;
                case 'L':
                    y -= 1;
                    break;
                case 'R':
                    y += 1;
                    break;
            }
        }

        return x == 0 && y == 0;
    }

    public static boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int cc = map.get(s.charAt(i));
                map.put(s.charAt(i), cc + 1);
            } else map.put(s.charAt(i), 1);
        }

        int prev = map.get(s.charAt(0));
        boolean result = true;
        for (Map.Entry<Character, Integer> set :
                map.entrySet()) {
            int cc = set.getValue();
            if (cc != prev) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static int[] diStringMatch(String s) {
        int[] answer = new int[s.length() + 1];
        int left = 0;
        int right = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                answer[i] = left;
                left++;
            } else {
                answer[i] = right;
                right--;
            }
        }
        answer[s.length()] = left;
        return answer;
    }

    public static int prefixCount(String[] words, String pref) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            int in = words[i].indexOf(pref);
            if (in == 0) count++;
        }
        return count;
    }

    public static boolean squareIsWhite(String coordinates) {
        int m = 0;
        switch (coordinates.charAt(0)) {
            case 'a':
                m = 1;
                break;
            case 'b':
                m = 2;
                break;
            case 'c':
                m = 3;
                break;
            case 'd':
                m = 4;
                break;
            case 'e':
                m = 5;
                break;
            case 'f':
                m = 6;
                break;
            case 'g':
                m = 7;
                break;
            case 'h':
                m = 8;
                break;
        }
        int n = (int) coordinates.charAt(1) - 48;
        if ((m + n) % 2 == 1) return true;
        return false;
    }

    public static String destCity(List<List<String>> paths) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < paths.size(); i++) {
            String a = paths.get(i).get(0);
            set.add(a);
        }

        for (int i = 0; i < paths.size(); i++) {
            if (!set.contains(paths.get(i).get(1))) return paths.get(i).get(1);
        }
        return null;
    }

    public static String generateTheString(int n) {
        char[] cc = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        String answer = "";
        int index = 0;
        if (n % 2 == 1)
            for (int i = 0; i < n; i++) {
                answer += cc[index];
            }
        else {
            answer += cc[index];
            index++;
            for (int i = 0; i < n - 1; i++) {
                answer += cc[index];
            }
        }
        return answer;
    }

    public static String reversePrefix(String word, char ch) {
        String reversed = "";
        int stop = 0;
        for (int i = 0; i < word.length(); i++) {
            reversed = word.charAt(i) + reversed;
            if (word.charAt(i) == ch) {
                stop = i + 1;
                break;
            }
        }
        if (stop != 0)
            for (int i = stop; i < word.length(); i++) {
                reversed = reversed + word.charAt(i);
            }
        else return word;
        return reversed;
    }

    public static boolean halvesAreAlike(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (set.contains(s.charAt(i))) count1++;
        }
        for (int i = s.length() / 2; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) count2++;
        }
        return count1 == count2;
    }

    public static String freqAlphabets(String s) {

        String answer = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '#') answer = getCharacter(s.charAt(i)) + answer;
            else {
                answer = getCharacter(s.substring(i - 2, i)) + answer;
                i -= 2;
            }
        }
        return answer;
    }

    private static char getCharacter(String ss) {
        HashMap<String, Character> map = new HashMap<>();
        map.put("10", 'j');
        map.put("11", 'k');
        map.put("12", 'l');
        map.put("13", 'm');
        map.put("14", 'n');
        map.put("15", 'o');
        map.put("16", 'p');
        map.put("17", 'q');
        map.put("18", 'r');
        map.put("19", 's');
        map.put("20", 't');
        map.put("21", 'u');
        map.put("22", 'v');
        map.put("23", 'w');
        map.put("24", 'x');
        map.put("25", 'y');
        map.put("26", 'z');
        return map.get(ss);
    }

    private static char getCharacter(char ss) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('1', 'a');
        map.put('2', 'b');
        map.put('3', 'c');
        map.put('4', 'd');
        map.put('5', 'e');
        map.put('6', 'f');
        map.put('7', 'g');
        map.put('8', 'h');
        map.put('9', 'i');
        return map.get(ss);
    }

    public static String replaceDigits(String s) {
        String answer = "";
        char prev = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                answer += s.charAt(i);
                prev = s.charAt(i);
            } else {
                int cc = s.charAt(i);
                cc = cc - 48;
                char c = (char) ((int) prev + cc);
                answer += c;
            }
        }
        return answer;
    }

    public static int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (int i = 0; i < patterns.length; i++) {
            if (word.contains(patterns[i])) count++;
        }
        return count;
    }

    public static String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' && stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == '(' && stack.peek() == ')') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')' && stack.peek() == '(')
                stack.push(s.charAt(i));
        }
        String answer = "";
        for (int i = 0; i < stack.size(); i++) {
            answer += stack.elementAt(i);
        }
        return answer;
    }


    public static int countPoints(String rings) {
        boolean colors[][] = new boolean[10][3]; // 0->R,1->G, 2->B
        for (int i = 0; i < rings.length() - 1; i += 2) {
            char currentColor = rings.charAt(i);
            int index = (int) rings.charAt(i + 1) - 48;
            switch (currentColor) {
                case 'R' -> colors[index][0] = true;
                case 'G' -> colors[index][1] = true;
                case 'B' -> colors[index][2] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < colors.length; i++) {
            boolean g = true;
            for (int j = 0; j < colors[i].length; j++) {
                if (!colors[i][j]) {
                    g = false;
                    break;
                }
            }
            if (g) count++;
        }
        return count;
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        String answer = "";
        for (int i = 0; i < words.length; i++) {
            String reverse = "";
            for (int j = words[i].length() - 1; j >= 0; j--) {
                reverse = reverse + words[i].charAt(j);
            }
            if (i != words.length - 1)
                answer += reverse + " ";
            else answer += reverse;
        }
        return answer;
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }
        int count = 0;
        boolean contains = true;
        for (int i = 0; i < words.length; i++) {
            contains = true;
            for (int j = 0; j < words[i].length(); j++) {
                if (!set.contains(words[i].charAt(j)))
                    contains = false;
            }
            if (contains) count++;
        }
        return count;
    }

    public static String toLowerCase(String s) {
        String ans = "";
        int cc = 0;
        char ch = '0';
        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) >= 65 && (int) s.charAt(i) <= 90) {
                cc = s.charAt(i) + 32;
                ch = (char) cc;
            } else
                ch = s.charAt(i);
            ans = ans + ch;
        }
        return ans;
    }

    public static String truncateSentence(String s, int k) {
        String[] words = s.split(" ");
        String res = "";
        for (int i = 0; i < k; i++) {
            if (i != k - 1)
                res += words[i] + " ";
            else res += words[i];
        }
        return res;
    }

    public static int maxDepth(String arr) {
        Stack<Character> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < arr.length(); i++) {
            if (arr.charAt(i) == '(') {
                stack.push(arr.charAt(i));
                max = Math.max(stack.size(), max);
            } else if (arr.charAt(i) == ')') stack.pop();
        }
        return max;
    }

    public static int uniqueMorseRepresentations(String[] words) {
        String[] morseMap = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String res = "";
            for (int j = 0; j < words[i].length(); j++) {
                String morseLetter = morseMap[(int) words[i].charAt(j) - 97];
                res += morseLetter;
            }
            set.add(res);
        }
        return set.size();
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String res1 = "", res2 = "";
        for (int i = 0; i < word1.length; i++) {
            res1 = res1 + word1[i];
        }
        for (int i = 0; i < word2.length; i++) {
            res2 = res2 + word1[2];
        }
        return res1.equals(res2);
    }

    public static boolean checkIfPangram(String sentence) {
        boolean[] alphabet = new boolean[26];
        for (int i = 0; i < sentence.length(); i++) {
            int cc = sentence.charAt(i);
            alphabet[cc - 97] = true;
        }

        for (boolean b : alphabet) {
            if (!b) return false;
        }
        return true;

    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int k = -1;
        switch (ruleKey) {
            case "type":
                k = 0;
                break;
            case "color":
                k = 1;
                break;
            case "name":
                k = 2;
                break;
        }
        int count = 0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).get(k).equals(ruleValue)) count++;
        }
        return count;
    }


    public static int hammingWeight(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 2;
            if (d == 1) sum++;
            n /= 2;
        }
        return sum;
    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> romans = new HashMap<>();
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);
        int sum = 0;
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                if (i + 1 < s.length()) {
                    if (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X') {
                        value = romans.get(s.charAt(i + 1)) - romans.get(s.charAt(i));
                        i++;
                    } else value = romans.get(s.charAt(i));
                } else value = romans.get(s.charAt(i));
            } else if (s.charAt(i) == 'X') {
                if (i + 1 < s.length()) {
                    if (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C') {
                        value = romans.get(s.charAt(i + 1)) - romans.get(s.charAt(i));
                        i++;
                    } else value = romans.get(s.charAt(i));
                } else value = romans.get(s.charAt(i));
            } else if (s.charAt(i) == 'C') {
                if (i + 1 < s.length()) {
                    if (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M') {
                        value = romans.get(s.charAt(i + 1)) - romans.get(s.charAt(i));
                        i++;
                    } else value = romans.get(s.charAt(i));
                } else value = romans.get(s.charAt(i));
            } else value = romans.get(s.charAt(i));
            sum += value;
        }
        return sum;
    }

    public static List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        HashMap<String, Integer> popularity = new HashMap<>();
        int maxView = 0;
        for (int i = 0; i < creators.length; i++) {
            if (!popularity.containsKey(creators[i])) {
                popularity.put(creators[i], views[i]);
                maxView = Math.max(maxView, views[i]);
            } else {
                int currentViews = popularity.get(creators[i]);
                popularity.put(creators[i], views[i] + currentViews);
                maxView = Math.max(maxView, views[i] + currentViews);
            }
        }
        List<String> names = new ArrayList<>();
        for (Map.Entry<String, Integer> set :
                popularity.entrySet()) {

            if (set.getValue() == maxView)
                names.add(set.getKey());
        }
        HashMap<String, String> map = new HashMap<>();
        List<List<String>> answer = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            for (int j = 0; j < creators.length; j++) {
                if (names.get(i).equals(creators[j])) {
                    String id = map.get(names.get(i));
                    if (id != null) {
                        int c = id.compareTo(ids[j]);
                        if (c > 0) map.put(names.get(i), ids[j]);
                        else map.put(names.get(i), id);
                    } else map.put(names.get(i), ids[j]);
                }
            }
        }
        for (Map.Entry<String, String> set :
                map.entrySet()) {

            List<String> list = new ArrayList<>();
            list.add(set.getKey());
            list.add(set.getValue());
            answer.add(list);
        }
        return answer;
    }

    public static int averageValue(int[] nums) {
        int sum = 0;
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 == 0 && nums[i] % 2 == 0) {
                sum += nums[i];
                c++;
            }
        }
        if (c != 0)
            return sum / c;
        else return c;
    }


}
