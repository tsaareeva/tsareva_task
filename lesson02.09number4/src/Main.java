
public class Main {
    public static void main(String[] args) {
        String str = "London морковь 8 fire солнце 2 4 wave 6 красивый education";
        int count = countWords(str);
        System.out.println("Количество слов, содержащих только символы латинского алфавита: " + count);
    }

    public static int countWords(String string){
        String[] words = string.split(" ");
        int count = 0;
        for (String word : words) {
            if (word.matches("[a-zA-Z]+")) {
                count++;
            }
        }
        return count;
    }
}