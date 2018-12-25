package com.qihong.demoresttemplate;

import org.apache.commons.io.IOUtils;
import org.hobsoft.spring.resttemplatelogger.LoggingCustomizer;
import org.hobsoft.spring.resttemplatelogger.LoggingInterceptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoRestTemplateApplicationTests {
    private Logger logger = LoggerFactory.getLogger(DemoRestTemplateApplicationTests.class);

    @Test
    public void contextLoads() {
    }

    @Test
    public void testRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(restTemplate.getRequestFactory()));
        restTemplate.getInterceptors().add(new ClientHttpRequestInterceptor() {
            @Override
            public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
                ClientHttpResponse response = clientHttpRequestExecution.execute(httpRequest, bytes);
                String a = IOUtils.toString(bytes, "utf-8");
                String inputString = IOUtils.toString(response.getBody(), "utf-8");

                logger.info("1interceptor response is {}", inputString);
                logger.info("123123");
                return response;
            }
        });
        String baiduResponse = restTemplate.getForObject("http://www.baidu.com", String.class);
        logger.info("baidu is {}", baiduResponse);
    }

}

