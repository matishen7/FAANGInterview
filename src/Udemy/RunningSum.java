package Udemy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class RunningSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(Solution(arr));
    }
    public static int[] Solution(int[] arr) {
        int sum = 0;
        List<Integer> output = new ArrayList<>();
        for (int i = 0 ;i < arr.length; i++)
        {
            sum += arr[i];
            output.add(sum);
        }
        int[] array = new int[output.size()];
        /*for (int i = 0 ;i < output.size();i++){
            array[i] = output.get(i);
            System.out.println(array[i]);
        }*/

        return array;
    }
}
