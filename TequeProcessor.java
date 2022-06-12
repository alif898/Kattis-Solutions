/**
 * @author Alif Naufal Farrashady A0218302U
 */

import java.io.*;

public class TequeProcessor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(
            new OutputStreamWriter(System.out)));
        
        Teque tq = new Teque();
        int n = Integer.parseInt(br.readLine());
        while (n > 0) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            int nextElement = Integer.parseInt(input[1]);
            if (command.equals("push_back")) {
                tq.pushBack(nextElement);
            } else if (command.equals("push_front")) {
                tq.pushFront(nextElement);
            } else if (command.equals("push_middle")) {
                tq.pushMiddle(nextElement);
            } else {
                pw.write(tq.get(nextElement) + "\n");
            }
            n -= 1;
        }
        pw.close();
    }
}

class Teque {
    int[] firstHalf = new int[1000000];
    int[] secondHalf = new int[1000000];
    int firstStart;
    int firstSize;
    int secondStart;
    int secondSize;

    Teque() {
        this.firstHalf = new int[1000000];
        this.secondHalf = new int[1000000];
        this.firstStart = 499999;
        this.firstSize = 0;
        this.secondStart = 499999;
        this.secondSize = 0;
    }

    void pushFront(int item) {
        if (firstSize == secondSize) {
            firstStart --;
            firstHalf[firstStart] = item;
            firstSize ++;
        } else {
            firstStart --;
            firstHalf[firstStart] = item;
            secondStart --;
            secondHalf[secondStart] = firstHalf[firstStart + firstSize];
            secondSize ++;
        }
    }

    void pushMiddle(int item) {
        if (firstSize == secondSize) {
            firstHalf[firstStart + firstSize] = item;
            firstSize ++;
        } else {
            secondStart --;
            secondHalf[secondStart] = item;
            secondSize ++;
        }
    }

    void pushBack(int item) {
        if (firstSize == secondSize) {
            secondHalf[secondStart + secondSize] = item;
            firstHalf[firstStart + firstSize] = secondHalf[secondStart];
            secondStart ++;
            firstSize ++;
        } else {
            secondHalf[secondStart + secondSize] = item;
            secondSize ++;
        }
    }

    int get(int index) {
        if (index >= firstSize) {
            return secondHalf[secondStart + index - firstSize];
        } else {
            return firstHalf[firstStart + index];
        }
    }
}