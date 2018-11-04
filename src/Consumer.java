import jdk.nashorn.internal.ir.Block;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Consumer implements Runnable{

    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue(10);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    queue.offer(1);
                    System.out.println(queue);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        System.out.println(queue.take());;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        while (true){

        }
    }
}
