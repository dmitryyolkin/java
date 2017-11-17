/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-06-21 08:08)
 */
@Entity
public class C {

    @ManyToOne
    private A a;

}
