package Udemy;

import java.util.*;

public class ArrayProblems {
    public static void main(String[] args) {
        int[] arr = {4,5,7,7,13};
        // System.out.println(MajorityElement(arr));

        //System.out.println(ContainsDuplicate(arr));
        //System.out.println(MissingNumber(arr));
        //int[] nums = MoveZeroes(arr);
        //for (int i = 0; i < nums.length; i++)
        //    System.out.println(nums[i]);
        //System.out.println(FindDuplicate(arr));
        //System.out.println(EdgeScore(arr));
        System.out.println(totalSteps(arr));
    }

    public static int totalSteps(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            numsList.add(nums[i]);
        int count = 0;
        return MakeNonDecreasing(numsList, count);
    }

    static int MakeNonDecreasing(List<Integer> nums, int count) {
        if (IsNonDecreasing(nums)) return count;
        count++;
        RemoveNonDecreasing(nums);
        return MakeNonDecreasing(nums, count);
    }

    static void RemoveNonDecreasing(List<Integer> nums) {
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            if (prev > nums.get(i)) {
                while (prev > nums.get(i)){
                    prev = nums.get(i);
                    nums.remove(i);
                }

            } else
                prev = nums.get(i);
        }
    }

    static boolean IsNonDecreasing(List<Integer> nums) {
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            if (prev > nums.get(i)) return false;
            prev = nums.get(i);
        }
        return true;
    }


    public static boolean canBeIncreasing(int[] nums) {
        boolean[] sorted = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (isSorted(nums, i)) sorted[i] = true;
        }
        int count = 0;
        for (int i = 0; i < sorted.length; i++)
            if (sorted[i]) count++;

        return count == 1;

    }

    private static boolean isSorted(int nums[], int skipIndex) {
        int prev = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i == skipIndex) continue;
            if (nums[i] <= prev) return false;
            prev = nums[i];
        }
        return true;
    }

    static int EdgeScore(int[] edges) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int currNode = 0; currNode < edges.length; currNode++) {
            int edge = edges[currNode];
            if (!map.containsKey(edge)) {
                map.put(edge, currNode);
            } else {
                int count = map.get(edge);
                map.put(edge, count + currNode);
            }
        }
        int maxValue = 0;
        int keyMax = 0;
        for (int i = 0; i < edges.length; i++)
            if (map.containsKey(i)) {
                maxValue = map.get(i);
                keyMax = i;
                break;
            }

        for (Map.Entry<Integer, Integer> set :
                map.entrySet()) {
            int value = set.getValue();
            int key = set.getKey();
            if (value > maxValue) {
                maxValue = value;
                keyMax = key;
            }
        }

        return keyMax;

    }

    public static int SingleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) return nums[i];
            i++;
        }
        return nums[nums.length - 1];
    }

    public static List<Integer> MajorityElement(int[] nums) {
        HashMap<Integer, Integer> elements = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int currCount;
        for (int i = 0; i < nums.length; i++) {
            if (!elements.containsKey(nums[i])) {
                elements.put(nums[i], 1);
            } else {
                currCount = elements.get(nums[i]);
                currCount = currCount + 1;
                elements.put(nums[i], currCount);
            }
        }
        for (Map.Entry<Integer, Integer> set : elements.entrySet()) {
            if (set.getValue() > nums.length / 3) {
                result.add(set.getKey());
                System.out.println(set.getKey());
            }
        }

        return result;
    }

    public static boolean ContainsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    public static int MissingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            if (i != nums[i]) return i;
        }
        return nums.length;
    }

    public static int[] MoveZeroes(int[] nums) {
        int zeroPointer = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[zeroPointer];
                nums[zeroPointer] = nums[i];
                nums[i] = temp;
                zeroPointer--;
            }
        }
        return nums;
    }

    public static int FindDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) return nums[i];
            else map.put(nums[i], 1);
        }
        return nums[nums.length - 1];
    }

    public static int[] SetMismatch(int[] nums) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) result[0] = nums[i];
            else map.put(nums[i], 1);
        }

        for (int i = 1; i <= nums.length; i++)
            if (!map.containsKey(i)) result[1] = i;
        return result;
    }
}

