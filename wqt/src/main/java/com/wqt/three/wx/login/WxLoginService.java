package com.wqt.three.wx.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.talkweb.twdpe.core.log.Logger;
import com.talkweb.twdpe.core.log.LoggerFactory;
import com.wqt.common.util.HttpUtils;
import com.wqt.common.util.JsonUtils;



public class WxLoginService {
	
	private static final Logger logger = LoggerFactory.getLogger(WxLoginService.class);
	
	/**appID**/
    private static final String APP_ID = "wx8f6411f0b3eec831";
   
    private static final String APP_SECRE="940865c067868091d88245842da07bcd";
    
    private static final String  AUTHORIZEURL="https://api.weixin.qq.com/sns/oauth2/access_token";
    
    private static final String WX_USERINFO="https://api.weixin.qq.com/sns/userinfo";
	
	public WxUserInfo weixinLogin(String authCode) {
		
		// 获取根据code获取授权钥匙
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("appid", APP_ID);
		params.put("secret", APP_SECRE);
		params.put("grant_type", "authorization_code");
		params.put("code", authCode);

	    String accessTokenReturn = "";
		accessTokenReturn = HttpUtils.URLPost(AUTHORIZEURL, params, HttpUtils.UTF_8);

		WxAccessTokenReturnInfo wxAccessTokenReturnInfo = JsonUtils.fromJson(accessTokenReturn,
				WxAccessTokenReturnInfo.class);
		
		 System.out.println("----accessTokenReturn----"+accessTokenReturn);
	       

		// 获取用户信息
		Map<String, Object> userInfoParams = new HashMap<String, Object>();
		userInfoParams.put("access_token", wxAccessTokenReturnInfo.getAccess_token());
		userInfoParams.put("openid", wxAccessTokenReturnInfo.getOpenid());
		String userInfoReturn = "";
		userInfoReturn = HttpUtils.URLPost(WX_USERINFO, userInfoParams, HttpUtils.UTF_8);
		WxUserInfo wxUserInfo = JsonUtils.fromJson(userInfoReturn, WxUserInfo.class);
		logger.error("userInfoReturn =" + userInfoReturn);
		
		 System.out.println("----userInfoReturn----"+userInfoReturn);
			
		return wxUserInfo;
	}
}
