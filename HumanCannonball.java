/**
 * @author Alif Naufal Farrashady A0218302U
 */
import java.io.*;
import java.util.*;

public class HumanCannonball {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(
                new OutputStreamWriter(System.out)));
        ArrayList<DoublePair> pairs = new ArrayList<DoublePair>();

        String[] start = br.readLine().split(" ");
        double startX = Double.parseDouble(start[0]);
        double startY = Double.parseDouble(start[1]);

        pairs.add(new DoublePair(startX, startY));

        String[] end = br.readLine().split(" ");
        double endX = Double.parseDouble(end[0]);
        double endY = Double.parseDouble(end[1]);
        pairs.add(new DoublePair(endX, endY));

        int n = Integer.parseInt(br.readLine());        
        for (int i = 0; i < n ; i++) {
            String[] nextLine = br.readLine().split(" ");
            double nextX = Double.parseDouble(nextLine[0]);
            double nextY = Double.parseDouble(nextLine[1]);
            pairs.add(new DoublePair(nextX, nextY));
        }

        double[][] adjMatrix = new double[n + 2][n + 2];
        adjMatrix[0][1] = getDistance(pairs.get(0), pairs.get(1)) / 5;
        adjMatrix[1][0] = adjMatrix[0][1];
        for (int i = 2; i < n + 2; i++) {
            double distance = getDistance(pairs.get(0), pairs.get(i));
            adjMatrix[0][i] = distance / 5;
            adjMatrix[i][0] = (Math.abs(distance - 50) / 5) + 2;
        }
        for (int i = 2; i < n + 2; i++) {
            double distance = getDistance(pairs.get(1), pairs.get(i));
            adjMatrix[1][i] = distance / 5;
            adjMatrix[i][1] = (Math.abs(distance - 50) / 5) + 2;
        }
        for (int i = 2; i < n + 2; i++) {
            for (int j = 3; j < n + 2; j++) {
                double distance = getDistance(pairs.get(i), pairs.get(j));
                adjMatrix[i][j] = (Math.abs(distance - 50) / 5) + 2;
                adjMatrix[j][i] = adjMatrix[i][j];
            }
        }
        double[][] result = floydWarshall(adjMatrix);
        pw.write(Double.toString(result[0][1]));
        pw.close();
    }

    static double getDistance(DoublePair p1, DoublePair p2) {
        double diffX = Math.abs(p1.x - p2.x);
        double diffY = Math.abs(p1.y - p2.y);
        return Math.hypot(diffX, diffY);
    }

    static double[][] floydWarshall(double[][] adjMatrix) {
        int V = adjMatrix.length;
        double[][] result = new double[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                result[i][j] = adjMatrix[i][j];
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    result[i][j] = Math.min(
                        result[i][j], result[i][k] + result[k][j]);
                }
            }
        }
        return result;
    }
}

class DoublePair {
    double x;
    double y;

    DoublePair(double x, double y) {
        this.x = x;
        this.y = y;
    }
}