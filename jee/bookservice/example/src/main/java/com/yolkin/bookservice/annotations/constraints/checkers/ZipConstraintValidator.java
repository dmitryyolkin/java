/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice.annotations.constraints.checkers;

import com.yolkin.bookservice.annotations.constraints.ZipCode;
import com.yolkin.bookservice.annotations.qualifiers.USA;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * ZipConstraintValidator validate correctness and existense of Zip Code
 *
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-05-18 07:40)
 */
public class ZipConstraintValidator implements ConstraintValidator<ZipCode, String> {

    @Inject
    @USA
    private ZipCodeChecker zipCodeChecker;
    private Pattern zipPattern = Pattern.compile("\\d{5}(-\\d{5})?");

    @Override
    public void initialize(ZipCode constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null &&
                zipPattern.matcher(value).matches() &&
                zipCodeChecker.isZipCodeValid(value);
    }
}