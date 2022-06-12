/**
 * @author Alif Naufal Farrashady A0218302U
 */

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.lang.StringBuilder;

public class Confirmity {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int[] intInput = new int[input.length];
            for (int j = 0; j < input.length; j++) {
                intInput[j] = Integer.parseInt(input[j]);
            }
            Arrays.sort(intInput);
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < input.length; k++) {
                sb.append(Integer.toString(intInput[k]));
            }
            String course = sb.toString();
            if (map.containsKey(course)) {
                int count = map.get(course);
                count ++;
                map.replace(course, count);
            } else {
                map.put(course, 1);
            }
        }
        int max = 0;
        int nMax = 0;
        Collection<Integer> counts = map.values();
        for (Integer count : counts) {
            if (count > max) {
                max = count;
                nMax = count;
            } else if (count == max) {
                nMax += count;
            }
        }
        System.out.println(nMax);
    }
}