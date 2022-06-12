import java.util.Scanner;

public class Autori {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            System.out.println(factorial(n) % 10);
            t -= 1;
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
