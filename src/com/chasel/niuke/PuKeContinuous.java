package com.chasel.niuke;

public class PuKeContinuous {
	public static boolean isContinuous(int[] numbers) {
		if(numbers.length != 5) return false;
		int[] arr = new int[14];
		for(int i=0;i<14;i++)arr[i]=0;
		int wang = 0;
		for(int i=0;i<5;i++){
			if(numbers[i] == 0) wang++;
			else arr[numbers[i]]++;
		}
		for(int i : arr) System.out.print(i + " ");
		int count=0;
		for(int i=1;i<14;i++){
			if(arr[i]>0){
				if(arr[i] > 1) return false;
				else{
					count++;
					i++;
					for(;i<14 && wang>=0;i++){
						if(arr[i] == 1) count++;
						else if(arr[i]==0){
							if(wang==0) break;
							count++;
							wang--;
						}
						else return false;
					}
					if(count + wang ==5) return true;
					break;
				}
			}
		}
		return false;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,3,2,5,4};
		System.out.println(isContinuous(arr));
	}
}
