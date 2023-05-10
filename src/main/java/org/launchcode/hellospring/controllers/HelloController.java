package org.launchcode.hellospring.controllers;

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
    @GetMapping("hello")
    public String goodbye(Model model){
        model.addAttribute("name", "Blake");
        return "form";
    }
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name,@RequestParam String language){
        if(language.equals("Telugu")) {
            return "Namasthe " + name + "!";
        }
        if(language.equals("Hindi")){
            return "Namaskar " + name + "!";
        }
        if(language.equals("Tamil")){
            return "Vanakkam " + name + "!";
        }
        if(language.equals("Urdu")){
            return "Salaam " + name + "!";
        }
        return "hello " + name + "!";
    }
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){
        model.addAttribute("name", name);
        return "form";
    }
    @GetMapping("/form")
    public String helloForm(){
        return "form";
    }
    @GetMapping("greet")
    public String createMessage(){
      return "<html>" +
              "<body>" +
              "<form method = 'get' action = '/hello'>"+
              "<input type = 'text' name = 'name' />" +
              "<select name = 'language' id = 'languages-select'>" +
              "<option value = 'English'>English</option>" +
              "<option value = 'Telugu'>Telugu</option>" +
              "<option value = 'Hindi'>Hindi</option>" +
              "<option value = 'Tamil'>Tamil</option>" +
              "<option value = 'Urdu'>Urdu</option>" +
              "<input type = 'submit' value = 'Greet Me' />" +
              "</form>" +
              "</body>" +
              "</html>";
    }
}
