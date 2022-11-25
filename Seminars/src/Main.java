import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // создаем 2 команды по 10 персонажей
        Random r = new Random();
        ArrayList<BaseNpc> team1 = new ArrayList<>();
        ArrayList<BaseNpc> team2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            switch (r.nextInt(1, 5)) {
                case 1 -> team1.add(new Peasant());
                case 2 -> team1.add(new Bandit());
                case 3 -> team1.add(new Sniper());
                case 4 -> team1.add(new Wizard(team1));
            }
        }
        for (int i = 0; i < 10; i++) {
            switch (r.nextInt(1, 5)) {
                case 1 -> team2.add(new Peasant());
                case 2 -> team2.add(new Spearman());
                case 3 -> team2.add(new Archer());
                case 4 -> team2.add(new Priest(team2));
            }
        }
        team1.forEach(System.out::println);
        team2.forEach(System.out::println);

        //test
        System.out.println("\n----HEALING TEST 1----");
        team1.add(new Bandit());
        team1.get(10).setHealth(2);
        System.out.println(team1.get(10));
        System.out.println("Wounded bandit health before healing: " + team1.get(10).getHealth());
        System.out.println("Wounded bandit MaxHealth before healing: " + team1.get(10).getMaxHealth());
        team1.add(new Wizard(team1));
        team1.get(11).step();
        System.out.println("Wounded bandit health after healing: " + team1.get(10).getHealth());
        System.out.println("Wounded bandit MaxHealth after healing: " + team1.get(10).getMaxHealth());

        System.out.println("----HEALING TEST 2----");
        team2.add(new Spearman());
        team2.get(10).setHealth(9);
        System.out.println(team2.get(10));
        System.out.println("Wounded Spearman health before healing: " + team2.get(10).getHealth());
        System.out.println("Wounded Spearman MaxHealth before healing: " + team2.get(10).getMaxHealth());
        team2.add(new Priest(team2));
        team2.get(11).step();
        System.out.println("Wounded Spearman health after healing: " + team2.get(10).getHealth());
        System.out.println("Wounded Spearman MaxHealth after healing: " + team2.get(10).getMaxHealth());

    }
}
