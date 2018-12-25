package com.qihong.demointerceptor.resource.support;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qihong.demointerceptor.interceptor.MyInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    Logger logger= LoggerFactory.getLogger(MyInterceptor.class);
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return methodParameter.getMethodAnnotation(RequestMapping.class) != null;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            logger.info("url is {},responseBody is {}", serverHttpRequest.getURI(), objectMapper.writeValueAsString(o));
        }catch (Exception e){

        }
        return o;
    }
}
