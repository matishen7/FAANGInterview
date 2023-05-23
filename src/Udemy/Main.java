package Udemy;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        int sum = n;
        HashSet<Integer> set = new HashSet<>();
        while( sum != 1)
        {
            int currSum = 0;
            while (n > 0)
            {
                int digit = n%10;
                currSum += digit*digit;
                n/=10;
            }
            if (set.contains(currSum)) break;
            else set.add(currSum);
            sum = currSum;
            n = currSum;
        }
        return sum == 1;
    }
}