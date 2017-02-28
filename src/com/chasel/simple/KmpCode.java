package com.chasel.simple;

/**
 * 实现kmp算法
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2016-10-17
 * @version v1.0
 */
public class KmpCode {
	
	/**
	 * 生成next的数组
	 * @param charSet
	 * @return
	 */
	public int[] creatNext(char[] charSet){
		int len = charSet.length;
		int[] next = new int[charSet.length];
		next[0] = 0;
		if(len <= 1) return next; 
		next[1] = 1;
		int j = 0;
		for(int i=2; i<len; i++){
			if(j==0||charSet[i-1] == charSet[j-1]){
				j++;
				next[i] = j;
			}else{
				j = next[j];
				i--;
			}
			System.err.println("i " +  i + "-- j " + j);
		}
		return next;
	}
	
	public static void main(String[] args) {
		char[] set = new char[]{'a','b','a','a','b','a','c','a'};
		int[] arr = new KmpCode().creatNext(set);
		for(char a : set) System.err.print(a+",");
		System.err.println();
		for(int a : arr) System.err.print(a+",");
	}
}
