package LeetCodeEasy;

import java.util.*;

public class HashTable {
    public static void main(String[] arg) {
        String s = "abcde";
        System.out.println(longestContinuousSubstring(s));
    }

    public static int longestContinuousSubstring(String s) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int largest = 1;
        for (int i = 0; i < alphabet.length(); i++) {
            for (int j = i + 1; j < alphabet.length() + 1; j++) {
                if (s.contains(alphabet.substring(i, j))) {
                    if (largest < j - i) largest = j - i;
                    System.out.println(alphabet.substring(i, j));
                }
            }
        }
        return largest;
    }

    public static int smallestEvenMultiple(int n) {
        if (n % 2 == 0) return n;
        else return 2 * n;
    }

    public static long arrayManipulation(int n, int[][] queries) {
        // Write your code here
        int[] arr = new int[n];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int a = query[0];
            int b = query[1];
            int k = query[2];
            for (int j = a - 1; j < b; j++) {
                arr[j] += k;
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        return pq.poll();
    }


    static int countingValleys(int steps, String path) {
        int sealevel = 0;
        int valleys = 0;
        for (int i = 0; i < steps; i++) {
            char cc = path.charAt(i);
            if (cc == 'U') {
                sealevel += 1;
                if (sealevel == 0) valleys++;
            } else sealevel -= 1;
        }
        return valleys;
    }


    public static int[] smallerNumbersThanCurrent(int[] nums) {
        HashMap<Integer, PriorityQueue<Integer>> indexes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            PriorityQueue<Integer> list;
            if (!indexes.containsKey(nums[i])) {
                list = new PriorityQueue<>();
            } else {
                list = indexes.get(nums[i]);
            }
            list.add(i);
            indexes.put(nums[i], list);
        }
        Arrays.sort(nums);
        int[] answer = new int[nums.length];
        int prev = -1, prevCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            PriorityQueue<Integer> priorityQueue = indexes.get(value);
            int j = priorityQueue.poll();
            if (prev == nums[i]) {
                prevCount += 1;
            } else prevCount = 0;
            answer[j] = i - prevCount;
            prev = nums[i];
        }
        return answer;
    }
}
