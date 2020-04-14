package com.company.multhread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Print {
    private static char [] aI = "1234567".toCharArray();
    private static char [] aC = "ABCDEFG".toCharArray();
    private static Lock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();

    static class PrintAi implements Runnable{
        @Override
        public void run(){
            try {
                lock.lock();
                for(char c : aI){
                    System.out.print(c);
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
    static class PrintAc implements Runnable{
        @Override
        public  void run(){
            try{
                lock.lock();
                for(char c: aC) {
                    System.out.print(c);
                    condition1.signal();
                    condition2.await();
                }
                condition1.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new PrintAi()).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new PrintAc()).start();
    }
}
