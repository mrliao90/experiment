package com.exp.dt;

/**
 * @author LIAO
 * @createTime 2021-12-10
 */
public class MainTest {
    public static void main(String[] args) {
	System.out.println("----多线程-----------");


	ThreadLocal threadLocal = new ThreadLocal();

	threadLocal.set("main---");

	System.out.println(threadLocal.get());

	threadLocal.remove();

	new Thread() {
	    public void run() {
		threadLocal.set("nihao001");
		System.out.println(threadLocal.get());
	    }
	}.start();
	new Thread() {
	    public void run() {
		System.out.println(threadLocal.get());
	    }
	}.start();
    }
}
