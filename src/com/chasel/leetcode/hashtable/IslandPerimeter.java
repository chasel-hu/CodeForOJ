package com.chasel.leetcode.hashtable;

/**
 * 463. Island Perimeter
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2017-2-27
 * @version v1.0
 */
public class IslandPerimeter {
	/**
	 * 给一个二维数组，表示一个单元格，1表示有物品，0表示水。然后求所有物品组成的孤岛的边数
	 * @param grid
	 * @return
	 */
	public static int islandPerimeter(int[][] grid) {
        int total = 0;
        int height = grid.length;
        if(height == 0) return 0;
        int width = grid[0].length;
        int[][] temp = new int[height+2][width+2];
        for(int i=0; i<height; i++){
        	for(int j=0; j<width; j++){
        		temp[i+1][j+1] = grid[i][j];
        	}
        }
        
        for(int i=1; i<=height; i++){
        	for(int j=1; j<=width; j++){
        		if(temp[i][j] == 1){
        			total += 4;
        			if(temp[i-1][j] == 1) total -= 1;
        			if(temp[i][j-1] == 1) total -= 1;
        			if(temp[i+1][j] == 1) total -= 1;
        			if(temp[i][j+1] == 1) total -= 1;
        		}
        	}
        }
     
        return total;
    }
	
	public static void main(String[] args) {
		int[][] grid = new int[][]{{0,1,0,0},
				 {1,1,1,0},
				 {0,1,0,0},
				 {1,1,0,0}};
		System.out.println("result is : " + islandPerimeter(grid));
	}
}
