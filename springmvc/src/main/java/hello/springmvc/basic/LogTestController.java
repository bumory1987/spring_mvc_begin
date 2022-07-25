package hello.springmvc.basic;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogTestController {

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "spring";

        log.trace("trace = {}, {}", name, name);
        log.debug("debug = {}, {}", name, name);
        log.info("info = {}, {}", name, name);
        log.warn("warn = {}, {}", name, name);
        log.error("error = {}, {}", name, name);

        return "ok";
    }
}
