import Characters.*;
import Map.AnsiColors;
import Map.MapFormer;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int GANG_SIZE = 10;

    public static void main(String[] args) {

        // создаем 2 команды по 10 персонажей, рандомно заполняем команды
        Random r = new Random();
        Scanner scanner = new Scanner(System.in);
        Team teamBlue = new Team(AnsiColors.ANSI_BLUE);
        Team teamGreen = new Team(AnsiColors.ANSI_GREEN);

        for (int i = 0; i < 10; i++) {
            switch (r.nextInt(1, 5)) {
                case 1 -> new Peasant(i, 0, teamBlue);
                case 2 -> new Bandit(i, 0, teamBlue);
                case 3 -> new Sniper(i, 0, teamBlue);
                case 4 -> new Wizard(i, 0, teamBlue);
            }
        }
        for (int i = 0; i < 10; i++) {
            switch (r.nextInt(1, 5)) {
                case 1 -> new Peasant(i, 9, teamGreen);
                case 2 -> new Lancer(i, 9, teamGreen);
                case 3 -> new Crossbowman(i, 9, teamGreen);
                case 4 -> new Priest(i, 9, teamGreen);
            }
        }

        MapFormer map = new MapFormer(10);
        map.placeTeamOnTheMap(teamBlue);
        map.placeTeamOnTheMap(teamGreen);
        while (true) {
            map.view();

            System.out.println("Press ENTER to continue");
            System.out.println("Press Q and ENTER to quit");
            String temp = scanner.nextLine();
            if (temp.equals("Q") || temp.equals("q")){
                System.exit(0);
            };
        }
    }
}
