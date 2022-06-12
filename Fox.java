/**
 * @author Alif Naufal Farrashady A0218302U
 */

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Fox {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(
            new OutputStreamWriter(System.out)));
        
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] recording = br.readLine().split(" ");
            ArrayList<String> wrong = new ArrayList<String>();

            while (true) {
                String nextSound = br.readLine();
                if (nextSound.equals("what does the fox say?")) {
                    break;
                }
                wrong.add(nextSound.split(" ")[2]);
            }

            for (String sound : recording) {
                if (!wrong.contains(sound)) {
                    pw.write(sound + " ");
                }
            }
            
            if (t - i > 0) {
                pw.write("\n");
            }
        }
        pw.close();
    }
}