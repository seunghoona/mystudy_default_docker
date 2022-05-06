package com.test.deploytest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.yaml.snakeyaml.introspector.PropertyUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Executors;

@SpringBootApplication
public class DeployTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeployTestApplication.class, args);

    }


}
