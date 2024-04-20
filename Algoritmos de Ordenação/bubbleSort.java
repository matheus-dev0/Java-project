
public class BubbleSort extends SortingAlgorithm {


  @Override
  public void sort(int[] unsortedArray) {

    int length = unsortedArray.length;
    int temporary = 0;

    // Start of the algothm
    for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {
        comparisons++;
        if (unsortedArray[i] > unsortedArray[j]) {
          movements++;

          // Switching positions
          temporary = unsortedArray[i];
          unsortedArray[i] = unsortedArray[j];
          unsortedArray[j] = temporary;
        }
      }

    }
    
  }

}
