public cass bubbleSort{

  public static void sort(int[] unsortedArray) {

    
    int length = unsortedArray.length;
    //Tracking the amount of iterations for Big(O) porpuses
    int iterations = 0;

    //This variable is responsible for storing the smaller number to be switched
    int temporary = 0;
    // Start of the algothm

    for (int i = 0; i < length; i++) {
      for(int j = 1; j < length; j++) {
        iterations++;

        if(unsortedArray[i] < unsortedArray[j]) {
          
          unsortedArray[i] = temporary;
          unsortedArray[j] = unsortedArray[i];
          unsortedArray[j] = temporary;
        }
      }

      
          
        
      }
    System.out,println("Iterations: " + iterations);
    
    
    }
  public static void main(String[] args) {
    int[] unsortedArray = {5, 3, 9, 15, 4, 2, 1};
    sort(unsortedArray);

    System.out.println("Sorted Array: "+ Arrays.toString(unsortedArray));
  }



}
  