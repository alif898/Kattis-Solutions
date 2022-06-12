/**
 * @author Alif Naufal Farrashady A0218302U
 */

import java.io.*;
import java.lang.StringBuilder;

public class ShatteredCake {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        int width = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int area = 0;

        while (n > 0) {
            String[] nextPiece = br.readLine().split(" ");
            int nextWidth = Integer.parseInt(nextPiece[0]);
            int nextLength = Integer.parseInt(nextPiece[1]);
            area += (nextWidth * nextLength);
            n -= 1;
        }
        System.out.println(area / width);
    }
}