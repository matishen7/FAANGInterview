package LeetCodeEasy;

public class DPProblems {
    public static void main(String[] args) {
        reverse(1534236469);
    }

    static int reverse(int x) {
        int sum = 0;
        int temp = x;
        if (x < 0) x = x * -1;
        int level = 1;
        int n = x;
        while (n > 9) {
            level *= 10;
            n /= 10;
        }

        System.out.println(level);
        while (x > 0) {
            int d = x % 10;
            sum += d * level;
            if (sum < level) return 0;
            x /= 10;
            level /= 10;
        }
        if (temp < 0) sum *= -1;
        System.out.println(sum);
        return sum;
    }
}
