package com.example.RESTAPI_WTH_SPRING;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GreetingsController {

    @GetMapping(path = "/greeting-bean")
    public Greetings greetings(@RequestParam(defaultValue = "Guys") String name){
        return new Greetings(232342342, name);
    }

    @GetMapping(path = "/greeting")
    public String greeting(){
        return "Hello";
    }

    @GetMapping(path = "/greetingsParams")
    public String greet(@RequestParam(defaultValue = "none") String name){
        return "Hello" + " " + name;
    }
    // demo data

    @GetMapping("/data")
    public Map<String, Object> getData() {
        Map<String, Object> data = new HashMap<>();
        data.put("message", "Hello from Spring Boot!");
        data.put("status", "success");
        data.put("timestamp", System.currentTimeMillis());
        return data;
    }

}


//public String greetings(@RequestParam(defaultValue = "World") String name){
//    return "Hello" + " " + name;
//}