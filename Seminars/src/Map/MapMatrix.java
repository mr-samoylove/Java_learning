package Map;

import Characters.AbstractTypes.BaseNpc;
import Characters.AbstractTypes.Team;

public class MapMatrix {
    static BaseNpc[][] mapMatrix = new BaseNpc[Constants.MAP_SIZE][Constants.MAP_SIZE];

    public void placeTeamOnTheMap(Team team) {
        for (BaseNpc player : team) {
            mapMatrix[player.getCoordinates().x][player.getCoordinates().y] = player;
        }
    }

    public static boolean isFree(int x, int y){
        return mapMatrix[x][y] == null || mapMatrix[x][y].getTypeSymbol() == '_' || mapMatrix[x][y].getStatus().equals("dead");
    }

    public static void movePlayer(BaseNpc player, String direction){
        int x = player.getCoordinates().x;
        int y = player.getCoordinates().y;
        mapMatrix[x][y] = null;
        switch (direction){
            case "right" -> player.setCoordinates(x, ++y);
            case "left"  -> player.setCoordinates(x, --y);
            case "down"    -> player.setCoordinates(++x, y);
            case "up"      -> player.setCoordinates(--x, y);
        }
        mapMatrix[x][y] = player;
    }

    public void removeTheDead() {
        for (BaseNpc[] line : mapMatrix) {
            for (BaseNpc player : line)
                if (player != null && player.getStatus().equals("dead"))
                    mapMatrix[player.getCoordinates().x][player.getCoordinates().y] = null;
        }
    }
}
