package com.chasel.niuke;

public class CoverRect {
	/**
	 * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ� 
	 * ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
	 * ��ͼ��֪������һ������ζ��ԣ���ȥ��ߵ�2*1,ʣ�µ�2*(n-1)
	 * ����һ���������һ�����½�����2*1��ʣ�µ���2*(n-2)
	 * ���ԣ���ʵ����һ��쳲���������
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
