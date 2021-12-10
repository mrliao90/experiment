package com.exp.dt.thread;

import java.util.List;

/**
 * @author LIAO
 * @createTime 2021-12-10
 */
public class Thread4 {

    public int add(List<Integer> list) {
	list.parallelStream().forEach(System.out::println);
	System.out.println("Lambda 有stream 和 parallelSteam（并行）");
	return list.parallelStream().mapToInt(i -> i).sum();
    }
}
