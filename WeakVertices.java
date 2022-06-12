/**
 * @author Alif Naufal Farrashady A0218302U
 */

import java.io.*;

public class WeakVertices {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(
            new OutputStreamWriter(System.out)));
        
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) {
                break;
            }
            int[][] adjMatrix = new int[n][n];
            boolean[] valid = new boolean[n];
            for (int i = 0; i < n; i++) {
                String[] nextLine = br.readLine().split(" ");
                for (int j = 0; j < nextLine.length; j++) {
                    adjMatrix[i][j] = Integer.parseInt(nextLine[j]);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        continue;
                    }
                    for (int k = 0; k < n; k++) {
                        if (i == k || j == k) {
                            continue;
                        }
                        if (adjMatrix[i][j] == 1 && 
                        adjMatrix[i][k] == 1 && 
                        adjMatrix[j][k] == 1) {
                            valid[i] = true;
                            valid[j] = true;
                            valid[k] = true;
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (!valid[i]) {
                    pw.write(i + " ");
                }
            }
            pw.write("\n");
        }
        pw.close();
    }
}