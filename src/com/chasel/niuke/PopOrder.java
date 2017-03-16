package com.chasel.niuke;

import java.util.Stack;

public class PopOrder {
	/**
	 * 在数组A的条件下，判断数组B是否是A的一个出栈顺序
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
