package io.eddie.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Map;

@Controller
public class TemplateController2 {

    @GetMapping("/params1")
    public String showIndex(HttpServletRequest req) {

        System.out.println("/params1");
        String name = req.getParameter("name");
        System.out.println("name = " + name);

        Map<String, String[]> paramMap = req.getParameterMap();

        paramMap.forEach((k, v) -> {
            System.out.println("key = " + k + " value = " + Arrays.toString(v));
        });

        return "index";
    }


    @GetMapping("/params2")
    public String showIndex2(@RequestParam(name = "name") String name) {

        System.out.println("/params2");
        System.out.println("name = " + name);

        return "index";
    }

    @GetMapping("/params3")
    public String showIndex3(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "age", required = false, defaultValue = "20") Integer age
    ) {

        System.out.println("/params3");

        System.out.println("name = " + name);
        System.out.println("age = " + age);

        return "index";
    }


}
