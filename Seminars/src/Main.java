public class Main {

    public static void main(String[] args) {
        int[][] mat =
                {
                        {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                        {0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
                        {0, 0, 1, 0, 1, 1, 1, 0, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
                        {0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
                        {0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
                        {0, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                        {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                        {0, 0, 1, 0, 0, 1, 1, 0, 0, 1},
                };

        int min_dist = Sem03_WaveAlgorithm.findShortestPath(mat, 0, 0, 7, 2);

        if (min_dist != -1) {
            System.out.println("The shortest path from source to destination " +
                    "has length " + min_dist);
        } else {
            System.out.println("Destination cannot be reached from source");
        }
    }
}