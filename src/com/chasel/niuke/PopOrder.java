package com.chasel.niuke;

import java.util.Stack;

public class PopOrder {
	/**
	 * ������A�������£��ж�����B�Ƿ���A��һ����ջ˳��
	 * @param pushA
	 * @param popA
	 * @return
	 */
	public boolean IsPopOrder(int [] pushA,int [] popA) {
	     Stack<Integer> stack= new Stack<Integer>();
	     int j = 0;
	     for(int i=0; i<pushA.length;i++){
	    	 if(stack.isEmpty()){
	    		 stack.push(pushA[i]);
	    		 continue;
	    	 }
	    	 if(stack.peek() == popA[j]){
	    		 stack.pop();
	    		 j++;
	    	 }
	    	 stack.push(pushA[i]);
	     }
	     
	     for(;j<pushA.length;j++){
	    	 if(stack.peek() == popA[j]){
	    		 stack.pop();
	    	 }else{
	    		 return false;
	    	 }
	     }
	     return true;
    }
}
