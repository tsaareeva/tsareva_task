public class MinMax<T extends Comparable<T>>{
    private final T[] array;

    public MinMax(T[] array) {
        this.array = array;
    }
    public T findMin(){
        if (array == null || array.length == 0){
            return null;
        }
        T min = array[0];
        for (T t : array) {
            if (t.compareTo(min) < 0) {
                min = t;
            }
        }
        return min;
    }
    public T findMax(){
        if (array == null || array.length == 0){
            return null;
        }
        T max = array[0];
        for (T t : array) {
            if (t.compareTo(max) > 0) {
                max = t;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[] intArray = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        MinMax<Integer> intMinMax = new MinMax<>(intArray);
        System.out.println("Min: " + intMinMax.findMin());
        System.out.println("Max: " + intMinMax.findMax());

        String[] strArray = {"apple", "banana", "cherry", "date"};
        MinMax<String> strMinMax = new MinMax<>(strArray);
        System.out.println("Min: " + strMinMax.findMin());
        System.out.println("Max: " + strMinMax.findMax());
    }
}
