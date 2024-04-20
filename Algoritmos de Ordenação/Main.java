import java.util.Random;
import java.util.Arrays;

public class Main {

    public int[] RandomArrayGenerator(int arrayLength, int maximumRange) {
        int[] unsortedArray = new int[arrayLength];
        Random r = new Random();

        for (int i = 0; i < arrayLength; i++) {
            int valuation;
            boolean isDuplicated;

            do {
                valuation = r.nextInt(maximumRange);
                isDuplicated = false;

                for (int j = 1; j < arrayLength; j++) {
                    if (valuation == unsortedArray[j]) {
                        isDuplicated = true;
                        break;
                    }
                }
            }

            while (isDuplicated);

            unsortedArray[i] = valuation;
        }

        return unsortedArray;
    }

    public String printArray(int[] array) {

       return Arrays.toString(array);

    }
    
    public static void main(String[] args) {
        Main main = new Main();
        SortingAlgorithm bubbleSort = new BubbleSort();
        SortingAlgorithm insertionSort = new InsertionSort();

        int[] vetor = main.RandomArrayGenerator(100, 8000);

        System.out.println("Original array: " + main.printArray(vetor));
        

        // Cloning the array to maintain it originally unsorted for further sorting operations during execution time
        
        //Bubble Sort performance
        System.out.println("\nBubble Sort:");
        bubbleSort.sort(vetor.clone());
        bubbleSort.showInfo(); 
        
        
        //Insertion Sort performance
        System.out.println("\nInsertion Sort:");

        //You can tell that the last sorting algorithm on the queue sorts the original array.
        insertionSort.sort(vetor);
        insertionSort.showInfo();

        System.out.println("\nSorted array: "+main.printArray(vetor));

    }


}

