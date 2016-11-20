package com.tfarm.dto;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class AnalyticsLog
{

	private static Logger logger = Logger.getLogger(AnalyticsLog.class);

	private String uri;

	private String param;

	private String postData;

	private String referer;

	private String userAgent;

	private Timestamp requestTime;

	private Timestamp responseTime;

	private int code = HttpServletResponse.SC_OK;

	private String result;

	private String ip;

	private int port;

	public String getUri()
	{
		return this.uri;
	}

	public void setUri(String uri)
	{
		this.uri = uri;
	}

	public String getParam()
	{
		return this.param;
	}

	public void setParam(String param)
	{
		this.param = param;
	}

	public String getReferer()
	{
		return this.referer;
	}

	public void setReferer(String referer)
	{
		this.referer = referer;
	}

	public Timestamp getRequestTime()
	{
		return this.requestTime;
	}

	public void setRequestTime(Timestamp requestTime)
	{
		this.requestTime = requestTime;
	}

	public Timestamp getResponseTime()
	{
		return this.responseTime;
	}

	public void setResponseTime(Timestamp responseTime)
	{
		this.responseTime = responseTime;
	}

	public int getCode()
	{
		return this.code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public String getUserAgent()
	{
		return this.userAgent;
	}

	public void setUserAgent(String userAgent)
	{
		this.userAgent = userAgent;
	}

	public String getResult()
	{
		return this.result;
	}

	public void setResult(String result)
	{
		this.result = result;
	}

	public String getIp()
	{
		return this.ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public int getPort()
	{
		return this.port;
	}

	public void setPort(int port)
	{
		this.port = port;
	}

	public String getPostData()
	{
		return this.postData;
	}

	public void setPostData(String postData)
	{
		this.postData = postData;
	}

	public void writeLog()
	{
		String anaLogStr = this.getRequestTime().getTime() + "\t" + this.getUri() + "\t" + this.getParam() + "\t" + this.getReferer() + "\t" + this.getCode() + "\t" + this.getResponseTime().getTime() + "\t" + this.getResult() + "\t" + this.getUserAgent();
		logger.debug(anaLogStr);
	}

	public String start()
	{
		return this.getUri() + "\t" + this.getParam() + "\t" + this.getPostData() + "\t" + this.getReferer() + "\t" + this.getCode() + "\t" + this.getResult() + "\t" + this.getUserAgent() + "\t" + this.getIp() + "\t" + this.getPort();
	}

	public String end()
	{
		return this.getRequestTime().getTime() + "\t" + this.getResponseTime().getTime() + "\t" + (this.getResponseTime().getTime() - this.getRequestTime().getTime()) + "\t" + this.getCode() + "\t" + this.getResult();
	}

	@Override
	public String toString()
	{
		return this.getRequestTime().getTime() + "\t" + this.getResponseTime().getTime() + "\t" + (this.getResponseTime().getTime() - this.getRequestTime().getTime()) + "\t" + this.getUri() + "\t" + this.getParam() + "\t" + this.getPostData() + "\t" + this.getReferer() + "\t" + this.getCode()
				+ "\t" + this.getResult() + "\t" + this.getUserAgent() + "\t" + this.getIp() + "\t" + this.getPort();
	}

}
