package mutithread;

public class SaleTickets {
    public static void main(String[] args) {
        Sale sale = new Sale();
        new Thread(sale,"user1").start();
        new Thread(sale,"user2").start();
        new Thread(sale,"user3").start();
        new Thread(sale,"user4").start();
        Thread.yield();
        while (true){
            if (sale.tickets == 0){
                sale.tickets = 100;
                System.out.println("Resale......");
                break;
            }
        }
        System.out.println("Main Ending...");
    }
}

class Sale implements Runnable{
    volatile int tickets = 100;
    //int tickets = 100;
    String str = new String("");

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (str) {
                work();
            }

            if(tickets == 0){
                break;
            }
        }
    }

    private void work() {
        if(tickets > 0){
            tickets--;
            System.out.println(Thread.currentThread().getName()+" rest tickets："+tickets);
        }
    }
}