/*
Есть пять философов (потоки), которые могут либо обедать либо размышлять.
Каждый философ должен пообедать три раза. Каждый прием пищи длиться 500 миллисекунд
После каждого приема пищи философ должен размышлять
Не должно возникнуть общей блокировки
Философы не должны есть больше одного раза подряд
 */


import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        List<Philosopher> philosophers = new ArrayList<>();
        Philosopher.philosophers = philosophers;

        for (int i = 0; i < 5; i++) {
            philosophers.add(new Philosopher());
        }

        for (Philosopher philosopher: philosophers) {
            philosopher.getThread().start();
        }

    }

}
