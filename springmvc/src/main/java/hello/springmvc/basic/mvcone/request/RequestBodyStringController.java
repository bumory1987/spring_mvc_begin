package hello.springmvc.basic.mvcone.request;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
//@Controller
public class RequestBodyStringController {


    @ResponseBody
    @PostMapping("/request-body-string-v1")
    public void requestBodyString(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("message body = {}", messageBody);

        response.getWriter().write("ok");

    }

    @ResponseBody
    @PostMapping("/request-body-string-v2")
    public void requestBodyStringV2(InputStream inputStream , Writer responseWriter ) throws IOException {
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("message body = {}", messageBody);

        responseWriter.write("ok");

    }


    @ResponseBody
    @PostMapping("/request-body-string-v3")
    public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) throws IOException {
        log.info("header = {}", httpEntity.getHeaders());
        log.info("message body = {}", httpEntity.getBody());
        return new HttpEntity<>("ok");
    }



    @PostMapping("/request-body-string-v32")
    public HttpEntity<String> requestBodyStringV32(RequestEntity<String> httpEntity) throws IOException {
        log.info("header = {}", httpEntity.getHeaders());
        log.info("message body = {}", httpEntity.getBody());
        return new ResponseEntity<String>("ok", HttpStatus.CREATED);
    }


    @ResponseBody
    @PostMapping("/request-body-string-v4")
    public String requestBodyStringV4(@RequestBody String messageBody, @RequestHeader(name = "my-number",required = false) Integer myNumber)  {
        log.info("message body = {}", messageBody);
        return "ok";
    }



}
