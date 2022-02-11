/**
 * @author Alif Naufal Farrashady A0218302U
 */

import java.io.*;
import java.lang.StringBuilder;

public class FizzBuzz {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(
            new OutputStreamWriter(System.out)));
        
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int n = Integer.parseInt(input[2]);

        for (int i = 1; i <= n; i++){
            if ((i % x == 0) && (i % y == 0)) {
                pw.write("FizzBuzz\n");
            } else if (i % x == 0) {
                pw.write("Fizz\n");
            } else if (i % y == 0) {
                pw.write("Buzz\n");
            } else {
                pw.write(i + "\n");
            }
        }

        pw.close();
    }
}