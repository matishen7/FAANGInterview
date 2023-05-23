package LeetCodeEasy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class StringManipulation {
    public static void main(String[] arg) {
        String s = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        System.out.println(areNumbersAscending(s));
    }

    public static boolean areNumbersAscending(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        int prev = -1;
        while (st.hasMoreElements()) {
            String w = st.nextToken();
            try {
                int i = Integer.parseInt(w);
                if (prev >= i) return false;
                prev = i;
            } catch (Exception e) {

            }
        }
        return true;
    }

    public static String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] ans = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            int order = words[i].charAt(words[i].length() - 1) - 48;
            StringBuilder sb = new StringBuilder(words[i]);
            sb.replace(sb.length() - 1, sb.length(), "");
            ans[order - 1] = sb.toString();
        }
        s = "";
        for (int i = 0; i < ans.length; i++) {
            if (i != ans.length - 1)
                s = s + ans[i] + " ";
            else s = s + ans[i];
        }
        return s;
    }

    public static List<String> cellsInRange(String s) {
        char[] columns = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] rows = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int fromCol = 0;
        int toCol = 0;
        for (int i = 0; i < columns.length; i++) {
            if (columns[i] == s.charAt(0)) {
                fromCol = i;
            }
            if (columns[i] == s.charAt(3)) {
                toCol = i;
            }
        }
        int fromRow = 0, toRow = 0;
        for (int i = 0; i < rows.length; i++) {
            if (rows[i] == s.charAt(1)) {
                fromRow = i;
            }
            if (rows[i] == s.charAt(4)) {
                toRow = i;
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = fromCol; i <= toCol; i++) {

            for (int j = fromRow; j <= toRow; j++) {
                String cell = "";
                cell = cell + columns[i] + rows[j];
                ans.add(cell);
            }
        }
        return ans;
    }

    public static String restoreString(String s, int[] indices) {
        char[] answer = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char cc = s.charAt(i);
            int index = indices[i];
            answer[index] = cc;
        }
        s = "";
        for (char c : answer) {
            s = s + c;
        }
        return s;
    }

    public static String interpret(String command) {
        StringBuilder sb = new StringBuilder(command);
        String p = "()";
        while (sb.indexOf(p) != -1) {
            int ind = sb.indexOf(p);
            sb.replace(ind, ind + 2, "o");
        }
        String al = "(al)";
        while (sb.indexOf(al) != -1) {
            int ind = sb.indexOf(al);
            sb.replace(ind, ind + 4, "al");
        }
        return sb.toString();
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            for (int j = 0; j < jewels.length(); j++) {
                if (jewels.charAt(j) == stones.charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static int mostWordsFound(String[] sentences) {
        int max = 0;
        for (int i = 0; i < sentences.length; i++) {
            String sentence = sentences[i];
            String[] words = sentence.split(" ");
            int wordCount = words.length;
            if (wordCount > max) max = wordCount;
        }
        return max;
    }

    public static int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (int i = 0; i < operations.length; i++) {
            String currOperation = operations[i];
            if (currOperation.equals("++X")) ++x;
            else if (currOperation.equals("X++")) x++;
            else if (currOperation.equals("--X")) --x;
            else if (currOperation.equals("X--")) x--;
        }
        return x;
    }

    public static String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder(address);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '.') {
                sb.replace(i, i + 1, "[.]");
                i = i + 2;
            }
        }
        return sb.toString();
    }
}

