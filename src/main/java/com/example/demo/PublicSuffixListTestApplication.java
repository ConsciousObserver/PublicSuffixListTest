package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@SpringBootApplication
public class PublicSuffixListTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PublicSuffixListTestApplication.class, args);
    }
}

@RestController
@RequestMapping("/")
class TestController {
    private static final String PUBLIC_SUFFIX_US_EAST_1_AMAZONAWS_COM = "us-east-1.amazonaws.com";

    @GetMapping("/hello")
    public String hello(HttpServletResponse response) {

        Cookie cookie = new Cookie("publix-suffix-cookie", "foo-bar");
        cookie.setDomain(PUBLIC_SUFFIX_US_EAST_1_AMAZONAWS_COM);

        response.addCookie(cookie);

        return "Hello World! " + LocalDateTime.now();
    }
}
