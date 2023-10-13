import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Developer> developers = new ArrayList<>();

        int tempInt = rand.nextInt(0, 10);
        for (int i = 0; i < tempInt; i++) {
            if (rand.nextBoolean()) {
                developers.add(new FrontEndDeveloper());
            } else {
                developers.add(new BackEndDeveloper());
            }

        }

        for (Developer developer : developers) {
            checkSpec(developer);
        }
    }

    static void checkSpec(Developer developer) {
        if (developer instanceof FrontEndProgramming) {
            ((FrontEndProgramming) developer).developGUI();
        } else if (developer instanceof BackEndProgramming) {
            ((BackEndProgramming) developer).developAPI();
        }

    }
}
