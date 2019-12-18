package com.janus.report.util;

import java.util.List;

/**
*
*
*@author ZWB
*@date 2019年12月12日
*@version 1.0  
*/
public class CusUilts {
	
	public static <T> boolean isEquals(List<T> list1,List<T> list2) {
		if(null != list1 && null != list2){
			if(list1.containsAll(list2) && list2.containsAll(list1)){
				return true;
			}
			return false;
		}
		return false;
	}

}
