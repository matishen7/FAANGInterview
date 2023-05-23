package LeetCodeEasy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Contest2 {
    public static void main(String[] args) {
        String s = "zz";
        int[] nums1 = new int[]{1, 2, 3, 4, 3};
        int[] nums2 = new int[]{1, 3, 4, 2};
        System.out.println(nextGreaterElements(nums1));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] pos = new int[nums.length];
        Arrays.fill(pos, -1);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j != i) {
                if (j == nums.length) j = 0;
                if (nums[i] < nums[j]) {
                    pos[i] = nums[j];
                    break;
                }
                j++;
            }
        }
        return pos;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nums2Map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            nums2Map.put(nums2[i], i);
        }
        int[] pos = new int[nums1.length];
        Arrays.fill(pos, -1);
        for (int i = 0; i < nums1.length; i++) {
            int currentIdx = nums2Map.get(nums1[i]);
            int j = currentIdx + 1;
            while (j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    pos[i] = nums2[j];
                    break;
                }
                j++;
            }
        }
        return pos;
    }

    public static int[] finalPrices(int[] prices) {
        int[] finalP = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int discount = 0;
            int j = i + 1;
            while (j < prices.length) {
                if (prices[j] < prices[i]) {
                    discount = prices[j];
                    break;
                }
                j++;
            }
            finalP[i] = prices[i] - discount;
        }
        return finalP;
    }

    public static int[] dailyTemperatures(int[] temperatures) {

        int[] temp = new int[temperatures.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < temperatures.length; i++) {
            map.put(temperatures[i], i);
        }
        for (int i = 0; i < temperatures.length - 1; i++) {
            int currTemp = temperatures[i];
            for (int j = currTemp + 1; j <= 100; j++) {
                if (map.containsKey(j)) {
                    int index = map.get(j);
                    if (index < i) continue;
                    temp[i] = index - i;
                    break;
                }
            }
        }
        return temp;
    }

    public static int longestNiceSubarray(int[] nums) {
        if (nums.length == 1) return 1;
        int max = 0;
        int[] ands = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                System.out.print(nums[i] + "&" + nums[j] + "=");
                System.out.println(nums[i] & nums[j]);
            }
            //ands[i] = nums[i] & nums[i + 1];
        }
        /*for (int i = 0; i < ands.length; i++) {
            if (ands[i] == 0) {
                int count = 0;
                int j = i;
                while (ands[j] == 0)
                {
                    count++;
                    j++;
                    if (j >= ands.length) break;
                }
                if (count > max) max = count;
            }
        }*/
        return max;
    }

    public static boolean checkDistances(String s, int[] distance) {
        char[] alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for (int i = 0; i < alphabet.length; i++) {
            char cc = alphabet[i];
            int count = 0;
            int firstIndex = s.indexOf(cc);
            if (firstIndex == -1) continue;
            int j = firstIndex + 1;
            while (cc != s.charAt(j)) {
                j++;
            }

            count = j - firstIndex - 1;
            if (count != distance[i]) return false;
        }
        return true;
    }
}
