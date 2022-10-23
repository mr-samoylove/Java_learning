public class Sem02_HanoiTower {
    // Метод печатает в консоль алгоритм решения Ханойской башни при заданном колличестве дисков
    // Доп аргументы задают имена трех осей (3 символа)
    static void getAlgorithm(int n, char first, char second, char third) {
        if (n == 1) {
            System.out.println("Переместите диск 1 из " + first + " в " + second);
            return;
        }
        getAlgorithm(n - 1, first, third, second);
        System.out.println("Переместите диск " + n + " из " + first + " в " + second);
        getAlgorithm(n - 1, third, second, first);
    }
}
