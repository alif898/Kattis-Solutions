/**
 * @author Alif Naufal Farrashady A0218302U
 */
import java.io.*;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Collections;
import java.util.PriorityQueue;

public class KattisQuest {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));        
        PrintWriter pw = new PrintWriter(new BufferedWriter(
            new OutputStreamWriter(System.out)));
        
        TreeMap<Long, PriorityQueue<Long>> map = new 
        TreeMap<Long, PriorityQueue<Long>>();
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] nextLine = br.readLine().split(" ");
            String command = nextLine[0];
            if (command.equals("add")) {
                Long e = Long.parseLong(nextLine[1]);
                Long g = Long.parseLong(nextLine[2]);
                if (map.containsKey(e)) {
                    map.get(e).add(g);
                } else {
                    PriorityQueue<Long> pq = new 
                    PriorityQueue<Long>(Collections.reverseOrder());
                    pq.add(g);
                    map.put(e, pq);
                }
            } else {
                Long x = Long.parseLong(nextLine[1]);
                Long result = Long.valueOf("0");
                if (!map.isEmpty()) {
                    while (x >= map.firstKey() && x >= 0) {
                        Long nextKey = map.floorKey(x);
                        PriorityQueue<Long> nextPq = map.get(nextKey);
                        result += nextPq.poll();
                        if (!nextPq.isEmpty()) {
                            map.put(nextKey, nextPq);
                        } else {
                            map.remove(nextKey);
                        }
                        x -= nextKey;
                        if (map.isEmpty()) {
                            break;
                        }
                    }
                }
                pw.write(result.toString() + "\n");
            }
        }
        pw.close();
    }
}