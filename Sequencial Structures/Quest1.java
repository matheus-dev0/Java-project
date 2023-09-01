import java.util.Scanner;

public class Quest1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("How many numbers will be calculated?");
        int n = input.nextInt();
        float sum = 0;
        

        for(int i = 0; i < n; i++) {
            System.out.printf("Digit the %d° number:\n", i+1);
          int numbers = input.nextInt();
            sum+= numbers;
        }

        sum /= n;
        
        System.out.printf("The common average of these numbers is %.2f.", sum);
        input.close();
    }
}