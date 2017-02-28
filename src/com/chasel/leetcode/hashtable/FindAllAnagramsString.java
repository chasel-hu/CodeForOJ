package com.chasel.leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. Find All Anagrams in a String
 * @author hujiancai
 * @email jiancaihu@gmail.com
 * @createTime 2017-2-27
 * @version v1.0
 */
public class FindAllAnagramsString {
	/**
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        if(s.length() == 0 || p.length()==0 || s.length() < p.length()) return list;
        int len = s.length() - p.length();
        char[] pp = p.toCharArray();
        char[] cc = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<pp.length; i++){
        	if(!map.containsKey(pp[i])) map.put(pp[i], 1);
        	else {
        		int aa = map.get(pp[i]);
        		map.put(pp[i], aa+1);
        	}
        }
        
        String sub = s.substring(0,p.length());
        System.out.println(sub);
        for(int i=0; i<sub.length(); i++){
        	if(map.containsKey(cc[i])){
        		int aa = map.get(cc[i]);
        		map.put(cc[i], aa-1);
        	}
        }
        
        for(int i=0; i<len; i++){
        	if(isAnagrams(cc,i,p.length()+i,map)){
        		list.add(i+1);
        	}
        }
        return list;
    }
	
	public static boolean isAnagrams(char[] cc, int index, int end, Map<Character, Integer> map){
		if(index != -1){
			if(map.containsKey(cc[index])){
				int start = map.get(cc[index]);
				map.put(cc[index], start+1);
			}
			if(map.containsKey(cc[end])){
				int start = map.get(cc[end]);
				map.put(cc[end], start-1);
			}
		}
		boolean flag = true;
		Collection<Integer> col = map.values();
		for (int tt : col) {
			if (tt != 0) {
				flag = false;
				break;
			}
		}
		if(flag) return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		String s = "aa";
		String p = "bb";
		List<Integer> list = findAnagrams(s,p);
		System.out.print("[");
		for(Integer a : list){
			System.out.print( a + ",");
		}
		System.out.println("]");
		
	}
}
