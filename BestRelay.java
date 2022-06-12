/**
 * Name: Alif Naufal Farrashady
 * Student Number: A0218302U
 */
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

public class BestRelay {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<Runner> runners = new ArrayList<Runner>();
        double benchmark = n * 20.0;

        while (n > 0) {
            String runnerName = sc.next();
            double firstLeg = sc.nextDouble();
            double otherLeg = sc.nextDouble();
            runners.add(new Runner(runnerName, firstLeg, otherLeg));
            sc.nextLine();
            n -= 1;
        }

        Collections.sort(runners, new RunnerComparator());
        
        ArrayList<String> result = new ArrayList<String>();
        for (Runner runner : runners) {
            ArrayList<String> currentTeam = new ArrayList<String>();
            Runner firstRunner = runner;
            double currentTime = runner.getFirstLeg();
            currentTeam.add(firstRunner.getName());
            int counter = 3;
            for (Runner otherRunner : runners) {
                if (!firstRunner.getName().equals(otherRunner.getName())) {
                    currentTime += otherRunner.getOtherLeg();
                    currentTeam.add(otherRunner.getName());
                    counter -= 1;
                }
                if (counter == 0) {
                    break;
                }
            }
            if (Double.compare(currentTime, benchmark) < 0) {
                benchmark = currentTime;
                result = currentTeam;
            }
        }

        System.out.println(benchmark);
        for (String name : result) {
            System.out.println(name);
        }
    }
}

class Runner {

    private final String name;
    private final double firstLeg;
    private final double otherLeg;

    Runner(String name, double firstLeg, double otherLeg) {
        this.name = name;
        this.firstLeg = firstLeg;
        this.otherLeg = otherLeg;
    }

    String getName() {
        return this.name;
    }

    double getFirstLeg() {
        return this.firstLeg;
    }

    double getOtherLeg() {
        return this.otherLeg;
    }
}

class RunnerComparator implements Comparator<Runner> {

    @Override
    public int compare(Runner r1, Runner r2) {
        return Double.compare(r1.getOtherLeg(), r2.getOtherLeg());
    }
}