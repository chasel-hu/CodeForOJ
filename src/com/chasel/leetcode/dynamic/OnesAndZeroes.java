package com.chasel.leetcode.dynamic;

/**
 * 474. Ones and Zeroes[Î´Íê³É°æ]
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2017-2-23
 * @version v1.0
 */
public class OnesAndZeroes {
	/**
	 * 
	 * @param strs
	 * @param m
	 * @param n
	 * @return
	 */
	public static int findMaxForm(String[] strs, int m, int n) {
		int index = 0;
        if(m ==0 && n==0) return 0;
        int len = strs.length;
        int[] one = new int[len+1];
        int[] zero = new int[len+1];
        one[0] = n;
        zero[0] = m;
        
        for(int i=0; i< len; i++){
        	if(addProfit(one,zero,index,strs[i])) index += 1;
        }
        
        for(int i=0; i<=index; i++){
        	System.out.println("index : " + i + " --- 0 : " + zero[i] + " --- 1 : " + one[i]);
        }
        
        return index;
    }
	
	public static boolean addProfit(int[] one, int[] zero, int index, String s){
		int num0 = 0,num1=0;
		char[] cs = s.toCharArray();
		for(int i=0; i < cs.length; i++){
			if(cs[i] == '0') num0 += 1;
			else num1 += 1;
		}
		
		if(one[index] >= num1 && zero[index] >= num0){
			one[index+1] = one[index] - num1;
			zero[index+1] = zero[index] - num0;
			return true;
		}else{
			for(int j = 0; j < index; j++){
				int temp0 = zero[j] - num0;
				int temp1 = one[j] - num1;
				if(temp0 >= zero[j+1] && temp1 >= one[j+1]){
					zero[j+1] = temp0;
					one[j+1] = temp1;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		String[] str = new String[]{"111","1000","1000","1000"};
		int m = 9;
		int n = 3;
		System.out.println("result is : " + findMaxForm(str,m,n));
	}
}
