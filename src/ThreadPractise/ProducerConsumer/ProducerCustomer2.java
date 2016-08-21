package ThreadPractise.ProducerConsumer;

//链表实现队列 实现生产者消费者
public class ProducerCustomer2 {
    public static int i = 0;
    //private ReentrantLock lock = new ReentrantLock();
    public static Queue<Tasks> queue = new Queue<Tasks>(10);
    public static void main(String[] args) {
        ProducerCustomer2 p = new ProducerCustomer2();
        Producer producer = p.new Producer();
        Customer customer = p.new Customer();
        new Thread(producer).start();
//        new Thread(producer).start();
//        new Thread(producer).start();
//        new Thread(producer).start();
//        new Thread(customer).start();
        new Thread(customer).start();
//        new Thread(customer).start();
//        new Thread(customer).start();
//        Queue<Integer> queue = new Queue<Integer>(4);
//        queue.push(1);
//        queue.push(2);
//        queue.push(3);
//        queue.push(4);
//        for (int i = 0; i < 4; i++) {
//            System.out.println(queue.getSize() + "---size");
//            System.out.println(queue.poll().value);
//        }
    }

    class Customer implements Runnable {
        @Override
        public void run() {

            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (queue) {
                    if (queue.getSize() > 0) {
                        queue.poll();
                        System.out.println("consumer :"+Thread.currentThread().getName()+" size:"+queue.getSize());
                        queue.notifyAll();
                    } else {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (queue) {
                    if (queue.getSize() < 10) {
                        System.out.println("prodecer :"+Thread.currentThread().getName()+" size:"+queue.getSize());
                        Tasks tasks = new Tasks("task" + (i++));
                        queue.push(tasks);
                        queue.notifyAll();
                    } else {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

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

class Queue<T> {
    private Node nodeQueue;
    private Node last;
    private int length;
    private int size = 0;

    Queue(int length) {
        this.nodeQueue = null;
        this.last = null;
        this.length = length;
    }

    public void push(T t) {
        Node node = new Node();
        node.value = t;
        if (nodeQueue == null) {
            nodeQueue = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        this.size++;
    }

    public T poll() {
        if (nodeQueue == null) {
            return null;
        }
        Node node = nodeQueue;
        nodeQueue = nodeQueue.next;
        this.size--;
        return node.value;
    }

    public int getSize() {
        return this.size;
    }

    class Node {
        T value;
        Node next;
    }

}