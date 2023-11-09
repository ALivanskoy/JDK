public class Eatery {

    private boolean isBusy;
    private Philosopher previousPhilosopher;

    public Eatery() {
        this.isBusy = false;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void occupyEatery(Philosopher philosopher) {

        if(previousPhilosopher == philosopher) return;

        this.isBusy = true;
        this.previousPhilosopher = philosopher;
    }

    public void deoccupyEatery () {
        this.isBusy = false;
    }
}
