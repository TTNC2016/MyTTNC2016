package com.tfarm.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * 禁止在事务内使用
 */
public class QuerySwitchDsDao extends JdbcDaoSupport
{
}
