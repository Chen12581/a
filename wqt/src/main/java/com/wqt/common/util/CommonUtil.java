package com.wqt.common.util;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class CommonUtil {
	
    public static final String BRANDPRODUCT_CACHE = "config.cache.brandproduct";
	
	public static final String BRANDPRODUCTKIND_CACHE = "config.cache.brandkindproduct";
		
	public static final String COPYRIGHTPRODUCT_CACHE = "config.cache.copyrightproduct";
	
	public static final String COPYRIGHTPRODUCTKIND_CACHE = "config.cache.copyrightkindproduct";
		
    public static final String PATENTPRODUCT_CACHE = "config.cache.patentproduct";
    
    public static final String PATENTPRODUCTKIND_CACHE = "config.cache.patentkindproduct";
		
    public static final String WORKERS_CACHE = "config.cache.workers";
    
    public static final String BANKS_CACHE = "config.cache.banks";
    
    //省
    public static final String PROVINCE_CACHE = "config.cache.province";
    
    //地市
    public static final String CITY_CACHE = "config.cache.city";
    
    //区县
    public static final String AREA_CACHE = "config.cache.area";
    
    //友情链接
    public static final String OUTURL_CACHE = "config.cache.outurl";
 
    
	/*
	  * 判断是否为整数 
	  * @param str 传入的字符串 
	  * @return 是整数返回true,否则返回false 
	*/
    public static boolean isInteger(String str) {  
	        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
	        return pattern.matcher(str).matches();  
	}
	  
	public static boolean isNumber(String str)
	{
		try {  
	    		   int num=Integer.valueOf(str);//把字符串强制转换为数字   
	               return true;//如果是数字，返回True   
	    } catch (Exception e) {  
	               return false;//如果抛出异常，返回False   
	    } 
	}
	
	/*比较两个日期之间相差的天数
	 * sDate   日期一
	 * eDate   日期二
	 */
	/*public static int daysOfTwo(Date sDate, Date eDate) 
	{
	       Calendar aCalendar = Calendar.getInstance();
	       aCalendar.setTime(sDate);
	       int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
	       aCalendar.setTime(eDate);
	       int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
	       return day2 - day1;
	}
	*/
	
	public static long daysOfTwo(String beginDateStr,String endDateStr)
    {
        long day=0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");   
        java.util.Date beginDate;
        java.util.Date endDate;
        try
        {
            beginDate = format.parse(beginDateStr);
            endDate= format.parse(endDateStr);   
            day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);   
            //System.out.println("相隔的天数="+day);  
        } catch (ParseException e)
        {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        }  
        return day;
    }
	
	 /**
     * 从list中随机抽取元素
     */
	public static List createRandomList(List list, int n) {
	    Map map = new HashMap();
	    List listNew = new ArrayList();
	    if (list.size() <= n) {
	        return list;
	    } else {
	        while (map.size() < n) {
	            int random = (int) (Math.random() * list.size());
	            if (!map.containsKey(random)) {
	                map.put(random, "");
	                listNew.add(list.get(random));
	            }
	        }
	        return listNew;
	    }
	}
	
	 /**
     * 从list中根据ID值查找元素
     */
	public static Object findObjectFromList(List list,String id) {
		Object resultoi=null;
		try {
			    for (int i = 0; i < list.size(); i++) {
			        Field[] fields = list.get(i).getClass().getDeclaredFields();
			        Object oi = list.get(i);
			        for (int j = 0; j < fields.length; j++) 
			        {
			            if(!fields[j].isAccessible()){
			                fields[j].setAccessible(true);
			            }
		                if(fields[j].getName().equals("id"))
		                {
		                	
								if(fields[j].get(oi).equals(id))
								{
									resultoi=oi;
									break;
								}
							
		                }
			         
			        }
			    }
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return resultoi;
	}
	
	

  /**
   * 从list中根据属性值查找元素
   */
	public static List findListFromList(List list,String propertyname,String propertyvalue) {
		List resultoi=new ArrayList();
		try {
			    for (int i = 0; i < list.size(); i++) {
			        Field[] fields = list.get(i).getClass().getDeclaredFields();
			        Object oi = list.get(i);
			        for (int j = 0; j < fields.length; j++) 
			        {
			            if(!fields[j].isAccessible()){
			                fields[j].setAccessible(true);
			            }
		                if(fields[j].getName().equals(propertyname))
		                {
							if(fields[j].get(oi).equals(propertyvalue))
							{
									resultoi.add(oi);
							}
		                }
			         
			        }
			    }
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return resultoi;
	}
	
	
	  /**
     * 从list中随机抽取某个属性的某类数据
     */
	public static List RandomKindList(List list, int n,String propertyname,String propertyvalue) {
		List resultoi=new ArrayList();
		try {
			    Map map = new HashMap();
			    if (list.size() <= n) {
			        return list;
			    } else 
			    {
			    	while (map.size() < n) {
			    		int random = (int) (Math.random() * list.size());
			    		if (!map.containsKey(random)) {
			    			Object oi=list.get(random);
					        Field[] fields = oi.getClass().getDeclaredFields();
					       
					        for (int j = 0; j < fields.length; j++) 
					        {
					            if(!fields[j].isAccessible()){
					                fields[j].setAccessible(true);
					            }
				                if(fields[j].getName().equals(propertyname))
				                {
									if(fields[j].get(oi).equals(propertyvalue))
									{
											resultoi.add(oi);
											map.put(random, "");
											break;
									}
				                }
					        }
				        }
			    	}
			    }
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultoi;
	}
	
	public static void main(String[] arg)
	{
		long day=CommonUtil.daysOfTwo("2016-12-12", "2016-12-22");
		System.out.println(day);
	}
}
