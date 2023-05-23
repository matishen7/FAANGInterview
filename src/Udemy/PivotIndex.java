package Udemy;

import java.util.ArrayList;
import java.util.List;

public class PivotIndex {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(Solution(arr));
    }

    public static int Solution(int[] arr) {
        if (arr.length == 0) return -1;
        int sumLeft = 0;
        int sumTotal = 0;
        for (int i = 0; i < arr.length; i++)
            sumTotal += arr[i];
        for (int i = 0; i < arr.length; i++) {
            if (i >= 1)
                sumLeft += arr[i - 1];
            else {
                sumLeft = 0;
            }
            int sumRight = sumTotal - sumLeft - arr[i];
            if (sumLeft == sumRight) return i;
        }
        return -1;
    }
}
