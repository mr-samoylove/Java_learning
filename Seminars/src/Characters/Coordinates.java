package Characters;

public class Coordinates {
    public int x;
    public int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static double getDistance(Coordinates a, Coordinates b){
        return Math.hypot(Math.abs(b.x - a.x), Math.abs(b.y - a.y));
    }

    public boolean isEqual(Coordinates coord) {
        return coord.y == y && coord.x == x;
    }
}
