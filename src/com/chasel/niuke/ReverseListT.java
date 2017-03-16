package com.chasel.niuke;

public class ReverseListT {

	public static ListNode ReverseList(ListNode head) {
		ListNode newHead = null;
		ListNode last = head;
		while(last != null){
			head = head.next;//head先往下移
			last.next = newHead;//然后第一个转向原来的头
			newHead = last; //头重置
			last = head; //last继续指向原来的链首
		}
		
		return newHead;
    }
	
	public static void main(String[] args) {
		ListNode node = new ListNode(9);
		ListNode temp = node;
		for(int i=10; i<20; i++){
			temp.next = new ListNode(i);
			temp = temp.next;
			temp.next = null;
		}
		
		temp = ReverseList(node);
		
		while(temp != null){
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
	}

}