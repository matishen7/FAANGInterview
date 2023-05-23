package Udemy;

public class MergeSortedLinkedList {
    public static void main(String[] args) {
        ListNode tail = new ListNode(4);
        ListNode node2 = new ListNode(2, tail);
        ListNode head = new ListNode(1, node2);

        ListNode tail2 = new ListNode(4);
        ListNode node22 = new ListNode(3, tail2);
        ListNode head2 = new ListNode(1, node22);
        PrintLinkedList(head);
        System.out.println("****************");
        PrintLinkedList(head2);
        System.out.println("****************");
        PrintLinkedList(Merge(head, head2));
    }

    public static void PrintLinkedList(ListNode head) {
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
    }

    private static class ListNode {
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

    public static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode currNode1 = list1;
        ListNode currNode2 = list2;
        ListNode listSofar = null;
        while (currNode1 != null) {
            ListNode list1Next = currNode1.next;
            ListNode list2Next = currNode2.next;
            if (currNode1.val >= currNode2.val) {
                listSofar = currNode2;
                listSofar.next = currNode1;
                listSofar.next.next = null;
                currNode2 = list2Next;
            } else {
                listSofar = currNode1;
                listSofar.next = currNode2;
            }
            currNode1 = currNode1.next;
        }
        return listSofar;
    }
}
