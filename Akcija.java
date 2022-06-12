/**
 * @author Alif Naufal Farrashady A0218302U
 */

import java.io.*;
import java.util.Arrays;

public class Akcija {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] priceArray = new int[n];
        int sum = 0;
        int free = 0;
        for (int i = 0; i < n; i++) {
            int nextPrice = Integer.parseInt(br.readLine());
            priceArray[i] = nextPrice;
            sum += nextPrice;
        }
        Arrays.sort(priceArray);
        for (int j = priceArray.length - 3; j >= 0; j -= 3) {
            free += priceArray[j];
        }
        System.out.println(sum - free);
    }
}