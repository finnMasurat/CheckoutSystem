/**
 * Created by finnmasurat on 21.05.15.
 */
import java.util.concurrent.Semaphore;

public class Checkout {
    private Semaphore waitingQueue;
    public int checkoutID;

    public Checkout(int checkoutID) {
        this.checkoutID = checkoutID;
        this.waitingQueue = new Semaphore( 1 , true);
    }

    public void lineUp() throws InterruptedException {
            waitingQueue.acquire();

        System.out.println(Thread.currentThread().getName()
                + " is paying");

        try {
            this.pay();

            System.out.println(Thread.currentThread().getName()
                    + " is leaving Checkout " + this.checkoutID);
        } finally {
            waitingQueue.release();
        }
    }


    public void pay() throws InterruptedException{
        int timeForPaying = (int) (500 * Math.random());

            Thread.sleep(timeForPaying);
    }


    public int getCountWaiters() {
        return this.waitingQueue.getQueueLength();
    }

}

