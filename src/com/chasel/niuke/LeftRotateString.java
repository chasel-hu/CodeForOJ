package com.chasel.niuke;

public class LeftRotateString {

	public String solution(String str,int n) {
        int len = str.length();
        n = n%len;
        String t1 = str.substring(0,n);
        String t2 = str.substring(n);
        return t2+t1;
    }
}
