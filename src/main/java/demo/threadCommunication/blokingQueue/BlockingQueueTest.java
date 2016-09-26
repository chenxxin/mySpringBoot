package demo.threadCommunication.blokingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> bq = new ArrayBlockingQueue<String>(2);

        bq.put("java");
        bq.put("thread");
//        bq.put("mysql");   // 队列长度为2，线程阻塞
//        bq.add("mysql");   // java.lang.IllegalStateException: Queue full
//        bq.offer("mysql"); // 返回 false

        bq.take();     // java
        bq.take();     // thread
//        bq.take();   // 队列已空，线程阻塞
//        bq.remove(); // java.util.NoSuchElementException
//        bq.poll();   // null
        System.out.println(bq.peek());
    }
}
