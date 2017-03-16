package com.chasel.niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FindSequence {
	public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer> > list = new ArrayList<ArrayList<Integer> >();
		int m = (int) Math.sqrt(sum);
		for(int i=2;i<m; i++){
			if(i%2==1 && sum % i == 0){ //奇数的情况下比较好解决
				int p = sum/i;
				int t = (i-1)/2;
				if(t > p) break;
				ArrayList<Integer> ai = new ArrayList<Integer>();
				for(int j=p-t;j<=p+t;j++) ai.add(j);
				list.add(ai);
			}else if(i%2==0){
				int p = sum/i;
				int t = i/2 - 1;
				if(t!=0 && t > p) break;
				if(p==1 || sum%p == i/2){
					ArrayList<Integer> ai = new ArrayList<Integer>();
					for(int j=p-t;j<=p+t+1;j++) ai.add(j);
					list.add(ai);
				}
			}
		}
		
		Collections.sort(list, new Comparator<ArrayList<Integer>>() {

			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				if(o1.get(0) > o2.get(0)) return 1;
				else if(o1.get(0) < o2.get(0)) return -1;
				return 0;
			}
		});
		
		return list;
    }
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer> > list = FindContinuousSequence(100);
//		for(ArrayList<Integer> alist : list){
//			for(int a : alist) System.out.print(a + " ");
//			System.out.println();
//		}
//		System.out.println(26%6);
	}
	
}
