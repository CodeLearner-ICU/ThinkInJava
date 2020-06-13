package mutithread;

@ThreadSafe
public class Annotation {
    private static volatile int num;
    private static boolean ready;

    private static class Reader extends Thread{
        @Override
        public void run(){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this){
                num = 43;
            }
        }
    }

    public static void main(String[] args) {
        Reader[] readers = new Reader[100];
        for (int i = 0; i < 100; i++) {
            readers[i] = new Reader();
        }
        for (int i = 0; i < 100; i++) {
            readers[i].start();
        }
        for (int i = 0; i < 100; i++) {
            try {
                readers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(num);
    }
}
