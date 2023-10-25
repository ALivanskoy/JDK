public class ArrayComparator {
    public static <T> boolean compareArrays(T[] array1, T[] array2) {
        // Проверяем, что массивы не null и имеют одинаковую длину
        if (array1 == null || array2 == null || array1.length != array2.length) {
            return false;
        }

        // Сравниваем каждый элемент массивов
        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }

        return true;
    }
}
