package com.tfarm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class BaseOperDao extends JdbcDaoSupport
{
	@Deprecated
	public int queryForInt(String sql)
	{
		int ret = getWrapTemplate().queryForInt(sql);
		return ret;
	}

	@Deprecated
	public int queryForInt(String sql, Object[] obj)
	{
		int ret = getWrapTemplate().queryForInt(sql, obj);
		return ret;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> queryForMap(String sql)
	{
		List<Map<String, Object>> row = getWrapTemplate().queryForList(sql);
		if (row == null || row.size() == 0)
		{
			return null;
		}
		return row.get(0);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> queryForMap(String sql, Object[] obj)
	{
		List<Map<String, Object>> row = getWrapTemplate().queryForList(sql, obj);
		if (row == null || row.size() == 0)
		{
			return null;
		}
		return row.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> queryForList(String sql)
	{
		List<Map<String, Object>> row = getWrapTemplate().queryForList(sql);
		return row;
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> queryForList(String sql, int timeout)
	{
		List<Map<String, Object>> row = getWrapTemplate(timeout).queryForList(sql);
		return row;
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> queryForList(String sql, Object[] obj)
	{
		List<Map<String, Object>> row = getWrapTemplate().queryForList(sql, obj);
		return row;
	}

	public List<Map<String, Object>> queryForList(String sql, Object[] obj, int timeout)
	{
		List<Map<String, Object>> row = getWrapTemplate(timeout).queryForList(sql, obj);
		return row;
	}

	public int update(String sql)
	{
		int ret = getWrapTemplate().update(sql);
		return ret;
	}

	public int update(String sql, int timeout)
	{
		return getWrapTemplate(timeout).update(sql);
	}

	/**
	 * 绑定参数更新
	 * @param sql SQL语句
	 * @param obj 绑定参数
	 * @return 结果
	 */
	public int update(String sql, Object[] obj)
	{
		return getWrapTemplate().update(sql, obj);
	}

	public int update(String sql, Object[] obj, int timeout)
	{
		return getWrapTemplate(timeout).update(sql, obj);
	}

	/**
	 * 批量执行绑定参数
	 * @param sql 语句
	 * @param setter 绑定参数
	 * @return 执行结果
	 */
	public int[] executeBatch(String sql, BatchPreparedStatementSetter setter)
	{
		return getWrapTemplate().batchUpdate(sql, setter);
	}

	/**
	 * 批量执行绑定参数
	 * @param sql 语句
	 * @param setter 绑定参数
	 * @param timeout 超时时间，单位秒
	 * @return 执行结果
	 */
	public int[] executeBatch(String sql, BatchPreparedStatementSetter setter, int timeout)
	{
		return getWrapTemplate(timeout).batchUpdate(sql, setter);
	}

	/**
	 * 慎用！多用于一次性活动使用备数据库大批量发送时使用
	 * 需要先将jdbc配置文件的该数据源的用户设置成有修改权限的用户
	 */
	public int updateByQueryDB(String sql, Object[] obj)
	{
		int ret = 0;
		// 路由到查询数据库
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_QUERY);
		try
		{
			ret = getWrapTemplate().update(sql, obj);
		}
		finally
		{
			// 使用后清除（因为保存在线程变量中，避免同一线程后面的再次使用）
			DBContextHolder.clearDBType();
		}
		return ret;
	}

	/**
	 * 禁止在事务内使用！
	 * 发送到查询专用数据库(对实时数据不敏感的查询)
	 */
	public List<Map<String, Object>> queryForListByQueryDB(String sql)
	{
		List<Map<String, Object>> row = null;
		// 路由到查询数据库
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_QUERY);
		try
		{
			row = getWrapTemplate().queryForList(sql);
		}
		finally
		{
			// 使用后清除（因为保存在线程变量中，避免同一线程后面的再次使用）
			DBContextHolder.clearDBType();
		}
		return row;
	}

	/**
	 * 禁止在事务内使用！
	 * 发送到查询专用数据库(对实时数据不敏感的查询)
	 */
	public List<Map<String, Object>> queryForListByQueryDB(String sql, int timeout)
	{
		List<Map<String, Object>> row = null;
		// 路由到查询数据库
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_QUERY);
		try
		{
			row = getWrapTemplate(timeout).queryForList(sql);
		}
		finally
		{
			// 使用后清除（因为保存在线程变量中，避免同一线程后面的再次使用）
			DBContextHolder.clearDBType();
		}
		return row;
	}

	/**
	 * 禁止在事务内使用！
	 * 发送到查询专用数据库(对实时数据不敏感的查询)
	 */
	public List<Map<String, Object>> queryForListByQueryDB(String sql, Object[] obj)
	{
		List<Map<String, Object>> row = null;
		// 路由到查询数据库
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_QUERY);
		try
		{
			row = getWrapTemplate().queryForList(sql, obj);
		}
		finally
		{
			// 使用后清除（因为保存在线程变量中，避免同一线程后面的再次使用）
			DBContextHolder.clearDBType();
		}

		return row;
	}

	/**
	 * 禁止在事务内使用！
	 * 发送到查询专用数据库(对实时数据不敏感的查询)
	 */
	public List<Map<String, Object>> queryForListByQueryDB(String sql, Object[] obj, int timeout)
	{
		List<Map<String, Object>> row = null;
		// 路由到查询数据库
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_QUERY);
		try
		{
			row = getWrapTemplate(timeout).queryForList(sql, obj);
		}
		finally
		{
			// 使用后清除（因为保存在线程变量中，避免同一线程后面的再次使用）
			DBContextHolder.clearDBType();
		}

		return row;
	}

	public int updateAnalyzeBD(String sql)
	{
		int ret = 0;
		// 路由到查询数据库
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_ANALYZE);
		try
		{
			ret = getWrapTemplate().update(sql);
		}
		finally
		{
			// 使用后清除（因为保存在线程变量中，避免同一线程后面的再次使用）
			DBContextHolder.clearDBType();
		}
		return ret;
	}

	public int updateAnalyzeBD(String sql, int timeout)
	{
		int ret = 0;
		// 路由到查询数据库
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_ANALYZE);
		try
		{
			ret = getWrapTemplate(timeout).update(sql);
		}
		finally
		{
			// 使用后清除（因为保存在线程变量中，避免同一线程后面的再次使用）
			DBContextHolder.clearDBType();
		}
		return ret;
	}

	public int updateAnalyzeBD(String sql, Object[] obj)
	{
		int ret = 0;
		// 路由到查询数据库
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_ANALYZE);
		try
		{
			ret = getWrapTemplate().update(sql, obj);
		}
		finally
		{
			// 使用后清除（因为保存在线程变量中，避免同一线程后面的再次使用）
			DBContextHolder.clearDBType();
		}
		return ret;
	}

	public int updateAnalyzeBD(String sql, Object[] obj, int timeout)
	{
		int ret = 0;
		// 路由到查询数据库
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_ANALYZE);
		try
		{
			ret = getWrapTemplate(timeout).update(sql, obj);
		}
		finally
		{
			// 使用后清除（因为保存在线程变量中，避免同一线程后面的再次使用）
			DBContextHolder.clearDBType();
		}
		return ret;
	}

	public int[] executeBatchAnalyzeBD(String sql, BatchPreparedStatementSetter setter)
	{
		int ret[] = null;
		// 路由到查询数据库
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_ANALYZE);
		try
		{
			ret = getWrapTemplate().batchUpdate(sql, setter);
		}
		finally
		{
			// 使用后清除（因为保存在线程变量中，避免同一线程后面的再次使用）
			DBContextHolder.clearDBType();
		}
		return ret;
	}

	public int[] executeBatchAnalyzeBD(String sql, BatchPreparedStatementSetter setter, int timeout)
	{
		int ret[] = null;
		// 路由到查询数据库
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_ANALYZE);
		try
		{
			ret = getWrapTemplate(timeout).batchUpdate(sql, setter);
		}
		finally
		{
			// 使用后清除（因为保存在线程变量中，避免同一线程后面的再次使用）
			DBContextHolder.clearDBType();
		}
		return ret;
	}

	/**
	 * 发送到分析数据库
	 */
	public List<Map<String, Object>> queryForListByAnalyzeBD(String sql)
	{
		List<Map<String, Object>> row = null;
		// 路由到查询数据库
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_ANALYZE);
		try
		{
			row = getWrapTemplate().queryForList(sql);
		}
		finally
		{
			// 使用后清除（因为保存在线程变量中，避免同一线程后面的再次使用）
			DBContextHolder.clearDBType();
		}
		return row;
	}
	
	
	public Map<String, Object> queryForMapByAnalyzeBD(String sql, Object[] obj)
	{
		List<Map<String, Object>> row = null;
		// 路由到查询数据库
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_ANALYZE);
		try
		{
			row = getWrapTemplate().queryForList(sql, obj);
		}
		finally
		{
			// 使用后清除（因为保存在线程变量中，避免同一线程后面的再次使用）
			DBContextHolder.clearDBType();
		}
		if (row != null && row.size() >0) {
			return row.get(0);
		}
		return null;
	}
	
	public Map<String, Object> queryForMapByAnalyzeBD(String sql)
	{
		List<Map<String, Object>> row = null;
		// 路由到查询数据库
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_ANALYZE);
		try
		{
			row = getWrapTemplate().queryForList(sql);
		}
		finally
		{
			// 使用后清除（因为保存在线程变量中，避免同一线程后面的再次使用）
			DBContextHolder.clearDBType();
		}
		if (row != null && row.size() >0) {
			return row.get(0);
		}
		return null;
	}
	

	/**
	 * 发送到分析数据库
	 */
	public List<Map<String, Object>> queryForListByAnalyzeBD(String sql, int timeout)
	{
		List<Map<String, Object>> row = null;
		// 路由到查询数据库
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_ANALYZE);
		try
		{
			row = getWrapTemplate(timeout).queryForList(sql);
		}
		finally
		{
			// 使用后清除（因为保存在线程变量中，避免同一线程后面的再次使用）
			DBContextHolder.clearDBType();
		}
		return row;
	}

	/**
	 * 发送到分析数据库
	 */
	public List<Map<String, Object>> queryForListByAnalyzeBD(String sql, Object[] obj)
	{
		List<Map<String, Object>> row = null;
		// 路由到查询数据库
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_ANALYZE);
		try
		{
			row = getWrapTemplate().queryForList(sql, obj);
		}
		finally
		{
			// 使用后清除（因为保存在线程变量中，避免同一线程后面的再次使用）
			DBContextHolder.clearDBType();
		}
		
		return row;
	}

	/**
	 * 发送到分析数据库
	 */
	public List<Map<String, Object>> queryForListByAnalyzeBD(String sql, Object[] obj, int timeout)
	{
		List<Map<String, Object>> row = null;
		// 路由到查询数据库
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_ANALYZE);
		try
		{
			row = getWrapTemplate(timeout).queryForList(sql, obj);
		}
		finally
		{
			// 使用后清除（因为保存在线程变量中，避免同一线程后面的再次使用）
			DBContextHolder.clearDBType();
		}

		return row;
	}
	
	/**
	 * 发送到分析数据库备库
	 */
	public List<Map<String, Object>> queryForListByAnalyzeQueryBD(String sql)
	{
		List<Map<String, Object>> row = null;
		// 路由到查询数据库
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_ANALYZE_QUERY);
		try
		{
			row = getWrapTemplate().queryForList(sql);
		}
		finally
		{
			// 使用后清除（因为保存在线程变量中，避免同一线程后面的再次使用）
			DBContextHolder.clearDBType();
		}
		return row;
	}

	/**
	 * 发送到分析数据库备库
	 */
	public List<Map<String, Object>> queryForListByAnalyzeQueryBD(String sql, int timeout)
	{
		List<Map<String, Object>> row = null;
		// 路由到查询数据库
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_ANALYZE_QUERY);
		try
		{
			row = getWrapTemplate(timeout).queryForList(sql);
		}
		finally
		{
			// 使用后清除（因为保存在线程变量中，避免同一线程后面的再次使用）
			DBContextHolder.clearDBType();
		}
		return row;
	}

	/**
	 * 发送到分析数据库备库
	 */
	public List<Map<String, Object>> queryForListByAnalyzeQueryBD(String sql, Object[] obj)
	{
		List<Map<String, Object>> row = null;
		// 路由到查询数据库
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_ANALYZE_QUERY);
		try
		{
			row = getWrapTemplate().queryForList(sql, obj);
		}
		finally
		{
			// 使用后清除（因为保存在线程变量中，避免同一线程后面的再次使用）
			DBContextHolder.clearDBType();
		}

		return row;
	}

	/**
	 * 发送到分析数据库备库
	 */
	public List<Map<String, Object>> queryForListByAnalyzeQueryBD(String sql, Object[] obj, int timeout)
	{
		List<Map<String, Object>> row = null;
		// 路由到查询数据库
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_ANALYZE_QUERY);
		try
		{
			row = getWrapTemplate(timeout).queryForList(sql, obj);
		}
		finally
		{
			// 使用后清除（因为保存在线程变量中，避免同一线程后面的再次使用）
			DBContextHolder.clearDBType();
		}
		return row;
	}

	private JdbcTemplate getWrapTemplate()
	{
		JdbcTemplate template = this.getJdbcTemplate();
		// 设置超时时间
		template.setQueryTimeout(10);
		return template;
	}

	private JdbcTemplate getWrapTemplate(int timeout)
	{
		JdbcTemplate template = this.getJdbcTemplate();
		// 设置超时时间，单位秒
		template.setQueryTimeout(timeout);
		return template;
	}

	/**
	 * 绑定参数查询
	 * @param sql SQL语句
	 * @param obj 绑定参数
	 * @return 结果集
	 */
	@Deprecated
	public List<Map<String, Object>> queryByParamAnalyzeBD(String sql, Object[] obj)
	{
		// 路由到查询数据库
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_ANALYZE);
		try
		{
			return getWrapTemplate().queryForList(sql, obj);
		}
		finally
		{
			// 使用后清除（因为保存在线程变量中，避免同一线程后面的再次使用）
			DBContextHolder.clearDBType();
		}
	}

	@Deprecated
	public List<Map<String, Object>> queryByParam(String sql, Object[] obj)
	{
		return getWrapTemplate().queryForList(sql, obj);
	}

	@Deprecated
	public <T> List<T> queryList(String sql, Object[] param, RowMapper rowmap)
	{
		List<T> row = getWrapTemplate(20000).query(sql, param, rowmap);
		return row;
	}
}
