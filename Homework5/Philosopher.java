import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Philosopher implements Runnable {

    private static int philosopherNumber;
    private String name;
    private int eatCount;
    private final Eatery eatery;


    {
        this.name = String.format("Philosopher %d", philosopherNumber++);
        this.eatCount = 0;
    }

    public Philosopher(Eatery eatery) {
        this.eatery = eatery;
    }

    public void dinner() throws InterruptedException {

        synchronized (this.eatery) {

            if (!eatery.isBusy()) {
                eatery.occupyEatery(this);
                eat();
                eatery.deoccupyEatery();
            }
        }
        Thread.sleep(500);
    }

    @Override
    public void run() {

        while (eatCount < 3) {
            try {
                dinner();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            think();
        }

    }

    public void eat() {
        System.out.println(String.format("%s eat %d times", this.name, 1 + this.eatCount++));
    }

    public void think() {
        System.out.println(String.format("%s now thinking", this.name));
    }

    @Override
    public String toString() {
        return name;
    }




}
