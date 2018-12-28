package com.qihong.demoresttemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.hobsoft.spring.resttemplatelogger.LoggingCustomizer;
import org.hobsoft.spring.resttemplatelogger.LoggingInterceptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoRestTemplateApplicationTests {
    private Logger logger = LoggerFactory.getLogger(DemoRestTemplateApplicationTests.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void contextLoads() {
    }

    /**
     *
     */
    @Test
    public void testRestTemplateGet() {
        ObjectMapper objectMapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(restTemplate.getRequestFactory()));
        restTemplate.getInterceptors().add(new ClientHttpRequestInterceptor() {
            @Override
            public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
                ClientHttpResponse response = clientHttpRequestExecution.execute(httpRequest, bytes);
                String responseBody = new String(StreamUtils.copyToByteArray(response.getBody()), "utf-8");

                logger.info("send request,[uri={},method={},param={},responseStatusCode={}],reponseBody={}", httpRequest.getURI().getPath(), httpRequest.getMethod(),httpRequest.getURI().getQuery(), response.getStatusCode().value(), objectMapper.writeValueAsString(responseBody));
                return response;
            }
        });
        String baiduResponse = restTemplate.getForObject("http://www.baidu.com?a=123", String.class);
        logger.info("baidu is {}", baiduResponse);
    }

    @Test
    public void testRestTemplatePost() {
        ObjectMapper objectMapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(restTemplate.getRequestFactory()));
        restTemplate.getInterceptors().add(new ClientHttpRequestInterceptor() {
            @Override
            public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
                ClientHttpResponse response = null;
                try {
                    response = clientHttpRequestExecution.execute(httpRequest, bytes);
                    String responseBody = new String(StreamUtils.copyToByteArray(response.getBody()), "utf-8");
                    HttpStatus statusCode = response.getStatusCode();
                    if (statusCode != HttpStatus.OK) {
                        logger.error("{} a request,[uri={},requestBody={},responseStatusCode={}],responseBody={}", httpRequest.getMethod(), httpRequest.getURI(), new String(bytes, "utf-8"), response.getStatusCode(), objectMapper.writeValueAsString(responseBody));
                    } else {
                        logger.info("{} a request,[uri={},requestBody={},responseStatusCode={}],responseBody={}", httpRequest.getMethod(), httpRequest.getURI(), new String(bytes, "utf-8"), response.getStatusCode(), objectMapper.writeValueAsString(responseBody));
                    }
                } catch (Exception e) {
                    String responseBody = new String(StreamUtils.copyToByteArray(response.getBody()), "utf-8");
                    HttpStatus statusCode = response.getStatusCode();
                    if (statusCode != HttpStatus.OK) {
                        logger.error("{} a request,[uri={},requestBody={},responseStatusCode={}],responseBody={}", httpRequest.getMethod(), httpRequest.getURI(), new String(bytes, "utf-8"), response.getStatusCode(), objectMapper.writeValueAsString(responseBody));
                    } else {
                        logger.info("{} a request,[uri={},requestBody={},responseStatusCode={}],responseBody={}", httpRequest.getMethod(), httpRequest.getURI(), new String(bytes, "utf-8"), response.getStatusCode(), objectMapper.writeValueAsString(responseBody));
                    }
                }
                return response;
            }
        });
        Map map = new HashMap();
        map.put("name", "1234");
        ResponseEntity<String> baiduResponse = restTemplate.postForEntity("http://git.chinacloud.com.cn/abc?a=123", map, String.class);
        logger.info("baidu is {}", baiduResponse);
    }

}

