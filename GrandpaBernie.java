/**
 * @author Alif Naufal Farrashady A0218302U
 */

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GrandpaBernie {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(
            new OutputStreamWriter(System.out)));
        
        int n = Integer.parseInt(br.readLine());
        HashMap<String, ArrayList<Integer>> map = new 
        HashMap<String, ArrayList<Integer>>();

        while (n > 0) {
            String[] input = br.readLine().split(" ");
            String country = input[0];
            Integer year = Integer.parseInt(input[1]);
            if (map.containsKey(country)) {
                map.get(country).add(year);
            } else {
                ArrayList<Integer> trips = new ArrayList<Integer>();
                trips.add(year);
                map.put(country, trips);
            }
            n --;
        }

        HashSet<String> sorted = new HashSet<String>();

        int q = Integer.parseInt(br.readLine());
        while (q > 0) {
            String[] input = br.readLine().split(" ");
            String country = input[0];
            Integer k = Integer.parseInt(input[1]);
            ArrayList<Integer> trips = map.get(country);
            if (!sorted.contains(country)) {
                Collections.sort(trips);
                sorted.add(country);
            }
            pw.write(trips.get(k - 1).toString());
            if (q > 1) {
                pw.write("\n");
            }
            q --;
        }
        pw.close();
    }
}