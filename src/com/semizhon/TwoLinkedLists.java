package com.semizhon;


import java.util.Deque;
import java.util.Stack;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

public class TwoLinkedLists {

    public static ListNode sortList(ListNode head) {
        if (head !=null && head.next == null) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head;
        ListNode headRight = null;
        ListNode resultHead = null;

        while (p2 != null && p1 != null) {

            if (p2.next == null) {
                p2 = null;
            } else {
                p2 = p2.next.next;
            }

            if(p2 == null) {
                headRight = p1.next;
                p1.next = null;
            } else {
                p1 = p1.next;
            }

        }

        ListNode head1 = sortList(head);
        ListNode head2 = sortList(headRight);

        resultHead = merge(head1, head2);


        return resultHead;
    }

    private static ListNode merge (ListNode head1, ListNode head2) {
        ListNode newHead = null;
        ListNode p1 = head1;
        ListNode p2 = head2;
        ListNode p3 = null;

        while (p1 != null || p2 != null) {
            ListNode newNode;
            if (p1 != null && p2 != null && p1.val < p2.val || p2 == null) {
                newNode = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                newNode = new ListNode(p2.val);
                p2 = p2.next;
            }

            if (newHead == null || p3 == null) {
                p3 = newHead = newNode;
            } else {
                p3.next = newNode;
                p3 = p3.next;
            }

        }

        return newHead;
    }


    public static ListNode removeElements(ListNode head, int val) {

        if (head.val == val) {
            head = head.next;
        }
        ListNode p1 = head;
        while (p1.next != null) {
            if (p1.next.val == val) {
                p1.next = p1.next.next;
            }
        }

        return head;

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int remember1 = 0;
        ListNode prevNode = null;

        while (l1 != null || l2 != null) {
            int sum = remember1;
            remember1 = 0;
            if (l1 == null) {
                sum += l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                sum += l1.val;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }


            if (sum >= 10) {
                remember1 = 1;
                sum = sum - 10;
            }
            ListNode newNode = new ListNode(sum);

        }



        return null;

    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(3);
        ListNode c1 = new ListNode(2);
        ListNode c2 = new ListNode(5);
        ListNode c3 = new ListNode(4);
        ListNode b1 = new ListNode(6);

        ListNode b2 = new ListNode(7);
        ListNode b3 = new ListNode(8);
        a1.next = a2;
        a2.next = c1;
        c1.next = c2;
        c2.next = c3;
        c3.next = b1;

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int length1 = getLength(headA);
        System.out.println("length1=" + length1);
        int length2 = getLength(headB);
        System.out.println("length2=" + length2);
        if (length1 == 0 || length2 == 0) {
            return null;
        }
        ListNode i = new ListNode(headA.val);
        i.next = headA.next;
        ListNode j = new ListNode(headB.val);
        j.next = headB.next;

        if (length1 < length2) {
            int k = length2;
            while (k != length1) {
                j = j.next;
                k--;
            }

        } else if (length1 > length2) {
            int k = length1;
            while (k != length2) {
                i = i.next;
                k--;
            }
        }

        while (i!= null && j != null && i.val != j.val) {
            i = i.next;
            j = j.next;
        }

        if (i == null || j== null) {
            return null;
        }

        if (i.val == j.val) {
            return i;
        }

        return null;

    }



    public int getLength (ListNode node) {
        int length = 0;
        if (node != null) {
            ListNode i = new ListNode(node.val);
            i.next = node.next;

            while (i != null) {
                length++;
                i = i.next;
            }
        }
        return length;
    }


}
