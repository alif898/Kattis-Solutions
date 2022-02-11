/**
 * Name: Alif Naufal Farrashady
 * Student Number: A0218302U
 */
import java.util.Scanner;

public class PeaSoupPancakes {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean result = false;

        while (n > 0) {
           int k = sc.nextInt();
           sc.nextLine();
           String restaurantName = sc.nextLine();
           boolean checkPea = false;
           boolean checkPancakes = false;
           while (k > 0) {
               String menuItem = sc.nextLine();
               if (menuItem.equals("pea soup")) {
                   checkPea = true;
               }
               if (menuItem.equals("pancakes")) {
                   checkPancakes = true;
               }
               k -= 1;
           }
           if (checkPea && checkPancakes) {
               System.out.println(restaurantName);
               result = true;
               break;
           }
           n -= 1;
        }
        if (!result) {
            System.out.println("Anywhere is fine I guess");
        }
    }
}