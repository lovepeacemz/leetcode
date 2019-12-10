package com.company.produceconsume;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Math.*;

/**
 * 描述内容
 *
 * @author zhangmeng36
 * @date 2019/9/9 下午7:04
 */
public class ProduceConsume {

    private static Queue<String> queue = new LinkedList();

    private static Lock lock = new ReentrantLock();

    private static Condition notEmpty = lock.newCondition();

    private static Condition notFull = lock.newCondition();

    static class Consumer implements Runnable {

        private Lock lock;

        private Condition notEmpty;

        private Condition notFull;

        public Consumer(Lock lock, Condition notEmpty, Condition notFull) {
            this.lock = lock;
            this.notEmpty = notEmpty;
            this.notFull = notFull;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 0 && !Thread.interrupted()) {
                        try {
                            System.out.println("queue is Empty!");
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("consume" + queue.poll());
                    notFull.signalAll();
                } finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(new Double(random() * (2000L)).longValue());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Producer implements Runnable {

        private Lock lock;

        private Condition notEmpty;

        private Condition notFull;

        public Producer(Lock lock, Condition notEmpty, Condition notFull) {
            this.lock = lock;
            this.notEmpty = notEmpty;
            this.notFull = notFull;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 10 && !Thread.interrupted()) {
                        try {
                            System.out.println("queue is full!");
                            notFull.await();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    queue.add("A");
                    System.out.println("produce a!");
                    notEmpty.signalAll();
                } finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(new Double(random() * (500L)).longValue());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        new Thread(new Producer(lock, notEmpty, notFull)).start();
        new Thread(new Consumer(lock, notEmpty, notFull)).start();
    }


}
