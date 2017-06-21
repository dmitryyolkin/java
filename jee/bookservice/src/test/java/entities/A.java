/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Collection;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-06-21 08:08)
 */
@Entity
public class A extends ASuperClass{

    @ManyToMany
    @JoinTable(
            name = "a_b",
            //joinColumns specifies primary key of entity that owns relationShip
            //inverseJoinColumns specifies primary key of entity that is owned by another entity
            joinColumns = {@JoinColumn(name = "a_id")},
            inverseJoinColumns = {@JoinColumn(name = "b_id")}
    )
    private Collection<B> bs;

    @OneToMany(
            // mappedBy specifies a side that owns relationShip
            // in mappedBy we save to specify entity attribute name of root entity
            mappedBy = "a"
    )
    private Collection<C> cs;

    @OneToOne
    @JoinColumn(
            name = "a_id"
    )
    private D d;
}
