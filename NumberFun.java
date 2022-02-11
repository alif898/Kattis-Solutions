import java.util.Scanner;
import java.util.ArrayList;

public class NumberFun {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> result = new ArrayList<String>();
        while (n > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (check(a, b, c)) {
                result.add("Possible");
            } else {
                result.add("Impossible");
            }
            n -= 1;
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    static boolean check(int a, int b, int c) {
        return ((a + b == c) || (a - b == c) || (b - a == c) || (a * b == c) || (a / (double) b == c) || (b / (double) a == c));
    }
}
