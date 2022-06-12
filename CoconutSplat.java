/**
 * @author Alif Naufal Farrashady A0218302U
 */

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class CoconutSplat {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        List<Coconut> coconuts = new LinkedList<Coconut>();
        for (int i = 0; i < n; i++) {
            coconuts.add(new Coconut(i, 1));
        }
        int nextIndex = 0;
        while (coconuts.size() > 1) {
            nextIndex = (nextIndex + s - 1) % coconuts.size();
            Coconut nextPlayer = coconuts.get(nextIndex);
            if (nextPlayer.isFolded()) {
                nextPlayer.changeState();
                Coconut clonedFist = new Coconut(nextPlayer.getPlayer(), 2);
                coconuts.add(coconuts.indexOf(nextPlayer) + 1, clonedFist);
            } else if (nextPlayer.isFist()) {
                nextPlayer.changeState();
                nextIndex ++;
            } else {
                nextPlayer.changeState();
                coconuts.remove(nextPlayer);
            }
        }
        System.out.println(coconuts.get(0).getPlayer() + 1);
    }
}

class Coconut {
    private int player;
    private int state;

    Coconut(int player, int state) {
        this.player = player;
        this.state = state;
    }

    int getPlayer() {
        return this.player;
    }

    void changeState() {
        this.state += 1;
    }

    boolean isFolded() {
        return this.state == 1;
    }

    boolean isFist() {
        return this.state == 2;
    }

    boolean isPalmDown() {
        return this.state == 3;
    }

    @Override
    public String toString() {
        return String.format("%d : %d", this.player, this.state);
    }
}
