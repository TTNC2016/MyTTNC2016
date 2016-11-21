package com.tfarm.dao;

public class DBContextHolder
{
	public static final String DATA_SOURCE_MAIN = "dataSource";
	public static final String DATA_SOURCE_QUERY = "dataSource2";
	public static final String DATA_SOURCE_ANALYZE = "dataSource3";
	public static final String DATA_SOURCE_ANALYZE_QUERY = "dataSource4";

	/** 线程变量，所以外部必须保证线程唯一性 */
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static void setDBType(String dbType)
	{
		contextHolder.set(dbType);
	}

	public static String getDBType()
	{
		String ds = contextHolder.get();
		if (ds == null)
		{
			// 默认数据库1
			return DATA_SOURCE_MAIN;
		}
		return contextHolder.get();
	}

	public static void clearDBType()
	{
		contextHolder.remove();
	}
}
