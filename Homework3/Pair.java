public class Pair<T1, T2> {

    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public void setFirst(T1 first) {
        this.first = first;
    }

    public T2 getSecond() {
        return second;
    }

    public void setSecond(T2 second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first.toString() + ", " + second.toString() + ")";
    }

    // Внутренний класс-итератор
    public class PairIterator {

        private boolean firstVisited;
        private boolean secondVisited;

        public PairIterator() {
            firstVisited = false;
            secondVisited = false;
        }

        public boolean hasNext() {
            return !firstVisited || !secondVisited;
        }

        public Object next() {
            if (!firstVisited) {
                firstVisited = true;
                return first;
            } else if (!secondVisited) {
                secondVisited = true;
                return second;
            } else {
                return null;
            }
        }
    }

    // Метод, возвращающий итератор
    public PairIterator iterator() {
        return new PairIterator();
    }
}
