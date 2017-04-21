/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-04-17 07:22)
 */
public class Book {
    private final String title;
    private final Float price;
    private final String description;
    private final String number;

    public Book(String title, Float price, String description, String number) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public Float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}