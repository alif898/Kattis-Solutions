import java.util.Scanner;
import java.util.ArrayList;

public class LastFactorialDigit {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (t > 0) {
            int n = sc.nextInt();
            result.add(factorial(n) % 10);
            t -= 1;
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    static int factorial(int n) {
        if (n == 1) {
            return n;
        } else {
            return n * factorial(n - 1);
        }
    }
}
