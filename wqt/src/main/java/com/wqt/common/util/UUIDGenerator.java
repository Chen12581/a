package com.wqt.common.util;

import java.security.SecureRandom;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.UUID;
 

public class UUIDGenerator {

	/**
	 * Description ： 获得一个UUID<br>
	 * 
	 *  
	 * 
	 * @return
	 * @since
	 *
	 */
	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		char[] charArray = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char c : charArray) {
			if (c != '-') {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * Description ： 获得指定数目的UUID<br>
	 * 
	 * wumc
	 * 
	 * @param number
	 * @return
	 * @since
	 *
	 */
	public static String[] getUUID(int number) {
		if (number < 1) {
			return null;
		}
		String[] ss = new String[number];
		for (int i = 0; i < number; i++) {
			ss[i] = getUUID();
		}
		return ss;
	}
	
	private static final Random RANDOM = new SecureRandom();
	/**
	 * 阿里生成新的订单号
	 * 
	 * @return String 订单号
	 */
	public synchronized static String newALOrderNumber() {
		
		String date = DateFormatUtils.parseDate(new SimpleDateFormat("yyyyMMddHHmmss"), new Date(System.currentTimeMillis()));
		 
		StringBuilder builder = new StringBuilder("AL").append(date);
		
		builder.append(String.valueOf(RANDOM.nextInt(100))).append(String.valueOf(RANDOM.nextInt(100)));
		return builder.toString();
	}
	/**
	 * 苹果支付订单
	 * @return
	 */
	public synchronized static String newOrderNumber() {
		
		String date = DateFormatUtils.parseDate(new SimpleDateFormat("yyyyMMddHHmmss"), new Date(System.currentTimeMillis()));
		
		StringBuilder builder = new StringBuilder("AL").append(date);
		
		builder.append(String.valueOf(RANDOM.nextInt(100))).append(String.valueOf(RANDOM.nextInt(100)));
		return builder.toString();
	}
	/**
	 * 微信支付订单
	 * @return
	 */
	public synchronized static String newWxOrderNumber() {
		
		String date = DateFormatUtils.parseDate(new SimpleDateFormat("yyyyMMddHHmmss"), new Date(System.currentTimeMillis()));
		
		StringBuilder builder = new StringBuilder("WX").append(date);
		
		builder.append(String.valueOf(RANDOM.nextInt(100))).append(String.valueOf(RANDOM.nextInt(100)));
		return builder.toString();
	}
	
	
	public static void main(String[] args) { 
		
		System.out.println(UUID.randomUUID().toString());
		
	}
}
