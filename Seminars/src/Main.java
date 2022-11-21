import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // создаем по одному представителю каждого из 7 классов и выводим их в консоль
        ArrayList<BaseNpc> oneOfEachCharacter = new ArrayList<>(Arrays.asList(
                new Archer(), new Peasant(), new Bandit(),
                new Sniper(), new Priest(), new Wizard(), new Spearman()));
        oneOfEachCharacter.forEach(System.out::println);

        // создаем 50 рандомных персонажей
        Random r = new Random();
        ArrayList<BaseNpc> fiftyRandomCharacters = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            switch (r.nextInt(1, 8)) {
                case 1 -> fiftyRandomCharacters.add(new Archer());
                case 2 -> fiftyRandomCharacters.add(new Peasant());
                case 3 -> fiftyRandomCharacters.add(new Bandit());
                case 4 -> fiftyRandomCharacters.add(new Sniper());
                case 5 -> fiftyRandomCharacters.add(new Priest());
                case 6 -> fiftyRandomCharacters.add(new Wizard());
                case 7 -> fiftyRandomCharacters.add(new Spearman());
            }
        }

        // выводим каждого лучника
        System.out.println();
        BaseNpc.printAllOfSpecificType(fiftyRandomCharacters, "Archer");
    }


}