package com.chasel.niuke;

public class MergeLink {
	public ListNode Merge(ListNode list1,ListNode list2) {
		ListNode head = null;
		if(list1 == null){
			head = list2;
			return head;
		}
		if(list2 == null){
			head = list1;
			return head;
		}
		if(list1.val > list2.val){
			head = list2;
			list2 = list2.next;
		}else{
			head = list1;
			list1 = list1.next;
		}
		ListNode l = head;
		while(list1 != null || list2 != null){
			if(list1 == null){
				l.next = list2;
				break;
			}
			if(list2 == null){
				l.next = list1;
				break;
			}
			
			if(list1.val > list2.val){
				l.next = list2;
				list2 = list2.next;
			}else{
				l.next = list1;
				list1 = list1.next;
			}
			l = l.next;
			l.next = null;
		}
		return head;
    }
}

