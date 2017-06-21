/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-06-21 08:11)
 */
@MappedSuperclass
public abstract class ASuperClass {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
}