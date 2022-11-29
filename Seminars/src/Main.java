import Characters.*;
import Map.AnsiColors;
import Map.MapCreator;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int GANG_SIZE = 10;

    public static void main(String[] args) {
        // создаем 2 команды по 10 персонажей, рандомно заполняем команды
        Team teamBlue = new Team(AnsiColors.ANSI_BLUE);
        Team teamGreen = new Team(AnsiColors.ANSI_GREEN);
        fillTeams(teamBlue, teamGreen, Map.Constants.GANG_SIZE);

        // создаем матрицу карты (из указателей на BaseNpc) и ставим туда персонажей
        MapCreator map = new MapCreator();
        map.placeTeamOnTheMap(teamBlue);
        map.placeTeamOnTheMap(teamGreen);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            map.draw();
            System.out.println("Press ENTER to continue");
            System.out.println("Press Q and ENTER to quit");
            String temp = scanner.nextLine();
            if (temp.equals("Q") || temp.equals("q")){
                System.exit(0);
            };
        }
    }

    public static void fillTeams(Team team1, Team team2, int gangSize) {
        Random r = new Random();
        for (int i = 0; i < gangSize; i++) {
            switch (r.nextInt(1, 5)) {
                case 1 -> new Peasant(i, 0, team1);
                case 2 -> new Bandit(i, 0, team1);
                case 3 -> new Sniper(i, 0, team1);
                case 4 -> new Wizard(i, 0, team1);
            }
        }
        for (int i = 0; i < gangSize; i++) {
            switch (r.nextInt(1, 5)) {
                case 1 -> new Peasant(i, 9, team2);
                case 2 -> new Lancer(i, 9, team2);
                case 3 -> new Xbowman(i, 9, team2);
                case 4 -> new Priest(i, 9, team2);
            }
        }
    }
}
