package Udemy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PlusOne {
    public static Stack<Integer> Solution(int[] nums) {
        Stack<Integer> result = new Stack<>();
        int carry = 0;
        int p = nums.length - 1;
        do {
            int sum = nums[p] + 1;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            }
            if (carry == 0) result.push(nums[p] + 1);
            else result.push(sum);
            p--;
        } while (p >= 0);
        return result;
    }
}
