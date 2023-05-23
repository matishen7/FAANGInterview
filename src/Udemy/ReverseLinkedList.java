package Udemy;

import java.util.*;

public class ReverseLinkedList {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 19, 5, 2, 7};
        ListNode l1 = GetReverseNode(nums1);
        int[] nums2 = {1, 3, 5};
        ListNode l2 = GetReverseNode(nums2);
        //ListNode res = SumOfTwo(l1, l2);
        deleteNode(l1);

       /* ListNode digit3 = new ListNode(3);
        ListNode digit04 = new ListNode(4, digit3);
        ListNode digit2 = new ListNode(2, digit04);

        // ListNode digit4 = new ListNode(4);
        ListNode digit6 = new ListNode(6, digit3);
        ListNode digit5 = new ListNode(5, digit6);*/

        //ListNode res = mergeTwoLists(digit5, digit2);

    }

    public static void deleteNode(ListNode node) {

    }

    public static void PrintLinkedList(ListNode head) {
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
    }
    public static ListNode sortList2(ListNode head) {
        List<Integer> list1 = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list1.add(curr.val);
            curr = curr.next;
        }
        Collections.sort(list1);
        ListNode listNode = GetReverseNode(list1);
        return listNode;
    }

    static ListNode mergeTwoLists(ListNode head1, ListNode head2) {

        List<Integer> list1 = new ArrayList<>();
        ListNode curr = head1;
        while (curr != null) {
            list1.add(curr.val);
            curr = curr.next;
        }

        curr = head2;
        while (curr != null) {
            list1.add(curr.val);
            curr = curr.next;
        }
        Collections.sort(list1);
        ListNode listNode = GetReverseNode(list1);
        return listNode;
    }

    static ListNode mergeKLists(ListNode[] heads) {
        if (heads.length == 0) return null;
        boolean allAreEmpty = true;
        for (int i = 0; i < heads.length; i++) {
            if (heads[i] != null)
            {
                allAreEmpty =  false;
                break;
            }
        }
        if (allAreEmpty) return null;
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < heads.length; i++) {
            ListNode curr = heads[i];
            while (curr != null) {
                list1.add(curr.val);
                curr = curr.next;
            }
        }

        Collections.sort(list1);
        ListNode listNode = GetReverseNode(list1);
        return listNode;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr1 = headA;
        ListNode curr2 = headB;
        while (curr1 != null || curr2 != null) {
            if (curr1 == curr2) return curr1;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return null;
    }

    static int TwinSum(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            arr.add(curr.val);
            curr = curr.next;
        }

        int n = arr.size();
        int i = 0;
        int max = arr.get(0) + arr.get(n - 1);
        while (i <= (n / 2) - 1) {
            int sum = arr.get(i) + arr.get(n - 1 - i);
            if (sum > max) max = sum;
            i++;
        }
        return max;
    }

    static ListNode RemoveNThNode(ListNode head, int n) {
        List<Integer> arr = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            arr.add(curr.val);
            curr = curr.next;
        }

        curr = head;
        ListNode result = null;
        ListNode prev = null;
        for (int i = arr.size() - 1; i >= 0; i--) {
            if (i == n - 1) {
                curr = curr.next;
                continue;
            }
            ListNode created = new ListNode(curr.val, prev);
            result = created;
            prev = created;
            curr = curr.next;
        }
        result = ReverseLinkedNode(result);
        return result;
    }

    static ListNode DeleteMiddle(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            arr.add(curr.val);
            curr = curr.next;
        }

        int middle = arr.size() / 2;

        curr = head;
        ListNode result = null;
        ListNode prev = null;
        for (int i = 0; i < arr.size(); i++) {
            if (i == middle) {
                curr = curr.next;
                continue;
            }
            ListNode created = new ListNode(curr.val, prev);
            result = created;
            prev = created;
            curr = curr.next;
        }
        result = ReverseLinkedNode(result);
        return result;
    }

    static ListNode MiddleNode(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            arr.add(curr.val);
            curr = curr.next;
        }

        int middle = arr.size() / 2 + 1;

        curr = head;
        ListNode result = null;
        for (int i = 0; i < middle; i++) {
            result = curr;
            curr = curr.next;
        }
        return result;
    }

    static boolean IsPalindromeLinkedList(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            arr.add(curr.val);
            curr = curr.next;
        }

        int i = 0;
        int j = arr.size() - 1;
        while (i < j) {
            if (arr.get(i) != arr.get(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    static boolean CycleList(ListNode head) {
        ListNode curr = head;
        HashSet<ListNode> set = new HashSet<>();
        while (curr != null) {
            if (!set.contains(curr))
                set.add(curr);
            else return true;
            curr = curr.next;
        }
        return false;
    }

    public static ListNode sortList(ListNode head) {
        //Node current will point to head
        ListNode current = head, index = null;
        int temp;

        if (head == null) {
            return null;
        } else {
            while (current != null) {
                //Node index will point to node next to current
                index = current.next;

                while (index != null) {
                    //If current node's data is greater than index's node data, swap the data between them
                    if (current.val > index.val) {
                        temp = current.val;
                        current.val = index.val;
                        index.val = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
        return head;
    }

    static ListNode SumOfTwo(ListNode l1, ListNode l2) {
        int carry = 0;
        int digit1 = 0;
        int digit2 = 0;
        ListNode prev = null;
        ListNode listSofar = new ListNode();
        while (l1 != null || l2 != null) {
            if (l1 != null) digit1 = l1.val;
            else digit1 = 0;
            if (l2 != null) digit2 = l2.val;
            else digit2 = 0;
            int sum = digit1 + digit2 + carry;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            } else carry = 0;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            ListNode createdNode = new ListNode(sum, prev);
            listSofar = createdNode;
            prev = listSofar;
        }
        if (carry == 1) {
            ListNode createdNode = new ListNode(carry, prev);
            listSofar = createdNode;
        }

        return ReverseLinkedNode(listSofar);
    }

    static ListNode GetNode(int[] nums) {
        ListNode listSofar = new ListNode();
        ListNode prev = null;
        for (int i = 0; i < nums.length; i++) {
            ListNode createdNode = new ListNode(nums[i], prev);
            listSofar = createdNode;
            prev = listSofar;
        }
        return listSofar;
    }

    static ListNode GetNode(List<Integer> nums) {
        ListNode listSofar = new ListNode();
        ListNode prev = null;
        for (int i = 0; i < nums.size(); i++) {
            ListNode createdNode = new ListNode(nums.get(i), prev);
            listSofar = createdNode;
            prev = listSofar;
        }
        return listSofar;
    }


    static ListNode GetReverseNode(int[] nums) {
        ListNode listSofar = new ListNode();
        ListNode prev = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            ListNode createdNode = new ListNode(nums[i], prev);
            listSofar = createdNode;
            prev = listSofar;
        }
        return listSofar;
    }

    static ListNode GetReverseNode(List<Integer> nums) {
        ListNode listSofar = new ListNode();
        ListNode prev = null;
        for (int i = nums.size() - 1; i >= 0; i--) {
            ListNode createdNode = new ListNode(nums.get(i), prev);
            listSofar = createdNode;
            prev = listSofar;
        }
        return listSofar;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode ReverseLinkedNode(ListNode head) {
        ListNode currentNode = head;
        ListNode listSofar = null;
        while (currentNode != null) {
            ListNode next = currentNode.next;
            currentNode.next = listSofar;
            listSofar = currentNode;
            currentNode = next;
        }
        return listSofar;
    }

    public static ListNode RemoveElements(ListNode head, int value) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            if (curr.val == value) {
                if (curr == head) {
                    head = head.next;
                } else {
                    prev.next = curr.next;
                    curr = head;
                }

            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
