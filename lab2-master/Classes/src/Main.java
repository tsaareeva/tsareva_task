public class Main {
    public static void main(String[] args) {
        Phone p1 = new Phone("89279744793","Huawei",0.25);
        Phone p2 = new Phone("89171856790","SAMSUNG",  0.3);
        Phone p3 = new Phone("89375586767","iPhone",0.45);

        System.out.println("Телефон 1: \n Номер: " + p1.getNumber() + "\n Модель: " + p1.getModel() + "\n Вес: " + p1.getWeight() + "\n");
        System.out.println("Телефон 2: \n Номер: " + p2.getNumber() + "\n Модель: " + p2.getModel() + "\n Вес: " + p2.getWeight() + "\n");
        System.out.println("Телефон 3: \n Номер: " + p3.getNumber() + "\n Модель: " + p3.getModel() + "\n Вес: " + p3.getWeight() + "\n");

        p2.receiveCall("Rostelecom");
        System.out.println();
        p1.receiveCall("Moshenniki", p1.getNumber());
        System.out.println();
        p3.sendMessage("89739388133", "891342133", "8949340129 \n");


        Reader reader1 = new Reader("Владимир Ильич Ленин", "111-222", "Факультет факультетов", "22.04.70", "89279744793");
        Reader reader2 = new Reader("Иосиф Виссарионович Сталин", "231-699", "Факультет математики и информационных технологий", "18.12.78", "89894455665");

        Book book1 = new Book("Капитанская дочка", "Пушкин");
        Book book2 = new Book("Существующая", "Книга");
        Book book3 = new Book("Черный квадрат", "Малевич");
        Book book4 = new Book("Сборник задач и упражнений по математическому анализу", "Демидович");
        Book book5 = new Book("Ляляля", "Бубубу");

        reader1.takeBook(5);
        reader1.takeBook("Ляляля", "Капитанская дочка", "Существующая");
        reader1.takeBook(book1, book2, book3);

        System.out.println();

        reader2.returnBook(3);
        reader2.returnBook("Книга1", "Книга2");
        reader2.returnBook(book4, book5);
    }
}