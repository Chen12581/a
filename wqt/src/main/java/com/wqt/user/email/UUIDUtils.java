package com.wqt.user.email;

import java.util.UUID;

public class UUIDUtils {
	     //生成随机字符串的工具类
	      public static String getUUID(){
	          return UUID.randomUUID().toString().replace("-", "");
	     }
}
