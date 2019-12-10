package com.company.multhread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述内容
 *
 * @author zhangmeng36
 * @date 2019/9/9 下午1:55
 */
public class Printabc {

    public static Lock lock = new ReentrantLock();

    public static Condition conditionA = lock.newCondition();

    public static Condition conditionB = lock.newCondition();

    public static Condition conditionC = lock.newCondition();


    static class MyThread extends Thread {

        Lock lock;

        Condition thisCondition;

        Condition nextCondition;

        String flag;

        Integer Count = 10;

        public MyThread(Condition thisCondition, Condition nextCondition, Lock lock, String flag) {
            this.lock = lock;
            this.thisCondition = thisCondition;
            this.nextCondition = nextCondition;
            this.flag = flag;
        }

        @Override
        public void run() {
            for (int i = 0; i < Count; i++) {
                lock.lock();
                try {
                    System.out.print(flag);
                    nextCondition.signal();
                    if (i < Count - 1) {
                        try {
                            // 本线程让出锁并等待唤醒
                            thisCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        new MyThread(conditionA, conditionB, lock, "A").start();
        Thread.sleep(10);
        new MyThread(conditionB, conditionC, lock, "B").start();
        Thread.sleep(10);
        new MyThread(conditionC, conditionA, lock, "C").start();
        Thread.sleep(10);

    }


}
