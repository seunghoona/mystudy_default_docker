package com.test.deploytest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
public class MemberController {

    @Value("${test.application.name}")
    private String name;

    @Value("${address.name}")
    private String address;

    @GetMapping("/")
    public MemberDTO test() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();

        log.info(String.format("IP = {%s} , URL = {%s} NAME= {%s} ADDRESS = {%s}", request.getRemoteAddr(), request.getRequestURL(), name, address));

        List<String> names = new ArrayList<>();
        names.add("테스트1");
        names.add("테스트2");


        return new MemberDTO(UUID.randomUUID().toString(), UUID.randomUUID().toString().substring(1, 4), names);
    }

    @Getter
    @AllArgsConstructor
    static class MemberDTO {

        private String name;

        private String test;
        private List<String> names = new ArrayList<>();
    }
}
