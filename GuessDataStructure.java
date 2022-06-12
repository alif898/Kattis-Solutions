/**
 * @author Alif Naufal Farrashady A0218302U
 */

import java.io.*;
import java.util.Comparator;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class GuessDataStructure {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(
            new OutputStreamWriter(System.out)));
        
        String s;
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);

            Deque<Integer> stack = new ArrayDeque<Integer>();
            Deque<Integer> queue = new ArrayDeque<Integer>();
            PriorityQueue<Integer> pq = new 
            PriorityQueue<Integer>(Comparator.reverseOrder());

            boolean isStack = true;
            boolean isQueue = true;
            boolean isPq = true;

            for (int i = 0; i < n; i++) {
                String[] nextLine = br.readLine().split(" ");
                int command = Integer.parseInt(nextLine[0]);
                int x = Integer.parseInt(nextLine[1]);

                if (command == 1) {
                    if (isStack) {
                        stack.addFirst(x);
                    }
                    if (isQueue) {
                        queue.addLast(x);
                    }
                    if (isPq) {
                        pq.add(x);
                    }
                } else {
                    if (isStack) {
                        if (stack.size() == 0 || (stack.pollFirst() != x))  {
                            isStack = false;
                        }
                    }
                    if (isQueue) {
                        if (queue.size() == 0 || (queue.pollFirst() != x)) {
                            isQueue = false;
                        }
                    }
                    if (isPq) {
                        if (pq.size() == 0 || (pq.poll() != x)) {
                            isPq = false;
                        }
                    }
                }

            }
            if (!isStack && !isQueue && !isPq) {
                pw.write("impossible");
            } else if ((isStack && isQueue) || 
            (isStack && isPq) || 
            (isQueue && isPq)) {
                pw.write("not sure");
            } else if (isStack) {
                pw.write("stack");
            } else if (isQueue) {
                pw.write("queue");
            } else if (isPq) {
                pw.write("priority queue");
            }
            pw.write("\n");
        }
        pw.close();
    }
}