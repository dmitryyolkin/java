package com.yolkin.springdemo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (22.03.18)
 */
@RestController
@RequestMapping("/api")
public class ApiController {
    private VisitsRepository visitsRepository;

    public ApiController(VisitsRepository visitsRepository) {
        this.visitsRepository = visitsRepository;
    }

    @GetMapping(
            value = "/visits",

            // by default it produces JSOn so 'produces' param can be omitted
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Iterable<Visit> getVisits() {
        return visitsRepository.findAll();
    }
}
