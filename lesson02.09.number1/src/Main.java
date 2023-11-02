
public class Main {
    public static void main(String[] args) {
        for (int i=0; i<=300; i++){
            if (i%4==0 && i%6==0 && Sum(i)<10){
                System.out.println(i);
            }
        }

    }
    public static int Sum(int num){
        int sum=0;
        while (num!=0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }

}