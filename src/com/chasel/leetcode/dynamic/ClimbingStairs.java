package com.chasel.leetcode.dynamic;

/**
 * 70. Climbing Stairs
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2017-2-23
 * @version v1.0
 */
public class ClimbingStairs {
	public static int climbStairs(int n) {
        if(n<=2) return n;
        int[] f = new int[n+1];
        f[0] = 1;
        f[1] = 2;
        for(int i=2; i<n;i++){
        	f[i] = f[i-1] + f[i-2];
        }
        return f[n-1];
    }
	
	public static void main(String[] args) {
		System.out.println("result is : " + climbStairs(10));
	}
}
