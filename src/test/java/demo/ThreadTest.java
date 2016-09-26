package demo;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;

public class ThreadTest {
    /**
     * 使用 Callable 和 Future 创建线程
     */
    @Test
    public void test() throws Exception {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(50);
            }
        });

        new Thread(futureTask, "Callable线程").start();
        Integer result = futureTask.get();
        System.out.println("子线程的返回值：" + result);
    }

    /**
     * 使用 Executor 的 execute() 启动线程
     */
    @Test
    public void test2() throws Exception {
        // Executor 使我们无需显示的去管理线程的生命周期
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(30);
            }
        });

        executorService.execute(task);

        Integer result = task.get();
        System.out.println(result);

        executorService.shutdown();
    }

    /**
     * 使用 Executor 的 submit() 启动线程
     */
    @Test
    public void test3() throws Exception {
        // Executor 使我们无需显示的去管理线程的生命周期
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        });

        Integer result = future.get();
        System.out.println(result);

        executorService.shutdown();
    }

    /**
     * 使用 Executor 创建多个线程
     */
    @Test
    public void test4() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletionService<Map> completionService = new ExecutorCompletionService<>(executorService);
        for (int i = 0; i<5; i++){
            final int key = i;
            final int value = i*i;
            completionService.submit(new Callable<Map>() {
                @Override
                public Map call() throws Exception {
                    return ImmutableMap.of(key, value);
                }
            });
        }

        /**
         * 获取结果时，总是先拿到队列上已经存在的对象，这样不用依次等待结果，显然效率更高
         */
        for (int i = 0; i<5; i++){
            Map map = completionService.take().get();
            for (Object key : map.keySet()){
                System.out.println("线程"+ key + "的返回值：" + map.get(key));
            }
        }

        executorService.shutdown();
    }

    /**
     * 不使用 CompletionService
     * 创建一个装 Future 类型的集合，将 Executor 提交的任务返回值添加到集合中，最后遍历集合取出数据
     */
    @Test
    public void test5() throws Exception {
        int n = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(n);
        Future<String>[] futures = new FutureTask[n];

        for (int i = 0; i<n; i++){
            final int rnt = i;
            futures[i] = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return String.valueOf(rnt*1000);
                }
            });
        }

        /**
         * 顺序获取结果。如果任务没有完成，则阻塞；可能别的任务已经完成，显然效率不高
         */
        for (int i = 0; i<n; i++){
            System.out.println(futures[i].get());
        }

        executorService.shutdown();
    }
}
