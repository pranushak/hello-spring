package org.launchcode.hellospring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    // @GetMapping("hello")
    // @ResponseBody
    // public String hello(){
    //     return "Hello, Spring!";
    // }
    // @GetMapping("hello")
    // public String goodbye(Model model){
    //     model.addAttribute("name", "Blake");
    //     return "form";
    // }
    @RequestMapping(value = "hello",method = {RequestMethod.GET,RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name,Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting",greeting);
        return "hello";
    }  
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){
        model.addAttribute("greeting","Hello, " + name + "!" );
        return "hello";
    }
    @GetMapping("/form")
    public String helloForm(){
        return "form";
    }
@GetMapping("hello-names")
public String helloNames(Model model){
    List<String> names = new ArrayList<>();
    names.add("LaunchCode");
    names.add("java");
    names.add("JavaScript");
    model.addAttribute("names", names);
    return "hello-list";
    
    }
}
