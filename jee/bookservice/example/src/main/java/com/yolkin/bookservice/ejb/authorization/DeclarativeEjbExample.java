package com.yolkin.bookservice.ejb.authorization;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (05.10.17)
 */
@Stateless
@DeclareRoles({"user"}) // this specifies security role list used by this ejb
@RolesAllowed({"admin", "user"}) //all methods available for these roles only
public class DeclarativeEjbExample {

    public void print() {
        System.out.println("DeclarativeEjbExample.print");
    }

    //overwrite method with 'Admin' role
    @RolesAllowed({"admin"})
    public void doAdminPrivileges() {

    }

    //deny for all
    @DenyAll
    public void doSomethingIllegal() {
        System.out.println("DeclarativeEjbExample.doSomethingIllegal");
    }
}
