import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Seminar01_Exceptions sem01 = new Seminar01_Exceptions();
        try {
            sem01.a();
        } catch (Exception e) {
            System.out.println("1. Ошибка!  --  " + e.getMessage());
        }

        try {
            sem01.b();
        } catch (Exception e) {
            System.out.println("2. Ошибка!  --  " + e.getMessage());
        }

        try {
            sem01.c(null);
        } catch (Exception e) {
            System.out.println("3. Ошибка!  --  " + e.getMessage());
        }

        try {
            int[] arr1 = {10, 10, 10};
            int[] arr2 = {1, 2, 3};
            int[] arrCorrectRes = sem01.arraysDiff(arr1, arr2);
            System.out.println("4. Корректный результат функции arraysDiff: " + Arrays.toString(arrCorrectRes));
            int[] arr3 = {1, 2, 3, 4, 5};
            int[] arrIncorrectRes = sem01.arraysDiff(arr1, arr3);
        } catch (Exception e) {
            System.out.println("5. Ошибка!  --  " + e.getMessage());
        }

        try {
            int[] arr1 = {10, 10, 10};
            int[] arr2 = {2, 5, 10};
            int[] arrCorrectRes = sem01.arraysDivision(arr1, arr2);
            System.out.println("6. Корректный результат функции arraysDivision: " + Arrays.toString(arrCorrectRes));
            int[] arr3 = {2, 0, 5};
            int[] arrIncorrectRes = sem01.arraysDivision(arr1, arr3);
        } catch (Exception e) {
            System.out.println("7. Ошибка!  --  " + e.getMessage());
        }
    }
}
