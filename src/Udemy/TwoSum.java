package Udemy;

import java.util.HashMap;

public class TwoSum {
    public static int[] FindIndices(int[] arr, int target) {
        int[] result = { 0, 0};
        if (arr.length == 0) return null;
        for (int i = 0; i < arr.length; i++) {
            int numToSearch = target - arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (numToSearch == arr[j]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    public static int[] FindIndicesOptimal(int[] arr, int target)
    {
        int[] result = {0,0};
        HashMap<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        for (int p = 0; p < arr.length ; p ++)
        {
            Integer currentMapValue = numsMap.get(arr[p]);
            if (currentMapValue != null)
            {
                result[0] = currentMapValue;
                result[1] = p;
                return result;
            }
            else {
                int ntf = target - arr[p];
                numsMap.put(ntf,p);
            }
        }
        return null;
    }
}
