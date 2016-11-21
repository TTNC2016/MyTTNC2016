package com.tfarm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;

public class DateUtil
{
	private static final Logger logger = Logger.getLogger(DateUtil.class);

	public static final String YYYY = "yyyy";
	public static final String YYYY_MM = "yyyy-MM";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YYYYMMDD = "yyyyMMdd";
	public static final String YYYYMMDDHHMM = "yyyyMMddHHmm";
	public static final String YYYY_MM_DD_ = "yyyy/MM/dd";
	public static final String YYYY_MM_DDHHMMSSSSS = "yyyy-MM-dd HH:mm:ss:SSS";
	public static final String YYYY_MM_DDHH = "yyyy-MM-dd HH";
	public static final String YYYY_MM_DDHHMM = "yyyy-MM-dd HH:mm";
	public static final String YYYY_MM_DDHHMMSS = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYY_MM_DDHHMMSSSSS_ = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String HHMM = "HH:mm";
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

	public static final long SECOND = 1000L;

	public static final long MINUTE = SECOND * 60;

	public static final long HOUR = MINUTE * 60;

	public static final long DAY = HOUR * 24;

	/**
	 * Calendar 转化 String 获取当前时间的具体情况,如年,月,日,week,date,分,秒等
	 * 
	 * @param format
	 * @return
	 */
	public static String convertCalendarToString(String format)
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String dateStr = sdf.format(cal.getTime());

