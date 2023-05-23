package Udemy;

public class SearchInsertPosition {
    public static int Solution(int[] nums, int target)
    {
        int pos = nums.length ;
        for (int i =0;i < nums.length;i++)
        {
            if (target <= nums[i] )
                return i;
        }
        return pos;
    }
}
