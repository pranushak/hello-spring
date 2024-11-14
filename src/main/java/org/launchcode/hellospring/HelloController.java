package org.launchcode.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(@RequestParam String coder){
//        return "hello," + coder +"!";
//    }

    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloParams(@PathVariable String name){
        return "hello ," + name ;
    }

    @RequestMapping(value="hello", method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello(@RequestParam String coder){
        return "hello" + coder + "!";
    }

    @GetMapping
    @ResponseBody
    public String helloForm(){
        String html = "<html>" +
                "<body>" +
                "<form method = 'get' action = '/hello'>" +
                "<input type = 'text' name = 'coder'/>" +
                "<input type = 'submit' name = 'Greet Me!'/>" +
                "</form>"+
                "</body>" +
                "</html>";
        return html;
    }
}
