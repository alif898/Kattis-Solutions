/**
 * @author Alif Naufal Farrashady A0218302U
 */
import java.io.*;
import java.util.*;

public class Islands {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(
                new OutputStreamWriter(System.out)));
        
        
        String[] firstLine = br.readLine().split(" ");
        int r = Integer.parseInt(firstLine[0]);
        int c = Integer.parseInt(firstLine[1]);

        char[][] grid = new char[r][c];

        for (int i = 0; i < r; i ++) {
            String nextLine = br.readLine();
            for (int j = 0; j < c; j++) {
                char next = nextLine.charAt(j);
                grid[i][j] = next;
            }
        }

        boolean[][] visited = new boolean[r][c];

        int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        int result = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 'L' && !visited[i][j]) {
                    visited[i][j] = true;
                    // run BFS
                    Queue<Vertex> queue = new ArrayDeque<Vertex>();
                    queue.add(new Vertex(i, j));
                    while (!queue.isEmpty()) {
                        Vertex next = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nextR = next.r + directions[k][0];
                            int nextC = next.c + directions[k][1];
                            if (nextR > -1 && 
                            nextC > -1 &&
                            nextR < r &&
                            nextC < c &&
                            grid[nextR][nextC] != 'W' &&
                            !visited[nextR][nextC]) {
                                visited[nextR][nextC] = true;
                                queue.add(new Vertex(nextR, nextC));
                            }
                        }
                    }
                    result ++;
                } else if (grid[i][j] == 'W') {
                    visited[i][j] = true;
                }
            }
        }
        pw.write(Integer.toString(result));
        pw.close();
    }
}

class Vertex {
    int r;
    int c;

    Vertex(int r, int c) {
        this.r = r;
        this.c = c;
    }
}