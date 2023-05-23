package Udemy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicatesSortedArray {
    public static int Solution(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++)
        System.out.println(nums[j]);
        return i;
    }
}
