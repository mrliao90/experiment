package com.exp.dt.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author LIAO
 * @createTime 2021-12-10
 */
@Service
public class AsyncService {
    @Async
    public void Async_A() {
	System.out.println(Thread.currentThread().getName() + "Async_A is running");
    }

    @Async
    public void Async_B() {
	System.out.println(Thread.currentThread().getName() + "Async_B is running");
    }
}
