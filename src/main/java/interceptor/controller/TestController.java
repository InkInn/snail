package interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/tmp")
    @ResponseBody
    public String test(String uid){
        return uid  + " aaaaaaaa";
    }
}
