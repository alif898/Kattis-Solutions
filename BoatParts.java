/**
 * @author Alif Naufal Farrashady A0218302U
 */

import java.io.*;
import java.util.HashSet;

public class BoatParts {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int p = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        int days = 0;
        HashSet<String> parts = new HashSet<String>(); 
        for (int i = 0; i < n; i++) {
            String part = br.readLine();
            if (!parts.contains(part)) {
                parts.add(part);
            }
            days ++;
            if (parts.size() == p) {
                System.out.println(days);
                return;
            }
        }
        System.out.println("paradox avoided");
    }
}