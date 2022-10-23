public class Main {
    public static void main(String[] args) {

        /* ЗАДАНИЕ 1 */

        // Количество дисков
        int n = 4;
        // в функцию передается кол-во дисков и названия колонн
        // Функция печатает в консоль алгоритм решения Ханойской башни при заданном колличестве дисков
        Sem02_HanoiTower.getAlgorithm(n, 'A', 'C', 'B');

        /* ЗАДАНИЕ 2 */
        System.out.print("\n\nИсходный массив: ");
        int[] arr = { 12, 11, 13, 5, 6 };
        for (int j : arr) System.out.print(j + " ");
        Sem02_InsersionSort.insersionSort(arr);
        System.out.print("\nОтсортированный массив: ");
        for (int j : arr) System.out.print(j + " ");
    }
}