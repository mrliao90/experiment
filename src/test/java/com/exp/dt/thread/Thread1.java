package com.exp.dt.thread;

/**
 * @author LIAO
 * @createTime 2021-12-10
 */
public class Thread1 extends Thread {

    @Override
    public void run() {
	System.out.println("--[创建多线程 : 1、继承Thread类，重写run()方法]--");
    }
}
