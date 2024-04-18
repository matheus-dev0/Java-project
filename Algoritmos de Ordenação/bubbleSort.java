import java.util.Arrays;
import java.util.Random;

public class bubbleSort {

  public static void sort(int[] unsortedArray) {

    int length = unsortedArray.length;
    // Tracking the amount of iterations for Big(O) porpuses
    int iterations = 0;
    // Tracking the amount of comparisons, also for Big(O) porpuses
    int comparisons = 0;

    // This variable is responsible for storing the smaller number to be switched
    int temporary = 0;
    // Start of the algothm

    for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {
        comparisons++;
        if (unsortedArray[i] > unsortedArray[j]) {
          iterations++;

          // Switching positions
          temporary = unsortedArray[i];
          unsortedArray[i] = unsortedArray[j];
          unsortedArray[j] = temporary;
        }
      }

    }
    System.out.println("Comparisons: "+ comparisons);
    System.out.println("Iterations: " + iterations);
    

  }
  //This is a way to create random array for big data testing porpuses
  //The arguments will define the array characteristics

  public static int[] randomGenerator(int arrayLength, int maximumValue) {

    int[] unsortedArray = new int[arrayLength];

    Random r = new Random();
    for (int i = 0; i < arrayLength; i++) {
      unsortedArray[i] = r.nextInt(maximumValue);
    
    }
  
    return unsortedArray;
  }

  public static void main(String[] args) {

    
    // Descomente para fazer do meio automático

    int[] unsortedArray = randomGenerator(10, 200);

    //Meio manual

    //int[] unsortedArray = {10,9,8,7,6,5,4,3,2,1,0};
    
    
    System.out.println("Unsorted Array: " + Arrays.toString(unsortedArray));
    sort(unsortedArray);

    System.out.println("Sorted Array: " + Arrays.toString(unsortedArray));
  }

}
