package com.yolkin.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (20.03.18)
 */
@Controller
public class IndexController {

    private VisitsRepository visitsRepository;

    public IndexController(VisitsRepository visitsRepository) {
        this.visitsRepository = visitsRepository;
    }

    @GetMapping(value = "/")
    public ModelAndView index() {
        Map<String, String> model = new HashMap<>();
        model.put("name", "Dmitry");

        //save visits
        visitsRepository.save(new Visit(
                String.format("Visited at %s", LocalDateTime.now())
        ));

        // please see index.html in resources/templates
        return new ModelAndView("index", model);
    }
}
