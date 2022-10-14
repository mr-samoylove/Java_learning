import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // task 1
        System.out.print("Задание 1\nВведите число, которое нужно сделать треугольным: ");
        Scanner inp = new Scanner(System.in);
        int n = getTriangularNumber(inp.nextInt());
        System.out.println(n);

        // task 2
        System.out.println();
        int[] arr = {1, 12, 9, 5, 6, 10};
        System.out.println("Задание 2\nВот исходный массив:");
        for (int m : arr) System.out.print(m + " ");

        HeapSort.sort(arr);
        System.out.println("\nВот массив после сортировки HeapSort:");
        for (int m : arr) System.out.print(m + " ");
    }

    /**
     * @param n integer to convert to a triangular number
     * @return triangular number
     */
    public static int getTriangularNumber(int n) {
        return n * (n + 1) / 2;
    }
}