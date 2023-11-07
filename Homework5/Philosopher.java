import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Philosopher implements Runnable{

    private static int philosopherNumber;
    public static List<Philosopher> philosophers = new CopyOnWriteArrayList<>();
    private String name;
    private int eatCount;
    private Thread thread;




    {
        this.name = String.format("Philosopher %d", philosopherNumber++);
        this.eatCount = 0;
        this.thread = new Thread(this,
                String.format("Thread %s", this.name));
    }



    public static void dinner (Philosopher philosopher) {


            if (philosopher.getEatCount() < 3) {
                philosopher.eat();
                try {
                    philosopher.think();
                    Thread.sleep(500);
                    philosopher.getThread().wait();
                    philosopher.getRandomPhilosopher().notify();

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                philosopher.getThread().interrupt();
                Philosopher.philosophers.remove(philosopher);
            }


    }

    @Override
    public void run() {

        while (!philosophers.isEmpty()) {
            Philosopher.dinner(this);
        }
    }

    public void eat () {
        System.out.println(String.format("%s eat %d times", this.name, 1 + this.eatCount++));
    }

    public void think () {
        System.out.println(String.format("%s now thinking", this.name));
    }

    private Philosopher getRandomPhilosopher () {

        List<Philosopher> list = new ArrayList<>(Philosopher.philosophers);
        list.remove(this);
        return list.get(new Random().nextInt(list.size()));
    }

    public Thread getThread() {
        return thread;
    }

    public int getEatCount() {
        return eatCount;
    }
}
