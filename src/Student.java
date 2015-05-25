/**
 * Created by finnmasurat on 21.05.15.
 */
import java.util.ArrayList;

public class Student extends Thread {

    private ArrayList<Checkout> checkouts;
    private Checkout checkout;

    public Student(ArrayList<Checkout> checkouts) {
        this.checkouts = checkouts;
        this.checkout = checkouts.get(0);
    }

    public void run() {
        try {
            while (!this.isInterrupted()) {
                for (Checkout c : this.checkouts) {
                    if (c.getCountWaiters() < this.checkout
                            .getCountWaiters()) {
                        this.checkout = c;
                    }
                }

                System.out.println(this.getName()
                        + " is lining up on Checkout " + this.checkout.checkoutID);


                this.checkout.lineUp();

                this.isWaiting();

            }

        } catch (InterruptedException e) {
                System.out.println(this.getName() + " was interrupted");
        }
    }

    private void isWaiting() {
        int sleepTime = (int) (5000 * Math.random());

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

}
