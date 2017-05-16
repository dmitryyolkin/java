/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice;

import com.yolkin.bookservice.annotations.validators.ZipCode;
import javax.validation.constraints.NotNull;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-05-16 07:37)
 */
public class Address {

    @NotNull
    private String street1;
    private String street2;

    @NotNull
    private String city;
    private String state;

    @NotNull
    @ZipCode
    private String zipCode;
    private String country;

    public Address(String street1, String street2, String city, String state, String zipCode, String country) {
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }

    public String getStreet1() {
        return street1;
    }

    public String getStreet2() {
        return street2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street1='" + street1 + '\'' +
                ", street2='" + street2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}