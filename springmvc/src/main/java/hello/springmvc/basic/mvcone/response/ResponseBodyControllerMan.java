package hello.springmvc.basic.mvcone.response;


import hello.springmvc.basic.mvcone.testobject.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//@RestController
//@Controller
@Slf4j
public class ResponseBodyControllerMan {
    @GetMapping("response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }


    @GetMapping("response-body-string-v2")
    public ResponseEntity<String> responseBodyV2(HttpServletResponse response) throws IOException {
        //동적으로 하고 싶을떄
        return new ResponseEntity<>("ok", HttpStatus.CREATED);
    }


    @ResponseBody
    @GetMapping("response-body-string-v3")
    public String responseBodyV3(HttpServletResponse response) throws IOException {
        return "ok";
    }


    @GetMapping("response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyV4() throws IOException {
        HelloData helloData = new HelloData();
        helloData.setUsername("sung");
        helloData.setAge(12);
        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }



    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("response-body-json-v1")
    public HelloData responseDoit(){
        Boolean test = true;
        HelloData helloData = new HelloData();
        helloData.setUsername("sung");
        helloData.setAge(12);
        return helloData;

    }





}
