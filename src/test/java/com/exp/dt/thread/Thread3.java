package com.exp.dt.thread;

import java.util.concurrent.Callable;

/**
 * @author LIAO
 * @createTime 2021-12-10
 */
public class Thread3 implements Callable<String> {
    @Override
    public String call() throws Exception {
	return "--[创建多线程 : 4、带返回值的线程 实现 Callable<T>]--";
    }
}
