package ThreadPractise.ProducerConsumer;

import java.util.concurrent.LinkedBlockingQueue;
//java 阻塞队列实现
public class ProducerCustomer1 {
    public static int limit = 10;  
    public static int i = 0;
    LinkedBlockingQueue<Task> queue=new LinkedBlockingQueue<Task>(limit);

    class Producer implements Runnable {  
        @Override  
        public void run() {

            while (true) {
                Task task = new Task(" task  Name:  "+i);
                    try {
                        Thread.sleep(1000);
                        queue.put(task);
                        System.out.println("produce  :" +task.taskname+"----size:"+queue.size());
                    } catch (InterruptedException e) {
                    }

            }
        }  
    }  
  
    class Customer implements Runnable {  
        @Override  
        public void run() {
            while (true){
                Task task= null;
                try {
                    Thread.sleep(3000);

                    task = queue.take();
                    System.out.println("consumser  :" +task.taskname+"----size:"+queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }  
    }  
  
    class Task {  
        public String taskname;  
        public Task(String taskname) {  
            this.taskname = taskname;  
        }  
    }  
    public static void main(String[] args) {  
        ProducerCustomer1 p = new ProducerCustomer1();  
        Producer producer = p.new Producer();  
        Customer customer = p.new Customer();  
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(customer).start();
        new Thread(customer).start();  
        new Thread(customer).start();  
    }  
}  
