package com.tzword.eurekaclient.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jianghy
 * @Description: 测试多线程
 * @date 2020/12/3 14:41
 */
@Slf4j
public class Test {

//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            list.add("user-" + i);
//        }
//        ExecutorService executor = Executors.newFixedThreadPool(4);
//        ReentrantLock reentrantLock = new ReentrantLock();
//        for (int i = 0; i < 10; i++) {
//            final int index = i;
//            executor.execute(() -> {
//                try {
//                    //怕线程不安全进行加锁
//                    reentrantLock.lock();
//                    for (String s : list) {
//                        log.info("多表操作 {}",s);
//                    }
//                    reentrantLock.unlock();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                System.out.println(Thread.currentThread().getName() + "  " + index);
//            });
//        }


        public static void main(String[] args) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                list.add("user-" + i);
            }
            ExecutorService executor = Executors.newFixedThreadPool(4);
            ReentrantLock reentrantLock = new ReentrantLock();
            for (int i = 0; i < list.size(); i++) {
                final int index = i;
                String s = list.get(i);
                executor.execute(() -> {
                    try {
                        //怕线程不安全进行加锁
//                    reentrantLock.lock();
                        Thread.sleep(1000);
                        log.info("多表操作 {}",s);
//                        reentrantLock.unlock();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "  " + index);
                });
            }
        }
}
