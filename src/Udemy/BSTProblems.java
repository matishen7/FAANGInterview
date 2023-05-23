package Udemy;

import java.util.*;

public class BSTProblems {
    public static void main(String[] args) {
        BinaryTreeSearch.GenerateBinaryNode generateBinaryNode = new BinaryTreeSearch.GenerateBinaryNode();
        BinaryTreeSearch.TreeNode head = generateBinaryNode.Get();
        System.out.println(BinaryTreeSearch.LevelOrders(head));
        //System.out.println(SumInRange(head, 5, 7));
        // System.out.println(SearchInBST(head, 12));
        //System.out.println(MinDifferenceBetweenNodes(head, Integer.MAX_VALUE,  Integer.MAX_VALUE));
        System.out.println(FindMode(head));


    }

    static int SumInRange(BinaryTreeSearch.TreeNode node, int low, int high) {
        int sum = 0;
        if (node == null) return sum;
        Queue<BinaryTreeSearch.TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (queue.size() > 0) {
            int count = 0;
            int length = queue.size();
            while (count < length) {
                BinaryTreeSearch.TreeNode currentNode = queue.poll();
                if (currentNode.val >= low && currentNode.val <= high) sum = sum + currentNode.val;
                count++;
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
        }
        return sum;
    }

    static List<Integer> FindMode(BinaryTreeSearch.TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if (node == null) return null;
        Stack<BinaryTreeSearch.TreeNode> stack = new Stack<>();
        stack.add(node);
        while (stack.size() > 0) {
            int count = 0;
            int length = stack.size();
            while (count < length) {
                BinaryTreeSearch.TreeNode currentNode = stack.pop();
                if (currentNode.left != null)
                {
                    if (currentNode.val == currentNode.left.val)
                        result.add(currentNode.val);
                }
                if (currentNode.right != null)
                {
                    if (currentNode.val == currentNode.right.val)
                        result.add(currentNode.val);
                }
                count++;
                if (currentNode.left != null) stack.add(currentNode.left);
                if (currentNode.right != null) stack.add(currentNode.right);
            }
        }
        return result;
    }

    static List<BinaryTreeSearch.TreeNode> SearchInBST(BinaryTreeSearch.TreeNode node, int val) {
        List<BinaryTreeSearch.TreeNode> result = new ArrayList<>();
        if (node == null) return null;
        Queue<BinaryTreeSearch.TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (queue.size() > 0) {
            int count = 0;
            int length = queue.size();
            while (count < length) {
                BinaryTreeSearch.TreeNode currentNode = queue.poll();
                if (currentNode.val == val) {
                    result.add(currentNode);
                }
                count++;
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
        }
        if (result.isEmpty()) return null;
        return result;
    }
}
