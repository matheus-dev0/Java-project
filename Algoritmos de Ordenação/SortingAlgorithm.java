public abstract class SortingAlgorithm {
    
    protected int comparisons;
    protected int movements;

    public SortingAlgorithm() {

        this.comparisons = 0;
        this.movements = 0;
    }

    protected abstract void sort(int[] array);


    public int getComparisons() {
        return comparisons;
    }

    public int getMovements() {
        return movements;
    }

    public void showInfo() {
        System.out.println("Comparisons: "+ getComparisons());
        System.out.println("Movements: "+ getMovements());
    }
}
