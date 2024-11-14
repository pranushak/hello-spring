package org.launchcode.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(@RequestParam String coder){
//        return "hello," + coder +"!";
//    }

//    @GetMapping("hello/{name}")
//    @ResponseBody
//    public String helloParams(@PathVariable String name){
//        return "hello ," + name ;
//    }

    @RequestMapping(method={RequestMethod.GET})
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){
        return "hello" + name + "!";
    }

    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm(){
        String html = "<html>" +
                "<body>" +
                "<form method = 'post' action = '/hello'>" +
                "<input type = 'text' name = 'name'/>" +
                "<select name='language'>" +
                "<option value = 'english'>English </option>" +
                "<option value = 'french'>French </option>" +
                "<option value = 'italian'>Italian </option>" +
                "<option value = 'spanish'>Spanish </option>" +
                "<option value = 'german'>German </option>" +
                "</select>" +
                "<input type = 'submit' value= 'Greet Me!'/>" +
                "</form>"+
                "</body>" +
                "</html>";
        return html;
    }


    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "goobye Spring!";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language){
        if(name == null){
            name = "world";
        }
        return createMessage(name,language);
    }
    public static String createMessage(String n, String l){
        String greeting = "";
        if (l.equals("english")) {
            greeting = "Hello";
        }
        else if (l.equals("french")) {
            greeting = "Bonjour";
        }
        else if (l.equals("italian")) {
            greeting = "Bonjourno";
        }
        else if (l.equals("spanish")) {
            greeting = "Hola";
        }
        else if (l.equals("german")) {
            greeting = "Hallo";
        }

        return greeting + " " + n;
    }
}
