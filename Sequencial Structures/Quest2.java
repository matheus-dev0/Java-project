import java.util.Scanner;
public class Quest2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Write the preferred number:");
        int number = input.nextInt();
        int successor = number + 1;
        int predecessor = number - 1;
        
        System.out.printf("The sucessor and the predecessor of %d, respectively, is %d and %d.", number, successor, predecessor);
        
        input.close();

    }
}
