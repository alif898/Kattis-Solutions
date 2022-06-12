/**
 * @author Alif Naufal Farrashady A0218302U
 */

import java.io.*;
import java.util.TreeMap;

public class BinarySearchTree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(
                new OutputStreamWriter(System.out)));
        
        TreeMap<Integer, Integer> bst = new TreeMap<Integer, Integer>();
        long totalDepth = 0;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int next = Integer.parseInt(br.readLine());
            int depth;

            Integer floorKey = bst.floorKey(next);
            Integer ceilingKey = bst.ceilingKey(next);

            if (floorKey == null && ceilingKey == null) {
                depth = 0;
            } else if (floorKey == null) {
                depth = bst.get(ceilingKey) + 1;
            } else if (ceilingKey == null) {
                depth = bst.get(floorKey) + 1;
            }  else {
                depth = Math.max(bst.get(ceilingKey), bst.get(floorKey)) + 1;
            }

            bst.put(next, depth);
            totalDepth += depth;
            pw.write(totalDepth + "\n"); 
        }
        pw.close();
    }
}