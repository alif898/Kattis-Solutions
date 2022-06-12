/**
 * @author Alif Naufal Farrashady A0218302U
 */
import java.io.*;
import java.util.*;

public class LostMap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(
                new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] nextLine = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(nextLine[j]);
            }
        }

        ArrayList<Edge> edgeList = new ArrayList<Edge>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                edgeList.add(new Edge(i, j, grid[i][j]));
            }
        }
        Collections.sort(edgeList);
        UFDS ufds = new UFDS(n);
        for (Edge edge : edgeList) {
            int i = edge.u;
            int j = edge.v;
            if (!ufds.isSameSet(i, j)) {
                ufds.unionSet(i, j);
                i ++;
                j ++;
                pw.write(String.format("%d %d\n", i, j));
            }
        }
        pw.close();
    }
}

class Edge implements Comparable<Edge> {
    int u;
    int v;
    int w;

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge other) {
        return this.w - other.w;
    }
}

class UFDS {
    int[] parent;

    UFDS(int n) {
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int findSet(int i) {
        if (parent[i] == i) {
            return i;
        } else {
            parent[i] = findSet(parent[i]);
            return parent[i];
        }
    }
    
    boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }

    void unionSet(int i , int j) {
        if (!isSameSet(i, j)) {
            parent[findSet(j)] = findSet(i);
        }
    }
}