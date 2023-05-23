package Udemy.InterfaceDesign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthLargest {
    int kk;
    List<Integer> stream;

    public KthLargest(int k, int[] nums) {
        stream = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            stream.add(nums[i]);
        kk = k;
    }

    public int add(int val) {
        stream.add(val);
        Collections.sort(stream);
        return stream.get(stream.size() - kk - 1);
    }
}

class SubrectangleQueries {
    int[][] rec;

    public SubrectangleQueries(int[][] rectangle) {
        rec = new int[rectangle.length][rectangle[0].length];
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < rectangle[i].length; j++)
                rec[i][j] = rectangle[i][j];
        }
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++)
            for (int j = col1; j <= col2; j++)
                rec[i][j] = newValue;
    }

    public int getValue(int row, int col) {
        return rec[row][col];
    }
}

class SubrectangleProgram {
    public static void main(String[] args) {
        SubrectangleQueries subrectangleQueries = new SubrectangleQueries(new int[][]{{1, 2, 1}, {4, 3, 4}, {3, 2, 1}, {1, 1, 1}});
        subrectangleQueries.getValue(0, 2); // return 1
        subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
        subrectangleQueries.getValue(0, 2); // return 5
        subrectangleQueries.getValue(3, 1); // return 5
        subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
        subrectangleQueries.getValue(3, 1); // return 10
        subrectangleQueries.getValue(0, 2); // return 5

        SubrectangleQueries subrectangleQueries2 = new SubrectangleQueries(new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}});
        subrectangleQueries2.getValue(0, 0); // return 1
        subrectangleQueries2.updateSubrectangle(0, 0, 2, 2, 100);
        subrectangleQueries2.getValue(0, 0); // return 100
        subrectangleQueries2.getValue(2, 2); // return 100
        subrectangleQueries2.updateSubrectangle(1, 1, 2, 2, 20);
        subrectangleQueries2.getValue(2, 2); // return 20
    }
}

class KthLargestProgram {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        kthLargest.add(3);   // return 4
        kthLargest.add(5);   // return 5
        kthLargest.add(10);  // return 5
        kthLargest.add(9);   // return 8
        kthLargest.add(4);   // return 8
    }
}
