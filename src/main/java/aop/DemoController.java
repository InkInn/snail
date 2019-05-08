package aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping("/aop/http/alive")
    public String alive(){
        return "bingo";
    }

    @AuthChecker
    @RequestMapping("/aop/http/user_info")
    public String callSomeInterface(){
        return "user_info";
    }
}
