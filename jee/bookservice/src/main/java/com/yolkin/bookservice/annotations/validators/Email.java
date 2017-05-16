/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice.annotations.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-05-16 07:36)
 */
@Size(min = 7)
@Pattern(regexp =
        "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
        + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*"
        + "@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?"
)
@ReportAsSingleViolation

//No need to specify certain validator
//because verification can be done with help of standard @Pattern annotation
@Constraint(validatedBy = {})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {
    //This key is used in 'resources/META-INF/ValidationMessages.properties' to specify
    //user-friendly message in case of error
    String message() default "{com.yolkin.bookservice.annotations.validators.Email.message}";

    //groups indicates for what cases this annotation should be checked
    //a certain case is specified with help of certain classes
    Class<?>[] groups() default {};

    //some meta information can be passed to validation client
    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    //this interface is needed to specify a few email constraints for the same field/method and so on
    @interface List {
        Email[] value();
    }

}