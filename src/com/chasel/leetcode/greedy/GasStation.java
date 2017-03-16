package com.chasel.leetcode.greedy;

/**
 * 134. Gas Station
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2017-3-2
 * @version v1.0
 */
public class GasStation {
	
	/**
	 * 有两个点需要认清
	 * 1.如果总的gas大于总的cost，那么肯定存在一个解。
	 * 2.如果车从A出发无法到达B，那么AB之间的任何站出发都无法到达B。
	 * @param gas
	 * @param cost
	 * @return
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int start = 0,total = 0,tank = 0;
		for(int i=0; i<gas.length; i++){
			tank += gas[i] - cost[i];
			if(tank < 0){
				start = i + 1;
				total += tank;
				tank = 0;
			}
		}
		return (tank+total>0)?start:-1;
    }

	public static void main(String[] args) {
		
	}
}
