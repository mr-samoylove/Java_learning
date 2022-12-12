import Characters.*;
import Characters.AbstractTypes.BaseNpc;
import Characters.AbstractTypes.Team;
import Map.*;

import java.util.Random;
import java.util.Scanner;

public class Controller {
    public void start() {
        // создаем 2 команды по 10 персонажей, рандомно заполняем команды
        Team teamBlue = new Team(AnsiColors.ANSI_BLUE);
        Team teamGreen = new Team(AnsiColors.ANSI_GREEN);
        fillTeams(teamBlue, teamGreen);

        // создаем матрицу карты (из указателей на BaseNpc) и ставим туда персонажей
        MapMatrix map = new MapMatrix();
        ViewConsole viewConsole = new ViewConsole();
        map.placeTeamOnTheMap(teamBlue);
        map.placeTeamOnTheMap(teamGreen);

        viewConsole.draw();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Press ENTER to continue");
            System.out.println("Press Q and ENTER to quit");
            String temp = scanner.nextLine();
            if (temp.equals("Q") || temp.equals("q"))
                System.exit(0);

            makeStep(teamBlue, teamGreen);
            viewConsole.draw();

            while (!LoggerQueue.logQueue.isEmpty())
                System.out.println(LoggerQueue.logQueue.poll());
            //map.removeTheDead();
        }
    }

    public static void makeStep(Team team1, Team team2) {
        for (BaseNpc player : Team.createTurnsOrder(team1, team2)) {
            if (!player.getStatus().equals("dead"))
                player.step();
        }
    }

    public static void fillTeams(Team team1, Team team2) {
        int gangSize = Constants.GANG_SIZE;
        Random r = new Random();
        for (int i = 0; i < gangSize - 1; i++) {
            switch (r.nextInt(1, 4)) {
                case 1 -> new Peasant(100, i, 0, team1, team2);
                case 2 -> new Bandit(20, i, 0, team1, team2);
                case 3 -> new Sniper(20, i, 0, team1, team2);
            }
        }
        new Wizard(1, 9, 0, team1, team2);
        for (int i = 0; i < gangSize - 1; i++) {
            switch (r.nextInt(1, 4)) {
                case 1 -> new Peasant(100, i, 9, team2, team1);
                case 2 -> new Lancer(20, i, 9, team2, team1);
                case 3 -> new Xbowman(20, i, 9, team2, team1);
            }
        }
        new Monk(1, 9, 9, team2, team1);
    }
}
