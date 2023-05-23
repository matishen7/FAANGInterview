package Udemy;

public class TrappingRainWater {
    public static int Solution(int[] heights) {
        int total = 0;
        for (int i = 0; i < heights.length; i++) {
            int maxL = FindMaxLeft(heights, i);
            int maxR = FindMaxRight(heights, i);

            int currentWater = GetMin(maxL, maxR) - heights[i];
            if (currentWater > 0) total += currentWater;
        }
        return total;
    }

    public static int SolutionOptimal(int[] heights) {
        int total = 0;
        int p1 = 0;
        int p2 = heights.length - 1;
        int maxL = 0;
        int maxR = 0;
        while (p1 < p2) {
            if (heights[p1] <= heights[p2]) {
                if (heights[p1] >= maxL)
                    maxL = heights[p1];
                else total += maxL - heights[p1];
                p1++;
            }
            else
            {
                if (heights[p2] >= maxR)
                    maxR =  heights[p2];
                else total += maxR - heights[p2];
                p2--;
            }
        }
        return total;
    }

    private static int GetMin(int a, int b) {
        if (a > b) return b;
        else return a;
    }

    private static int FindMaxLeft(int[] arr, int position) {
        int max = 0;
        for (int i = 0; i < position; i++)
            if (arr[i] > max) max = arr[i];
        return max;
    }

    private static int FindMaxRight(int[] arr, int position) {
        int max = 0;
        for (int i = position; i < arr.length; i++)
            if (arr[i] > max) max = arr[i];
        return max;
    }
}
