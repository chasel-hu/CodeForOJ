package com.chasel.niuke;

public class DeleteDuplicaNode {
	
	/**
	 * 删除排序链表中的重复节点
	 * @param pHead
	 * @return
	 */
	public static ListNode deleteDuplication(ListNode pHead) {
		if(pHead==null || pHead.next==null) return pHead;
		
		ListNode p = pHead;
		ListNode l = p.next;
		ListNode tack = pHead;
		
		while(l != null){
			if(p.val != l.val){
				tack = p;
				p = p.next;
				l = l.next;
			}else{
				while(l != null && l.val == p.val){
					l = l.next;
				}
				if(p == pHead){
					tack = l;
					pHead = l;
				}else{
					tack.next = l;
				}
				p = l;
				if(l!=null) l = l.next;
				else {
					break;
				}
			}
		}
		
		return pHead;
	}
	
	public static void main(String[] args) {
		ListNode pHead = new ListNode(1);
		ListNode l = new ListNode(1);
		pHead.next = l;
		int count = 2;
		for(int i=1; i<7; i++){
			ListNode gg = new ListNode(count);
			l.next = gg;
			l = gg;
			gg.next = null;
			if(i%2==0) count++;
		}
		
		pHead = deleteDuplication(pHead);
		
		while(pHead != null){
			System.out.print(pHead.val + " -> ");
			pHead = pHead.next;
		}
	}
}
