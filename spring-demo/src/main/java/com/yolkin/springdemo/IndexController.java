package com.yolkin.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (20.03.18)
 */
@Controller
public class IndexController {

    @GetMapping(value = "/")
    public ModelAndView index() {
        Map<String, String> model = new HashMap<>();
        model.put("name", "Dmitry");

        // please see index.html in resources/templates
        return new ModelAndView("index", model);
    }
}
