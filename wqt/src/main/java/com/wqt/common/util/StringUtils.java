package com.wqt.common.util;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * 
 * book
 * 
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {

	/**
	 * 是否全部为空
	 * 
	 * @param arr
	 * @return
	 */
	public static boolean isAllBlank(String... arr) {
		if (arr == null) {
			return true;
		}
		for (String string : arr) {
			if (isNotBlank(string)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 是否全部不为空
	 * 
	 * @param arr
	 * @return
	 */
	public static boolean isAllNotBlank(String... arr) {
		if (arr == null) {
			return false;
		}
		for (String string : arr) {
			if (isBlank(string)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 是否包含一个为空
	 * 
	 * @param arr
	 * @return
	 */
	public static boolean isOrBlank(String... arr) {
		if (arr == null) {
			return true;
		}
		for (String string : arr) {
			if (isBlank(string)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 是否包含一个不为空
	 * 
	 * @param arr
	 * @return
	 */
	public static boolean isOrNotBlank(String... arr) {
		if (arr == null) {
			return false;
		}
		for (String string : arr) {
			if (isNotBlank(string)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 字符串比较
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean strEquals(String a, String b) {
		if (a == null && b == null)
			return true;
		if (a == null)
			return false;
		return a.equals(b);
	}

	/**
	 * 转Long
	 * 
	 * @param s
	 * @return
	 */
	public static Long toLong(String s) {
		try {
			return Long.parseLong(s);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 转Integer
	 * 
	 * @param s
	 * @return
	 */
	public static Integer toInteger(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * a to z, A to Z
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isAtoZ(String s) {
		if (isEmpty(s)) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' || s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {

			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * 是否为中文(部分匹配)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean containsChinese(String str) {
		if (str == null) {
			return false;
		}
		for (char c : str.toCharArray()) {
			Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
			if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
					|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
					|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
					|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
					|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
					|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
					|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 生产新的随机验证码
	 * 
	 * @return 随机数字验证码，4位
	 */
	public static final String newVerifyCode() {
		SecureRandom random = new SecureRandom();
		char[] chars = new char[4];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = (char) ('0' + random.nextInt(10));
		}
		return new String(chars);
	}
	
	/**
	 * 统计中文字符数
	 * 
	 * @param str
	 * @return
	 */
	public static int chineseCharCount(String str) {
		int count = 0;
		if (str == null) {
			return count;
		}
		for (char c : str.toCharArray()) {
			Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
			if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
					|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
					|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
					|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
					|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
					|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
					|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
				count++;
			}
		}
		return count;
	}
	
	
	public static boolean isMobileNO(String mobiles){  
		  
		Pattern p = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(16[1-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$");  
		  
		Matcher m = p.matcher(mobiles);  
		  
		return m.matches();  
		  
		}  
	/**
	 * 验证密码
	 * 长度在6~20之间，只能包含字符、数字和下划线
	 * @param password
	 * @return
	 */
	public static boolean validaterPWD(String password){  
		
		Pattern p = Pattern.compile("^([A-Z]|[a-z]|[0-9]|[_]){6,20}$");  
		
		Matcher m = p.matcher(password);  
		
		return m.matches();  
		
	}  
	
}
