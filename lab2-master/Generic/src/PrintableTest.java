import Interfaces.Printable;

public class PrintableTest {
    public static void main(String[] args) {
        Printable p = new Printable() {
            @Override
            public void print() {
                System.out.println("Анонимный класс");
            }
        };
        p.print();
    }
}

