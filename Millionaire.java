/**
 * @author Alif Naufal Farrashady A0218302U
 */
import java.io.*;
import java.util.*;

public class Millionaire {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(
                new OutputStreamWriter(System.out)));
        
        
        String[] firstLine = br.readLine().split(" ");
        int m = Integer.parseInt(firstLine[0]);
        int n = Integer.parseInt(firstLine[1]);

        int[][] grid = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i ++) {
            String[] nextLine = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int height = Integer.parseInt(nextLine[j]);
                grid[i][j] = height;
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        PriorityQueue<Pair> pq = new 
        PriorityQueue<Pair>(new PairComparator());

        pq.add(new Pair(0, 0, grid[0][0], 0));
        visited[0][0] = true;
        int result = 0;

        while(!pq.isEmpty() && !visited[m -1][n - 1]) {
            Pair current = pq.poll();
            visited[current.x][current.y] = true;
            result = Math.max(current.difference, result);

            for (int i = 0; i < 4; i++) {
                int newX = current.x + directions[i][0];
                int newY = current.y + directions[i][1];
                if (newX > -1 &&
                newY > -1 &&
                newX < m &&
                newY < n && 
                !visited[newX][newY]) {
                    int newHeight = grid[newX][newY];
                    int newDifference = newHeight - current.height;
                    Pair next = new Pair(newX, newY, newHeight, newDifference);
                    pq.add(next);
                }
            }
        }
        pw.write(Integer.toString(result));
        pw.close();
    }
}

class Pair {
    int x;
    int y;
    int height;
    int difference;

    Pair(int x, int y, int height, int difference) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.difference = difference;
    }
}

class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
        int weightDiff = p1.difference - p2.difference;
        return weightDiff;
    }
}