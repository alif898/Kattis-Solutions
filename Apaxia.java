/**
 * @author Alif Naufal Farrashady A0218302U
 */

import java.io.*;
import java.lang.StringBuilder;

public class Apaxia {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        String input = br.readLine();
        String result;

        if (input.isEmpty()) {
            result = "";
        } else {
            StringBuilder sbResult = new StringBuilder();
            sbResult.append(input.charAt(0));
            for (int i = 1; i < input.length(); i++) {
                if (input.charAt(i - 1) == input.charAt(i)){
                    continue;
                } else {
                    sbResult.append(input.charAt(i));
                }
            }
            result = sbResult.toString();
        }
        System.out.println(result);
    }
}