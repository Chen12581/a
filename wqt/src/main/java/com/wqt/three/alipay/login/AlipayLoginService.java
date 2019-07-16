package com.wqt.three.alipay.login;

import org.springframework.beans.factory.InitializingBean;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.talkweb.twdpe.core.log.Logger;
import com.talkweb.twdpe.core.log.LoggerFactory;
import com.wqt.common.action.CommonAction;

/*支付宝第三方登录*/
public class AlipayLoginService implements InitializingBean {
	private static final Logger logger = LoggerFactory.getLogger(AlipayLoginService.class);	
	
	/**Alipay客户端*/
    private AlipayClient alipayClient;

    /**支付宝网关*/
    private static final String ALIPAY_BORDER_PROD = "https://openapi.alipay.com/gateway.do";
    /**appID**/
    private static final String APP_ID_PROD = "2018110161935942";
    /**私钥*/
    private static final String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCqULcm3mRsP+3HWBojkvolXFYD0DVHeQHYChSDIBrkAXKzB9wMRBrivFqD4xokFvLnNl+CT9kxKeXevF1FPDy59uTDD3aQ163P5Zg/U+N28icePrpOrBfTOnDYPV7mZ4/iwExDYYay3E5QRMA8BwiDaHtv0u3mHa9Px3f7KkVQmkHtjqF9WbF4iPhWilDmr/GGiRFgJbAFbL5KtlWH1LbrFn4JWSpu+VKmQ+3rorbbzduPjZ4h1cvBFNAAd7KolgOKSY+792BxBtKStSM/eGGgmlRtK0Y5gaNsB54KVp4v0Mwg3vRF2s3xm7KAh8+OPL8vFbs9CgyvfgtfhBiuqEfNAgMBAAECggEAP0RWlPi+AzxIPunqY9agV6qSRT5d3FwGJFOyRPdzJcmn6vt7cY8HEbz4Ps/pEQj5WIxpNEYnH006F+CPIT38LPSbDB69Y5bK+VSHlta5w6C2iVSx7rGc9Blce+doTlygJZJbghhDakPOT6EKbAIM1ovEdsi7GOVkD1XAqyuLriHRwMJwH0hA0WnepctOdnvLOVh0QzPbtfmSy6ruVtmfmSwCRVFiHIh6mxWpvkzvNDEWE9Q0iTjlPhRytBYnl2aGgDpFGXo2X7NOtE5uxbW4/DLEWwr8UpSbzhSuuOYzsKJ0St5r2Ri8P7sG1MYk04L18/J/5jlJY0BhHvjy1hsdAQKBgQD55+ybrqOiZPl2zbEaF1zztihuIb1pgx8S24AlTEJGSwis6h/FO4X15iWxoGGHMVuEwS9pKZFpLXkuftNkNt+jfnXn3y5iEd0hiZzcZnTMPnYub7msHYPU8HesmXjdST9AhajXVIB/6M+8WhD2lSXRAYD4BGsBoUxkcgcdov7lDQKBgQCud+833+5+m3y+5WVcsF0kWhIncBTQlFA/lbjqx7O6MZ/PPHti2Kyw/qlY0qqL1+miegJ3PpnO4vYRBzt4X8rxzeHhN3ezJ70tgvqHDcvwTR+RffXvkBq4XH6NdA2f2iXw4LNrNvr1BAUQuZulQDf8euhJ8uFmbfYL11+U0C+9wQKBgQDn2bX4kcOarFeNUzQV4ssICF3mH0Ndmpq/ogl3kRKDqKV51xR2pcyY4FbkPsl85dvkhF56EGipzdh5vIxek1JUmsTExJiBv9UKgmOXTy7ZNrHqTxlRh2iBrD87UH+DvasDL33/mJRHFzVzp5PJUYJuMBj5ARBNyNnY7rmPU2NsGQKBgQCDL/25lvFfVA1eAWHRa2/uCKhD7VxJZmxdE3jjWVyEchIHoyPoNKLNx/+QoX/J/YVZPcMi5PiEf1algTmvjuAsKDJjxfCEzynJ0gYNjUs/Gs7U+ND33PSqkio6tPwVqdQDpwJiaQoVOHuSku49OOegOs714+KmwaJUTxM4874iQQKBgDmUrIXV+DO6UyqQDZoea5KTG7qIsOnbGgL71DpY6q1QDQfEBz1c8pZtgdIszGT0L3AQW0zMbehrtfycnIU7qlYXaB91k7MbQOWI7FCmbDwwS3O5C4hIHkkIhf8FuN1SvzhsTnXNAGgTNIBcWJUE4xveGlWC3t69hZ5H5Wl32Auk";
    /**公钥*/
    private static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAw+DVjhW6rLFDOvJ4lKKFtQFVjomV9oGbIrWdU1z2BIwFg5OOSl1/kITsqBxo6ysWnU1zoSQ/sIdfnaTo2NcoGdrgp9o2V0djxEYp7QftZUytATgZDB55yH4yikEpJHaB7dqc6pPe9sKohpRT7hJzkgFoEsbUZHJnyKHhGHPCZfCI4bSVZcHMx0WnRv9ahG2XxU1GGyKk4MTVk53O9lmeV0J+Rv4HGM8c1XUtKdgHxzbAAQgXSRFAde4DlgGY09szS7OmSMpvwTKrrvh0XLak2I2Y15D6A2mXDX2tjgEu0/wUIzPH0h4pZe63OXvOMW+rEBUd1kEwj7in3Jmi4g/2JwIDAQAB";


	@Override
	public void afterPropertiesSet() throws Exception {
		alipayClient = new DefaultAlipayClient(ALIPAY_BORDER_PROD, APP_ID_PROD, APP_PRIVATE_KEY, "json", "UTF-8", ALIPAY_PUBLIC_KEY, "RSA2");
	}
	
	
	/**
     * 根据auth_code获取用户的user_id和access_token
     * @param authCode
     * @return
     */
    public String getAccessToken(String authCode) 
    { 
    	AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        request.setCode(authCode);
        request.setGrantType("authorization_code");
        try { 
        	   AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(request);
        	   System.out.println("oauthTokenResponse.getAccessToken()----------"+oauthTokenResponse.getAccessToken());
               return oauthTokenResponse.getAccessToken();
        } catch (Exception e) 
        { 
        	logger.error("使用authCode获取信息失败！", e);
            return null;
        } 
   } 
    
    /**
     * 根据access_token获取用户信息
     * @param token
     * @return
     */
    public AlipayUserInfo getUserInfoByToken(String token) { 
    	AlipayUserInfoShareRequest request = new AlipayUserInfoShareRequest ();
        try { 
        	AlipayUserInfoShareResponse response = alipayClient.execute(request, token);
            if (response.isSuccess()) { //打印响应信息
                //封装支付宝对象信息
                AlipayUserInfo alipayUser = new AlipayUserInfo();
                alipayUser.setOpenId(response.getUserId());
                alipayUser.setCity(response.getCity());
                alipayUser.setProvince(response.getProvince());
                alipayUser.setNickName(response.getNickName());
                return alipayUser;
            }
            else
            {
               logger.error("根据 access_token获取用户信息失败!");
               return null;
            }

        } catch (Exception e) { 
        	logger.error("根据 access_token获取用户信息抛出异常！", e);
            return null;
        } 
    }
}
