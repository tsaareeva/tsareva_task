import java.io.Serializable;

public class MyGenericClass<T extends Comparable<String>,V extends Animal,K extends Number>{
    private final T t;
    private final V v;
    private final K k;
    public MyGenericClass(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }
    public T getT() {
        return t;
    }
    public V getV() {
        return v;
    }
    public K getK() {
        return k;
    }
    public void printClassNames() {
        System.out.println("Type of T: " + t.getClass().getName());
        System.out.println("Type of V: " + v.getClass().getName());
        System.out.println("Type of K: " + k.getClass().getName());
    }

    public static void main(String[] args) {
        MyGenericClass<String,Animal,Integer> test = new MyGenericClass<>("Биба", new Animal(), 22);
        test.printClassNames();
    }
}
