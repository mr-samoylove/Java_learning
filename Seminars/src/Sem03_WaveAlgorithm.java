import java.util.ArrayDeque;
import java.util.Queue;

public class Sem03_WaveAlgorithm {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    // A Queue Node
    static class Node {
        // (x, y) represents matrix cell coordinates, and
        // `dist` represents their minimum distance from the source
        int x, y, dist;

        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    // Below arrays detail all four possible movements from a cell
    private static final int[] row = {-1, 0, 0, 1};
    private static final int[] col = {0, -1, 1, 0};

    // Function to check if it is possible to go to position (row, col)
    // from the current position. The function returns false if (row, col)
    // is not a valid position or has a value 0 or already visited.
    private static boolean isValid(int[][] mat, int[][] visited, int row, int col) {
        return (row >= 0) && (row < mat.length) && (col >= 0) && (col < mat[0].length) && mat[row][col] == 1 && visited[row][col] == 0;
    }

    // Find the shortest possible route in a matrix `mat` from source
    // cell (i, j) to destination cell (x, y)
    public static int findShortestPath(int[][] mat, int i, int j, int x, int y) {
        // if input is invalid
        if (mat == null || mat.length == 0 || mat[i][j] == 0 || mat[x][y] == 0) {
            return -1;
        }

        int M = mat.length;
        int N = mat[0].length;
        int[][] visited = new int[M][N];
        Queue<Node> q = new ArrayDeque<>();

        // mark the source cell as visited and enqueue the source node
        visited[i][j] = -1;
        q.add(new Node(i, j, 1));

        int min_dist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node node = q.poll();

            // i, j represent a current cell, and `dist` stores its
            // minimum distance from the source
            i = node.x;
            j = node.y;
            int dist = node.dist;

            // if the destination is found, draw way out and stop
            if (i == x && j == y) {
                min_dist = dist;
                String wayOut = formWayOut(visited, x, y, min_dist);
                printWayOut(wayOut, mat, M, N);
                break;
            }

            // check for all four possible movements from the current cell
            // and enqueue each valid movement
            for (int k = 0; k < 4; k++) {
                // check if it is possible to go to position
                // (i + row[k], j + col[k]) from current position
                if (isValid(mat, visited, i + row[k], j + col[k])) {
                    // mark next cell as visited and enqueue it
                    visited[i + row[k]][j + col[k]] = dist;
                    q.add(new Node(i + row[k], j + col[k], dist + 1));
                }
            }
        }

        if (min_dist != Integer.MAX_VALUE) {
            return min_dist;
        }
        return -1;
    }

    private static String formWayOut(int[][] visited, int x, int y, int min_dist) {
        StringBuilder wayOut = new StringBuilder("");
        wayOut.append("0, 0 - ");
        wayOut.append(String.format("%d, %d - ", x, y));
        while (min_dist-- != 0) {
            // check for all four possible movements from the current cell
            for (int k = 0; k < 4; k++) {
                if (x == 0 && k == 0) continue; // if at the upper border
                if (y == 0 && k == 1) continue; // if at the left border
                if (visited[x + row[k]][y + col[k]] == min_dist) {
                    x += row[k];
                    y += col[k];
                    wayOut.append(String.format("%d, %d - ", x, y));
                    break;
                }
            }
        }
        return wayOut.toString();
    }

    private static void printWayOut(String wayOut, int[][] mat, int M, int N) {
        for (int a = 0; a < M; a++) {
            for (int b = 0; b < N; b++) {
                if (wayOut.contains(String.format("%d, %d", a, b))) {
                    System.out.print(ANSI_RED + mat[a][b] + "\t" + ANSI_RESET);
                } else {
                    System.out.print(mat[a][b] + "\t");
                }
            }
            System.out.println();
        }
    }
}