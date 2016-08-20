package sync;

/**
 * Created by luairan on 16/8/18.
 */
public class DeadLock {
    DeadLock(int a){
        a=100;
    }
    public static void main(String[] args) {
        Object o1=new Object();
        Object o2=new Object();
        Thread t1=new Thread(new Pro(o1,o2));
        Thread t2=new Thread(new Pro2(o1,o2));
        t1.start();
        t2.start();
    }


}

class  Pro implements Runnable{
    Object o1;
    Object o2;
    Pro(Object o1,Object o2){
        this.o1=o1;
        this.o2=o2;
    }
    @Override
    public void run() {
        synchronized (o1){
            try {
                Thread.sleep(1000);
            }catch (Exception e){

            }
            synchronized (o2){

            }
        }
    }
}
class  Pro2 implements Runnable{
    Object o1;
    Object o2;
    Pro2(Object o1,Object o2){
        this.o1=o1;
        this.o2=o2;
    }
    @Override
    public void run() {
        synchronized (o2){
            try {
                Thread.sleep(1000);
            }catch (Exception e){

            }
            synchronized (o1){

            }
        }
    }
}
