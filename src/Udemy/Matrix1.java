package Udemy;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix1 {
    protected static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        int[][] arr = TwoDArray.GetRandomArray(10, 10);

        TwoDArray.PrintArray(arr);
        //System.out.println(Search2DMatrix(arr, 2));
        SetZeros(arr);
        TwoDArray.PrintArray(arr);
    }



    static void SetZeros(int[][] arr) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                if (arr[i][j] == 0)
                    queue.add(new int[]{i, j});

        while (queue.size() > 0) {
            int[] currCoordinates = queue.poll();
            int row = currCoordinates[0];
            int col = currCoordinates[1];

            int tempRow = row - 1;
            while (tempRow >= 0) {
                arr[tempRow][col] = 0;
                tempRow--;
            }

            tempRow = row + 1;
            while (tempRow < arr.length) {
                arr[tempRow][col] = 0;
                tempRow++;
            }

            int tempCol = col + 1;
            while (tempCol < arr.length) {
                arr[row][tempCol] = 0;
                tempCol++;
            }

            tempCol = col - 1;
            while (tempCol >= 0) {
                arr[row][tempCol] = 0;
                tempCol--;
            }
        }
    }

    static int[][] Transpose(int[][] arr) {
        int[][] res = new int[arr[0].length][arr.length];
        int i = 0, j = 0;
        for (int col = 0; col < arr[0].length; col++) {
            for (int row = 0; row < arr.length; row++) {
                //System.out.print(arr[row][col] + " ");
                res[col][row] = arr[row][col];
            }
            //System.out.println();
        }
        return res;
    }

    private static boolean Search2DMatrix(int[][] arr, int target) {
        boolean[][] seen = TwoDArray.GetSeenArray(arr.length, arr[0].length);
        //PrintArray(seen);
        boolean result = SearchDFS(arr, seen, target);
        //PrintArray(seen);
        System.out.println("Search BFS");
        return result;
    }

    private static boolean SearchDFS(int[][] arr, boolean[][] seen, int target) {
        boolean result = false;
        Queue<int[]> queue = new LinkedList<>() {
        };
        queue.add(new int[]{0, 0});
        while (queue.size() > 0) {
            int[] currPosition = queue.poll();
            int row = currPosition[0];
            int col = currPosition[1];
            if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length || seen[row][col]) continue;


            if (arr[row][col] == target) {
                result = true;
                break;
            }
            seen[row][col] = true;
            for (int k = 0; k < directions.length; k++) {
                int[] currDirection = directions[k];
                queue.add(new int[]{row + currDirection[0], col + currDirection[1]});
            }
        }
        return result;
    }
}
