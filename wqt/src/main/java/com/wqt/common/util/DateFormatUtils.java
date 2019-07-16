package com.wqt.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类.
 * 
 */
public class DateFormatUtils {

	public final static DateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public final static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	public final static DateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("y-M-d");

	public final static DateFormat DATE_FORMAT_2 = new SimpleDateFormat("MM-dd");

	public final static DateFormat DATE_FORMAT_3 = new SimpleDateFormat("HH:mm");
	
	public static Date parseString(DateFormat dateFormat, String dateStr) throws ParseException {
		return dateFormat.parse(dateStr);
	}

	public static String parseDate(DateFormat dateFormat, Date date) {
		return dateFormat.format(date);
	}

	public static String parseDateToDatetimeString(Date date) {
		return DATE_TIME_FORMAT.format(date);
	}

	public static String converToStringDate(Date date, String formatString) {
		if (StringUtils.isEmpty(formatString)) {
			SimpleDateFormat sdf_datetime_s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf_datetime_s.format(date);
		} else {
			SimpleDateFormat format = new SimpleDateFormat(formatString);
			return format.format(date);
		}
	}

	/**
	 * @see 将字符串转化为JAVA时间类型(精确到秒)。
	 * 
	 * @return Date date。JAVA时间类型。
	 * @param String
	 *            。字符串。
	 */
	public static Date converToDateTime(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(dateStr);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * @see 将字符串转化为JAVA时间类型(精确到分)。
	 * 
	 * @return Date date。JAVA时间类型。
	 * @param String
	 *            。字符串。
	 */
	public static String converToStringMiniuteDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			return sdf.format(date);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * @see 得到传入日期n天后的日期,如果传入日期为null，则表示当前日期n天后的日期
	 * 
	 * @param Date
	 *            dt
	 * @param days
	 *            可以为任何整数，负数表示前days天，正数表示后days天
	 * @return Date
	 */
	public static Date getAddDayTime(Date dt, int days) {
		if (dt == null)
			dt = new Date(System.currentTimeMillis());
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + days);
		return cal.getTime();
	}

