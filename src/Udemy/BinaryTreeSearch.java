package Udemy;

import java.util.*;

import static Udemy.ReverseLinkedList.GetReverseNode;

public class BinaryTreeSearch {
    public static void main(String[] args) {
        Integer[] parent1 = {1, 2, 3, 4, 5, 6, null, null, null, 7, 8};
        Integer[] parent2 = {1, 3, 2, null, 6, 4, 5, null, null, null, null, 8, 7};

        TreeNode root1 = createTree(parent1);
        TreeNode root2 = createTree(parent2);
        System.out.println(flipEquivDFS(root1, root2));

        //System.out.println(BinaryTreeSearch.LevelOrders(root, 3, 0));
        //List<Integer> listInOrder = new ArrayList<>();
        //List<Integer> listPreOrder = new ArrayList<>();
        //List<Integer> listPostOrder = new ArrayList<>();
        //inOrderTraversal(root, listInOrder);
        //System.out.println(listInOrder);
        //System.out.println(!TraverseFromRootToLeaf(root, 6).isEmpty());
        //System.out.println(TraverseFromRootToLeaf(root, 6));
        //int count = 0;
        //System.out.println(pseudoPalindromicPaths(root));
        //System.out.println(binaryTreePaths(root));
        //smallestFromLeaf(root);
        //PathToNumber(root);
        //flatten(root);
        //System.out.println(insertIntoMaxTree(root, 10));
        //System.out.println(kthSmallest(root, 5));
        //System.out.println(constructMaximumBinaryTree(parent));
        //System.out.println(findSecondMinimumValue(root));
        //System.out.println(minDiffInBST(root));
        /*preorderTraversal(root, listPreOrder);
        System.out.println(listPreOrder);
        postorderTraversal(root, listPostOrder);
        System.out.println(listPostOrder);*/

        /*Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        List<Node> children3 = new ArrayList<>();
        children3.add(node5);
        children3.add(node6);
        Node node3 = new Node(3, children3);
        List<Node> children1 = new ArrayList<>();
        children1.add(node3);
        children1.add(node2);
        children1.add(node4);
        Node node1 = new Node(1, children1);
        System.out.println(postorderN_aryTree(node1));
        System.out.println(preorderN_aryTree(node1));
        System.out.println(levelorderN_aryTree(node1));*/
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return flipEquivDFS(root1, root2);
    }

    static boolean flipEquivDFS(TreeNode node1, TreeNode node2) {
        if (node1 != null && node2 != null) {
            if (node1.left.val != node2.right.val) return false;
            flipEquivDFS(node1.left, node2.right);
            flipEquivDFS(node2.right, node1.left);
        }
        return false;
    }

    public static TreeNode invertTree(TreeNode root) {
        return InvertDFS(root);
    }

    static TreeNode InvertDFS(TreeNode node) {
        if (node == null) return node;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        InvertDFS(node.left);
        InvertDFS(node.right);
        return node;
    }

