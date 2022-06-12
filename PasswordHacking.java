/**
 * @author Alif Naufal Farrashady A0218302U
 */

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class PasswordHacking {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Double[] probArray = new Double[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            double nextProb = Double.parseDouble(input[1]);
            probArray[i] = nextProb;
        }
        Arrays.sort(probArray, Collections.reverseOrder());
        int attempt = 1;
        double result = 0.0;
        for (double prob : probArray) {
            result += prob * attempt;
            attempt++;
        }
        System.out.println(result);
    }
}