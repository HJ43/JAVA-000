周四作业
```
package java0.conc0303;

import java.util.concurrent.*;

public class Homework03 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        // ---------------------------[方法1-start]-------------------------------------
        long start=System.currentTimeMillis();
        final int[] result1 = new int[1];
        Thread thread1 = new Thread(() -> {
            result1[0] = sum();
        });
        thread1.start();
        thread1.join();
        System.out.println("方法1异步计算结果为：" + result1[0]);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        // ---------------------------[方法1-end]-------------------------------------
        // ---------------------------[方法2-start]-------------------------------------
        start=System.currentTimeMillis();
        final int[] result2 = new int[1];
        new Thread(() -> {
            result2[0] = sum();
        }).start();
        Thread.sleep(1000L);
        System.out.println("方法2异步计算结果为：" + result2[0]);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        // ---------------------------[方法2-end]-------------------------------------
        // ---------------------------[方法3-start]-------------------------------------
        start=System.currentTimeMillis();
        FutureTask<Integer> futureTask3 = new FutureTask<>(() -> sum());
        new Thread(futureTask3).start();
        System.out.println("方法3异步计算结果为：" + futureTask3.get());
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        // ---------------------------[方法3-end]-------------------------------------
        // ---------------------------[方法4-start]-------------------------------------
        start=System.currentTimeMillis();
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> result4 = executor.submit(() -> sum());
        System.out.println("方法4异步计算结果为：" + result4.get());
        executor.shutdown();
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        // ---------------------------[方法4-end]-------------------------------------
        // ---------------------------[方法5-start]-------------------------------------
        start=System.currentTimeMillis();
        ExecutorService executor5 = Executors.newSingleThreadExecutor();
        Future<Integer> result5 = executor5.submit(() -> sum());
        executor5.shutdown();
        System.out.println("方法5异步计算结果为：" + result5.get());
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // ---------------------------[方法5-end]-------------------------------------
        // ---------------------------[方法6-start]-------------------------------------
        start=System.currentTimeMillis();
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> sum());
        Integer result6 = integerCompletableFuture.get(2, TimeUnit.SECONDS);
        System.out.println("方法6异步计算结果为：" + result6);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        // ---------------------------[方法6-end]-------------------------------------
        // ---------------------------[方法7-start]-------------------------------------
        start=System.currentTimeMillis();
        CompletableFuture<Integer> integerCompletableFuture7 = CompletableFuture.supplyAsync(() -> sum());
        Integer result7 = integerCompletableFuture7.get(2, TimeUnit.SECONDS);
        System.out.println("方法7异步计算结果为：" + result7);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        // ---------------------------[方法7-end]-------------------------------------
        // ---------------------------[方法8-start]-------------------------------------
        start=System.currentTimeMillis();
        final CountDownLatch countDownLatch8 = new CountDownLatch(1);
        final int[] result8 = new int[1];
        Thread thread8 = new Thread(() -> {
            result8[0] = sum();
            countDownLatch8.countDown();
        });
        thread8.start();
        countDownLatch8.await(1000, TimeUnit.SECONDS);
        System.out.println("方法8异步计算结果为：" + result8[0]);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        // ---------------------------[方法8-end]-------------------------------------
        // ---------------------------[方法9-start]-------------------------------------
        start=System.currentTimeMillis();
        final CountDownLatch countDownLatch9 = new CountDownLatch(1);
        final int[] result9 = new int[1];
        Thread thread9 = new Thread(() -> {
            result9[0] = sum();
            countDownLatch9.countDown();
        });
        thread9.start();
        countDownLatch9.await(1000, TimeUnit.SECONDS);
        System.out.println("方法9异步计算结果为：" + result9[0]);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        // ---------------------------[方法9-end]-------------------------------------
        // ---------------------------[方法10-start]-------------------------------------
        start=System.currentTimeMillis();
        final Semaphore semaphore = new Semaphore(1);
        final int[] result10 = new int[1];
        Thread thread10 = new Thread(() -> {
            try {
                semaphore.acquire();
                result10[0] = sum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        });
        thread10.start();
        Thread.sleep(100L);
        semaphore.acquire();
        System.out.println("方法10异步计算结果为：" + result10[0]);
        semaphore.release();
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        // ---------------------------[方法10-end]-------------------------------------

    }

    private static int sum() {
        return fibo(36);
    }
    
    private static int fibo(int a) {
        if ( a < 2) 
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
```

周六作业
![Image text](https://github.com/HJ43/JAVA-000/blob/main/pic/w4-1.png)
