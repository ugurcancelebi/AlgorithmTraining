package com.company.LeetCodeJavaQuestions;
/*
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    Example:
    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
*/
public class AddTwoNums {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val,ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return new ListNode(l1.val);
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 4;
        node.next.val = 5;
        node.next.next.val = 6;
        ListNode node2 = new ListNode();
        node2.val = 1;
        node2.next.val = 2;
        node2.next.next.val = 3;
    }
}
