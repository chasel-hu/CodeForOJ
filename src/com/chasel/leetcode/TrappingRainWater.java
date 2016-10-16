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
	 * �����Ǹ�������ʾԪ�ظ߶�
	 * ��������ʱ�����������ɶ���ˮ
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
	 * ���������У���headΪ��ͷ��tailΪ��β��������С
	 * @param height
	 * @param head
	 * @param tail
	 * @return
	 */
	public int countArea(int[] height, int head, int tail){
		if(head == tail || head == tail-1) return 0;
		int size = tail - head - 1;// ���������head��tail�ı�
		int high = ((height[tail] > height[head])?height[head]:height[tail]);//���½�С���Ǹ��߶�
		int total = size * high;// ���������
		for(int i=head+1; i<tail;i++){// ��ȥ�����ֵ��������head����һλѭ����tailǰһλֹͣ
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
