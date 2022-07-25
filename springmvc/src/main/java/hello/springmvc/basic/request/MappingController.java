package hello.springmvc.basic.request;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


//@RestController
@Slf4j
public class MappingController {

//    @RequestMapping(value = {"/hello-basic", "/hello-go"})
//    private String helloBasic(){
//        log.info("hello = {}");
//        return "ok";
//    }
//
//    @GetMapping(value = {"/hello-hello", "/hello-good"})
//    public String helloTwo(){
//        return "hi";
//    }

    @GetMapping(value = "/hello-basic")
    private String helloBasic(){
        log.info("hello = {}");
        return "ok";
    }


    @GetMapping("/mappingtwo/{userId}")
    public String mappingPathTwo(@PathVariable String userId){
        log.info("mapping path = {}", userId);
        return "ok";
    }


    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
        log.info("mapping path = {}", data);
        return "ok";
    }


    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPathThree(@PathVariable String userId, @PathVariable String orderId){
        log.info("user path = {} , order path = {} ", userId, orderId);
        return "ok";
    }



    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam(){
        log.info("mapping param");
        return "ok";
    }


    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader(){
        log.info("mapping param");
        return "ok";
    }



    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes(){
        log.info("consume");
        return "ok";
    }


    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingHtml(){
        log.info("produce");
        return "ok";
    }

}
