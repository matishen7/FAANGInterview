package Udemy;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {

        String s = "))((";
        System.out.println(RemoveMinBrackets(s));
    }

    public static boolean Solution(String arr) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length(); i++) {
            if (arr.charAt(i) == '(' || arr.charAt(i) == '{' || arr.charAt(i) == '[')
                stack.push(arr.charAt(i));
            else {
                if (stack.isEmpty()) return false;
                char cc = (char) stack.pop();
                if (arr.charAt(i) == '}' && cc != '{')
                    return false;

                if (arr.charAt(i) == ']' && cc != '[')
                    return false;

                if (arr.charAt(i) == ')' && cc != '(')
                    return false;
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }

    public static String RemoveMinBrackets(String s) {
        StringBuilder arr = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length(); i++) {
            if (arr.charAt(i) == '(') {
                stack.push(i);
            } else if (arr.charAt(i) == ')' && stack.size() > 0) {
                stack.pop();
            } else if (arr.charAt(i) == ')') {
                arr.replace(i, i + 1, "");
                i--;
            }
            }
        while (!stack.isEmpty()) {
            int currpos = stack.pop();
            arr.replace(currpos, currpos + 1, "");
        }
        return arr.toString();
    }

}

