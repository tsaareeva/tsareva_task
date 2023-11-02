public class Main {
    public static void main(String[] args) {
        String str = "sun 5555 sfff beer ";
        System.out.println(countMin(str));
    }

    public static String countMin(String string) {


        String[] words = string.split(" ");
        String ans="";
        int count = 0, n = 0, min = 100000;
        for (String word : words) {

            for (int i = 0; i < word.length(); i++) {
                for (int j = i; j < word.length(); j++) {
                    if (word.charAt(i) != word.charAt(j)) {
                        n++;
                    }
                }
            }
            if (n < min) {
                min = n;
                ans = word;
            }
            n=0;

        }
        return ans;
    }
}