package Udemy;

import javax.swing.*;
import java.util.*;

public class TwoDArray {

    protected static int[][] directions = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1},};

    protected static int[][] directionsDiagoncal = {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}};

    protected static int[][] directionsUpandLeft = {
            {-1, 0},
            {0, -1}};

    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
        };
        /*int[][] arr = {
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };*/
        PrintArray(arr);
        PrintArray(floodFill(arr, 1, 0, 2));
        //PrintArray(arr);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        int currentColor = image[sr][sc];
        while (queue.size() > 0) {
            int[] currCoordinates = queue.poll();
            int row = currCoordinates[0];
            int col = currCoordinates[1];
            image[row][col] = color;
            for (int k = 0; k < directions.length; k++) {
                int[] currDirection = directions[k];
                int nextRow = row + currDirection[0];
                int nextCol = col + currDirection[1];

                if (nextRow < 0 || nextRow >= image.length || nextCol < 0 || nextCol >= image[0].length)
                    continue;
                if (image[nextRow][nextCol] != color && image[nextRow][nextCol] == currentColor) {
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }
        return image;
    }

    static int minPathSum(int[][] grid) {
        int sum = 0;
        int upValue;
        int leftValue;
        int row = grid.length - 1;
        int col = grid[grid.length - 1].length - 1;
        while (row >= 0 && col >= 0) {
            sum = sum + grid[row][col];
            if (row == 0 && col == 0) break;
            if (row - 1 < 0) upValue = Integer.MAX_VALUE;
            else upValue = grid[row - 1][col];
            if (col - 1 < 0) leftValue = Integer.MAX_VALUE;
            else leftValue = grid[row][col - 1];
            if (upValue < leftValue) {
                if (row > 0)
                    row = row - 1;
                else row = 0;
            } else {
                if (col > 0)
                    col = col - 1;
                else col = 0;
            }

        }
        return sum;
    }

    static int[][] MaxLocalInteger(int[][] arr) {
        int[][] maxLocal = new int[arr.length - 2][arr.length - 2];

        for (int i = 0; i < maxLocal.length; i++) {
            for (int j = 0; j < maxLocal[0].length; j++) {
                boolean[][] seen = new boolean[arr.length][arr.length];
                int max = BFSLargestLocal(arr, seen, i + 1, j + 1);
                maxLocal[i][j] = max;
            }
        }
        PrintArray(maxLocal);
        return maxLocal;
    }

    static int BFSLargestLocal(int[][] arr, boolean[][] seen, int m, int n) {
        int max = arr[m][n];

        for (int k = 0; k < directionsDiagoncal.length; k++) {
            int[] currDirection = directionsDiagoncal[k];
            int value = arr[m + currDirection[0]][n + currDirection[1]];
            if (value > max) max = value;
        }
        return max;
    }

    static void WallsGates(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++)
            for (int col = 0; col < matrix[0].length; col++)
                if (matrix[row][col] == 0)
                    WallsGatesDFS(matrix, row, col, 0);
    }

    static void WallsGatesDFS(int[][] matrix, int row, int col, int step) {
        step++;
        for (int k = 0; k < directions.length; k++) {
            int[] currDirections = directions[k];
            int nextRow = row + currDirections[0];
            int nextCol = col + currDirections[1];
            if (nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[0].length)
                continue;
            if (step < matrix[nextRow][nextCol]) {
                matrix[nextRow][nextCol] = step;
                WallsGatesDFS(matrix, nextRow, nextCol, step);
            }
        }
    }

    static int IslandPerimeter(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) queue.add(new int[]{i, j});
            }
        int perimeter = 0;
        while (queue.size() > 0) {
            int[] currCoordinates = queue.poll();
            int currRow = currCoordinates[0];
            int currCol = currCoordinates[1];
            int numWalls = 0;
            for (int k = 0; k < directions.length; k++) {
                int[] currDirections = directions[k];
                int nextRow = currRow + currDirections[0];
                int nextCol = currCol + currDirections[1];

                if (nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[0].length) {
                    numWalls++;
                    continue;
                }

                if (matrix[nextRow][nextCol] == 0)
                    numWalls++;
            }
            perimeter += numWalls;
        }

        System.out.println(perimeter);
        return perimeter;
    }


    static int RottenOranges(int[][] matrix) {
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) fresh++;
                else if (matrix[i][j] == 2) queue.add(new int[]{i, j});
            }

        int qLength = queue.size();
        int minutes = 0;
        while (queue.size() > 0) {
            if (qLength == 0) {
                minutes++;
                qLength = queue.size();
            }

            int[] currCoordinates = queue.poll();
            qLength--;
            int currRow = currCoordinates[0];
            int currCol = currCoordinates[1];


            for (int k = 0; k < directions.length; k++) {
                int[] currDirection = directions[k];
                int nextRow = currRow + currDirection[0];
                int nextCol = currCol + currDirection[1];

                if (nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[0].length)
                    continue;
                if (matrix[nextRow][nextCol] == 1) {
                    fresh--;
                    queue.add(new int[]{nextRow, nextCol});
                    matrix[nextRow][nextCol] = 2;
                }
            }
        }
        if (fresh > 0) {
            System.out.println(-1);
            return -1;
        }
        System.out.println(minutes);
        return minutes;
    }

    static int CountIslands(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                    matrix[i][j] = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    while (queue.size() > 0) {
                        int[] currPosition = queue.poll();
                        int currRow = currPosition[0];
                        int currCol = currPosition[1];

                        for (int k = 0; k < directions.length; k++) {
                            int[] currDirection = directions[k];
                            int nextRow = currRow + currDirection[0];
                            int nextCol = currCol + currDirection[1];

                            if (nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[0].length)
                                continue;
                            if (matrix[nextRow][nextCol] == 1) {
                                queue.add(new int[]{nextRow, nextCol});
                                matrix[nextRow][nextCol] = 0;
                            }
                        }
                    }
                }
            }
        System.out.println(count);
        return count;
    }

    static List<Integer> TraversalDFS(int[][] arr) {
        boolean[][] seen = GetSeenArray(arr.length, arr[0].length);
        //PrintArray(seen);
        List<Integer> result = new ArrayList<>();
        DFS(arr, 0, 0, seen, result);
        //PrintArray(seen);
        System.out.println("Traversal DFS");
        PrintArray(result);

        return result;
    }

    static List<Integer> TraversalBFS(int[][] arr) {
        boolean[][] seen = GetSeenArray(arr.length, arr[0].length);
        //PrintArray(seen);
        List<Integer> result = BFS(arr, seen);
        //PrintArray(seen);
        System.out.println("Traversal BFS");
        PrintArray(result);
        return result;
    }

    static void DFS(int[][] arr, int row, int col, boolean[][] seen, List<Integer> result) {
        if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length || seen[row][col]) return;

        seen[row][col] = true;
        result.add(arr[row][col]);

        for (int k = 0; k < directions.length; k++) {
            int[] currDirection = directions[k];
            DFS(arr, row + currDirection[0], col + currDirection[1], seen, result);
        }
    }

    static List<Integer> BFS(int[][] arr, boolean[][] seen) {
        List<Integer> result = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>() {
        };
        queue.add(new int[]{0, 0});
        while (queue.size() > 0) {
            int[] currPosition = queue.poll();
            int row = currPosition[0];
            int col = currPosition[1];
            if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length || seen[row][col]) continue;

            seen[row][col] = true;
            result.add(arr[row][col]);

            for (int k = 0; k < directions.length; k++) {
                int[] currDirection = directions[k];
                queue.add(new int[]{row + currDirection[0], col + currDirection[1]});
            }
        }
        return result;
    }

    static void PrintArray(int[][] arr) {
        System.out.println("******************");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void PrintArray(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void PrintArray(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    public static int[][] GetRandomArray(int rowLength, int colLength) {
        int[][] resultArray = new int[rowLength][colLength];
        Random random = new Random();
        for (int i = 0; i < rowLength; i++)
            for (int j = 0; j < colLength; j++) {
                int value = random.nextInt(10);
                resultArray[i][j] = value;
            }
        return resultArray;
    }

    public static boolean[][] GetSeenArray(int rowLength, int colLength) {
        boolean[][] resultArray = new boolean[rowLength][colLength];
        Random random = new Random();
        for (int i = 0; i < rowLength; i++)
            for (int j = 0; j < colLength; j++) {
                resultArray[i][j] = false;
            }
        return resultArray;
    }
}
