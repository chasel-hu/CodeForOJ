package com.chasel.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 57. Insert Interval
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2017-3-5
 * @version v1.0
 */
public class InsertInterval {
	/**
	 * 
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if(intervals == null || newInterval == null) return intervals;
		int size = intervals.size();
		
		//����if����һ���ж�
		if(size == 0 || intervals.get(size-1).end < newInterval.start) {
			intervals.add(newInterval);
			return intervals;
		}
		if(intervals.get(0).start > newInterval.end) {
			intervals.add(0, newInterval);
			return intervals;
		}
		int tag0 = 0;
		int tag1 = 0;
		int i = 0;
		for(; i<size; i++){
			if(intervals.get(i).start > newInterval.start) {
				tag0 = i-1;
				break;
			}
		}
		for(; i<size; i++){
			if(intervals.get(i).end >= newInterval.end) {
				tag1 = i;
				break;
			}
		}
		
		if(tag0 < 0)
		
		System.out.println("tag0 is " + tag0 + ", tag1 is " + tag1);
        return null;
    }
	
	public static int compare(Interval a, Interval b){
		if(a.start==b.start&&a.end==b.end) return 0; //��ȫ�غ�
		if(a.end <= b.start) return -3; //a��ȫС��b
		if(a.start >= b.end) return 3; //a��ȫ����b
		else if(a.start < b.start){
			if(a.end < b.end) return -2; //aǰ�벿����b����
			else return -1; //a��ȫ��Χb
		}else{
			if(a.end < b.end) return 1; //b��ȫ��Χa
			else return 2; //a��벿����b����
		}
	}
	
	public static void main(String[] args) {
		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1,2));
		list.add(new Interval(3,5));
		list.add(new Interval(6,7));
		list.add(new Interval(8,10));
		list.add(new Interval(12,16));
		Interval ite = new Interval(1,6);
		
		List<Interval> result = insert(list, ite);
//		for(Interval i : result) System.out.print(i + ",");
	}
}

class Interval{
	 int start;
	 int end;
	 Interval() { start = 0; end = 0; }
	 Interval(int s, int e) { start = s; end = e; }
	@Override
	public String toString() {
		return "[" + start + ", " + end + "]";
	}
	 
}