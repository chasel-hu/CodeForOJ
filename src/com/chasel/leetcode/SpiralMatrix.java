package com.chasel.leetcode;

import java.util.List;

/**
 * 
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2016-10-27
 * @version v1.0
 */
public class SpiralMatrix {
	
	public List<Integer> spiralOrder(int[][] matrix) {
        return null;
    }
	
	public static void main(String[] args) {
		int[][] matrix = new int[][]{};
		
		SpiralMatrix obj = new SpiralMatrix();
		List<Integer> list = obj.spiralOrder(matrix);
		
		for(Integer a : list)
			System.out.print(a + " ");
		
		System.out.println();
		System.out.println("end");
	}
}
