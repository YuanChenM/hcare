package com.hoperun.core.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.hoperun.core.bean.RsResponse;
import com.hoperun.core.exception.SystemException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/**
 * RestClientUtil
 *
 * @author yuan_chen
 * @version 1.0
 **/
public final class RestClientUtil {
    /**
     * ACCEPT:application/json
     */
    private static final String ACCEPT = "application/json";
    /**
     * CONTENT_TYPE:application/json; charset=utf-8
     */
    private static final String CONTENT_TYPE = "application/json; charset=utf-8";
    /**
     * UTF8:UTF-8
     */
    private static final String UTF8 = "UTF-8";
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(RestClientUtil.class);
    /**
     * Http Client Builder
     */
    private static HttpClientBuilder httpClientBuilder;

    static {
        // 长连接保持30秒
        PoolingHttpClientConnectionManager pollingConnectionManager = new PoolingHttpClientConnectionManager(30, TimeUnit.SECONDS);
        // 总连接数
        pollingConnectionManager.setMaxTotal(1000);
        // 同路由的并发数
        pollingConnectionManager.setDefaultMaxPerRoute(1000);
        httpClientBuilder = HttpClients.custom();
        httpClientBuilder.setConnectionManager(pollingConnectionManager);
        // 重试次数，默认是3次，没有开启
        httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(2, true));
        // 保持长连接配置，需要在头添加Keep-Alive
        httpClientBuilder.setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy());
    }

    /**
     * Rest Http Post 请求
     *
     * @param url   请求的URL
     * @param param 请求的参数
     * @return resultType
     */
    public static <T extends Serializable> RsResponse<T> post(String url, Object param, TypeReference<RsResponse<T>> typeReference) {
        logger.info("请求URL:" + url);
        String jsonParam = JSON.toJSONString(param);
        logger.info("请求参数:" + jsonParam);
        try {
            HttpClient httpclient = httpClientBuilder.build();
            HttpPost method = new HttpPost(url);
            method.addHeader("Content-type", CONTENT_TYPE);
            method.setHeader("Accept", ACCEPT);
            method.setEntity(new StringEntity(jsonParam, Charset.forName(UTF8)));
            long startTime = System.currentTimeMillis();
            HttpResponse response = httpclient.execute(method);
            long endTime = System.currentTimeMillis();
            logger.info("请求花费时间为:" + (endTime - startTime));
            String body = EntityUtils.toString(response.getEntity());
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                logger.debug("Http 返回失败，Http失败状态为：" + statusCode);
                throw new SystemException("Http 返回失败，Http失败状态为：" + statusCode);
            }
            logger.info("返回数据:" + body);
            return JSON.parseObject(body, typeReference);
        } catch (ClientProtocolException e) {
            throw new SystemException(e.getMessage());
        } catch (IOException e) {
            throw new SystemException(e.getMessage());
        }
    }
}
