package ThreadPractise.ProducerConsumer;

//链表实现阻塞队列 实现生产者消费者
public class ProducerCustomerlock {
    public static int i = 0;
    public static BlockingQueue<Tasks> queue = new BlockingQueue<Tasks>(10);
    public static void main(String[] args) {
        ProducerCustomerlock p = new ProducerCustomerlock();
        Producer producer = p.new Producer();
        Customer customer = p.new Customer();
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();
//        new Thread(producer).start();
        new Thread(customer).start();
//        new Thread(customer).start();
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
class BlockingQueue<T> {
    private Node nodeQueue;
    private Node last;
    private int length;
    private int size = 0;

    BlockingQueue(int length) {
        this.nodeQueue = null;
        this.last = null;
        this.length = length;
    }

    public synchronized void push(T t) throws InterruptedException {
        Node node = new Node();
        node.value = t;
        System.out.println(this.size);
        if(this.size>=10){
            System.out.println(">10");
            wait();
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
        notifyAll();
    }

    public synchronized T poll() throws InterruptedException {
        if (nodeQueue == null) {
            System.out.println("null");
            wait();
            return null;
        }
        Node node = nodeQueue;
        nodeQueue = nodeQueue.next;
        this.size--;
        notifyAll();
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