package com.exp.dt.thread;

/**
 * @author LIAO
 * @createTime 2021-12-10
 */
public class Thread2 implements Runnable {
    @Override
    public void run() {
	System.out.println("--[创建多线程 : 2、实现Runnable接口，重写run()]--");
    }
}
