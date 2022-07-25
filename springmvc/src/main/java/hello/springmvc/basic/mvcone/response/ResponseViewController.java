package hello.springmvc.basic.mvcone.response;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/responsive-view-v1")
    public ModelAndView responsiveView() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello");
        return mav;
    }


    @RequestMapping("/responsive-view-v2")
    public String responsiveViewTwo(Model model) {
        model.addAttribute("data", "hello man!");
        return "response/hello";
    }

    @RequestMapping("/response/hello")
    public void responsiveViewThree(Model model) {
        model.addAttribute("data", "hello man!");
    }


}
