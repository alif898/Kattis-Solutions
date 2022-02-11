import java.util.Scanner;
import java.lang.Math;

public class Pot {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        while (n > 0) {
            int x = sc.nextInt();
            result += pot(x);
            n -= 1;
        }
        System.out.println(result);
    }

    static double pot(int x) {
        int lastDigit = x % 10;
        int number = ((x - lastDigit) / 10);
        return Math.pow(number, lastDigit);
    }
}