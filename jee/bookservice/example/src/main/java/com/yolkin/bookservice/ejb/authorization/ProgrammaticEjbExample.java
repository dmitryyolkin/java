package com.yolkin.bookservice.ejb.authorization;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (05.10.17)
 */
@Stateless
public class ProgrammaticEjbExample {
    @Resource
    private SessionContext sessionContext;

    public void doAdminPrivileges() {
        if (!sessionContext.isCallerInRole("admin")) {
            throw new SecurityException("role is not admin");
        }

        System.out.println("Do some admin staff");
    }

}