		return dateStr;
	}

	/**
	 * Calendar 转化 String 获取当前时间的具体情况,如年,月,日,week,date,分,秒等
	 * 
	 * @param format
	 * @return
	 */
	public static String convertCalendarToString(Calendar cal, String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String dateStr = sdf.format(cal.getTime());

		return dateStr;
	}

	/**
	 * String 转化Calendar
	 * 
	 * @param str
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public static Calendar convertStringToCalendar(String str, String format) throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = sdf.parse(str);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	public static Date convertStringToDate(String date, String format) throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date d = sdf.parse(date);
		return d;
	}

	public static String convertStringToStringDate(String date, String format) throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String d = sdf.format(date);
		return d;
	}

	public static String convertDateToString(String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String dateStr = sdf.format(new Date());
		return dateStr;
	}

	public static String convertDateToString(Date date, String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String dateStr = sdf.format(date);
		return dateStr;
	}

	public static XMLGregorianCalendar convertToXMLGregorianCalendar(Date date) throws Exception
	{
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		XMLGregorianCalendar gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);

		return gc;
	}

	public static boolean isInTimePeriod()
	{
		Calendar time = Calendar.getInstance();
		time.set(Calendar.HOUR_OF_DAY, 23);
		time.set(Calendar.MINUTE, 0);
		time.set(Calendar.MILLISECOND, 0);
		long elevenClock = time.getTimeInMillis();
		time.set(Calendar.HOUR_OF_DAY, 23);
		time.set(Calendar.MINUTE, 30);
		long elevenHalfClock = time.getTimeInMillis();
		long currentTime = System.currentTimeMillis();
		if (currentTime > elevenClock && currentTime < elevenHalfClock)
		{
			return true;
		}
		else
			return false;

		//return false;
	}

	/**
	 * 凌晨12点3点
	 * @return
	 */
	public static boolean compareTime()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		long firstClock = calendar.getTimeInMillis();

		calendar.set(Calendar.HOUR_OF_DAY, 3);
		long secondClock = calendar.getTimeInMillis();

		long currentTime = System.currentTimeMillis();

		if (currentTime > firstClock && currentTime < secondClock)
			return true;

		return false;
	}

	public static long getSubTime()
	{

		return 0;
	}

	/**
	 * 返回当前日期
	 * 
	 * @return
	 */
	public static String getCurrentDate(String format)
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String date = sdf.format(cal.getTime());
		return date;
	}

	/**
	 * 返回给定天的num天后的字符串
	 * @param curDay
	 * @param dateFormat
	 * @param num
	 * @return
	 */
	public static String getNextDay(String curDay, String dateFormat, int num)
	{
		SimpleDateFormat sdf = null;
		Calendar cal = null;
		Date date = null;
		String dateStr = null;

		sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(false);
		try
		{
			date = sdf.parse(curDay);
			cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DAY_OF_MONTH, num);
			date = cal.getTime();
			dateStr = sdf.format(date);
		}
		catch (ParseException e)
		{
			logger.error("错误的日期格式！", e);

			return curDay;
		}

		return dateStr;
	}

	/**
	 * 返回给定天的下一天的字符串
	 * @param curDay
	 * @param dateFormat
	 * @return
	 */
	public static String getNextDay(String curDay, String dateFormat)
	{
		SimpleDateFormat sdf = null;
		Calendar cal = null;
		Date date = null;
		String dateStr = null;

		sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(false);
		try
		{
			date = sdf.parse(curDay);
			cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DAY_OF_MONTH, 1);
			date = cal.getTime();
			dateStr = sdf.format(date);
		}
		catch (ParseException e)
		{
			logger.error("错误的日期格式！", e);
			return curDay;
		}

		return dateStr;
	}

	/**
	 * 返回给定天的前一天的字符串
	 * @param curDay
	 * @param dateFormat
	 * @return
	 */
	public static String getPreDay(String curDay, String dateFormat)
	{
		SimpleDateFormat sdf = null;
		Calendar cal = null;
		Date date = null;
		String dateStr = null;

		sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(false);
		try
		{
			date = sdf.parse(curDay);
			cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DAY_OF_MONTH, -1);
			date = cal.getTime();
			dateStr = sdf.format(date);
		}
		catch (ParseException e)
		{
			logger.error("错误的日期格式！", e);
			return curDay;
		}

		return dateStr;
	}

	/**
	 * 返回给定天的前两天的字符串
	 * @param curDay
	 * @param dateFormat
	 * @return
	 */
	public static String getPrepreDay(String curDay, String dateFormat)
	{
		SimpleDateFormat sdf = null;
		Calendar cal = null;
		Date date = null;
		String dateStr = null;

		sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(false);
		try
		{
			date = sdf.parse(curDay);
			cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DAY_OF_MONTH, -2);
			date = cal.getTime();
			dateStr = sdf.format(date);
		}
		catch (ParseException e)
		{
			logger.error("错误的日期格式！", e);
			return curDay;
		}

		return dateStr;
	}

	public static void main(String args[])
	{
		System.out.println(getPrepreDay(getCurrentDate(DateUtil.YYYY_MM_DD), DateUtil.YYYY_MM_DD));
		System.out.println(getPreDay(getCurrentDate(YYYY_MM_DD), YYYY_MM_DD, 10000));
	}

	/**
	 * 返回给定天的num天前的字符串
	 * @param curDay
	 * @param dateFormat
	 * @return
	 */
	public static String getPreDay(String curDay, String dateFormat, int num)
	{
		SimpleDateFormat sdf = null;
		Calendar cal = null;
		Date date = null;
		String dateStr = null;

		sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(false);
		try
		{
			date = sdf.parse(curDay);
			cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DAY_OF_MONTH, -num);
			date = cal.getTime();
			dateStr = sdf.format(date);
		}
		catch (ParseException e)
		{
			logger.error("错误的日期格式！", e);
			return curDay;
		}

		return dateStr;
	}

	/**
	 * 将日期转换为字符串
	 * @param date		要转换为String的日期
	 * @param format	日期格式
	 * @return
	 */
	public static String Date2String(Date date, String format)
	{
		SimpleDateFormat df = new SimpleDateFormat(format);
		String time = df.format(date);
		return time;
	}

	/**
	 * 比较两个时间的差，用时间2-时间1
	 * @param date1
	 * @param date2
	 * @return 两个时间相差的分钟
	 */
	public static int getMinute(String date1, String date2, String format)
	{
		try
		{
			if (date1 == null || date2 == null)
				return 0;

			SimpleDateFormat sdf = new SimpleDateFormat(format);
			java.util.Date beginDate = sdf.parse(date1);
			java.util.Date endDate = sdf.parse(date2);

			Long minute = (endDate.getTime() - beginDate.getTime()) / (60 * 1000);

			return minute.intValue();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 比较两个时间的差，用时间2-时间1
	 * @param date1
	 * @param date2
	 * @return 两个时间相差的分钟
	 */
	public static int getSeconds(String date1, String date2, String format)
	{
		try
		{
			if (date1 == null || date2 == null)
				return 0;

			SimpleDateFormat sdf = new SimpleDateFormat(format);
			java.util.Date beginDate = sdf.parse(date1);
			java.util.Date endDate = sdf.parse(date2);

			Long second = (endDate.getTime() - beginDate.getTime()) / (1000);

			return second.intValue();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 时间相减得到天数
	 * 
	 * @param beginDateStr
	 * @param endDateStr
	 * @return long
	 */
	public static long getDaySub(String beginDateStr, String endDateStr, String format)
	{
		long day = 0;
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			java.util.Date beginDate = sdf.parse(beginDateStr);
			java.util.Date endDate = sdf.parse(endDateStr);

			day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
		}
		catch (Exception e)
		{
			logger.error("", e);
		}

		return day;
	}

	/**
	 * 毫秒转日期字符串
	 * @param str
	 * @param dateformat
	 * @return
	 */
	public static String getDateTimeByMillisecond(String str, String dateformat)
	{
		Date date = new Date(Long.valueOf(str));
		SimpleDateFormat format = new SimpleDateFormat(dateformat);
		String time = format.format(date);
		return time;
	}

	public static long getMillisecondByDate(String str, String dateformat)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
		try
		{
			return sdf.parse(str).getTime();
		}
		catch (ParseException e)
		{
			logger.error("错误的日期格式！", e);
			return 0;
		}
	}

	public static GregorianCalendar parse2Cal(String pDateStr)
	{
		StringTokenizer sToken = new StringTokenizer(pDateStr, "-/");
		int vYear = Integer.parseInt(sToken.nextToken());
		//GregorianCalendar的月份是从0开始算起
		int vMonth = Integer.parseInt(sToken.nextToken()) - 1;
		int vDayOfMonth = Integer.parseInt(sToken.nextToken());
		return new GregorianCalendar(vYear, vMonth, vDayOfMonth);
	}

	/**
	 * 将当前时间减去hour个小时
	 * @param hour
	 * @param dateformat
	 * @return
	 */
	public static String getCurrentDaySub(int hour, String dateformat)
	{
		SimpleDateFormat format = new SimpleDateFormat(dateformat);
		Date beginDate = new Date();
		Calendar date = Calendar.getInstance();
		date.setTime(beginDate);
		date.set(Calendar.HOUR, date.get(Calendar.HOUR) - hour);
		return format.format(date.getTime());
	}

	/**
	 * 将当前时间减去minute分钟
	 * @param minute
	 * @param dateformat
	 * @return
	 */
	public static String getCurrentMinuteSub(int minute, String dateformat)
	{
		SimpleDateFormat format = new SimpleDateFormat(dateformat);
		Date beginDate = new Date();
		Calendar date = Calendar.getInstance();
		date.setTime(beginDate);
		date.set(Calendar.MINUTE, date.get(Calendar.MINUTE) - minute);
		return format.format(date.getTime());
	}

	/**
	 * 将当前时间减去second秒
	 * @param second
	 * @param dateformat
	 * @return
	 */
	public static String getCurrentSecondSub(int second, String dateformat)
	{
		SimpleDateFormat format = new SimpleDateFormat(dateformat);
		Date beginDate = new Date();
		Calendar date = Calendar.getInstance();
		date.setTime(beginDate);
		date.set(Calendar.SECOND, date.get(Calendar.SECOND) - second);
		return format.format(date.getTime());
	}

	/**
	 * 获得开始和结束时间
	 */
	public static String[] getCurrentDateArray(String startDate, String endDate)
	{
		if (ObjectUtil.isNull(startDate))
		{
			startDate = DateUtil.getCurrentDate(DateUtil.YYYY_MM_DD) + " 00:00:00";
		}

		if (ObjectUtil.isNull(endDate))
		{
			endDate = DateUtil.getCurrentDate(DateUtil.YYYY_MM_DD) + " 23:59:59";
		}

		String[] array = new String[] { startDate, endDate };

		return array;
	}

	/**
	 * 获得上个月的gDay日
	 * @param gDay 需要获取的上个月日期
	 * @return 2016-03-24
	 */
	public static String getLastDay(int gDay)
	{
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);
		int lastMonth = calendar.get(Calendar.DAY_OF_MONTH) >= gDay ? month : (month > 0 ? month - 1 : 11);
		if (month == 0 && month != lastMonth)
		{
			year = calendar.get(Calendar.YEAR) - 1;
		}
		lastMonth += 1;
		String lm = lastMonth + "";
		String gd = gDay + "";
		if (lastMonth < 10)
		{
			lm = "0" + lm;
		}
		if (gDay < 10)
		{
			gd = "0" + gd;
		}
		return year + "-" + lm + "-" + gd;
	}
	
	
	
	public static String convertOnday(String day)
	{
		if (day.indexOf('-') != -1)
		{
			return day.replaceAll("-", "");
		}
		else
		{
			return day.substring(0, 4) + "-" + day.substring(4, 6) + "-" + day.substring(6, 8);
		}
	}

}
