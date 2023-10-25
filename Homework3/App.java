public class App {

    public static void main(String[] args) {

        // Первое задание
        
        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {1, 2, 3};
        Integer[] array3 = {1, 2, 4};

        System.out.println(ArrayComparator.compareArrays(array1, array2)); // true
        System.out.println(ArrayComparator.compareArrays(array1, array3)); // false

        String[] strArray1 = {"Hello", "World"};
        String[] strArray2 = {"Hello", "World"};
        String[] strArray3 = {"Hello", "Java"};

        System.out.println(ArrayComparator.compareArrays(strArray1, strArray2)); // true
        System.out.println(ArrayComparator.compareArrays(strArray1, strArray3)); // false

        // Второе задание

        Pair<String, Integer> pair1 = new Pair<>("Hello", 123);
        Pair<Double, Boolean> pair2 = new Pair<>(3.14, true);

        System.out.println(pair1.getFirst()); // Hello
        System.out.println(pair1.getSecond()); // 123

        System.out.println(pair2.getFirst()); // 3.14
        System.out.println(pair2.getSecond()); // true

        System.out.println(pair1); // (Hello, 123)
        System.out.println(pair2); // (3.14, true)

    }
}
