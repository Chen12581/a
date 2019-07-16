package com.wqt.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtils {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);
    /**
     * 定义编码格式 UTF-8
     */
    public static final String UTF_8 = "UTF-8";

    /**
     * 定义编码格式 GBK
     */
    public static final String GBK = "GBK";

    private static final String URL_PARAM_CONNECT_FLAG = "&";

    private static final String EMPTY = "";

    private static MultiThreadedHttpConnectionManager connectionManager = null;

    private static int connectionTimeOut = 20000;

    private static int socketTimeOut = 20000;

    private static int maxConnectionPerHost = 200;

    private static int maxTotalConnections = 200;

    private static HttpClient client;

    static {
        connectionManager = new MultiThreadedHttpConnectionManager();
        connectionManager.getParams().setConnectionTimeout(connectionTimeOut);
        connectionManager.getParams().setSoTimeout(socketTimeOut);
        connectionManager.getParams().setDefaultMaxConnectionsPerHost(maxConnectionPerHost);
        connectionManager.getParams().setMaxTotalConnections(maxTotalConnections);
        client = new HttpClient(connectionManager);
    }

    /**
     * POST方式提交数据
     * 
     * @param url 待请求的URL
     * @param params 要提交的数据
     * @param enc 编码
     * @return 响应结果
     * @throws IOException IO异常
     */
    public static String URLPost(String url, Map<String, Object> params, String enc) {
        String response = EMPTY;
        PostMethod postMethod = null;
        try {
            postMethod = new PostMethod(url);
            postMethod.setRequestHeader("Content-Type",
                    "application/x-www-form-urlencoded;charset=" + enc);
            // 将表单的值放入postMethod中
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                Object value = params.get(key);
                if (value != null) {
                    postMethod.addParameter(key, value.toString());
                }
            }
            // 执行postMethod
            int statusCode = client.executeMethod(postMethod);
            if (statusCode == HttpStatus.SC_OK) {
            	BufferedReader reader = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream(),enc));
            	StringBuilder sb=new StringBuilder();
            	String line=null;
    			while ((line = reader.readLine()) != null) {
    				sb.append(line);
    			}
                response = sb.toString();
            } else {
                logger.error("statusCode = " + postMethod.getStatusCode());
            }
        } catch (HttpException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (postMethod != null) {
                postMethod.releaseConnection();
                postMethod = null;
            }
        }
        return response;
    }

    /**
     * GET方式提交数据
     * 
     * @param url 待请求的URL
     * @param params 要提交的数据
     * @param enc 编码
     * @return 响应结果
     * @throws IOException IO异常
     */
    public static String URLGet(String url, Map<String, Object> params, String enc) {

        String response = EMPTY;
        GetMethod getMethod = null;
        StringBuffer strtTotalURL = new StringBuffer(EMPTY);

        if (strtTotalURL.indexOf("?") == -1) {
            strtTotalURL.append(url).append("?").append(getUrl(params, enc));
        } else {
            strtTotalURL.append(url).append("&").append(getUrl(params, enc));
        }
        try {
            getMethod = new GetMethod(strtTotalURL.toString());
            getMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset="
                    + enc);
            // 执行getMethod
            int statusCode = client.executeMethod(getMethod);
            if (statusCode == HttpStatus.SC_OK) {
                response = getMethod.getResponseBodyAsString();
            } else {
                logger.error("statusCode = " + getMethod.getStatusCode());
            }
        } catch (HttpException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (getMethod != null) {
                getMethod.releaseConnection();
                getMethod = null;
            }
        }

        return response;
    }
    public static HttpClient getClient() {
		return client;
	}

    /**
     * 据Map生成URL字符串
     * 
     * @param map Map
     * @param valueEnc URL编码
     * @return URL
     */
    private static String getUrl(Map<String, Object> map, String valueEnc) {

        if (null == map || map.keySet().size() == 0) {
            return (EMPTY);
        }
        StringBuffer url = new StringBuffer();
        for (String key : map.keySet()) {
            Object val = map.get(key);
            if (val == null) {
                continue;
            }
            try {
                val = URLEncoder.encode(val.toString(), valueEnc);
            } catch (UnsupportedEncodingException e) {
                logger.error(e.getMessage(), e);
            }
            url.append(key).append("=").append(val).append(URL_PARAM_CONNECT_FLAG);
        }
        String strURL = url.toString();
        if (strURL.endsWith(URL_PARAM_CONNECT_FLAG)) {
            strURL = strURL.substring(0, strURL.length() - 1);
        }
        return strURL;
    }
    
	/**
	 * 模拟请求
	 * @param url
	 * @return
	 */
	public static JSONObject httpGet(String url,String errMessage){
        //get请求返回结果
        JSONObject jsonResult = null;
        try {
            DefaultHttpClient client = new DefaultHttpClient();
            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
 
            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                String strResult = EntityUtils.toString(response.getEntity());
                /**把json字符串转换成json对象**/
                jsonResult = JSONObject.fromObject(strResult);
                url = URLDecoder.decode(url, "UTF-8");
            } else {
            	logger.error(errMessage+":" + url);
            }
        } catch (IOException e) {
        	logger.error(errMessage+":" + url, e);
        }
        return jsonResult;
    }
}
