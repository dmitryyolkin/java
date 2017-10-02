/*
 * Copyright (c) 2008-2017 Maxifier Ltd. All Rights Reserved.
 */
package com.yolkin.bookservice.ejb;

import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.SessionContext;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (2017-08-02 07:37)
 */
@Asynchronous
public class AsyncEJB {
    @Resource
    private SessionContext sessionContext;

    public Future<Integer> get(int iterations){
        if (sessionContext.wasCancelCalled()) {
            //result was cancelled by user
            return new AsyncResult<>(-1);
        }

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        return executorService.submit(() -> {
            int sum = 0;
            for (int i = 0; i < iterations; i++) {
                sum += i;
            }
            return sum;
        });
    }
}