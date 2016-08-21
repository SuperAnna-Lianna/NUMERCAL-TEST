package ThreadPractise.ProducerConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by luairan on 16/8/21.
 */
//链表实现  采用ReentrantLock阻塞队列    实现生产者消费者
public class ProConByReentrantLock {
    public static int i = 0;
    //    private ReentrantLock lock = new ReentrantLock();
    public static BlockingQueue<Tasks> queue = new BlockingQueue<Tasks>(10);
    public static void main(String[] args) {
        ProConByReentrantLock p = new ProConByReentrantLock();
        Producer producer = p.new Producer();
        Customer customer = p.new Customer();
        new Thread(producer).start();
        new Thread(producer).start();
//        new Thread(producer).start();
//        new Thread(customer).start();
        new Thread(customer).start();
    }

    class Producer implements Runnable {
        @Override
        public void run() {

            while (true) {
                Tasks task = new Tasks(" task  Name:  "+i);
                try {
                    Thread.sleep(1000);
                    queue.push(task);
                    System.out.println("produce  :" +task.taskname+"----size:"+queue.getSize());
                } catch (InterruptedException e) {
                }

            }
        }
    }

    class Customer implements Runnable {
        @Override
        public void run() {
            while (true){
                Tasks task= null;
                try {
                    Thread.sleep(1000);

                    task = queue.poll();
                    if(task!=null)
                        System.out.println("consumser  :" +task.taskname+"----size:"+queue.getSize());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class Tasks {
        public String taskname;
        public Tasks(String taskname) {
            this.taskname = taskname;
        }
    }

}

class BlockingQueues<T> {
    private Node nodeQueue;
    private Node last;
    private int length;
    private int size = 0;
    private final ReentrantLock lock;

    private final Condition condition;


    BlockingQueues(int length) {
        this.nodeQueue = null;
        this.last = null;
        this.length = length;
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    public  void push(T t) throws InterruptedException {
        lock.lock();
        try {
            Node node = new Node();
            node.value = t;
            System.out.println(this.size);
            if(this.size>=10){
                System.out.println(">10");
                condition.await();
                return;
            }
            if (nodeQueue == null) {
                nodeQueue = node;
                last = node;
            } else {
                last.next = node;
                last = node;
            }
            this.size++;
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }

    public  T poll() throws InterruptedException {
        lock.lock();
        try {
            if (nodeQueue == null) {
                System.out.println("null");
                condition.await();
                return null;
            }
            Node node = nodeQueue;
            nodeQueue = nodeQueue.next;
            this.size--;
            condition.signalAll();
            return node.value;
        }finally {
            lock.unlock();
        }

    }

    public int getSize() {
        return this.size;
    }

    class Node {
        T value;
        Node next;
    }

}