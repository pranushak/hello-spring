package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "Hello, Spring!";
    }

    @RequestMapping(value = "hellogoodbye", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hellogoodbye(){
        return "hello, goodbye!";
    }
}
