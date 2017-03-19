package com.chasel.niuke;

public class JudgeNumeric {
	
	public boolean isNumeric(char[] str) {
		boolean idDot = false;
		boolean afterE = false;
		for(int i=0; i<str.length; i++){
			if(str[i] >= 48 && str[i] <= 57) continue;
			else if(str[i] == 'E' || str[i] == 'e'){
				if(i==str.length-1) return false;
				afterE = true;
			}else if(str[i] == '.'){
				if(i==0 || idDot || afterE || i==str.length-1) return false;
				idDot = true;
			}else if(str[i] == '-' || str[i] == '+'){
				if(i>0){
					if(str[i-1] == '+' || str[i-1] == '-') return false;
					if(str[i-1] != 'E' && str[i-1] != 'e') return false;
				}
			}else return false;
		}
        return true;
    }
}
