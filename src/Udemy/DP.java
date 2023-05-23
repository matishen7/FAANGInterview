package Udemy;

import static java.lang.Math.cos;
import static java.lang.Math.max;

public class DP {
    public static void main(String[] args) {
        //int n = 6;
        int[] cost = {2,7,9,3,1};
        //System.out.println(Fibonacci(3));
        //System.out.println(Tribonacci(25));
        System.out.println(rob(cost));


    }

    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < n; i = i + 2) {
            dp[i] = nums[i] + Math.max(dp[i-1], dp[i-2]);
        }
        return Math.max(dp[n - 1], dp[n - 2]);
    }

    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return dp[0];
    }

    static int Fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    static int Tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        fib[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            fib[i] = fib[i - 1] + fib[i - 2] + fib[i - 3];
        }
        return fib[n];
    }

    static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i <= 0) dp[i] = 0;
            else if (i == 1) dp[i] = 1;
            else if (i == 2) dp[i] = 2;
            else
                dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else {
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