	/**
	 * @see 将日期转化为字符串(精确到秒)。
	 * 
	 * @return Date date。JAVA时间类型。
	 * @param String
	 *            。字符串。
	 */
	public static String converToStringTime(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return format.format(date);
		} catch (Exception e) {
			return null;
		}
	}

	public static Date converToDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(dateStr);
		} catch (Exception e) {
			return null;
		}
	}

	public static String converToStringDate(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return format.format(date);
		} catch (Exception e) {
			return null;
		}
	}

	public static String converToStringDate2(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");
		try {
			return format.format(date);
		} catch (Exception e) {
			return null;
		}
	}

	public static String getToday() {
		return DateFormatUtils.converToStringDate(new Date());
	}

	/**
	 * 将时间移动days天
	 * 
	 * @param date
	 *            当前日期
	 * @param days
	 *            移动的天数
	 * @return 移动后的时间
	 */
	public static Date addDay(Date date, Integer days) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_YEAR, days);
		return c.getTime();
	}

	/**
	 * 将时间移动months天
	 * 
	 * @param date
	 *            当前日期
	 * @param months
	 *            移动的月数
	 * @return 移动后的时间
	 */
	public static Date addMonth(Date date, Integer months) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, months);
		return c.getTime();
	}

	/**
	 * Description ： 比较两个时间的大小
	 * 
	 * @author "hejp" 2015年3月11日 下午7:59:28
	 * @param data1
	 * @param data2
	 * @return
	 *
	 */
	public static int compare_date(Date data1, Date data2) {
		try {
			if (data1.getTime() > data2.getTime()) {
				// System.out.println("dt1 在dt2前");
				return 1;
			} else if (data1.getTime() < data2.getTime()) {
				// System.out.println("dt1在dt2后");
				return -1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static Date dayBegin(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	public static Date dayEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	public static long getDaySub(String beginDateStr, String endDateStr) {
		long day = 0;
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date beginDate;
		java.util.Date endDate;
		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
			day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
			// System.out.println("相隔的天数="+day);
		} catch (ParseException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return day;
	}
	
	
	public static String  getDaySubString(Date beginDate, Date endDate) {
		String  day = "";
	
		try {
			
		long	dayNum = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
		
		long    hourNum=(endDate.getTime() - beginDate.getTime()-dayNum*(24 * 60 * 60 * 1000))/( 60 * 60 * 1000);
		
		long    secNum=(endDate.getTime() - beginDate.getTime()-dayNum*(24 * 60 * 60 * 1000)-hourNum*( 60 * 60 * 1000))/( 60 * 1000);
		
		if(secNum>0){
			day = secNum+"分";
			
			if(hourNum>0){
				day=hourNum+"小时"+day;
				if(dayNum>0){
					day=dayNum+"天"+day;
				}
				
			}
			
			
		}
		
		
	
		
		} catch (Exception e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return day;
	}
	
	
	
	public static String  getDayStyleString(Date  d) {
		String  day = "";
		try {
			  long delta = (new Date().getTime()-d.getTime())/1000;  
		        if(delta<=0)return d.toLocaleString();  
		        if(delta/(60*60*24*365) > 0) return delta/(60*60*24*365) +"年前";  
		        if(delta/(60*60*24*30) > 0) return delta/(60*60*24*30) +"个月前";  
		        if(delta/(60*60*24*7) > 0)return delta/(60*60*24*7) +"周前";  
		        if(delta/(60*60*24) > 0) return delta/(60*60*24) +"天前";  
		        if(delta/(60*60) > 0)return delta/(60*60) +"小时前";  
		        //if(delta/(60) > 0)return delta/(60) +"分钟前";  
		        if(delta/(60) > 0)return parseDate(DATE_FORMAT_3, d); 
		        return "刚刚";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return day;
	}
	
	public static String  getDaySubCurrString(String  endDateStr) {
		String  day = "";
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		java.util.Date endDate;
		
		
		
		try {
			    endDate = format.parse(endDateStr);
			if(endDate.getTime() - System.currentTimeMillis()<0)    {
				
				return "过期";
			}
			    
		long	dayNum = (endDate.getTime() - System.currentTimeMillis()) / (24 * 60 * 60 * 1000);
		
		long    hourNum=(endDate.getTime() - System.currentTimeMillis()-dayNum*(24 * 60 * 60 * 1000))/( 60 * 60 * 1000);
		
		long    secNum=(endDate.getTime() - System.currentTimeMillis()-dayNum*(24 * 60 * 60 * 1000)-hourNum*( 60 * 60 * 1000))/( 60 * 1000);
		
		if(secNum>0){
			day = secNum+"分";
			
			if(hourNum>0){
				day=hourNum+"小时"+day;
				if(dayNum>0){
					day=dayNum+"天"+day;
				}
			}	
		}
		
		} catch (Exception e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return day;
	}
	
	
	public static String  getDaySubCurrSubstring(String  endDateStr) {
		
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		java.util.Date endDate=null;
		
		
			    try {
					endDate = format.parse(endDateStr);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(endDate.getTime() - System.currentTimeMillis()<0)    {
				
				return "0分";
			}
			    
		long	dayNum = (endDate.getTime() - System.currentTimeMillis()) / (24 * 60 * 60 * 1000);
		if(dayNum>0){
			
			return dayNum+"天";
		}
		
		
		long    hourNum=(endDate.getTime() - System.currentTimeMillis()-dayNum*(24 * 60 * 60 * 1000))/( 60 * 60 * 1000);
		if(hourNum>0){
			
			return hourNum+"小时";
		}
		
		long    secNum=(endDate.getTime() - System.currentTimeMillis()-dayNum*(24 * 60 * 60 * 1000)-hourNum*( 60 * 60 * 1000))/( 60 * 1000);
		if(secNum>0){
					
					return secNum+"分";
				}
		
		
		return "0分";
	}
	
	
	
	public static void main(String[] arg){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		
		System.out.println( sdf.format(new Date()));
		
		
	}

}
