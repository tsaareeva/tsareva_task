public class Main {
    public static void main(String[] args) {
        String str1 = "Java";
        String str2 = "Hello,world!";
        int len1 = str1.length();
        int len2 = str2.length();

        if ((len1 % 2 != 0) || (len2 % 2 != 0)) {
            System.out.println("Нечетное кол-во знаков");

        }
        else{
            int i1 = len1 / 2;
            int i2 = len2 / 2;
            System.out.println(str1.substring(i1-1,i1+1));
            System.out.println(str2.substring(i2-1,i2+1));
        }
    }
}