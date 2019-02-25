package com.dataStructure.leetCode;


import java.util.LinkedList;
import java.util.Queue;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

public class Solution2 {
    Queue priorityQueue=new LinkedList();
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a=l1.val,b=l2.val;
        int a1=1,a2=1;
        while(l1.next!=null){
            l1=l1.next;
            a1=a1*10;
            a=a+a1*l1.val;
        }
        while(l2.next!=null){
            l2=l2.next;
            a2=a2*10;
            b=b+a2*l2.val;
        }

        int c=a+b;
        reverse(c);
        ListNode node=new ListNode(Integer.parseInt(priorityQueue.poll().toString()));
        ListNode listNode=node;
        while (!priorityQueue.isEmpty()){
            listNode.next=new ListNode(Integer.parseInt(priorityQueue.poll().toString()));
            listNode=listNode.next;
        }
        return node;

    }
    private void reverse(int a){
      StringBuilder s=new StringBuilder(a);
      s.reverse();
      for(int i=0;i<s.length();i++){

      }
    }
    private void multiply(int a){

    }
    public static void main(String args[]){
            Queue priorityQueue1=new LinkedList();
           /* priorityQueue1.add(2);
            priorityQueue1.add(4);
            priorityQueue1.add(3);*/
            priorityQueue1.add(9);
            ListNode l1=new ListNode(Integer.parseInt(priorityQueue1.poll().toString()));
            ListNode listNode=l1;
            while(!priorityQueue1.isEmpty()){
                listNode.next=new ListNode(Integer.parseInt(priorityQueue1.poll().toString()));
                listNode=listNode.next;
            }

        Queue priorityQueue2=new LinkedList();
        priorityQueue2.add(1);
        for(int i=0;i<7;i++){
            priorityQueue2.add(9);
        }
        ListNode l2=new ListNode(Integer.parseInt(priorityQueue2.poll().toString()));
        ListNode listNode2=l2;
        while(!priorityQueue2.isEmpty()){
            listNode2.next=new ListNode(Integer.parseInt(priorityQueue2.poll().toString()));
            listNode2=listNode2.next;
        }
        Solution2 solution2=new Solution2();
        solution2.addTwoNumbers(l1,l2);
    }
}