package Algoritmos;
/* Este algoritmo é uma variante do Quick Sort original, que naturalmente é implementado com a variante de Horae
*  A variação de Lomuto é uma versão mais simples e versátil de entender, porém menos eficiente
*/

import java.util.Random;
import java.util.Arrays;

public class quickSortLomuto {

    public static void sort(int[] unsortedArray, int minimum, int maximum) {

        int pivot = unsortedArray[maximum - 1];
        int position = minimum;

        for (int j = minimum; j < maximum; j++) {
            if (unsortedArray[j] <= pivot) {

                
                swap(unsortedArray, position, j);

                System.out.println("Pivot: " + pivot);
                System.out.println("Position: " + unsortedArray[position]);
                System.out.println(position + ": " + Arrays.toString(unsortedArray));
                position += 1;
            }
        }

        // sort(unsortedArray, minimum, position - 1);
        // sort(unsortedArray, position + 1, maximum);

    }

    private static void swap(int[] array, int position1, int position2) {
        int temp = array[position1];
        array[position1] = array[position2];
        array[position2] = temp;
    }

    public static int[] randomGenerator(int arrayLength, int maximumValue) {

        int[] unsortedArray = new int[arrayLength];
        Random r = new Random();

        for (int i = 0; i < arrayLength; i++) {
            int valuation;
            boolean isDuplicated;

            do {
                valuation = r.nextInt(maximumValue);
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

    public static void main(String[] args) {

        // int[] vetor = { 7, 12, 10, 8, 5, 19, 3, 15 };

        int[] vetor = randomGenerator(10, 200);

        System.out.println("B: " + Arrays.toString(vetor));

        sort(vetor, 0, vetor.length);

        System.out.println("A: " + Arrays.toString(vetor));
        System.out.println();

    }
}
