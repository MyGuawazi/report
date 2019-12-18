package com.janus.report.util;
/**
*
*数据源类型
*@author ZWB
*@date 2019年11月22日
*@version 1.0  
*/
public class DataSourceType {
	
	/**
	 * 内部枚举类
	 * 用于选择数据源类型
	 */
	public enum DataBaseType{
		OA,Primeton,ERP
	}
	
	//使用ThreadLocal保证线程安全
	private static final ThreadLocal<DataBaseType> TYPE = new ThreadLocal<DataBaseType>();
	
	/**
	 * 往当前线程里设置数据源类型
	 * @param dataBaseType
	 */
	public static void setDataSource(DataBaseType dataBaseType) {
		if(dataBaseType == null) {
			throw new NullPointerException();
		}
		TYPE.set(dataBaseType);
	}
	
	/**
	 * 获取数据源类型
	 * 	如果当前线程没有数据类型,就默认OA数据源
	 * @return
	 */
	public static DataBaseType getDataBaseType() {
		return TYPE.get() == null ? DataBaseType.OA : DataBaseType.Primeton;
	}
	
	/**
	 * 清空数据源类型
	 */
	public static void clearDataBaseType() {
		TYPE.remove();
	}

}
