import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Seminar02_Exceptions {

    public float askForFloatAndPrintThatFloat() {
        Scanner sc = new Scanner(System.in);
        Float fl = null;
        System.out.println("Введите вещественное число");
        while (fl == null) {
            try {
                fl = Float.parseFloat(sc.next());
            } catch (Exception e) {
                System.out.println("Ошибка, попробуйте еще раз");
            }
        }
        return fl;
    }

    public void task2(int[] intArray){
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException | IndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }
    }

    public void task3() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }
    private void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }

}
