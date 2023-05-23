package LeetCodeEasy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class MonotonousStack {
    public static void main(String[] args) {
        int[] temperatures = new int[]{5,4,3,2,1};
        nextGreaterElements(temperatures);
    }

    static int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] ans = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1)
                ans[i] = 0;
            while (!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]) {
                st.pop();
            }
            if (!st.isEmpty() && temperatures[st.peek()] > temperatures[i]) {
                ans[i] = st.peek() - i;
            }
            st.push(i);
        }
        return ans;
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans, -1);
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) ans[i] = -1;
            else
                ans[i] = nums[st.peek()];
            st.push(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) ans[i] = -1;
            else
                ans[i] = nums[st.peek()];
            st.push(i);
        }

        return ans;
    }
}
