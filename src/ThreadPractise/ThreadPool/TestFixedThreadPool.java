package ThreadPractise.ThreadPool;

import java.util.concurrent.*;

/**
 * Created by luairan on 16/8/6.
 */
//线程池工作原理   验证代码
public class TestFixedThreadPool {
    public static void main(String[] args) throws InterruptedException {
        //创建一个可重用固定线程数的线程池

        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<Runnable>(15);

//        核心线程数10,最大线程数40,有界阻塞队列
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 40,
                0L, TimeUnit.MILLISECONDS,
                arrayBlockingQueue,Executors.defaultThreadFactory() );
        for(;;){
//            execute 方法参数是必须实现runable接口
            pool.execute(new MyThread());
            Thread.sleep(100);
//            前10个任务,没放到阻塞队列,直接创建线程执行,知道数量到核心线程数量10;
//            第10个之后的任务放到阻塞队列中,由核心线程数目去消费阻塞队列中的任务,直到阻塞队列满
//            阻塞队列慢,无法塞到阻塞队列,创建新线程数目执行,直到数量到达最大线程数量40
//            当再来的新的任务发现阻塞队列满了,线程池达到最大线程数没法创建新的线程,则将这无法执行的任务采用饱和策略处理.默认的饱和策略为抛异常
            System.out.println(" thead pool size:"+pool.getPoolSize()+" quene size is"+arrayBlockingQueue.size());
        }
    }
}
