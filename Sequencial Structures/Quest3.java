import java.util.Scanner;
public class Quest3 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("This program will receive 3 numbers, multiplicate the first two, then divide by the three.");
        System.out.println("Digit the first number:");
        int first = input.nextInt();
        System.out.println("Digit the second number:");
        int second = input.nextInt();
        System.out.println("Digit the third number:");
        int third = input.nextInt();

        float calculum = (first * second) / third;

        System.out.printf("The result of the calculum is %.2f.", calculum);
        input.close();
        }
}
