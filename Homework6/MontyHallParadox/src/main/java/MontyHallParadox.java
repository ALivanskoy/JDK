import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHallParadox {
    private static final int NUM_ITERATIONS = 10000; // Количество итераций (шагов цикла)
    private static final int NUM_DOORS = 3; // Количество дверей

    public static void main(String[] args) {
        Map<Integer, Integer> results = new HashMap<>(); // Хранение результатов

        int positiveCount = 0;
        int negativeCount = 0;

        Random random = new Random();

        for (int i = 1; i <= NUM_ITERATIONS; i++) {
            int winningDoor = random.nextInt(NUM_DOORS); // Выбирается случайная выигрышная дверь
            int chosenDoor = random.nextInt(NUM_DOORS); // Игрок выбирает случайную дверь

            int revealedDoor;
            do {
                revealedDoor = random.nextInt(NUM_DOORS); // Ведущий открывает случайную невыигрышную дверь
            } while (revealedDoor == chosenDoor || revealedDoor == winningDoor);

            int switchedDoor;
            do {
                switchedDoor = random.nextInt(NUM_DOORS); // Игрок меняет выбор на другую дверь
            } while (switchedDoor == chosenDoor || switchedDoor == revealedDoor);

            if (switchedDoor == winningDoor) {
                positiveCount++; // Игрок выиграл
            } else {
                negativeCount++; // Игрок проиграл
            }

            results.put(i, positiveCount);
        }

        // Вывод статистики
        System.out.println("Количество позитивных результатов: " + positiveCount);
        System.out.println("Количество негативных результатов: " + negativeCount);
        System.out.println("Процент от общего количества шагов цикла: " + (positiveCount * 100.0 / NUM_ITERATIONS) + "%");
    }
}
