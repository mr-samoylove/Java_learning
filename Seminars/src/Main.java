import Characters.*;
import Map.AnsiColors;
import Map.MapCreator;

import java.util.ArrayList;
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

        map.draw();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Press ENTER to continue");
            System.out.println("Press Q and ENTER to quit");
            String temp = scanner.nextLine();
            if (temp.equals("Q") || temp.equals("q"))
                System.exit(0);

            makeStep(teamBlue, teamGreen);
            map.draw();
            //map.removeTheDead();
        }
    }

    public static void makeStep(Team team1, Team team2) {
        for (BaseNpc player : Team.createTurnsOrder(team1, team2)) {
            player.step();
        }
    }

    public static void fillTeams(Team team1, Team team2, int gangSize) {
        Random r = new Random();
        for (int i = 0; i < gangSize; i++) {
            switch (r.nextInt(1, 5)) {
                case 1 -> new Peasant(i, 0, team1, team2);
                case 2 -> new Bandit(i, 0, team1, team2);
                case 3 -> new Sniper(i, 0, team1, team2);
                case 4 -> new Wizard(i, 0, team1, team2);
            }
        }
        for (int i = 0; i < gangSize; i++) {
            switch (r.nextInt(1, 5)) {
                case 1 -> new Peasant(i, 9, team2, team1);
                case 2 -> new Lancer(i, 9, team2, team1);
                case 3 -> new Xbowman(i, 9, team2, team1);
                case 4 -> new Monk(i, 9, team2, team1);
            }
        }
    }
}
