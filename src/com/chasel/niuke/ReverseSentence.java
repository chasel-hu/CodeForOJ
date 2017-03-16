package com.chasel.niuke;

public class ReverseSentence {

	public static String solution(String str) {
		if(str==null || str.trim().length()<=1) return str;
        StringBuilder sb = new StringBuilder();
        String[] pp = str.split(" ");
        for(int i=pp.length-1; i>0; i--) sb.append(pp[i]).append(" ");
        sb.append(pp[0]);
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String str = "";
		System.out.println(solution(str));
	}
}
