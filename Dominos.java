/**
 * @author Alif Naufal Farrashady A0218302U
 */
import java.io.*;
import java.util.*;

public class Dominos {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(
                new OutputStreamWriter(System.out)));
        
        
        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            ArrayList<LinkedList<Integer>> adjList = new 
            ArrayList<LinkedList<Integer>>();
            for (int j = 0; j < n; j ++) {
                adjList.add(new LinkedList<Integer>());
            }

            for (int j = 0; j < m; j++) {
                String[] nextLine = br.readLine().split(" ");
                int x = Integer.parseInt(nextLine[0]);
                int y = Integer.parseInt(nextLine[1]);
                x --;
                y --;
                adjList.get(x).add(y);
            }

            DirectedGraph graph = new DirectedGraph(adjList);

            int result = graph.countIsolatedSCC();
            pw.write(result + "\n");
        }
        pw.close();
    }
}

class Pair<X, Y> {
    X first;
    Y second;

    Pair(X first, Y second) {
        this.first = first;
        this.second = second;
    }
}

class DirectedGraph {
    int V;
    ArrayList<LinkedList<Integer>> adjList;

    DirectedGraph(ArrayList<LinkedList<Integer>> adjList) {
        this.V = adjList.size();
        this.adjList = adjList;
    }

    DirectedGraph transpose() {
        ArrayList<LinkedList<Integer>> transposedAdjList = new 
        ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < this.V; i++) {
            transposedAdjList.add(new LinkedList<Integer>());
        }
        for (int i = 0; i < this.V; i++) {
            for (int j : this.adjList.get(i)) {
                transposedAdjList.get(j).add(i);
            }
        }
        return new DirectedGraph(transposedAdjList);
    }

    void updateStack(int u, boolean[] visited, ArrayDeque<Integer> stack) {
        visited[u] = true;

        LinkedList<Integer> uAdj = this.adjList.get(u);
        for (int v : uAdj) {
            if (!visited[v]) {
                updateStack(v, visited, stack);
            }
        }
        stack.push(u);
    }

    int[] DFS(int u, boolean[] visited, int[] parent, int nextID) {
        visited[u] = true;
        parent[u] = nextID;

        LinkedList<Integer> uAdj = this.adjList.get(u);
        for (int v : uAdj) {
            if (!visited[v]) {
                DFS(v, visited, parent, nextID);
            }
        }
        return parent;
    }

    Pair<Integer, int[]> kosaraju() {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        boolean[] visited1 = new boolean[this.V];
        int[] parent = new int[this.V];

        for (int i = 0; i < this.V; i++) {
            if (!visited1[i]) {
                updateStack(i, visited1, stack);
            }
        }

        DirectedGraph transpose = this.transpose();
        boolean[] visited2 = new boolean[this.V];
        int nextID = 0;


        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!visited2[u]) {
                nextID ++;
                transpose.DFS(u, visited2, parent, nextID);
            }
        }
        return new Pair<Integer, int[]>(nextID, parent);
    }

    int countIsolatedSCC() {
        Pair<Integer, int[]> kosarajuResult = this.kosaraju();
        int nSCC = kosarajuResult.first;
        int[] parent = kosarajuResult.second;
        int result = 0;
        boolean[] checked = new boolean[nSCC + 1];
        for (int i = 0; i < this.V; i++) {
            LinkedList<Integer> iAdj = this.adjList.get(i);
            for (int v : iAdj) {
                if (parent[i] != parent[v]) {
                    if (!checked[parent[v]]) {
                        checked[parent[v]] = true;
                        result ++; 
                    }
                }
            }
        }
        return nSCC - result;
    }
}