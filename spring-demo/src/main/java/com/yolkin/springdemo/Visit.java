package com.yolkin.springdemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (22.03.18)
 */
@Entity
public class Visit {

    @Id
    @GeneratedValue
    private Long id;

    private String description;

    public Visit() {
    }

    public Visit(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
