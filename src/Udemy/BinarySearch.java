package Udemy;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 3, 5, 5, 5, 7, 8, 9};
        System.out.println(GuessGame(10));
    }

    public static int BinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] <= target)
                left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static int BinarySearch(int[] arr, int target, int leftPos, int rightPos) {
        int left = leftPos;
        int right = rightPos;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] <= target)
                left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static int[] FindRange(int[] nums, int target) {
        int[] range = {-1, -1};
        if (nums.length == 0) return range;
        int firstPos = BinarySearch(nums, target, 0, nums.length - 1);
        if (firstPos == -1) return range;
        int startPos = firstPos, endPos = firstPos, temp1 = 0, temp2 = 0;
        while (startPos != -1) {
            temp1 = startPos;
            startPos = BinarySearch(nums, target, 0, startPos - 1);
        }
        startPos = temp1;

        while (endPos != -1) {
            temp2 = endPos;
            endPos = BinarySearch(nums, target, endPos + 1, nums.length - 1);
        }
        endPos = temp2;

        range[0] = startPos;
        range[1] = endPos;

        System.out.println(startPos);
        System.out.println(endPos);
        return range;
    }

    public static int FirstBadversion(int n) {
        int index = -1;
        int start = 1;
        int end = n;
        boolean found = false;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            found = isBad(mid);
            if (!found)
                start = mid + 1;
            else {
                index = mid;
                end = mid - 1;
            }
        }
        return index;
    }

    public static int GuessGame(int n) {
        int total = 0;
        int start = 1;
        int end = n;
        int found  = -1;
        while (found!=0) {
            int mid = start + (end - start) / 2;
            found = GuessNum(mid);
            if (found == 1) {
                start = mid + 1;
                total += mid;
            }
            else if (found == -1){
                end = mid - 1;
                total += mid;
            }
            else return total;
        }
        return total;
    }

    private static int GuessNum(int n) {
        int pick = 10;
        if (n > pick) return -1;
        else if (n < pick)
            return 1;
        return 0;
    }

    public void maxValue(String n, int x) {
        //73,6 => 763
        //-55,2=>-255
        int ascii;
        StringBuilder num = new StringBuilder(n);
        int pos = 0;
        if (num.charAt(0) != '-')
        {
            do {
               ascii = (int) num.charAt(0);
               pos++;
            }
            while ( x < ascii);
            System.out.println(pos);
        }
    }

    private static boolean isBad(int n)
    {
        return true;
    }
}
