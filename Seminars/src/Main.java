public class Main {
    public static void main(String[] args) {
        Seminar02_Exceptions sem2 = new Seminar02_Exceptions();

        System.out.println("Задание 1:");
        float fl = sem2.askForFloatAndPrintThatFloat();
        System.out.println("Ваше число: " + fl);

        System.out.println("\nЗадание 2:");
        int[] arr1 = {1, 2, 3};
        sem2.task2(arr1);
        int[] arr2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        sem2.task2(arr2);

        System.out.println("\nЗадание 3:");
        sem2.task3();

        System.out.println("\nЗадание 4:");
        sem2.cantSendEmptyLines();
    }
}
