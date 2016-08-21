package ThreadPractise.ProducerConsumer;

// 自建数组实现生产者消费者
public class ProducerCustomer3 {
    public static int limit = 10;
    public static int current = 0;
    public static int name = 0;

    public static Tasks[] taskses = new Tasks[10];

    class Customer implements Runnable {
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (taskses){
                    if(current>=0){
                        Tasks tasks = taskses[current];
                        System.out.println("Customer :" +Thread.currentThread().getName()+" get task at:"+current+" position");
                        if(current>0)
                        current--;
                        taskses.notifyAll();
                    }else{
                        try {
                            taskses.wait();
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
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (taskses){
                    Tasks tasks = new Tasks("task" + name);
                    if(current<limit){
                        taskses[current]=tasks;
                        System.out.println("Producer :" +Thread.currentThread().getName()+" add task at:"+current+" position");
                        taskses.notifyAll();
                        if(current+1<limit)
                        current++;
                    }else{
                        try {
                            taskses.wait();
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
    public static void main(String[] args) {
        ProducerCustomer3 p = new ProducerCustomer3();
        Producer producer = p.new Producer();
        Customer customer = p.new Customer();
        new Thread(producer).start();
        new Thread(producer).start();
//        new Thread(producer).start();
//        new Thread(producer).start();
        new Thread(customer).start();
        new Thread(customer).start();
        new Thread(customer).start();
    }
}  
