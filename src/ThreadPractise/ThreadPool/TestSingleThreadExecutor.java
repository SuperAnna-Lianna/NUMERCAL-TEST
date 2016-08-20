package ThreadPractise.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by luairan on 16/8/6.
 */
class MyThread implements  Runnable{
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"\t\t"+ "正在执行。。。");
    }
}
public class TestSingleThreadExecutor {
    public static void main(String[] args) {
//        //创建一个可重用固定线程数的线程池
//        ExecutorService pool = Executors. newSingleThreadExecutor();
//        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
//        Runnable t1 = new MyThread();
//        Thread t2 = new MyThread();
//        Thread t3 = new MyThread();
//        Thread t4 = new MyThread();
//        Thread t5 = new MyThread();
//
//        //将线程放入池中进行执行
//        pool.execute(t1);
//        pool.execute(t2);
//        pool.execute(t3);
//        pool.execute(t4);
//        pool.execute(t5);
//        //关闭线程池
//        try {
//            t1.sleep(100L);
//
//        }catch (InterruptedException e){
//
//        }
//        pool.shutdown();
    }


}
