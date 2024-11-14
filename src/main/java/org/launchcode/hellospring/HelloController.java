package org.launchcode.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    @ResponseBody
    public String hello(@RequestParam String coder){
        return "hello," + coder +"!";
    }

    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloParams(@PathVariable String name){
        return "hello ," + name ;
    }
}
