public class Main {
    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5, 155, 2523, 523, 16, 865, 4637, 345 };

        System.out.println("До сортировки: ");
        for (int j : arr) System.out.print(j + " ");
        System.out.println();

        Sem04_QuickSort.quickSort(arr, 0, arr.length - 1);

        System.out.println("После сортировки: ");
        for (int j : arr) System.out.print(j + " ");
    }
}