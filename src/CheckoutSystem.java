/**
 * Created by finnmasurat on 21.05.15.
 */
import java.util.ArrayList;

public class CheckoutSystem {

    public static final int countStudents = 10;
    public static final int countCheckouts = 1;
    public static final int runningtime = 2000;

    public static void main(String args[]){

        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Checkout> checkouts = new ArrayList<>();

        System.out.println("-------------------- START -------------------");

        for(int i = 1; i <= countCheckouts; i++){
            checkouts.add(new Checkout(i));
        }

        for(int j = 1; j <= countStudents; j++){
            Student current = new Student(checkouts);
            current.setName("Student " + j);
            students.add(current);

        }



        for(Student s: students){
            s.start();
        }

        try {
            Thread.sleep(runningtime);
        } catch (InterruptedException e) {
        }

        for(Student s: students){
            s.interrupt();
        }

        System.out.println("-------------------- THE END -------------------");
    }
}

