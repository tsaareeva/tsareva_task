public class Reader {
    private final String fullName;
    private final String libraryCard;
    private final String faculty;
    private final String birth;
    private final String phoneNumber;

    public Reader(String fullName, String libraryCard, String faculty, String birth, String phoneNumber) {
        this.fullName = fullName;
        this.libraryCard = libraryCard;
        this.faculty = faculty;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
    }

    public void takeBook(int countBooks) {
        System.out.println(fullName + " взял " + countBooks + " книги.");
    }

    public void takeBook(String... bookNames) {
        System.out.print(fullName + " взял книги: ");
        for (String bookName : bookNames) {
            System.out.print(bookName + ", ");
        }
        System.out.println();
    }

    public void takeBook(Book... books) {
        System.out.print(fullName + " взял книги: ");
        for (Book book : books) {
            System.out.print(book.getTitle() + " (автор: " + book.getAuthor() + "), ");
        }
        System.out.println();
    }

    public void returnBook(int countBooks) {
        System.out.println(fullName + " вернул " + countBooks + " книги.");
    }

    public void returnBook(String... bookNames) {
        System.out.print(fullName + " вернул книги: ");
        for (String bookName : bookNames) {
            System.out.print(bookName + ", ");
        }
        System.out.println();
    }

    public void returnBook(Book... books) {
        System.out.print(fullName + " вернул книги: ");
        for (Book book : books) {
            System.out.print(book.getTitle() + " (автор: " + book.getAuthor() + "), ");
        }
        System.out.println();
    }
}