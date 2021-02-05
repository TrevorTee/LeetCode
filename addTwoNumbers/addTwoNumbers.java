package addTwoNumbers;

import javax.swing.*;
import java.util.LinkedList;

public class addTwoNumbers {
    public static void main(String[] args) {
        /*
        You are given two non-empty linked lists
                representing two non-negative integers.
        The digits are stored in reverse order,
            and each of their nodes contains a single digit.
         Add the two numbers and return the sum as a linked list.

        You may assume the two numbers do not contain any leading zero, except the number 0 itself.
         */

        /**
         * Definition for singly-linked list.
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode() {}
         *     ListNode(int val) { this.val = val; }
         *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         * }
         */
        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(4, a1);
        ListNode a3 = new ListNode(2, a2);

        ListNode a5 = new ListNode(4);
        ListNode a6 = new ListNode(6, a5);
        ListNode a4 = new ListNode(5, a6);

        ListNode res = addTwoNumbers(a3, a4);
        System.out.println(res.next.val);
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val){ this.val = val;}
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode resList = new ListNode();
        int carry = 0;
        ListNode p=l1, q=l2, cur=resList;
        while(p!=null || q!=null){
            int x = (p!=null)?p.val:0;
            int y = (q!=null)?q.val:0;
            cur.next = new ListNode((x+y+carry)%10);
            carry = (x+y+carry)/10;
            cur = cur.next;
            p = (p!=null)?p.next:null;
            q = (q!=null)?q.next:null;

        }
        if(carry!=0){
            cur.next = new ListNode(carry);
        }
        return resList.next;
    }
}
