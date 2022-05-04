package com.test.deploytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@RestController
public class DeployTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeployTestApplication.class, args);
    }

    @GetMapping("/")
    public String test() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        return String.format("ip = {%s} , URL = {%s}", request.getRemoteAddr(), request.getRequestURL());
    }

}
