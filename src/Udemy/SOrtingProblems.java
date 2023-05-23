package Udemy;

import java.util.*;

public class SOrtingProblems {
    public static void main(String[] args) {
        /*String s = "anagram";
        String t = "nagaram";
        System.out.println(Anagram(s, t));*/
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] res = IntersectionTwoArrays(nums1, nums2);
        for (int i = 0; i < res.length; i++)
            System.out.println(res[i]);
    }

    public static void QuickSorting(int[] nums, int left, int right) {
        if (left < right) {
            int partitionIndex = GetPartition(nums, left, right);
            QuickSorting(nums, left, partitionIndex - 1);
            QuickSorting(nums, partitionIndex + 1, right);
        }
    }

    private static int GetPartition(int[] nums, int left, int right) {
        int pivotElement = nums[right];
        int partitionIndex = left;
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivotElement) {
                swap(nums, partitionIndex, j);
                partitionIndex++;
            }
        }
        swap(nums, partitionIndex, right);
        return partitionIndex;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static boolean Anagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        Arrays.sort(schars);
        Arrays.sort(tchars);
        for (int i = 0; i < schars.length; i++)
            if (schars[i] != tchars[i]) return false;
        return true;
    }

    public static int[] IntersectionTwoArrays(int[] nums1, int[] nums2) {
        HashSet<Integer> seen = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        //QuickSorting(nums1, 0, nums1.length - 1);
        //QuickSorting(nums2, 0, nums2.length - 1);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++)
                if (nums1[i] == nums2[j]) {
                    if (!seen.contains(nums1[i])) {
                        seen.add(nums1[i]);
                        res.add(nums1[i]);
                    }
                }
        }

        int[] array = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            array[i] = res.get(i);
            //System.out.println(array[i]);
        }
        return array;
    }

}
