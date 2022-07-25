package hello.springmvc.basic.request;


import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.testobject.HelloData;
import hello.springmvc.basic.testobject.NestedHello;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
//@Controllerller
public class RequestBodyJsonController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/request-body-json-v1")
    public void requestBodyJsonv1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String s = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("body = {}", s);
        HelloData helloData = objectMapper.readValue(s , HelloData.class);

        log.info("user = {}", helloData);
        response.getWriter().write("ok");
    }

    @ResponseBody
    @PostMapping("/request-body-json-v2")
    public String requestBodyJsonv2(@RequestBody String messageBody) throws IOException {

        log.info("body = {}", messageBody);
        HelloData helloData = objectMapper.readValue(messageBody , HelloData.class);

        log.info("user = {}", helloData);
        return "ok";
    }


    @ResponseBody
    @PostMapping("/request-body-json-v3")
    public String requestBodyJsonv23(@RequestBody HelloData hello) throws IOException {
        log.info("body = {}", hello);
        return "ok";
    }


    @ResponseBody
    @PostMapping("/request-body-json-v4")
    public NestedHello requestBodyJsonv23(@RequestBody NestedHello hello) throws IOException {
        log.info("body = {}", hello);
        return hello;
    }


    @ResponseBody
    @PostMapping("/request-body-json-v5")
    public NestedHello requestBodyJsonv5(HttpEntity<NestedHello>  hello) throws IOException {
        log.info("body = {}", hello);
        NestedHello getdata = hello.getBody();
        return getdata;
    }



}
