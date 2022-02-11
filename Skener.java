/**
 * @author Alif Naufal Farrashady A0218302U
 */

import java.io.*;
import java.lang.StringBuilder;

public class Skener {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(
            new OutputStreamWriter(System.out)));
        
        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        int zr = Integer.parseInt(input[2]);
        int zc = Integer.parseInt(input[3]);

        String[][] inputArray = new String[r][c];

        for (int h = 0; h < r; h++) {
            String nextLine = br.readLine();
            for (int i = 0; i < c; i++) {
                inputArray[h][i] = nextLine.substring(i, i + 1);
            }
        }

        for (int j = 0; j < inputArray.length; j++) {
            for (int x = 0; x < zr; x++) {
                for (int k = 0; k < inputArray[0].length; k++) {
                    for (int y = 0; y < zc; y++) {
                        pw.write(inputArray[j][k]);
                    }
                }
                pw.write("\n");
            }
        }
        pw.close();
    }
}