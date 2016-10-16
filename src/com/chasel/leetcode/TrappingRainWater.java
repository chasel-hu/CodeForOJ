package com.chasel.leetcode;

/**
 * 42. Trapping Rain Water
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2016-10-16
 * @version v1.0
 */
public class TrappingRainWater {

	/**
	 * 给定非负整数表示元素高度
	 * 求出下雨的时候，最大的能容纳多少水
	 * @param height
	 * @return
	 */
	public int trap(int[] height) {

		if(height==null || height.length<=2) return 0;
		int len = height.length;
		int total = 0;
		for(int i=0;i<len;i++){
			if(i == len-1 || height[i] <= height[i+1]){
				continue;
			}else{
				int temp = height[i];
				int max = 0;
				int maxIndex = i;
				int orgin = i;
				i++;
				while(i<len){
					if(temp < height[i]){
						max=height[i];
						maxIndex=i;
						break;
					}
					if(max < height[i]) {
						max=height[i];
						maxIndex=i;
					}
					i++;
				}
				if(orgin == maxIndex || orgin == maxIndex-1) {
					if(orgin == maxIndex) i = maxIndex;
					else i = maxIndex - 1;
					continue;
				}
				total += countArea(height,orgin,maxIndex);
				i = maxIndex-1;
			}
		}
		
        return total;
    }
	
	/**
	 * 计算数组中，以head为开头，tail为结尾的容器大小
	 * @param height
	 * @param head
	 * @param tail
	 * @return
	 */
	public int countArea(int[] height, int head, int tail){
		if(head == tail || head == tail-1) return 0;
		int size = tail - head - 1;// 不计入包括head和tail的边
		int high = ((height[tail] > height[head])?height[head]:height[tail]);//存下较小的那个高度
		int total = size * high;// 计算总面积
		for(int i=head+1; i<tail;i++){// 减去各部分的面积，从head的下一位循环到tail前一位停止
			total -= height[i];
		}
		return total;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{0,2,0};
		TrappingRainWater obj = new TrappingRainWater();
		System.err.println(obj.trap(arr));
	}
}
