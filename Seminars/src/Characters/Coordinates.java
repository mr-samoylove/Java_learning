package Characters;

public class Coordinates {
    public int x;
    public int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEqual(Coordinates coord) {
        return coord.y == y && coord.x == x;
    }
}
