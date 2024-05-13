package com.itdemo;

/**
 * @ClassName Concurrent
 * @Description TODO
 * @Author 23097
 * @Data 2024/5/12 15:54
 **/
public class Concurrent {
    //常量
    private static int MAX_VALUE = 100;

    public static void main(String[] args) {
        Concurrentcomm con = new Concurrentcomm();
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    for (int i = 0; i < MAX_VALUE; i++) {
                        Thread.sleep(0);
                        con.product();
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();
        // 消费者
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                    for (int i = 0; i < MAX_VALUE; i++) {
                        con.customer();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
