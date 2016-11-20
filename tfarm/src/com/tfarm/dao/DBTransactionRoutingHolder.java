package com.tfarm.dao;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.support.DefaultTransactionStatus;

import com.tfarm.util.ObjectUtil;

public class DBTransactionRoutingHolder extends DataSourceTransactionManager
{
	private static final long serialVersionUID = -5852214615796944725L;

	public static final String TRANSACTION_1 = "db1_tx";
	public static final String TRANSACTION_3 = "db3_tx";

	@Override
	protected DefaultTransactionStatus newTransactionStatus(TransactionDefinition definition, Object transaction, boolean newTransaction, boolean newSynchronization, boolean debug, Object suspendedResources)
	{
		if (definition instanceof TransactionAttribute)
		{
			TransactionAttribute rta = (TransactionAttribute) definition;
			if (ObjectUtil.isNull(rta.getQualifier()))
			{
				// 老版本没有指定数据源，默认数据源1
				DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_MAIN);
			}
			else if (rta.getQualifier().equalsIgnoreCase(TRANSACTION_1))
			{
				DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_MAIN);
			}
			else if (rta.getQualifier().equalsIgnoreCase(TRANSACTION_3))
			{
				DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_ANALYZE);
			}
		}
		return super.newTransactionStatus(definition, transaction, newTransaction, newSynchronization, debug, suspendedResources);
	}

}
