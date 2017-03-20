package com.chasel.niuke;

public class CoverRect {
	/**
	 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。 
	 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
	 * 画图可知，对于一个大矩形而言，切去左边的2*1,剩下的2*(n-1)
	 * 还有一种是左边是一个上下交叠的2*1，剩下的是2*(n-2)
	 * 所以，其实答案是一个斐波那契数列
	 * @param target
	 * @return
	 */
	public int RectCover(int target) {
		if(target <= 2) return target;
		int a = 1,b = 2;
		for(int i=3;i<=target;i++){
			int tmp = a+b;
			a = b;
			b = tmp;
		}
		return b;
	}
}
