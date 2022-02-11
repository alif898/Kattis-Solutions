/**
 * @author Alif Naufal Farrashady A0218302U
 */
import java.io.*;

public class SumKind {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        
        PrintWriter pw = new PrintWriter(new BufferedWriter(
            new OutputStreamWriter(System.out)));
        
        int p = Integer.parseInt(br.readLine());

        for (int i = 0; i < p; i++) {
            String[] input = br.readLine().split(" ");
            int k = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            String result = k + " " + helper(n)[0] + " " + helper(n)[1] + " " + helper(n)[2] + "\n";
            pw.write(result);
        }
        pw.close();
    }

    static int[] helper(int n) {
        // index 0 for total, index 1 for odd, index 2 for even
        int[] result = new int[3];
        int counter = 1;
        while (counter < n + 1) {
            result[0] += counter;
            result[1] += ((2 * counter) - 1);
            result[2] += (2 * counter);
            counter++;
        }
        return result;
    }
}