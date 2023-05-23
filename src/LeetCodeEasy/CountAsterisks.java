package LeetCodeEasy;

import Udemy.BinaryTreeSearch;

import java.util.*;

public class CountAsterisks {
    public static void main(String[] args) {
        //String s = "l|*e*et|c**o|*de|";
        //System.out.println(count(s));
        //int[] prices = {7, 1, 5, 3, 6, 4};
        //char[] s = {'h', 'e', 'l', 'l', 'o'};
        //System.out.println(ReverseStr(s));
        //String s = "12..33.4";
        System.out.println(SpecialInteger(11));
    }



    static int CountSepcialIntegers(int n)
    {
        int count = 0;
        for (int i = 1; i <= n; i++)
            if (SpecialInteger(i)) count++;
        return count;
    }

    static boolean SpecialInteger(int n)
    {
        HashSet<Integer> set = new HashSet<>();
        while (n > 0)
        {
            int digit = n%10;
            if (!set.contains(digit)) {
                set.add(digit);
            }
            else return false;
            n /= 10;
        }
        return true;
    }

    static boolean StrongPassword(String s) {
        boolean atleast8chars = false;
        boolean lower = false;
        boolean upper = false;
        boolean digit = false;
        boolean specchars = false;
        boolean adjacent = true;
        Character arr[] = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'};
        Set<Character> spec = new HashSet<>(Arrays.asList(arr));
        if (s.length() >= 8) atleast8chars = true;
        for (int i = 0; i < s.length(); i++) {
            int ascii = s.charAt(i);
            if (ascii >= 97 && ascii <= 122) {
                lower = true;
                break;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            int ascii = s.charAt(i);
            if (ascii >= 65 && ascii <= 90) {
                upper = true;
                break;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            int ascii = s.charAt(i);
            if (ascii >= 48 && ascii <= 57) {
                digit = true;
                break;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (spec.contains(s.charAt(i))) {
                specchars = true;
                break;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                adjacent = false;
                break;
            }
        }

        return atleast8chars && lower && upper && digit && specchars && adjacent;
    }

    public static String validIPAddress(String queryIP) {
        String result = "Neither";
        if (queryIP.contains(".")) {
            result = "IPv4";
            int count = 0;
            for (int i = 0; i < queryIP.length();i++)
            {
                if (queryIP.charAt(i) == '.') count++;
            }
            if (count > 3) return "Neither";
            String[] ip4 = queryIP.split("\\.");
            if (ip4.length != 4) return "Neither";
            for (int i = 0; i < ip4.length; i++) {
                if (ip4[i].length() >= 2 && ip4[i].charAt(0) == '0')
                    return "Neither";
            }

            for (int i = 0; i < ip4.length; i++) {
                String section = ip4[i];
                if (section.length() >= 4) return "Neither";

                for (int j = 0; j < section.length(); j++) {
                    int ascii = section.charAt(j);
                    if (ascii < 48 || ascii > 57) return "Neither";
                }
            }

            for (int i = 0; i < ip4.length; i++) {
                String section = ip4[i];
                if (section.length() == 0) return "Neither";
                int num = StrToNum(section);
                if (num > 255 || num < 0) return "Neither";
            }

        } else if (queryIP.contains(":")) {
            result = "IPv6";
            Character arr[] = {'a', 'b', 'c', 'd', 'e', 'f',
            'A','B','C','D','E','F',
            '0','1','2','3','4','5','6','7','8','9'};
            Set<Character> set = new HashSet<>(Arrays.asList(arr));
            int count = 0;
            for (int i = 0; i < queryIP.length();i++)
            {
                if (queryIP.charAt(i) == ':') count++;
            }
            if (count > 7) return "Neither";

            String[] ip6 = queryIP.split("\\:");
            if (ip6.length != 8) return "Neither";

            for (int i = 0; i < ip6.length; i++) {
                String section = ip6[i];
                if (section.length() == 0) return "Neither";
                if (section.length() > 4) return "Neither";
                for (int j = 0; j < section.length(); j++) {
                    if (!set.contains(section.charAt(j))) return "Neither";
                }
            }
        }

        return result;

    }

    private static int StrToNum(String s) {
        int len = s.length();
        int level = 1;
        for (int i = 1; i < len; i++) {
            level *= 10;
        }
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - 48;
            num = num + digit * level;
            level /= 10;
        }
        return num;
    }

    static int PercentageOfLetter(String s, char cc) {
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == cc) count++;
        }

        int percent = count * 100 / len;
        return percent;
    }

    static int Stocks(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++)
            for (int j = i + 1; j < prices.length; j++) {
                int curr = prices[j] - prices[i];
                if (profit < curr) profit = curr;
            }
        return profit;
    }

    static String SortStringByFreq(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), 1);
            else {
                int count = map.get(s.charAt(i));
                map.put(s.charAt(i), count + 1);
            }
        }

        LinkedHashMap<Character, Integer> sortedMap = new LinkedHashMap<>();

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        String result = "";
        for (Map.Entry<Character, Integer> set :
                sortedMap.entrySet()) {

            int count = set.getValue();
            char cc = set.getKey();
            for (int j = 0; j < count; j++)
                result = cc + result;
        }
        return result;
    }


    static String RemoveSubstring(String s, String part) {
        StringBuilder b = new StringBuilder(s);
        while (b.indexOf(part) != -1) {
            int index = b.indexOf(part);
            b = b.replace(index, index + part.length(), "");
        }

        return b.toString();
    }

    static char OccurTwice(String s) {
        HashSet<Character> set = new HashSet<>();
        char cc = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i)))
                set.add(s.charAt(i));
            else {
                cc = s.charAt(i);
                break;
            }
        }
        return cc;
    }

    static int UniqueChar(String s) {
        HashMap<Character, Integer> characterHashMap = new HashMap<>();
        char lastChar = s.charAt(0);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!characterHashMap.containsKey(s.charAt(i))) {
                characterHashMap.put(s.charAt(i), i);
                lastChar = s.charAt(i);
            } else {
                characterHashMap.put(s.charAt(i), -1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            int curr = characterHashMap.get(s.charAt(i));
            if (curr != -1) return curr;
        }
        return -1;
    }

    public static char[] ReverseStr(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        return s;
    }

    public static String ReverseStrVowels(String s) {
        HashSet<Character> vowels = new HashSet<>() {
        };
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');
        char[] cc = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (vowels.contains(cc[i]) && vowels.contains(cc[j])) {
                char temp = cc[i];
                cc[i] = cc[j];
                cc[j] = temp;
                i++;
                j--;
            } else if (vowels.contains(cc[i]) && !vowels.contains(cc[j]))
                j--;
            else if (!vowels.contains(cc[i]) && vowels.contains(cc[j]))
                i++;
            else {
                i++;
                j--;
            }
        }
        String string = new String(cc);

        return string;
    }

    static int count(String s) {
        int starting = 0;
        int ending = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                count++;
                if (count == 2) starting = i;
            }
        }

        count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                count++;
                if (count == 2) ending = i;
            }
        }

        count = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = starting + 1; i <= ending; i++) {
            if (s.charAt(i) == '|' && stack.isEmpty()) {
                stack.add(s.charAt(i));
            } else if (s.charAt(i) == '|' && !stack.isEmpty())
                stack.pop();
            else if (s.charAt(i) == '*' && !stack.isEmpty())
                count++;
        }

        return count;
    }
}
