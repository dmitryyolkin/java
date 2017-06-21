/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-06-21 08:23)
 */
@Entity
public class D {

    @OneToOne(
            mappedBy = "d"
    )
    private A a;
}