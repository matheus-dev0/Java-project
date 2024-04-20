public class InsertionSort extends SortingAlgorithm {

    @Override
    public void sort(int[] arr) {
        comparisons = 0;
        movements = 0;

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            comparisons++;

            while ((j > 0) && (arr[j - 1] > temp)) {

                // Movimenta o elemento para a direita
                arr[j] = arr[j - 1];
                j -= 1;

                // Contabiliza uma movimentação
                movements++;

            }

            arr[j] = temp;
        }

    }

}
