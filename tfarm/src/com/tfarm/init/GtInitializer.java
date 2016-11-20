package com.tfarm.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class GtInitializer implements ApplicationListener
{
	
	private static Logger logger = LoggerFactory.getLogger(GtInitializer.class);
	private static Boolean init = false;

	public void onApplicationEvent(ApplicationEvent arg0)
	{
		synchronized (init)
		{
			// TODO 网上资料显示该接口会调两次，但实际仅有一次，可能与版本相关，有待长期验证是不是特定场景触发
			if (init)
			{
				System.out.println("abc222ccc");
				logger.error("gtgj has bean initialized ! ");
				return;
			}
			try
			{
				logger.info("abcccc");
				// 系统配置
				startCommon();

				// 初始化缓存


				init = true;
				System.out.println("abccdddcc");
			}
			catch (Exception e)
			{
				logger.error("", e);
				System.exit(1);
			}
		}

	}

	public static void startCommon() throws Exception
	{
		// 系统配置
		//GtConfig.init();

		// 检查连接的数据库是否正确
		//checkDbserverIp();

		System.out.println("abcee2222222222eeccc");

	}



}