    static int maxDepth(TreeNode node) {
        if (node == null)
            return -1;
        else {
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    public static TreeNode reverseOddLevels(TreeNode root) {
        List<List<Integer>> levels = LevelOrders(root);
        int numberOfelments = (int) (Math.pow(2, levels.size()) - 1);
        int[] arr = new int[numberOfelments];
        int k = 0;
        for (int i = 0; i < levels.size(); i++) {
            List<Integer> leveltochange = levels.get(i);
            if (i % 2 == 0)
                for (int j = 0; j < leveltochange.size(); j++) {
                    arr[k] = leveltochange.get(j);
                    k++;
                }
            else
                for (int j = leveltochange.size() - 1; j >= 0; j--) {
                    arr[k] = leveltochange.get(j);
                    k++;
                }
        }
        return null;
    }

    public static List<List<Integer>> LevelOrders(TreeNode head) {
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
                currentLevelValues.add(currentNode.val);
                count++;
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
            result.add(currentLevelValues);
        }
        // result = ReverseLevelOrder(result);
        return result;
    }

    public static ReverseLinkedList.ListNode flatten(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        System.out.println(list);
        int[] nums1 = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            nums1[i] = list.get(i);
        return GetReverseNode(nums1);
    }

    public static void sumNumbers(TreeNode root) {
        Stack<Integer> paths = new Stack<>();
        List<List<Integer>> list = new ArrayList<>();
        StringbinaryTreePathsRecursion(root, paths, list);
        System.out.println(list);
        System.out.println(FindLexSmaller(list));
    }


    static int PathToNumber(TreeNode root) {
        Stack<Integer> paths = new Stack<>();
        List<Integer> list = new ArrayList<>();
        PathToNumberRecursion(root, paths, list);
        int sum = 0;
        for (int i = 0; i < list.size(); i++)
            sum += list.get(i);
        return sum;
    }

    static void PathToNumberRecursion(TreeNode root, Stack<Integer> paths, List<Integer> list) {
        if (root != null) {
            paths.add(root.val);
            if (root.left == null && root.right == null) {
                List<Integer> p = new ArrayList<>(paths);
                int currPathNum = PathToNum(p);
                list.add(currPathNum);
            }
            PathToNumberRecursion(root.left, paths, list);
            PathToNumberRecursion(root.right, paths, list);
            paths.pop();
        }
    }

    static int PathToNum(List<Integer> path) {
        int num = 0;
        int level = (int) Math.pow(10, path.size() - 1);
        for (int i = 0; i < path.size(); i++) {
            num += level * path.get(i);
            level /= 10;
        }
        return num;
    }

    public static void smallestFromLeaf(TreeNode root) {
        Stack<Integer> paths = new Stack<>();
        List<List<Integer>> list = new ArrayList<>();
        StringbinaryTreePathsRecursion(root, paths, list);
        System.out.println(list);
        System.out.println(FindLexSmaller(list));
    }

    static String FindLexSmaller(List<List<Integer>> list) {
        List<String> listStr = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String s = "";
            for (int j = list.get(i).size() - 1; j >= 0; j--) {
                char cc = (char) ((char) list.get(i).get(j).intValue() + 97);
                s = s + cc;
            }
            listStr.add(s);
        }
        String smallest = listStr.get(0);
        for (int i = 1; i < listStr.size(); i++)
            if (smallest.compareTo(listStr.get(i)) > 0) smallest = listStr.get(i);
        return smallest;
    }

    static void StringbinaryTreePathsRecursion(TreeNode root, Stack<Integer> paths, List<List<Integer>> list) {
        if (root != null) {
            paths.add(root.val);
            if (root.left == null && root.right == null) {
                List<Integer> p = new ArrayList<>(paths);
                list.add(p);
            }
            StringbinaryTreePathsRecursion(root.left, paths, list);
            StringbinaryTreePathsRecursion(root.right, paths, list);
            paths.pop();
        }
    }

    public static int pseudoPalindromicPaths(TreeNode root) {
        Stack<Integer> paths = new Stack<>();
        List<List<Integer>> list = new ArrayList<>();
        pseudoPalindromicPathsRecursion(root, paths, list);
        return list.size();
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        Stack<Integer> paths = new Stack<>();
        binaryTreePathsRecursion(root, paths, list);
        return list;
    }

    static void binaryTreePathsRecursion(TreeNode root, Stack<Integer> paths, List<String> list) {
        if (root != null) {
            paths.add(root.val);
            if (root.left == null && root.right == null) {
                String p = GetpathAsString(paths);
                list.add(p);
            }
            binaryTreePathsRecursion(root.left, paths, list);
            binaryTreePathsRecursion(root.right, paths, list);
            paths.pop();
        }
    }

    private static String GetpathAsString(Stack<Integer> paths) {
        String s = "";
        for (int i = 0; i < paths.size(); i++)
            if (i != paths.size() - 1)
                s = s + paths.get(i) + "->";
            else s = s + paths.get(i);
        return s;
    }

    static void pseudoPalindromicPathsRecursion(TreeNode root, Stack<Integer> paths, List<List<Integer>> list) {
        if (root != null) {
            paths.add(root.val);
            if (root.left == null && root.right == null) {
                if (pseudoPalindromicPathsExists(paths)) {
                    System.out.println(paths);
                    List<Integer> p = new ArrayList<>(paths);
                    list.add(p);
                }
            }
            pseudoPalindromicPathsRecursion(root.left, paths, list);
            pseudoPalindromicPathsRecursion(root.right, paths, list);
            paths.pop();
        }
    }

