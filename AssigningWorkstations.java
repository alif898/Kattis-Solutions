/**
 * @author Alif Naufal Farrashady A0218302U
 */

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AssigningWorkstations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        PriorityQueue<Researcher> researchers = new 
        PriorityQueue<Researcher>(new ResearcherComparator());
        PriorityQueue<Integer> stationTimes = new PriorityQueue<Integer>();

        int result = 0;
        
        for (int i = 0; i < n; i++) {
            String[] nextLine = br.readLine().split(" ");
            int a = Integer.parseInt(nextLine[0]);
            int s = Integer.parseInt(nextLine[1]);
            researchers.add(new Researcher(a, s));
        }

        while (!researchers.isEmpty()) {
            Researcher nextResearcher = researchers.poll();
            stationTimes.add(nextResearcher.getLeave());

            if (nextResearcher.getArrival() < stationTimes.peek()) {
                continue;
            }

            while(!stationTimes.isEmpty()) {
                int availableTime = stationTimes.poll();
                int unlockRange = nextResearcher.getArrival() - availableTime;
                if (unlockRange < 0) {
                    stationTimes.add(availableTime);
                    break;
                } else if (unlockRange > m) {
                    continue;
                } else {
                    result ++;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}

class Researcher {
    private int arrival;
    private int duration;

    Researcher(int arrival, int duration) {
        this.arrival = arrival;
        this.duration = duration;
    }

    int getArrival() {
        return this.arrival;
    }

    int getDuration() {
        return this.duration;
    }
    
    int getLeave() {
        return this.getArrival() + this.getDuration();
    }
}

class ResearcherComparator implements Comparator<Researcher> {
    @Override
    public int compare(Researcher r1, Researcher r2) {
        if (r1.getArrival() == r2.getArrival()) {
            return r1.getDuration() - r2.getDuration();
        }
        return r1.getArrival() - r2.getArrival();
    }
}