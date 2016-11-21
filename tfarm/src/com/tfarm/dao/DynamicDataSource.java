package com.tfarm.dao;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource
{

	@Override
	protected Object determineCurrentLookupKey()
	{
		return DBContextHolder.getDBType();
	}

}
