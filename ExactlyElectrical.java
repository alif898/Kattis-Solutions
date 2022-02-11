/**
 * @author Alif Naufal Farrashady A0218302U
 */
import java.io.*;

public class ExactlyElectrical {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        
        String[] firstLine = br.readLine().split(" ");
        int a = Integer.parseInt(firstLine[0]);
        int b = Integer.parseInt(firstLine[1]);

        String[] secondLine = br.readLine().split(" ");
        int c = Integer.parseInt(secondLine[0]);
        int d = Integer.parseInt(secondLine[1]);

        int t = Integer.parseInt(br.readLine());
        int distance = Math.abs(a - c) + Math.abs(b - d);
        if (t < distance || (t - distance) % 2 == 1) {
            System.out.println("N");
        } else {
            System.out.println("Y");
        }
    }
}