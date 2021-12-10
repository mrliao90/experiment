package com.exp.dt.thread;

import com.exp.dt.Config;
import com.exp.dt.service.AsyncService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author LIAO
 * @createTime 2021-12-10
 */
public class ThreadTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

	/*
	 * --[创建多线程 : 2、实现Runnable接口，重写run()]--
	 * --[创建多线程 : 1、继承Thread类，重写run()方法]--
	 * */

	Thread thread1 = new Thread(new Thread1());
	Thread thread2 = new Thread(new Thread2());

	thread2.start();
	thread1.start();

	/*
	 * 匿名内部类的方式
	 * */

	new Thread() {
	    public void run() {
		System.out.println("[创建多线程 : 3、匿名内部类，相当于方式1 继承Thtead]");
	    }

	}.start();
	new Thread(new Runnable() {
	    @Override
	    public void run() {
		System.out.println("[创建多线程 : 3、匿名内部类，相当于方式2 实现Runnable]");
	    }
	}).start();

	/*
	 * 带返回值的线程(实现implements  Callable<返回值类型>)
	 * */
	Thread3 thread3 = new Thread3();
	FutureTask<String> task = new FutureTask<>(thread3);
	Thread t = new Thread(task);
	t.start();
	//获取返回值
	System.out.println(task.get());

	/*
	 * 定时任务
	 * */

	Timer timer = new Timer();
	timer.schedule(new TimerTask() {
	    @Override
	    public void run() {
		System.out.println("--[创建多线程 : 5、定时器(java.util.Timer)--");
	    }
	}, 0, 1000);

	/*
	 * 线程池的实现
	 * */
	Executor threadPool = Executors.newFixedThreadPool(10);
	for (int i = 0; i < 10; i++) {
	    threadPool.execute(new Runnable() {
		@Override
		public void run() {
		    System.out.println("--[创建多线程 : 6、线程池的实现(java.util.concurrent.Executor接口)]--");
		    System.out.println(Thread.currentThread().getName() + "is running");
		}
	    });
	}
	// 运行完毕，但程序并未停止，原因是线程池并未销毁，若想销毁调用threadPool.shutdown();    注意需要把我上面的
	// Executor threadPool = Executors.newFixedThreadPool(10);              改为
	// ExecutorService threadPool = Executors.newFixedThreadPool(10);     否则无shutdown()方法
	//若创建的是CachedThreadPool则不需要指定线程数量，线程数量多少取决于线程任务，不够用则创建线程，够用则回收。

	/*
	 * 7、Lambda表达式的实现(parallelStream)
	 * */

	List<Integer> list = Arrays.asList(1, 2, 3, 5, 6);
	Thread4 thread4 = new Thread4();
	thread4.add(list);

	/*
	 * 8、Spring 实现多线程
	 *
	 * (1)新建Maven工程导入spring相关依赖
	 * (2)新建一个java配置类(注意需要开启@EnableAsync注解——支持异步任务)
	 * (3)书写异步执行的方法类(注意方法上需要有@Async——异步方法调用)
	 * */

	//构造方法传递 java 配置类 config.class
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
	AsyncService bean = ac.getBean(AsyncService.class);

	bean.Async_A();
	bean.Async_B();


    }
}
