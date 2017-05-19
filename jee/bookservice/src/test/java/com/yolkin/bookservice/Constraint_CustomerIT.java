/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.Instant;
import java.util.Date;
import java.util.Set;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-05-18 08:03)
 */
public class Constraint_CustomerIT {
    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        //Для того чтобы мы смогли получить ValidationFactory необходимо в pom.xml добавить дпополнительную зависимость
//        <dependency>
//            <groupId>org.glassfish</groupId>
//            <artifactId>javax.el</artifactId>
//            <version>3.0.1-b08</version>
//        </dependency>

        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterClass
    public static void tearDown() {
        validatorFactory.close();
    }

    @Test
    public void validCustomer() {
        Customer customer = new Customer(
                "John",
                "Smith",
                "john.smith@gmail.com",
                "123456",
                Date.from(Instant.now().minusSeconds(60 * 60)),
                null
        );

        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertEquals(violations.size(), 0);
    }

    @Test
    public void invalidCustomer() {
        Customer customer = new Customer(
                "John",
                "Smith",
                "john.smith", //invalid mail
                "123456",
                Date.from(Instant.now().plusSeconds(60 * 60)), //invalid birth date
                null
        );

        //по умолчанию все сообщения ищутся в файле resources/ValidationMessages.properties,
        //который является дефолтным файлом собощений

        //Если вы хотите создать специфичный файл для своей локали, напр-р, для 'ru_RU'
        //тогда необходимо создать файль resources/ValidationMessages_ru.properties
        //Зачитка бандла осуществляется с помощью ResourceBundle.getBundle()
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertEquals(violations.size(), 2);
    }

}