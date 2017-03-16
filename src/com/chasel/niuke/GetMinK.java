package com.chasel.niuke;


public class GetMinK {
	public java.util.ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		java.util.ArrayList<Integer> list = new java.util.ArrayList<Integer>();
		if(k <= input.length){
			addNum(input,0,input.length-1,k,list);
			java.util.Collections.sort(list);
		}
        return list;
    }
	
	/**
	 * end是取得到的
	 * @param input
	 * @param start
	 * @param end
	 * @param k
	 * @param list
	 */
	public void addNum(int[] input, int start, int end, int k, java.util.ArrayList<Integer> list){
		if(start == end) {
			list.add(start);
			return;
		}
		if(k == end-start+1){
			addToList(input,start,end+1,list);
			return;
		}
		int tmp = findArrayList(input,start,end);
//		System.out.println(tmp);
		
//		for(int i=0; i<input.length; i++) System.out.print(input[i] + " ");
		
		int c = tmp - start;
		if(k==c){
			addToList(input,start,tmp,list);
		}else if(k==c+1){
			addToList(input,start,tmp+1,list);
		}else if(k > c + 1){
			addToList(input,start,tmp+1,list);
			addNum(input,tmp+1,end,k-c-1,list);
		}else{
			addNum(input,start,tmp-1,k,list);
		}
	}
	
	public void addToList(int[] input, int start, int end, java.util.ArrayList<Integer> list){
		for(int i=start; i<end; i++){
			list.add(input[i]);
		}
	}
	
	/**
	 * 
	 * @param input 数组
	 * @param start 开始的位置
	 * @param end 结束位置【可达】
	 */
	private int findArrayList(int[] input, int start,int end){
		if(start >= end) return start;
		int h = start;
		int t = end;
		int target = input[start];
		while(h<t){
			while(h<t && target <= input[t]) t--;
			input[h] = input[t];
			while(h<t && target >= input[h]) h++;
			input[t] = input[h];
		}
		input[h] = target;
		return h;
	}
	
	public static void main(String[] args) {
		GetMinK gm = new GetMinK();
		int[] input = new int[]{4,5,1,6,2,7,3,8};
		int k = 8;
//		System.out.println(gm.findArrayList(input, 0, input.length-1));
		java.util.ArrayList<Integer> list = gm.GetLeastNumbers_Solution(input, k);
		for(int i : list) System.out.print(i + " ");
	}
}
