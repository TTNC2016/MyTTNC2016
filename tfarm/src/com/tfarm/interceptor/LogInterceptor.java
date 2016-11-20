package com.tfarm.interceptor;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tfarm.dto.AnalyticsLog;
import com.tfarm.util.ObjectUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LogInterceptor extends AbstractInterceptor
{

	private static final long serialVersionUID = 6046289308499745194L;

	private static Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

	@Override
	public String intercept(ActionInvocation invocation) throws Exception
	{
		Timestamp requestTime = new Timestamp(System.currentTimeMillis());
		ActionContext ctx = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);

		AnalyticsLog anaLog = new AnalyticsLog();
		try
		{
			// 记录日志
			anaLog.setRequestTime(requestTime);
			anaLog.setUri(request.getRequestURI());
			// 数据 
			String str = ObjectUtil.getParam(request.getParameterMap());
			anaLog.setParam(str);
			anaLog.setReferer(request.getHeader("referer"));
			anaLog.setUserAgent(request.getHeader("User-Agent"));
			String ip = ObjectUtil.getRemoteIp(ServletActionContext.getRequest());
			anaLog.setIp(ip);
			anaLog.setPort(request.getRemotePort());
			if (logger.isDebugEnabled())
			{
				logger.debug("start -> " + anaLog.start());
			}
			// 执行下面的拦截器
			String result = invocation.invoke();

			anaLog.setResponseTime(new Timestamp(System.currentTimeMillis()));
			anaLog.setResult(result);
			if (logger.isDebugEnabled())
			{
				anaLog.setParam(null);
				anaLog.setReferer(null);
				anaLog.setUserAgent(null);
				anaLog.setIp(null);
				anaLog.setPort(0);
				logger.debug("end -> " + anaLog.end());
			}
			// 统计
			//StatisticsActionProcessor.statisticsAction(invocation, anaLog);
		}
		catch (Exception e)
		{
			logger.error("Error -> " + request.getRequestURI(), e);
			throw e;
		}

		return Action.SUCCESS;
	}

	/*@Override
	public String intercept(ActionInvocation invocation) throws Exception
	{
		ActionContext ctx = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) ctx.get(ServletActionContext.HTTP_RESPONSE);
		String user = ObjectUtil.getString(request.getSession().getAttribute("user"));
		// 不存在
		if (ObjectUtil.isNull(user))
		{
			request.setAttribute("iflag", "1");
			//request.getRequestDispatcher("/login.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return null;
		}
		return invocation.invoke();
	}*/

	private String getServerClassPath(String region)
	{
		// com.huoli.loco.actions.server.platformbuy.ServerHelpPay12306Action@555214b9
		// 找到server后第一个包名截止
		int pos = region.indexOf('.', "com.tfarm.actions.".length());
		if (pos == -1)
		{
			return "com.tfarm.actions";
		}
		return region.substring(0, pos);
	}

}
