package com.chasel.mi;

public class BitDiff {
	/**
	 * ������������������ͬ��bit
	 * @param m
	 * @param n
	 * @return
	 */
	public static int countBitDiff(int m, int n) {
		int tmp = m^n;
		int count = 0;
		while (tmp!=0){
			count += tmp%2;
			tmp = tmp>>>1;
		}
		return count;
    }
	
	public static void main(String[] args) {
		int m = 10;
		int n = 5;
		System.out.println(countBitDiff(m,n));
	}
}
