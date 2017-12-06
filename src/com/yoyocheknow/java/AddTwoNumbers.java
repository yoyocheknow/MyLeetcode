package com.yoyocheknow.java;

/**
 * 类说明
 *  You are given two non-empty linked lists representing two non-negative integers.
 *  The digits are stored in reverse order and each of their nodes contain a single digit.
 *  Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *   Example
 *   Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8
     Explanation: 342 + 465 = 807.
 *
 * @author zhangzhihua
 * @date 2017/12/5 17:28
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res= new ListNode(0);
        ListNode current=res;
        int carry=0;
        while(l1!=null||l2!=null)
        {
            int x= (l1!=null)?l1.val:0;
            int y= (l2!=null)?l2.val:0;
            int sum=x+y+carry;
            res.next=new ListNode(sum%10);
            carry=sum/10;

            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
            res=res.next;
        }

        if(carry!=0)
        {
            res.next=new ListNode(carry);
        }
        return current.next;
    }

    public static void main(String args[])
    {
        ListNode list1=new ListNode(2) ;
        ListNode list2=new ListNode(4);
        ListNode list3=new ListNode(3);
        list1.next=list2;
        list2.next=list3;
        ListNode l1=list1;
        ListNode list4 = new ListNode(5);
        ListNode list5= new ListNode(6);
        ListNode list6 = new ListNode(4);
        list4.next=list5;
        list5.next=list6;
        ListNode l2=list4;
        ListNode list ;
        list=addTwoNumbers(l1,l2);
        System.out.print(list.toString());
    }
}

 class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
    }

     @Override
     public String toString() {
         return "ListNode{" +
                 "val=" + val +
                 ", next=" + next +
                 '}';
     }
 }
