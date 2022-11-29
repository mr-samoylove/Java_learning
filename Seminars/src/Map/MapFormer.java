package Map;

import Characters.BaseNpc;
import Characters.Team;

import java.util.Collections;

public class MapFormer {
    public static int step = 0;
    private final int GANG_SIZE;
    BaseNpc[][] mapMatrix = new BaseNpc[10][10];

    public MapFormer(int GANG_SIZE){
        this.GANG_SIZE = GANG_SIZE;
    }

    public void placeTeamOnTheMap(Team team) {
        for (BaseNpc player : team) {
            mapMatrix[player.getCoordinates().x][player.getCoordinates().y] = player;
        }
    }

    public void view() {
        System.out.println(AnsiColors.ANSI_RED + "Step: " + step++ + AnsiColors.ANSI_RESET);
        System.out.println(MapFormer.top10);

        // отрисовка всех линий
        for (int i = 0; i < GANG_SIZE; i++) {
            for (int j = 0; j < GANG_SIZE; j++) {
                BaseNpc player = mapMatrix[i][j];
                if (player == null) System.out.print("|   ");
                else System.out.print("| " + player.getTeamColor() + player.getTypeSymbol() + " " + AnsiColors.ANSI_RESET);
            }
            System.out.println('|');

            if (i != GANG_SIZE - 1)
                System.out.println(MapFormer.mid10);
            else System.out.println(MapFormer.bottom10);
        }
    }

    // region ---Border formatters---
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("---b"))) + formatDiv("---c");
    private static final String mid10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("---e"))) + formatDiv("---f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("---h"))) + formatDiv("---i");
    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }
    // endregion
}
