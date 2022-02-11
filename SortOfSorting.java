/**
 * @author Alif Naufal Farrashady A0218302U
 * 
 * Pseudo code
 * 
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class SortOfSorting {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        
        PrintWriter pw = new PrintWriter(new BufferedWriter(
            new OutputStreamWriter(System.out)));
        
        boolean continueProcess = true;
        int counter = 0;
        while (continueProcess) {
            int n = Integer.valueOf(br.readLine());
            if (n == 0) {
                continueProcess = false;
                break;
            } else if (!(counter == 0)) {
                pw.write("\n");
            }
            ArrayList<NameString> names = new ArrayList<>();
            while (n > 0) {
                String nextName = br.readLine();
                names.add(new NameString(nextName));
                n--;
            }
            Collections.sort(names);
            for (NameString nextName : names) {
                pw.write(nextName.getName() + "\n");
            }
            counter += 1;
        }
        pw.close();
    }
}

class NameString implements Comparable<NameString> {

    private final String name;

    NameString(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    @Override
    public int compareTo (NameString other) {
        char thisFirst = this.getName().charAt(0);
        char thisSecond = this.getName().charAt(1);
        char otherFirst = other.getName().charAt(0);
        char otherSecond = other.getName().charAt(1);
        if (thisFirst < otherFirst) {
            return -1;
        } else if (thisFirst > otherFirst) {
            return 1;
        } else {
            if (thisSecond < otherSecond) {
                return -1;
            } else if (thisSecond > otherSecond) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}