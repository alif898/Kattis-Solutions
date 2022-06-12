/**
 * @author Alif Naufal Farrashady A0218302U
 */

import java.io.*;
import java.math.BigInteger;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

public class CardTrading {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int t = Integer.parseInt(firstLine[1]);
        int k = Integer.parseInt(firstLine[2]);

        int[] cards = new int[1000001];
        String[] secondLine = br.readLine().split(" ");
        for (String card : secondLine) {
            int cardNumber = Integer.parseInt(card);
            cards[cardNumber]++;
        }

        int tCounter = t;
        ArrayList<Price> prices = new ArrayList<Price>();
        while (tCounter > 0) {
            String[] nextLine = br.readLine().split(" ");
            int cardNumber = t - tCounter + 1;
            int buyPrice = Integer.parseInt(nextLine[0]);
            int sellPrice = Integer.parseInt(nextLine[1]);
            int buy = (2 - cards[cardNumber]) * buyPrice;
            int sell = cards[cardNumber] * sellPrice;
            prices.add(new Price(cardNumber, buy, sell));
            tCounter -= 1;
        }

        Collections.sort(prices, new PriceComparator());

        BigInteger profit = new BigInteger("0");
        for (int i = 0; i < k; i++) {
            Price nextCard = prices.get(i);
            profit = profit.subtract(BigInteger.valueOf(nextCard.getBuy()));
        }
        for (int j = k; j < t; j++) {
            Price nextCard = prices.get(j);
            profit = profit.add(BigInteger.valueOf(nextCard.getSell()));
        }
        System.out.println(profit);
    }
}

class Price {
    
    private final int card;
    private final int buy;
    private final int sell;

    Price(int card, int buy, int sell) {
        this.card = card;
        this.buy = buy;
        this.sell = sell;
    }

    int getCard() {
        return this.card;
    }

    int getBuy() {
        return this.buy;
    }

    int getSell() {
        return this.sell;
    }
}

class PriceComparator implements Comparator<Price> {

    @Override
    public int compare(Price p1, Price p2) {
        int p1Cost = p1.getBuy() + p1.getSell();
        int p2Cost = p2.getBuy() + p2.getSell();
        if (p1Cost < p2Cost) {
            return -1;
        } else if (p1Cost > p2Cost) {
            return 1;
        } else {
            if (p1.getBuy() < p2.getBuy()) {
                return -1;
            } else if (p1.getBuy() > p2.getBuy()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}