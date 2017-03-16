package com.chasel.leetcode.divide;

/**
 * 402. Remove K Digits --- �㲻���������������Ǵ����
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2017-3-3
 * @version v1.0
 */
public class RemoveKDigits {
	/**
	 * ��ʼ�뷨������С�ڵ���K��Ȼ����0��
	 * ���ǰK����Ϊ0�����д���0��ָ��Χ�ڰ���0���������Ƴ��������Ƴ�ǰK�����ġ�
	 * @param num
	 * @param k
	 * @return
	 */
	public static String removeKdigits(String num, int k) {
		int len = num.length();
		if(len <= k) return "0";
		int i = 0;
		int temp = k;
		int tag0 = -1;//��ʾ���һ��0���±�
		while(i<=temp&&i<len){
			if(num.charAt(i) == '0'){
				tag0 = i;
				temp++;
			}
			i++;
		}
		int left = temp - tag0 - 1;
		if((left + tag0) >= len-1) {return "0";}
		String str = num.substring(tag0+1);
//		System.out.println(str);
//		System.out.println(left);
//		System.out.println(tag0);
//		System.out.println(temp);
        return removeKNum(str,left);
    }
	
	/**
	 * �������
	 * @param num
	 * @param k
	 * @return
	 */
	public static String removeKMax(String num, int k){
		int[] ttt = new int[10];
		for(int i=0; i<num.length();i++){
			ttt[num.charAt(i) - 48]++;
		}
		StringBuilder sb = new StringBuilder(num);
		int j = 9;
		for(int i=0; i<k;i++){
			if(ttt[j] == 0){
				i--;
				j--;
			}else{
				int t = sb.indexOf("" + j);
				sb.replace(t, t+1, "");
				ttt[j] --;
			}
		}
		return sb.toString();
	}
	
	/**
	 * ���ǿ��Ǵ�����ȵ����
	 * @param num
	 * @param k
	 * @return
	 */
	public static String removeK(String num, int k){
		if(k >= num.length()) return "0";
		StringBuilder sb = new StringBuilder(num);
		int i = 0;
		int len = num.length();
		int j = 1;
		char c = sb.charAt(0);
		while(i<k){
			if(c >= sb.charAt(j)) {
				c = sb.charAt(j);
				if(j != 0){
					sb.replace(j-1, j, "");
				}else{
					sb.replace(len-1, len, "");
				}
				len--;
				i++;
			}else{
				c = sb.charAt(j);
				j++;
			}
			if(j>=len) j = 0;
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * @param num
	 * @param k
	 * @return
	 */
	public static String removeKNum(String num, int k){
		if(k >= num.length()) return "0";
		StringBuilder sb = new StringBuilder(num);
		int i = 0;
		int j = 0;
		int len = sb.length();
		while(i<k&&j<len-1){
			if(sb.charAt(j+1) < sb.charAt(j)){
				sb.replace(j, j+1, "");
				i++;
				len--;
			}else{
				j++;
			}
		}
		if(i<k) {
			len = sb.length();
			sb.replace(len-k+i, len, "");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String num = "112";
		int k = 1;
		System.out.println(removeKdigits(num,k));
	}
}
