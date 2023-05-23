package LeetCodeEasy;

import java.util.*;

public class Contest3 {
    public static void main(String[] args) {
        int[] nums = {7, 4, 5, 1, 8, 12, 4, 7};
        System.out.println(lengthOfLIS(nums, 3));
    }

    public static int lengthOfLIS(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()) stack.add(nums[i]);
            else
            {
                int value = stack.peek();
                if (value > nums[i]) {
                    stack.pop();
                    stack.add(nums[i]);
                }
                else stack.add(nums[i]);
            }
        }
        return stack.size();
    }

    static boolean Sorted(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) return false;
        }
        return true;
    }

    public static int mostFrequentEven(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], 1);
                    priorityQueue.add(1);
                } else {
                    int count = map.get(nums[i]);
                    map.put(nums[i], count + 1);
                    priorityQueue.add(count + 1);
                }
            }
        }
        if (priorityQueue.isEmpty()) return -1;
        int max = priorityQueue.poll();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> set :
                map.entrySet()) {

            if (set.getValue() == max) pq.add(set.getKey());
        }
        return pq.poll();
    }
}
