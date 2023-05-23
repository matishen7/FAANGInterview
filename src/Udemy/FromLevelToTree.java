package Udemy;

import java.util.*;

public class FromLevelToTree {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length + 1];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i])
                dp[i] = dp[i - 1] + 1;
        }
        return dp[nums.length-1];
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
            }
        }
        if (dp[amount] != amount + 1) return dp[amount];
        else return -1;
    }

    public static int[] twoSum2(int[] arr, int target) {
        int[] result = {0, 0};
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] > target)
                j--;
            else if (arr[i] + arr[j] < target) {
                i++;
            } else {
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            }
        }
        return result;
    }

    public static List<Integer> twoSum(int[] arr, int target) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        for (int p = 0; p < arr.length; p++) {
            Integer currentMapValue = numsMap.get(arr[p]);
            if (currentMapValue != null) {
                result.add(arr[currentMapValue]);
                result.add(arr[p]);
                return result;
            } else {
                int ntf = target - arr[p];
                numsMap.put(ntf, p);
            }
        }
        return null;
    }

    public static List<List<Integer>> threeSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                if (arr[i] + arr[left] + arr[right] > target)
                    right--;
                else if (arr[i] + arr[left] + arr[right] < target)
                    left++;
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[left]);
                    list.add(arr[right]);
                    ans.add(list);
                    left++;
                    while (arr[left] == arr[left - 1])
                        left++;
                }
            }
        }
        return ans;
    }

    public static int search(int[] nums, int target) {
        for (int i = 0, j = nums.length - 1; i <= j; ) {
            if (nums[i] == target)
                return i;
            if (nums[j] == target)
                return j;
            if (nums[i] > target)
                --j;
            else
                ++i;
        }
        return -1;
    }

    public static int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i != j) {
            if (nums[j] > nums[i]) {
                return nums[i];
            } else {
                int mid = (i + j) / 2;
                if (nums[mid] >= nums[i]) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
        }
        return nums[i];
    }

    public static int deleteString(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        while (!sb.isEmpty()) {
            int begin = 0;
            int end = (int) Math.floor(sb.length() / 2) + 1;
            boolean canDelete = false;
            while (!canDelete) {
                String firstHalf = sb.substring(begin, end);
                String secondHalf = sb.substring(end, sb.length());
                if (firstHalf.equals(secondHalf)) canDelete = true;
                end = (int) Math.floor(end / 2);
            }
        }
        return count;
    }

    public static int minimizeXor(int num1, int num2) {
        int setBitsNum2 = countSetBits(num2);
        int min = Integer.MAX_VALUE;
        int ans = num1;
        int maxx = Math.max(num1, num2);
        for (int i = 1; i < maxx; i++) {
            int setBits = countSetBits(i);
            if (setBits == setBitsNum2) {
                int value = i ^ num1;
                if (value < min) {
                    ans = i;
                    min = value;
                }
            }
        }
        return ans;
    }

    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public static int maxSum(int[][] grid) {
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1},
                {0, 0},
                {1, -1}, {1, 0}, {1, 1}};
        int max = 0;
        for (int i = 1; i < grid.length - 1; i++) {

            for (int j = 1; j < grid[i].length - 1; j++) {
                //System.out.print(grid[i][j]);
                int sum = 0;
                for (int k = 0; k < directions.length; k++) {
                    int[] currDirection = directions[k];
                    sum += grid[i + currDirection[0]][j + currDirection[1]];
                }
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    public static int commonFactors(int a, int b) {
        int min = Math.min(a, b);
        int count = 1;
        for (int i = 2; i <= min; i++) {
            if (a % i == 0 && b % i == 0) count++;
        }
        return count;
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];
        int max = prices[prices.length - 1];
        int j = prices.length - 1;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) min = prices[i];
            if (max < prices[j]) max = prices[j];
            if (profit < max - min) profit = max - min;
            j--;
            if (j <= i) break;
        }
        return profit;
    }

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(nums[i] + dp[i - 1], dp[i]);
        }
        return dp[nums.length];
    }

    public static int maxScore(int[] cardPoints, int k) {
        int total = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            total = total + cardPoints[i];
        }
        int l = 0, r = cardPoints.length - k - 1;
        int ans = 0;
        while (r < cardPoints.length) {
            int sum = 0;
            for (int i = l; i <= r; i++) {
                sum = sum + cardPoints[i];
            }
            ans = Math.max(ans, total - sum);
            l++;
            r++;
        }
        return ans;
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int position = 0, total = 0;
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum = sum + gas[i] - cost[i];
            if (sum < 0) {
                total += sum;
                position = i + 1;
                sum = 0;
            }
        }
        total += sum;
        if (total >= 0) return position;
        else return -1;
    }

    public static int minimumDeletions(int[] nums) {
        if (nums.length == 1) return 1;
        int max = nums[0], maxIndex = 0, min = nums[0], minIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
            if (min > nums[i]) {
                min = nums[i];
                minIndex = i;
            }
        }

        int minDeletions = Integer.MAX_VALUE;
        int i = 0;
        int deletion = 1;
        while (i < maxIndex || i < minIndex) {
            i++;
            deletion++;
        }

        if (deletion < minDeletions) minDeletions = deletion;

        i = nums.length - 1;
        deletion = 1;
        while (i > maxIndex || i > minIndex) {
            i--;
            deletion++;
        }
        if (deletion < minDeletions) minDeletions = deletion;

        deletion = nums.length - Math.abs(maxIndex - minIndex) - 1;
        deletion = nums.length - deletion;

        if (deletion < minDeletions) minDeletions = deletion;
        return minDeletions;
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    public static int maxSubArrayKadanes(int[] nums) {
        int[] maxSum = new int[nums.length];
        maxSum[0] = nums[0];
        int max = maxSum[0];
        for (int i = 1; i < nums.length; i++) {
            maxSum[i] = Math.max(nums[i], nums[i] + maxSum[i - 1]);
            if (max < maxSum[i]) max = maxSum[i];
        }
        return max;
    }

    public static int maxSubarraySumCircular(int[] nums) {
        int total = 0, maxSum = nums[0], curMax = 0, minSum = nums[0], curMin = 0;
        for (int a : nums) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }


    public static int maxSubArrayProduct(int[] nums) {
        int maxProduct = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                maxProduct = Math.max(product, maxProduct);
            }
        }
        return maxProduct;
    }

    static void PrefixRecursion(String word, HashMap<String, Integer> map) {
        for (int j = 1; j < word.length() + 1; j++) {
            String currentPrefix = word.substring(0, j);
            if (!map.containsKey(currentPrefix)) {
                map.put(currentPrefix, 1);
            } else {
                int cc = map.get(currentPrefix);
                map.put(currentPrefix, cc + 1);
            }
        }
    }

    public static int[] sumPrefixScores(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int[] answer = new int[words.length];
        //Arrays.fill(answer, 1);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = i + 1; j < word.length() + 1; j++) {
                String currentPrefix = word.substring(0, j);
                if (!map.containsKey(currentPrefix)) {
                    map.put(currentPrefix, 1);
                } else {
                    int cc = map.get(currentPrefix);
                    map.put(currentPrefix, cc + 1);
                }
            }
        }
        return answer;
    }


    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        PriorityQueue<Integer> tr = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pl = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < players.length; i++) {
            pl.add(players[i]);
        }
        for (int i = 0; i < trainers.length; i++) {
            tr.add(trainers[i]);
        }

        int count = 0;
        while (!tr.isEmpty() && !pl.isEmpty()) {
            int t = tr.peek();
            int p = pl.peek();
            if (t >= p) {
                count++;
                tr.poll();
            }
            pl.poll();
        }
        return count;
    }
}
