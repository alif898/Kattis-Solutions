/**
 * @author Alif Naufal Farrashady A0218302U
 */

import java.io.*;
import java.util.ArrayDeque;

public class DelimiterSoup {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(
            new OutputStreamWriter(System.out)));
        
        int l = Integer.parseInt(br.readLine());
        char[] inputArray = br.readLine().toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<Character>();

        boolean ok = true;
        for (int i = 0; i < l ; i++) {
            char nextChar = inputArray[i];
            if (nextChar == ' ') {
                continue;
            } else {
                if (nextChar == ']' || nextChar == ')' || nextChar == '}') {
                    if (stack.isEmpty()) {
                        pw.write(String.format("%s %d", nextChar, i));
                        ok = false;
                        break;
                    } else {
                        char fromStack = stack.pop();
                        if (!((fromStack == '[' && nextChar == ']') || 
                        (fromStack == '(' && nextChar == ')') || 
                        (fromStack == '{' && nextChar == '}'))) {
                            pw.write(String.format("%s %d", nextChar, i));
                            ok = false;
                            break;
                        }
                    }
                } else {
                    stack.push(nextChar);
                }
            }
        }
        if (ok) {
            pw.write("ok so far"); 
        }
        pw.close();
    }
}