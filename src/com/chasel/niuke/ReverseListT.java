package com.chasel.niuke;

public class ReverseListT {

	public static ListNode ReverseList(ListNode head) {
		ListNode newHead = null;
		ListNode last = head;
		while(last != null){
			head = head.next;//head��������
			last.next = newHead;//Ȼ���һ��ת��ԭ����ͷ
			newHead = last; //ͷ����
			last = head; //last����ָ��ԭ��������
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