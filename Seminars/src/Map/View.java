package Map;

import Characters.AbstractTypes.BaseNpc;

import java.util.ArrayDeque;

public class View {
    public static int step = 0;
    public void draw() {
        System.out.println(AnsiColors.ANSI_RED + "Step: " + step++ + AnsiColors.ANSI_RESET);
        System.out.println(Constants.top10);

        // region ---отрисовка---
        ArrayDeque<BaseNpc> playersFoundInTheRow = new ArrayDeque<>();
        for (int i = 0; i < Constants.GANG_SIZE; i++) {
            for (int j = 0; j < Constants.GANG_SIZE; j++) {
                BaseNpc player = MapMatrix.mapMatrix[i][j];
                if (player == null) System.out.print("|   ");
                else {
                    playersFoundInTheRow.add(player);
                    System.out.print("| " + player.getTeamColor() + player.getTypeSymbol() + " " + AnsiColors.ANSI_RESET);
                }
            }
            System.out.print("|  ");
            while (!playersFoundInTheRow.isEmpty()) {
                BaseNpc player = playersFoundInTheRow.pop();
                String playerName = player.getClass().getSimpleName();
                System.out.print(player.getTeamColor() + String.format("%-9s", playerName));
                System.out.print("id=" + String.format("%-3d", player.getNpcID()));
                System.out.print("hp=" + String.format("%4.1f/%-4.1f    ", player.getHealth(), player.getMaxHealth()) + AnsiColors.ANSI_RESET);
            }
            System.out.println();

            if (i != Constants.GANG_SIZE - 1)
                System.out.println(Constants.mid10);
            else System.out.println(Constants.bottom10);
        }
        // endregion
    }
}
