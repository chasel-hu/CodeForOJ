package com.chasel.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. Group Anagrams
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2016-10-26
 * @version v1.0
 */
public class GroupAnagrams {

	/**
	 * 果然还是时间开销比较大的话，就需要用Map
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> list = new ArrayList<List<String>>();
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(int i=0; i<strs.length; i++){
			char[] temp = strs[i].toCharArray();
			Arrays.sort(temp);
			String s = new String(temp);
			if(map.containsKey(s)){
				int index = map.get(s);
				list.get(index).add(strs[i]);
			}else{
				map.put(s, list.size());
				List<String> ll = new ArrayList<String>();
				ll.add(strs[i]);
				list.add(ll);
			}
		}
		
		return list;
    }
	
	public static void main(String[] args) {
		GroupAnagrams obj = new GroupAnagrams();
		String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> list = obj.groupAnagrams(strs);
		
		for(List<String> ll : list){
			System.out.print("[");
			for(String s : ll){
				System.out.print("'" + s + "' ");
			}
			System.out.println("]");
		}
	}
}
