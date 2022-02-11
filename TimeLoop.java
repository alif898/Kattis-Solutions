import java.util.Scanner;

public class TimeLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int counter = 1;
        while (counter <= input) {
            System.out.println(counter + " Abracadabra");
            counter += 1;
        }
    }
}