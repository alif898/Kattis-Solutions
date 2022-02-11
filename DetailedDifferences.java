import java.util.Scanner;
import java.util.ArrayList;

public class DetailedDifferences {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> result = new ArrayList<String>();
        while (n > 0) {
            String firstString = sc.nextLine();
            String secondString = sc.nextLine();
            String nextResult = firstString + "\n" + secondString + "\n" + difference(firstString, secondString) + "\n";
            result.add(nextResult);
            n -= 1;
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    static String difference(String firstString, String secondString) {
        String result = "";
        for (int i = 0; i < firstString.length(); i ++) {
            if (firstString.charAt(i) == secondString.charAt(i)) {
                result += ".";
            } else {
                result += "*";
            }
        }
        return result;
    }
}
