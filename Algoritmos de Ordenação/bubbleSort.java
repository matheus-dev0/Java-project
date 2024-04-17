import java.util.Arrays;
import java.util.Random;

public class bubbleSort {

  public static void sort(int[] unsortedArray) {

    int length = unsortedArray.length;
    // Tracking the amount of iterations for Big(O) porpuses
    int iterations = 0;

    // This variable is responsible for storing the smaller number to be switched
    int temporary = 0;
    // Start of the algothm

    for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {

        if (unsortedArray[i] > unsortedArray[j]) {
          iterations++;

          // Switching positions
          temporary = unsortedArray[i];
          unsortedArray[i] = unsortedArray[j];
          unsortedArray[j] = temporary;
        }
      }

    }
    System.out.println("Iterations: " + iterations);

  }

  public static void main(String[] args) {

    // This is a random array generator, you only need to change the length and
    // maximum number in array.

    int arrayLength = 25; // Change Here as desired
    int maximumValue = 290; // Change Here as desired

    int[] unsortedArray = new int[arrayLength];

    Random r = new Random();
    for (int i = 0; i < arrayLength; i++) {
      unsortedArray[i] = r.nextInt(maximumValue);

    }

    System.out.println("Unsorted Array: " + Arrays.toString(unsortedArray));
    sort(unsortedArray);

    System.out.println("Sorted Array: " + Arrays.toString(unsortedArray));
  }

}
