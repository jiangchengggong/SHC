package com.dream.shc.sys.util;

public class StringUtil {
	public static boolean stringIsNotEmpty(String str){
		if(str==null||"".equals(str)){
			return false;
		}else{
			return true;
		}
	}

}
