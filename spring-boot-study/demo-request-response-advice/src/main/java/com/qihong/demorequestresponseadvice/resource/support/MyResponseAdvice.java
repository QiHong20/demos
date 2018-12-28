package com.qihong.demorequestresponseadvice.resource.support;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class MyResponseAdvice implements ResponseBodyAdvice<Object> {
    private Logger logger = LoggerFactory.getLogger(MyResponseAdvice.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return methodParameter.getMethodAnnotation(RequestMapping.class) != null;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        try {
            if(serverHttpResponse instanceof ServletServerHttpResponse){
                int statusCode = ((ServletServerHttpResponse) serverHttpResponse).getServletResponse().getStatus();
                if (statusCode == 200) {
                    logger.info("receive request response detail [url={},query={},method={}，responseStatusCode={},responseBody={}]", serverHttpRequest.getURI().getPath(),serverHttpRequest.getURI().getQuery(), serverHttpRequest.getMethod(), statusCode, objectMapper.writeValueAsString(o));
                } else {
                    logger.error("receive request response detail [url={},query={},method={},responseStatusCode={},responseBody={}]", serverHttpRequest.getURI().getPath(),serverHttpRequest.getURI().getQuery(), serverHttpRequest.getMethod(), statusCode, objectMapper.writeValueAsString(o));
                }
            }
        } catch (Exception e) {
            logger.error("JxBusinessResponseBodyAdvice json error ", e);
        }
        return o;
    }
}
