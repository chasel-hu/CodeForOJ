package com.chasel.niuke;

public class FindAppearingOnce {

	public static char FirstAppearingOnce(String s){
		int len = 0;
		if(s==null || (len=s.length())==0) return '#';
		if(len==1) return s.charAt(0);
		int[] firstshow = new int[256];
		int[] count = new int[256];
		for(int i=0;i<256;i++){
			firstshow[i]=-1;
			count[i]=0;
		}
		for(int i=0; i<len; i++){
			int t = s.charAt(i);
			if(firstshow[t] == -1){
				count[t] = 1;
				firstshow[t] = i;
			}else{
				count[t]++;
			}
		}
		
		for(int i=0;i<256;i++){
			if(firstshow[i] == -1) continue;
			if(count[i] == 1){
				if(firstshow[i] < len) len = firstshow[i];
			}
		}
		
		if(len < s.length()) return s.charAt(len);
		
		return '#';
    }
	
	public static void main(String[] args) {
		String s = "google";
		StringBuilder sb = new StringBuilder();
		System.out.println(FirstAppearingOnce(s));
	}
}
