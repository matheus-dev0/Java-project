import java.util.Scanner;
public class Quest4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digit the amount of grades:");
        int n = input.nextInt(); // amount of terms of the weighted average


        float[] grades = new float[n];
        float[] weights = new float[n];
        float weight = 0;

        float weightedAverage = 0;

        for(int i = 0; i < n; i++) {
            System.out.printf("Digit the %d° grade:\n", i+1);
            grades[i] = input.nextFloat();
            System.out.println("Digit the weight:");
            weights[i] = input.nextFloat();

        }
   
        for(int i = 0; i < n; i++) {
            
            weightedAverage += grades[i] * weights[i];
            weight += weights[i];
        }

        weightedAverage /= weight;
        System.out.printf("The weighted average of the given grades are %.2f. ", weightedAverage);
        input.close();
    }
}
