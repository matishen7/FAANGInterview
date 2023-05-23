package LeetCodeEasy;

import Udemy.BinaryTreeSearch;

import javax.naming.LinkRef;
import javax.swing.plaf.IconUIResource;
import java.util.*;

import static Udemy.BinaryTreeSearch.*;

public class Contests {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        //String pattern = "abba";
        //String s = "dog cat cat dog";
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int gasTotal=0;
        int costTotal=0;
        int n=gas.length;
        //maintaining a difference array of gas and cost
        int[] diff=new int[n];
        for(int i=0; i<n; i++){
            gasTotal+=gas[i]; //finding the sum total of gas
            costTotal+=cost[i]; //finding the sum total of cost
            diff[i]=gas[i]-cost[i];
        }
        //if total cost is greater than fuel available there is no way loop can be completed
        if(costTotal>gasTotal)
            return -1;

        int res=0; //variable to maintain the sum of differences as we move forward in the loop
        int start=0; //start index of the loop
        int i=0;
        while(i<n){
            res+=diff[i];
            if(res<0){ //if at any moment difference becomes negative we flush the variable and change the start index and further check for the new start index
                res=0;
                i++;
                start=i;
            }
            else i++;
        }
        return start;
    }

    public static int waysToSplitArray(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        int count = 0;
        int rightSum;
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum = leftSum + nums[i];
            rightSum = sum - leftSum;
            if (leftSum >= rightSum) count++;
        }
        return count;
    }

    public static int findMiddleIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        int rightSum;
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 < 0) leftSum = 0;
            else
                leftSum = leftSum + nums[i - 1];
            rightSum = sum - nums[i] - leftSum;
            if (leftSum == rightSum) return i;
        }
        return -1;
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length() / 2; i++) {
            char cc = pattern.charAt(i);
            if (!map.containsKey(cc) && !set.contains(words[i])) {
                map.put(cc, words[i]);
                set.add(words[i]);
            }
        }

        for (int i = 0; i < pattern.length(); i++) {
            char cc = pattern.charAt(i);
            String expectedWord = map.get(cc);
            if (!expectedWord.equals(words[i])) return false;
        }

        return true;
    }

    public static int findLucky(int[] arr) {
        //int[] lucky = new int[arr.length];
        int maxLucky = -1;
        int maxLuckyCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++)
                if (arr[i] == arr[j]) count++;
            if (count == arr[i]) {
                if (arr[i] > maxLucky) {
                    maxLucky = arr[i];
                    maxLuckyCount = count;
                }
            }
        }
        return maxLucky;
    }

    public static long[] kthPalindrome(int[] queries, int intLength) {
        long[] pals = new long[intLength];
        for (int i = 0; i < pals.length; i++) {
            pals[i] = GetPalindrom(intLength, i);
        }
        return pals;
    }

    private static long GetPalindrom(int intLength, int i) {
        int half = (int) Math.ceil(intLength / 2);
        int d = 1;
        int halfNum = 0;
        while (half > 0) {
            halfNum = (int) (halfNum + d * Math.pow(10, d));
            half--;
            d--;
        }
        return halfNum;
    }

    public static boolean isPalindrome(int x) {
        List<Integer> list = new ArrayList<>();
        if (x < 0) return false;
        while (x > 0) {
            int d = x % 10;
            list.add(d);
            x /= 10;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (!Objects.equals(list.get(left), list.get(right))) return false;
            left++;
            right--;
        }
        return true;
    }

    public static int[] sortArrayByParity(int[] nums) {
        int[] evens = new int[nums.length];
        int[] odds = new int[nums.length];
        int e = 0, o = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evens[e] = nums[i];
                e++;
            } else {
                odds[o] = nums[i];
                o++;
            }
        }

        for (int i = 0; i < e; i++) {
            nums[i] = evens[i];
        }
        o = 0;
        for (int i = e; i < nums.length; i++) {
            nums[i] = odds[o];
            o++;
        }
        return nums;
    }

    public static int[] sortEvenOdd(int[] nums) {
        int[] evens = new int[nums.length];
        int[] odds = new int[nums.length];
        int e = 0, o = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evens[e] = nums[i];
                e++;
            } else {
                odds[o] = nums[i];
                o++;
            }
        }
        Arrays.sort(evens);
        Arrays.sort(odds);
        e = e - 1;
        o = odds.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = evens[e];
                e++;
            } else {
                nums[i] = odds[o];
                o--;
            }
        }
        return nums;
    }

    public static int[] sortArrayByParityII(int[] nums) {
        int[] evens = new int[nums.length];
        int[] odds = new int[nums.length];
        int e = 0, o = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evens[e] = nums[i];
                e++;
            } else {
                odds[o] = nums[i];
                o++;
            }
        }
        e = 0;
        o = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = evens[e];
                e++;
            } else {
                nums[i] = odds[o];
                o++;
            }
        }
        return nums;
    }

    public static int[] rearrangeArray(int[] nums) {
        int[] positives = new int[nums.length];
        int[] negatives = new int[nums.length];
        int p = 0, n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                positives[p] = nums[i];
                p++;
            } else {
                negatives[n] = nums[i];
                n++;
            }
        }
        p = 0;
        n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = positives[p];
                p++;
            } else {
                nums[i] = negatives[n];
                n++;
            }
        }
        return nums;
    }

    public static int[] pivotArray(int[] nums, int pivot) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] pivotArray = new int[nums.length];
        int leftPos = 0;
        int rightPos = 0;
        int piv = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                left[leftPos] = nums[i];
                leftPos++;
            } else if (nums[i] > pivot) {
                right[rightPos] = nums[i];
                rightPos++;
            } else {
                pivotArray[piv] = nums[i];
                piv++;
            }
        }
        for (int j = 0; j < piv; j++) {
            left[leftPos] = pivotArray[j];
            leftPos++;
        }
        for (int j = 0; j < rightPos; j++) {
            left[leftPos] = right[j];
            leftPos++;
        }
        return left;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> triplets = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int targetSum = -nums[i];
            int left = i + 1;
            searchPair(nums, targetSum, left, triplets);
        }
        return List.copyOf(triplets);
    }

    private static void searchPair(int[] nums, int targetSum, int left, Set<List<Integer>> triplets) {
        int right = nums.length - 1;
        while (left < right) {
            int currSum = nums[left] + nums[right];
            if (currSum == targetSum) {
                triplets.add(List.of(-targetSum, nums[left], nums[right]));
                left++;
                right--;
            } else if (currSum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static int[] twoSum(int[] arr, int target) {
        int[] result = {0, 0};
        HashMap<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        for (int p = 0; p < arr.length; p++) {
            Integer currentMapValue = numsMap.get(arr[p]);
            if (currentMapValue != null) {
                result[0] = currentMapValue;
                result[1] = p;
                return result;
            } else {
                int ntf = target - arr[p];
                numsMap.put(ntf, p);
            }
        }
        return null;
    }

    public static List<List<Integer>> threeSumBruteForce(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {

            for (int j = i + 1; j < nums.length - 1; j++) {
                List<Integer> l = new ArrayList<>();
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                    }
                }
                if (!l.isEmpty())
                    result.add(l);
            }
        }
        return result;
    }

    public static int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;
        for (int num : nums) {
            if ((set.contains(num + diff) && set.contains(num + 2 * diff))) {
                //first condition- j=d+i
                //second condition - k=2d+i
                ans++;

            }
        }

        return ans;
    }

    public static int arithmeticTripletsBruteForce(int[] nums, int diff) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) {
                        count++;
                        System.out.println("i=" + i + " " + nums[i]);
                        System.out.println("j=" + j + " " + nums[j]);
                        System.out.println("k=" + i + " " + nums[k]);
                    }
                }
            }
        }
        return count;
    }

    public static int countGoodTriplets(int[] nums, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (Math.abs(nums[i] - nums[j]) <= a &&
                            Math.abs(nums[j] - nums[k]) <= b &&
                            Math.abs(nums[i] - nums[k]) <= c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        boolean[] seen = new boolean[strs.length];
        List<List<String>> groups = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            List<String> group = new ArrayList<>();
            if (!seen[i]) {
                group.add(strs[i]);
                seen[i] = true;
            }
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagram(strs[i], strs[j]) && !seen[j]) {
                    group.add(strs[j]);
                    seen[j] = true;
                }
            }
            if (!group.isEmpty())
                groups.add(group);
        }
        return groups;
    }

    public static int[] decompressRLElist(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i = i + 2) {
            int times = nums[i];
            for (int j = 0; j < times; j++) {
                result.add(nums[i + 1]);
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            res[i] = result.get(i);
        return res;
    }

    public static int compress(char[] chars) {
        String r = "";
        for (int i = 0; i < chars.length; i++) {
            int count = 0;
            int j = i;
            while (chars[i] == chars[j]) {
                count++;
                j++;
                if (j == chars.length) break;
            }
            String asciiCount = NumToString(count);
            if (asciiCount.equals("1")) r = r + chars[i];
            else r = r + chars[i] + asciiCount;
            i = j - 1;
        }
        for (int i = 0; i < r.length(); i++)
            chars[i] = r.charAt(i);
        return r.length();
    }

    static String NumToString(int count) {
        if (count == 0) return "0";
        String r = "";
        while (count > 0) {
            int digit = count % 10;
            r = (char) (digit + 48) + r;
            count /= 10;
        }
        return r;
    }

    static int StringToNum(String s) {
        if (s == "0") return 0;
        int result = 0;
        int level = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int digit = s.charAt(i) - 48;
            result = result + digit * level;
            level *= 10;
        }
        return result;
    }

    public static String countAndSay(int n) {
        if (n == 1) return "1";
        String s = countAndSay(n - 1);
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            int j = i;
            while (s.charAt(i) == s.charAt(j)) {
                count++;
                j++;
                if (j == s.length()) break;
            }
            char asciiCount = (char) (count + 48);
            r = r + asciiCount + s.charAt(i);
            i = j - 1;
        }
        return r;
    }


    public static int garbageCollection(String[] garbage, int[] travel) {
        int[] metals = new int[garbage.length];
        for (int i = 0; i < garbage.length; i++) {
            int countM = 0;
            for (int j = 0; j < garbage[i].length(); j++) {
                if (garbage[i].charAt(j) == 'M') {
                    countM++;
                }
            }
            metals[i] = countM;
        }
        int j = metals.length - 1;
        while (metals[j] == 0) {
            j--;
        }
        int mtime = 0;
        for (int i = j; i >= 0; i--) {
            if (i == 0) mtime = mtime + metals[i];
            else mtime = mtime + metals[i] + travel[i - 1];
        }
        System.out.println(mtime);

        int[] papers = new int[garbage.length];
        for (int i = 0; i < garbage.length; i++) {
            int countP = 0;
            for (int p = 0; p < garbage[i].length(); p++) {
                if (garbage[i].charAt(p) == 'P') {
                    countP++;
                }
            }
            papers[i] = countP;
        }
        j = papers.length - 1;
        while (papers[j] == 0) {
            j--;
        }
        int Ptime = 0;
        for (int i = j; i >= 0; i--) {
            if (i == 0) Ptime = Ptime + papers[i];
            else Ptime = Ptime + papers[i] + travel[i - 1];
        }
        System.out.println(Ptime);
// glass
        int[] glass = new int[garbage.length];
        for (int i = 0; i < garbage.length; i++) {
            int countG = 0;
            for (int p = 0; p < garbage[i].length(); p++) {
                if (garbage[i].charAt(p) == 'G') {
                    countG++;
                }
            }
            glass[i] = countG;
        }
        j = glass.length - 1;
        while (glass[j] == 0) {
            j--;
        }
        int Gtime = 0;
        for (int i = j; i >= 0; i--) {
            if (i == 0) Gtime = Gtime + glass[i];
            else Gtime = Gtime + glass[i] + travel[i - 1];
        }
        System.out.println(Gtime);
        return mtime + Ptime + Gtime;
    }

    public static String removeStars(String s) {
        StringBuilder st = new StringBuilder(s);
        int len = st.length();
        int i = 0;
        while (i < len) {
            if (st.charAt(i) != '*') i++;
            else {
                st.delete(i - 1, i);
                st.delete(i - 1, i);
                i = i - 1;
                len = len - 2;
            }
        }
        return st.toString();
    }

    static boolean hasStarts(StringBuilder b, int pos) {
        for (int i = b.length() - 1; i >= pos; i--)
            if (b.charAt(i) == '*') return true;
        return false;
    }

    public static int[] answerQueries(int[] nums, int[] queries) {
        int[] answers = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int currentQuery = queries[i];
            int currentSum = 0;
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (currentSum + nums[j] <= currentQuery) {
                    currentSum += nums[j];
                    count++;
                }
            }
            answers[i] = count;
        }
        return answers;
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int min = 0;
        while (tickets[k] > 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] > 0) {
                    min++;
                    tickets[i]--;
                }
            }
        }
        return min;
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < students.length; i++)
            queue.add(students[i]);
        int i = 0;
        while (queue.size() > 0) {
            int currStudent = queue.peek();
            int currSandwich = sandwiches[i];
            if (currStudent == currSandwich) {
                queue.poll();
                i++;
            } else {
                if (SameValuesinStudents(new LinkedList<>(queue))) break;
                currStudent = queue.poll();
                queue.add(currStudent);
            }
        }
        return queue.size();
    }

    static boolean SameValuesinStudents(Queue<Integer> queue) {
        int value = queue.poll();
        List<Integer> arr = new ArrayList<>(queue);
        for (int i = 0; i < arr.size(); i++) {
            if (value != arr.get(i)) return false;
        }
        return true;
    }

    public static int characterReplacement(String s, int k) {
        int index = longestRepeating(s);
        char cc = s.charAt(index);
        int count = 0;
        while (k > 0) {
            if (s.charAt(index) != cc) {
                k--;
            }
            count++;
            index--;
        }
        return count;
    }

    static int longestRepeating(String s) {
        int longest = 0;
        int index = -1;
        for (int i = 0; i < s.length() - 1; i++) {
            int j = i;
            int count = 0;
            while (s.charAt(i) == s.charAt(j)) {
                count++;
                j++;
                if (j >= s.length()) break;
            }
            if (count >= longest) {
                longest = count;
                index = i + longest - 1;
            }
        }
        return index;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> maps1 = new HashMap<>();
        HashMap<Character, Integer> maps2 = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!maps1.containsKey(ransomNote.charAt(i)))
                maps1.put(ransomNote.charAt(i), 1);
            else {
                int count = maps1.get(ransomNote.charAt(i));
                maps1.put(ransomNote.charAt(i), count + 1);
            }
        }
        for (int i = 0; i < magazine.length(); i++) {
            if (!maps2.containsKey(magazine.charAt(i)))
                maps2.put(magazine.charAt(i), 1);
            else {
                int count = maps2.get(magazine.charAt(i));
                maps2.put(magazine.charAt(i), count + 1);
            }
        }
        for (Map.Entry<Character, Integer> set :
                maps1.entrySet()) {
            Character cc = set.getKey();
            Integer i1 = set.getValue();
            Integer i2;
            if (!maps2.containsKey(cc))
                i2 = 0;
            else i2 = maps2.get(cc);
            if (i1 > i2) return false;
        }
        return true;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int len = p.length();
        if (len > s.length()) return result;
        for (int i = 0; i < s.length() - len + 1; i++) {
            if (isAnagram(s.substring(i, i + len), p))
                result.add(i);
        }
        return result;
    }

    public static boolean isAnagram(String s, String t) {
        System.out.println(s + "=" + t);
        if (s.length() != t.length()) return false;
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        Arrays.sort(schars);
        Arrays.sort(tchars);
        for (int i = 0; i < schars.length; i++)
            if (schars[i] != tchars[i]) return false;
        return true;
    }

    public static List<String> letterCombinations(String digits) {
        String[] letters = new String[10];
        letters[2] = "abc";
        letters[3] = "def";
        letters[4] = "ghi";
        letters[5] = "jkl";
        letters[6] = "mno";
        letters[7] = "pqrs";
        letters[8] = "tuv";
        letters[9] = "wxyz";
        List<String> buttons = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            char cc = digits.charAt(i);
            int d = cc - 48;
            String button = letters[d];
            buttons.add(button);
        }
        List<String> result = new ArrayList<>();

        for (int i = 0; i < buttons.size(); i++) {
            for (int j = 0; j < buttons.get(i).length(); j++) {

            }
        }

        return result;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> numsArrayList = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++)
            numsArrayList.add(nums1[i]);
        for (int j = 0; j < nums2.length; j++)
            numsArrayList.add(0, nums2[j]);
        Collections.sort(numsArrayList);
        int median = numsArrayList.size() / 2;
        if (numsArrayList.size() % 2 == 0) {
            double sum = numsArrayList.get(median) + numsArrayList.get(median - 1);
            return sum / 2;
        }
        return numsArrayList.get(median) / 1.0;
    }

    static void BinaryInsert(ArrayList<Integer> list, int left, int right, int insertedNum) {
        if (left == right) {
            list.add(left - 1, insertedNum);
            return;
        }
        int median = (left + right) / 2;
        if (insertedNum > list.get(median)) {
            left = median + 1;
            BinaryInsert(list, left, right, insertedNum);
        } else {
            right = median - 1;
            BinaryInsert(list, left, right, insertedNum);
        }
    }

    public static boolean isSymmetric(BinaryTreeSearch.TreeNode root) {
        List<List<Integer>> list = LevelOrdersWithNullValues(root);
        System.out.println(list);
        Integer leftValue;
        Integer rightValue;
        for (int i = 0; i < list.size(); i++) {
            int begin = 0;
            int end = list.get(i).size() - 1;
            while (begin < end) {
                leftValue = list.get(i).get(begin);
                rightValue = list.get(i).get(end);
                if (leftValue != rightValue) return false;
                begin++;
                end--;
            }
        }
        return true;
    }

    public static List<List<Integer>> LevelOrdersWithNullValues(TreeNode head) {
        List<List<Integer>> result = new ArrayList<>();
        if (head == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (queue.size() > 0) {
            List<Integer> currentLevelValues = new ArrayList<>();
            int count = 0;
            int length = queue.size();
            while (count < length) {
                TreeNode currentNode = queue.poll();
                if (currentNode != null)
                    currentLevelValues.add(currentNode.val);
                else currentLevelValues.add(null);
                count++;
                if (currentNode != null) {
                    if (currentNode.left != null) queue.add(currentNode.left);
                    else queue.add(null);
                    if (currentNode.right != null) queue.add(currentNode.right);
                    else queue.add(null);
                }

            }
            result.add(currentLevelValues);
        }
        // result = ReverseLevelOrder(result);
        return result;
    }

    static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int[] currEdge = edges[i];
            int source = currEdge[0];
            int target = currEdge[1];
            adjList[source].add(target);
            adjList[target].add(source);
        }
        int minHeight = Integer.MAX_VALUE;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < adjList.length; i++) {
            boolean[] seen = new boolean[n];
            Queue<ArrayList<Integer>> queue = new LinkedList<>();
            queue.add(adjList[i]);
            seen[i] = true;
            int qLength = queue.size();
            int height = 0;
            while (queue.size() > 0) {
                if (qLength == 0) {
                    height++;
                    qLength = queue.size();
                }
                ArrayList<Integer> currEdges = queue.poll();
                qLength--;
                for (int v = 0; v < currEdges.size(); v++) {
                    if (!seen[currEdges.get(v)]) {
                        seen[currEdges.get(v)] = true;
                        queue.add(adjList[currEdges.get(v)]);
                    }
                }
            }
            if (minHeight > height) minHeight = height;
            if (!map.containsKey(height)) {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                map.put(height, indexes);
            } else {
                List<Integer> currIndexes = map.get(height);
                currIndexes.add(i);
                map.put(height, currIndexes);
            }
            System.out.println(i + "->" + height);
        }
        return map.get(minHeight);
    }

    public static int amountOfTime(BinaryTreeSearch.TreeNode root, int start) {
        ArrayList<Integer>[] list = GetAdjancencyList(root);
        boolean[] seen = new boolean[1000001];
        start = start - 1;
        seen[start] = true;
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        queue.add(list[start]);
        int qLength = queue.size();
        int count = 0;
        while (queue.size() > 0) {
            if (qLength == 0) {
                count++;
                qLength = queue.size();
            }
            ArrayList<Integer> currBranch = queue.poll();
            qLength--;
            for (int i = 0; i < currBranch.size(); i++) {
                if (!seen[currBranch.get(i)]) {
                    seen[currBranch.get(i)] = true;
                    queue.add(list[currBranch.get(i)]);
                }
            }
            for (int i = 0; i < list.length; i++) {
                if (!seen[i]) {
                    ArrayList<Integer> curr = list[i];
                    boolean found = false;
                    for (int j = 0; j < curr.size(); j++) {
                        if (start == curr.get(j) - 1) {
                            seen[i] = true;
                            queue.add(list[i]);
                            found = true;
                            break;
                        }
                    }
                    if (found) break;
                }
            }
        }
        return count;
    }

    static ArrayList<Integer>[] GetAdjancencyList(BinaryTreeSearch.TreeNode root) {
        ArrayList<Integer>[] list = new ArrayList[100001];
        for (int i = 0; i < list.length; i++)
            list[i] = new ArrayList<>();
        Queue<BinaryTreeSearch.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            BinaryTreeSearch.TreeNode currentNode = queue.poll();
            if (currentNode.left != null) {
                list[currentNode.val - 1].add(currentNode.left.val);
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                list[currentNode.val - 1].add(currentNode.right.val);
                queue.add(currentNode.right);
            }
        }
        return list;
    }

}
