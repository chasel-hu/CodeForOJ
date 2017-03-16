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
	 * ����������Ҫ����
	 * 1.����ܵ�gas�����ܵ�cost����ô�϶�����һ���⡣
	 * 2.�������A�����޷�����B����ôAB֮����κ�վ�������޷�����B��
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