    static boolean pseudoPalindromicPathsExists(Stack<Integer> paths) {
        int oddFreqTotal = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < paths.size(); i++) {
            int count = 0;
            if (!set.contains(paths.get(i))) {
                set.add(paths.get(i));
                for (int j = i; j < paths.size(); j++)
                    if (paths.get(i) == paths.get(j)) count++;
            }
            if (count % 2 != 0) oddFreqTotal++;
        }
        return oddFreqTotal <= 1;
    }

    public static List<List<Integer>> TraverseFromRootToLeaf(TreeNode root, int target) {
        Stack<Integer> paths = new Stack<>();
        List<List<Integer>> list = new ArrayList<>();
        PathsRecursion(root, paths, target, list);
        return list;
    }

    static void PathsRecursion(TreeNode root, Stack<Integer> paths, int target, List<List<Integer>> list) {
        if (root != null) {
            paths.add(root.val);
            if (root.left == null && root.right == null) {
                if (SumPaths(paths) == target) {
                    System.out.println(paths);
                    List<Integer> p = new ArrayList<>(paths);
                    list.add(p);
                }
            }
            PathsRecursion(root.left, paths, target, list);
            PathsRecursion(root.right, paths, target, list);
            paths.pop();
        }
    }

    static int SumPaths(Stack<Integer> paths) {
        int sum = 0;
        for (int i = 0; i < paths.size(); i++) {
            sum += paths.elementAt(i);
        }
        return sum;
    }

    public static TreeNode insertIntoMaxTree(TreeNode root, int val) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        list.add(val);
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            nums[i] = list.get(i);
        System.out.println(list);
        return constructMaximumBinaryTreeRecursion(nums);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTreeRecursion(nums);
    }

    static TreeNode constructMaximumBinaryTreeRecursion(int[] nums) {
        if (nums.length == 0) return null;
        int[] maxResult = FindMaxValueInArray(nums);
        int maxValue = maxResult[0];
        int maxIndex = maxResult[1];
        int[] leftArray = GetNewArrayLeft(nums, maxIndex - 1);
        int[] rightArray = GetNewArrayRight(nums, maxIndex + 1);
        TreeNode node = new TreeNode(maxValue, constructMaximumBinaryTreeRecursion(leftArray), constructMaximumBinaryTreeRecursion(rightArray));
        return node;
    }

    static int[] GetNewArrayRight(int[] nums, int from) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = from; i < nums.length; i++)
            list.add(nums[i]);

        int[] myArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            myArray[i] = list.get(i);
        return myArray;
    }

    static int[] GetNewArrayLeft(int[] nums, int end) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = end; i >= 0; i--)
            list.add(nums[i]);

        int j = 0;
        int[] myArray = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            myArray[j] = list.get(i);
            j++;
        }
        return myArray;
    }

    static int[] FindMaxValueInArray(int[] nums) {
        int[] result = new int[2];
        result[0] = nums[0];
        result[1] = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] > result[0]) {
                result[0] = nums[i];
                result[1] = i;
            }
        return result;
    }

    static int findSecondMinimumValue(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        findSecondMinimumValueDFS(root, result, set);
        Collections.sort(result);
        if (result.size() == 1) return -1;
        return result.get(1);
    }

    public static void findSecondMinimumValueDFS(TreeNode root, List<Integer> list, HashSet<Integer> set) {
        if (root != null) {
            findSecondMinimumValueDFS(root.left, list, set);
            if (!set.contains(root.val)) {
                set.add(root.val);
                list.add(root.val);
            }
            findSecondMinimumValueDFS(root.right, list, set);
        }
    }

    static int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(root, result);
        Collections.sort(result);
        return result.get(k - 1);
    }

    public static List<Integer> postorderN_aryTree(Node root) {
        List<Integer> result = new ArrayList<>();
        postorderN_aryTreeDFS(root, result);
        return result;
    }

    static void postorderN_aryTreeDFS(Node root, List<Integer> result) {
        if (root != null) {
            if (root.children != null)
                for (int i = 0; i < root.children.size(); i++)
                    postorderN_aryTreeDFS(root.children.get(i), result);
            result.add(root.val);
        }
    }

    public static List<Integer> preorderN_aryTree(Node root) {
        List<Integer> result = new ArrayList<>();
        preorderN_aryTreeDFS(root, result);
        return result;
    }

    static void preorderN_aryTreeDFS(Node root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            if (root.children != null)
                for (int i = 0; i < root.children.size(); i++)
                    preorderN_aryTreeDFS(root.children.get(i), result);
        }
    }

    public static List<List<Integer>> levelorderN_aryTree(Node root) {
        return levelorderN_aryTreeDFS(root);
    }

    static List<List<Integer>> levelorderN_aryTreeDFS(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            List<Integer> currentLevelValues = new ArrayList<>();
            int count = 0;
            int length = queue.size();
            while (count < length) {
                Node currNode = queue.poll();
                currentLevelValues.add(currNode.val);
                count++;
                List<Node> currChildren = currNode.children;
                if (currChildren != null)
                    for (int i = 0; i < currChildren.size(); i++)
                        queue.add(currChildren.get(i));
            }
            result.add(currentLevelValues);
        }
        return result;
    }

    public static boolean IsValidTree(TreeNode node) {
        if (node == null) return true;
        return IsValidDFS(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean IsValidDFS(TreeNode node, long min, long max) {
        if (node.val <= min || node.val >= max)
            return false;
        if (node.left != null)
            if (!IsValidDFS(node.left, min, node.val)) return false;
        if (node.right != null)
            if (!IsValidDFS(node.right, node.val, max)) return false;
        return true;
    }

    public static int GetMaxDepth(TreeNode head, int count) {
        if (head == null) return count;
        count++;
        System.out.println(head.val);
        int leftCount = GetMaxDepth(head.left, count);
        int rightCount = GetMaxDepth(head.right, count);
        if (leftCount > rightCount) return leftCount;
        else return rightCount;
    }

    /*public static boolean IsBalanced(TreeNode node) {
        if (node == null) return true;
        int lh = height(node.left);
        int rh = height(node.right);

        if (Math.abs(lh - rh) <= 1 && IsBalanced(node.left) && IsBalanced(node.right)) return true;
        return false;

    }
*/
    static int GetHeight(TreeNode node) {
        int height = 0;
        while (node.left != null) {
            height++;
            node = node.left;
        }
        return height;
    }



    /*static int NumberOfNodesCompleteTree(TreeNode node) {
        if (node == null) return 0;
        int height = height(node);
        if (height == 0) return 1;
        int upperCount = (int) Math.pow(2, height) - 1;
        int left = 0, right = upperCount;
        while (left < right) {
            int indexToFind = (int) Math.ceil((left + right) / 2);
            if (NodeExists(indexToFind, height, node))
                left = indexToFind;
            else right = indexToFind - 1;
        }
        return upperCount + left + 1;
    }*/

    private static boolean NodeExists(int indexToFind, int height, TreeNode node) {
        int left = 0;
        int right = (int) Math.pow(2, height) - 1;
        int count = 0;
        while (count < height) {
            int midOfNode = (int) Math.ceil((left + right) / 2);
            if (indexToFind >= midOfNode) {
                node = node.right;
                left = midOfNode;
            } else {
                node = node.left;
                right = midOfNode - 1;
            }
            count++;
        }
        return node != null;
    }


    public static int MinDepthOfBinaryTree(TreeNode root, int count) {
        if (root == null) return count;
        count++;
        if (root.left == null) return MinDepthOfBinaryTree(root.right, count);
        else if (root.right == null) return MinDepthOfBinaryTree(root.left, count);
        int leftCount = MinDepthOfBinaryTree(root.left, count);
        int rightCount = MinDepthOfBinaryTree(root.right, count);
        if (leftCount < rightCount) return leftCount;
        else return rightCount;
    }

    public static int minDiffInBST(TreeNode root) {
        int diff = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<>();
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode currentNode = queue.poll();
            result.add(currentNode.val);
            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
        }
        for (int i = 0; i < result.size(); i++)
            for (int j = i + 1; j < result.size(); j++)
                if (result.get(i) != result.get(j))
                    if (Math.abs(result.get(i) - result.get(j)) < diff) diff = Math.abs(result.get(i) - result.get(j));
        return diff;
    }


    public static List<Integer> RightSideViewBFS(TreeNode head) {
        List<Integer> result = new ArrayList<>();
        if (head == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (queue.size() > 0) {
            List<Integer> currentLevelValues = new ArrayList<>();
            int count = 0;
            int length = queue.size();
            while (count < length) {
                TreeNode currentNode = queue.poll();
                currentLevelValues.add(currentNode.val);
                count++;
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
            result.add(currentLevelValues.get(currentLevelValues.size() - 1));
        }
        // result = ReverseLevelOrder(result);
        return result;
    }

    public static List<Integer> RightSideViewDFS(TreeNode head) {
        int currentLevel = 0;
        List<Integer> result = DFS(head, currentLevel, new ArrayList<>());
        return result;
    }

    private static List<Integer> DFS(TreeNode node, int level, List<Integer> result) {
        if (node == null) return result;
        if (level >= result.size()) result.add(node.val);
        if (node.right != null)
            DFS(node.right, level + 1, result);
        if (node.left != null)
            DFS(node.left, level + 1, result);
        return result;
    }


    public static List<Double> averageOfLevels(TreeNode head) {
        List<Double> result = new ArrayList<>();
        if (head == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (queue.size() > 0) {
            List<Integer> currentLevelValues = new ArrayList<>();
            int count = 0;
            int length = queue.size();
            double sum = 0;
            while (count < length) {
                TreeNode currentNode = queue.poll();
                currentLevelValues.add(currentNode.val);
                sum += currentNode.val;
                count++;
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
            result.add(sum / count);
        }
        // result = ReverseLevelOrder(result);
        return result;
    }

    private static List<List<Integer>> ReverseLevelOrder(List<List<Integer>> levels) {
        List<List<Integer>> reversed = new ArrayList<>();
        for (int i = levels.size() - 1; i >= 0; i--) {
            reversed.add(levels.get(i));
        }
        return reversed;
    }


    public static class GenerateBinaryNode {
        public TreeNode Get() {
            TreeNode node7 = new TreeNode(9);
            TreeNode node6 = new TreeNode(5);
            TreeNode node5 = new TreeNode(16);
            TreeNode node4 = new TreeNode(25);
            TreeNode node2 = new TreeNode(7, node5, node4);
            TreeNode node1 = new TreeNode(7, node6, node7);
            TreeNode head = new TreeNode(12, node1, node2);
            return head;
        }
    }

    public static TreeNode createTree(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<Integer> integerQueue = new LinkedList<>();
        for (int i = 1; i < array.length; i++) {
            integerQueue.offer(array[i]);
        }

        TreeNode treeNode = new TreeNode(array[0]);
        treeNodeQueue.offer(treeNode);

        while (!integerQueue.isEmpty()) {
            Integer leftVal = integerQueue.isEmpty() ? null : integerQueue.poll();
            Integer rightVal = integerQueue.isEmpty() ? null : integerQueue.poll();
            TreeNode current = treeNodeQueue.poll();
            if (leftVal != null) {
                TreeNode left = new TreeNode(leftVal);
                current.left = left;
                treeNodeQueue.offer(left);
            }
            if (rightVal != null) {
                TreeNode right = new TreeNode(rightVal);
                current.right = right;
                treeNodeQueue.offer(right);
            }
        }
        return treeNode;
    }

    public static TreeNode insertLevelOrder(int[] arr, int i) {
        TreeNode root = null;
        // Base case for recursion
        if (i < arr.length) {
            root = new TreeNode(arr[i]);

            // insert left child
            root.left = insertLevelOrder(arr, 2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, 2 * i + 2);
        }
        return root;
    }

    public static TreeNode createTree(int[] parent) {
        // create an empty map
        Map<Integer, TreeNode> map = new HashMap<>();

        // create `n` new tree nodes, each having a value from 0 to `n-1`,
        // and store them in a map
        for (int i = 0; i < parent.length; i++) {
            map.put(i, new TreeNode(parent[i]));
        }

        // represents the root node of a binary tree
        TreeNode root = null;

        // traverse the parent array and build the tree
        for (int i = 0; i < parent.length; i++) {
            // if the parent is -1, set the root to the current node having the
            // value `i` (stored in map[i])
            if (parent[i] == -1) {
                root = map.get(i);
            } else {
                // get the parent for the current node
                TreeNode ptr = map.get(parent[i]);

                // if the parent's left child is filled, map the node to its right
                // child
                if (ptr.left != null) {
                    ptr.right = map.get(i);
                }
                // if the parent's left child is empty, map the node to it
                else {
                    ptr.left = map.get(i);
                }
            }
        }

        // return root of the constructed tree
        return root;
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.val + " ");
            inOrderTraversal(root.right);
        }
    }

    public static void inOrderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            inOrderTraversal(root.left, list);
            list.add(root.val);
            inOrderTraversal(root.right, list);
        }
    }

    public static void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }

    public static void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            postorderTraversal(root.left, list);
            postorderTraversal(root.right, list);
            list.add(root.val);
        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        ;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left) {
            this.left = left;
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }
}
