package com.chasel.huawei;

import java.util.Scanner;

public class HighScore {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int student = 0;
		int question = 0;
		while(in.hasNext()){
			student = in.nextInt();
			question = in.nextInt();
			int[] arr = new int[student];
			for (int i = 0; in.hasNext() && i < student; i++) {
				arr[i] = in.nextInt();
			}
			
			in.nextLine();
			String[] str = new String[question];
			for (int i = 0; i < question; i++) {
				str[i] = in.nextLine();
			}
			display(arr, str);
		}
	}

	public static void display(int[] student, String[] question) {
		for(int i=0; i<question.length; i++){
			String[] c = question[i].trim().split(" ");
			int tt = Integer.parseInt(c[1]);
			int pp = Integer.parseInt(c[2]);
			
			if(c[0].equals("Q")){
				if(tt > pp) System.out.println(findMax(student,pp,tt));
				else System.out.println(findMax(student,tt,pp));
			}else {
				student[tt-1] = pp;
			}
		}
	}
	
	public static int findMax(int[] student, int start, int end){
		int max = 0;
		for(int i=start-1; i<end; i++)if(student[i] > max) max = student[i];
		return max;
	}
	
}
