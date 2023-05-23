package Udemy;

// Java program to implement Max Heap

import java.util.*;

// Main class
public class MaxHeap {

    public static void main(String[] arg) {
        int[] nums = {0,0,1,0,1,1};
        System.out.println(maxDistToClosest(nums));
    }

    public static int maxDistToClosest(int[] seats) {
        List<Integer> occupied = new ArrayList<>();
        int occupiedSeats = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                occupied.add(i);
                occupiedSeats++;
            }
        }
        if (occupiedSeats == 1) {
            if (occupied.get(0) == 0 || occupied.get(0) == seats.length - 1) return seats.length - 1;
            return Math.max(occupied.get(0), seats.length - 1 - occupied.get(0));
        }
        int maxDistance = 0;
        int j = 0;
        while (seats[j]!=1)
        {
            j++;
        }
        if (j > maxDistance) maxDistance = j;
        for (int i = 1; i < occupied.size(); i++) {
            int currDis = occupied.get(i) - occupied.get(i - 1);
            if (currDis > maxDistance) maxDistance = currDis;
        }
        return maxDistance / 2;
    }

    public static int minSetSize(int[] arr) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            if (!frequency.containsKey(arr[i])) {
                frequency.put(arr[i], 1);
                pq.add(1);
            } else {
                int count = frequency.get(arr[i]);
                frequency.put(arr[i], count + 1);
                pq.add(count + 1);
            }
        }
        int len = arr.length;
        int half = arr.length / 2;
        HashSet<Integer> set = new HashSet<>();
        while (len > half) {
            int freq = pq.poll();
            int value = -1;
            for (Map.Entry<Integer, Integer> mapset :
                    frequency.entrySet()) {
                if (mapset.getValue() == freq) {
                    value = mapset.getKey();
                    frequency.put(value, -2);
                    break;
                }
            }
            set.add(value);
            len = len - freq;
        }
        return set.size();
    }

    public static int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < operations.length; i++) {
            int replaced = operations[i][0];
            int replacing = operations[i][1];
            int index = map.get(replaced);
            nums[index] = replacing;
            map.put(nums[index], index);
        }
        return nums;
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) return new int[0][0];
        int k = 0;
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = original[k];
                k++;
            }
        }
        return arr;
    }

    public static List<Integer> findDuplicates(int[] nums) {
        int[] counts = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i] - 1]++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] >= 2) ans.add(i + 1);
        }
        return ans;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) ans.add(i);
        }
        return ans;
    }

    public static int firstMissingPositive(int[] nums) {
        Set<Integer> pqMin = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            pqMin.add(nums[i]);
        }
        for (int i = 1; true; i++) {
            if (!pqMin.contains(i)) return i;
        }
    }


    public static String[] findRelativeRanks(int[] score) {
        String[] prizes = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int pr = 0;
        String[] answer = new String[score.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < score.length; i++) {
            priorityQueue.add(score[i]);
            map.put(score[i], i);
        }
        while (!priorityQueue.isEmpty()) {
            int cs = priorityQueue.poll();
            int index = map.get(cs);
            if (pr < prizes.length) {
                String cp = prizes[pr];
                pr++;
                answer[index] = cp;
            } else {
                answer[index] = String.valueOf(pr + 1);
                pr++;
            }
        }
        return answer;
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            priorityQueue.add(stones[i]);
        }
        while (priorityQueue.size() > 1) {
            int st1 = priorityQueue.poll();
            int st2 = priorityQueue.poll();
            if (st1 > st2) {
                st1 = st1 - st2;
                priorityQueue.add(st1);
            } else if (st2 > st1) {
                st2 = st2 - st1;
                priorityQueue.add(st2);
            }
        }
        if (priorityQueue.isEmpty()) return 0;
        return priorityQueue.poll();
    }

    public static int minimumOperations(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            priorityQueue.add(nums[i]);
        }
        int count = 0;
        while (!priorityQueue.isEmpty()) {
            int minValue = priorityQueue.poll();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) continue;
                nums[i] = nums[i] - minValue;
            }
            priorityQueue.clear();
            count++;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) continue;
                priorityQueue.add(nums[i]);
            }
        }
        return count;
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        ArrayList<Integer> weakest = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int soldiers = 0;
            for (int j = 0; j < mat[i].length; j++)
                if (mat[i][j] == 1) soldiers++;

            priorityQueue.add(soldiers);
            PriorityQueue<Integer> indexes;
            if (!map.containsKey(soldiers)) {
                indexes = new PriorityQueue<>();
            } else {
                indexes = map.get(soldiers);
            }
            indexes.add(i);
            map.put(soldiers, indexes);
        }
        int i = 0;
        while (i < k) {
            if (priorityQueue.isEmpty()) break;
            int currentNumSoldiers = priorityQueue.poll();
            PriorityQueue<Integer> indexes = map.get(currentNumSoldiers);
            int j = 0;
            while (j + i < k) {
                if (indexes.isEmpty()) break;
                weakest.add(indexes.poll());
                j++;
            }
            i = i + j;
        }
        int[] arr = new int[weakest.size()];
        for (int a = 0; a < weakest.size(); a++)
            arr[a] = weakest.get(a);
        return arr;
    }

    public static int maxProduct(int[] nums) {
        PriorityQueue<Integer> pQueue
                = new PriorityQueue<Integer>(
                Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            pQueue.add(nums[i]);
        }
        int a = pQueue.poll() - 1;
        int b = pQueue.poll() - 1;
        return a * b;
    }

    class SmallestInfiniteSet {
        HashSet<Integer> set;
        PriorityQueue<Integer> pq;

        public SmallestInfiniteSet() {
            set = new HashSet<>();
            pq = new PriorityQueue<>();
            for (int i = 1; i <= 1000; i++) {
                set.add(i);
                pq.add(i);
            }
        }

        public int popSmallest() {
            if (pq.isEmpty()) return 0;
            else {
                int value = pq.poll();
                set.remove(value);
                return value;
            }
        }

        public void addBack(int num) {
            if (!set.contains(num)) {
                set.add(num);
                pq.add(num);
            }
        }
    }
}

