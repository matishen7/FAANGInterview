package Udemy;

import java.util.ArrayList;

public class GreedyMethod {
    public static void main(String[] args) {

        int[][] times = {{1,2,1},{2,1,3}};
        System.out.println(networkDelayTime(times, 2,2));
    }

    public static long networkDelayTime(int[][] times, int n, int k) {
        long[] distances = new long[n];
        for (int i = 0; i < n; i++)
            distances[i] = Long.MAX_VALUE;

        distances[k - 1] = 0;
        for (int i = 0; i < n - 1; i++)
        {
            int count = 0;
            for (int j = 0; j < times.length; j++)
            {
                int source = times[j][0];
                int target = times[j][1];
                int weight = times[j][2];

                if (distances[source - 1] + weight < distances[target-1]) {
                    distances[target - 1] = distances[source - 1] + weight;
                    count++;
                }
            }
            if (count == 0) break;
        }

        long ans = GetMax(distances);
        if (ans == Long.MAX_VALUE) return -1;
        return ans;
    }
    private static long GetMax(long[] arr)
    {
        long max = arr[0];
        for (int i = 0; i < arr.length; i++)
            if (max < arr[i]) max = arr[i];
        return max;
    }
}
