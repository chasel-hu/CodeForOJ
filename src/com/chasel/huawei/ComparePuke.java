package com.chasel.huawei;

import java.util.Scanner;

public class ComparePuke {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		String[] ss = line.split("-");
		System.out.println(compare(ss[0],ss[1]));
	}
	
	public static String compare(String s1, String s2){
		String[] p1 = s1.split(" ");
		String[] p2 = s2.split(" ");

		if(p1[0].equals("joker") || p2[0].equals("joker")){
			return "joker JOKER";
		}
		
		if(p1.length == p2.length){//长度相等，比对第一个
			return (process(p1[0]) > process(p2[0]))?s1:s2;
		}else if(p1.length == 4 || p2.length == 4){//没有炸弹，则error
			return (p1.length == 4)?s1:s2;
		}
		return "ERROR";
	}
	
	public static int process(String a){
		if(a.length() == 1) {
			char c = a.charAt(0);
			switch (c) {
			case '2':
				return 15;
			case 'J':
				return 11;
			case 'Q':
				return 12;
			case 'K':
				return 13;
			case 'A':
				return 14;
			default:
				return Integer.parseInt(a);
			}
		}
		return 10;
	}
}
