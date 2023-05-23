package Udemy;

public class WaterContainer {
    public static int FindGreatestArea(int[] arr) {
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int area = GetMin(arr[i], arr[j]) * (j - i);
                if (area > maxArea) maxArea = area;
            }
        }
        return maxArea;
    }

    public static int FindGreatestAreaOptimal(int[] arr) {
        int maxArea = 0;
        int p1 = 0;
        int p2 = arr.length - 1;
        while (p1 < p2) {
            {
                int area = GetMin(arr[p1], arr[p2]) * (p2 - p1);
                if (area >= maxArea) maxArea = area;
                if (arr[p1] <= arr[p2])
                    p1++;
                else p2--;

            }
        }
        return maxArea;
    }

    private static int GetMin(int a, int b) {
        if (a > b) return b;
        else return a;
    }
}
