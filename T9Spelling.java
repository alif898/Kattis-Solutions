/**
 * @author Alif Naufal Farrashady A0218302U
 * 
 * Pseudo code
 * 
 * define helper function that converts letter to keypad string
 * 
 * while there is lines of input
 *      initialise input as string
 *      initialise result
 *      for loop iterating through letters of input string
 *          convert to keypad string, append to result
 *          if next letter is the same or has the same digit in keypad
 *              append space to result
 *      add to output
 * 
 * print output
 */
import java.io.*;
import java.lang.StringBuilder;

public class T9Spelling {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        
        PrintWriter pw = new PrintWriter(new BufferedWriter(
            new OutputStreamWriter(System.out)));
        
            int n = Integer.valueOf(br.readLine());
        
        int counter = 1;
        while (n > 0) {
            String nextCase = br.readLine();
            StringBuilder str = new StringBuilder();

            char[] chars = nextCase.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                String currentChar = converter(chars[i]);
                str.append(currentChar);
                if (i < chars.length - 1) {
                    String nextChar = converter(chars[i + 1]);
                    if (chars[i] == chars[i + 1] || 
                    currentChar.charAt(0) == nextChar.charAt(0)) {
                        str.append(" ");
                    }
                }
            }
            pw.write(String.format(
                "Case #%d: %s", counter, str.toString()) + "\n");
            counter += 1;
            n -= 1;
        }
        pw.close();
    }

    static String converter(char letter) {
        String result = "0";
        switch (letter) {
            case 'a':
                result = "2";
                break;
            case 'b':
                result = "22";
                break;
            case 'c':
                result = "222";
                break;
            case 'd':
                result = "3";
                break;
            case 'e':
                result = "33";
                break;
            case 'f':
                result = "333";
                break;
            case 'g':
                result = "4";
                break;
            case 'h':
                result = "44";
                break;
            case 'i':
                result = "444";
                break;
            case 'j':
                result = "5";
                break;
            case 'k':
                result = "55";
                break;
            case 'l':
                result = "555";
                break;
            case 'm':
                result = "6";
                break;
            case 'n':
                result = "66";
                break;
            case 'o':
                result = "666";
                break;
            case 'p':
                result = "7";
                break;
            case 'q':
                result = "77";
                break;
            case 'r':
                result = "777";
                break;
            case 's':
                result = "7777";
                break;
            case 't':
                result = "8";
                break;
            case 'u':
                result = "88";
                break;
            case 'v':
                result = "888";
                break;
            case 'w':
                result = "9";
                break;
            case 'x':
                result = "99";
                break;
            case 'y':
                result = "999";
                break;
            case 'z':
                result = "9999";
                break;
        }
        return result;
    }
}