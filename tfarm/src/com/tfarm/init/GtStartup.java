package com.tfarm.init;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class GtStartup implements ApplicationContextAware
{
	/** 日志打到 trainnet_data 中 */
	private static Logger logger = LoggerFactory.getLogger(GtStartup.class);

	private static ApplicationContext context;

	public static boolean isTrainnet = true;
	public static String classUrl;
	/** 由于是分布式环境，该名字为每个tomcat的目录名（在部署时必须唯一） */
	public static String tomcatname;
	public static int tomcatIndex = -1;
	public static String tomcatpath;
	/** 程序名 */
	public static String projectname;
	public static String projectPath;

	public static void startup() throws IOException
	{
		try
		{
			/*	URL url = GtStartup.class.getResource("/");
				classUrl = url.getPath();
				logger.info("Startup classpath url " + classUrl);

				// /home/gtgj/tomcat-loco/webapps/trainnet/WEB-INF/classes/
				int index = classUrl.indexOf("/webapps/");
				// /home/gtgj/tomcat-loco
				String path = classUrl.substring(0, index);
				index = path.lastIndexOf("/");

				// tomcat-loco1
				tomcatname = path.substring(index + 1);
				tomcatpath = classUrl.split(tomcatname)[0] + tomcatname;
				projectname = ObjectUtil.getStringFromToEx(classUrl, "/webapps/", "/");
				projectPath = tomcatpath + "/webapps/" + projectname;

				String tindex = tomcatname.replace("tomcat-loco", "");
				if (ObjectUtil.isNotNull(tindex) && ObjectUtil.isNumber(tindex))
				{
					tomcatIndex = Integer.parseInt(tindex);
				}
				logger.info("Startup tomcat-name " + tomcatname + ", index " + tomcatIndex + ", path " + tomcatpath + ", projectname " + projectname + ", projectPath " + projectPath);*/

			System.out.println("-------------------");
		}
		catch (Exception e)
		{
			logger.error("", e);
			System.exit(1);
		}
	}

	public void setApplicationContext(ApplicationContext c) throws BeansException
	{
		context = c;
	}

	public static ApplicationContext getContext()
	{
		return context;
	}

}
