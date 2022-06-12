/**
 * @author Alif Naufal Farrashady A0218302U
 */

import java.io.*;
import java.util.HashMap;

public class VirtualFriends {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(
                new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            UFDS ufds = new UFDS();
            int f = Integer.parseInt(br.readLine());
            for (int j = 0; j < f; j++) {
                String[] nextLine = br.readLine().split(" ");
                String friend1 = nextLine[0];
                String friend2 = nextLine[1];

                ufds.insert(friend1);
                ufds.insert(friend2);
                pw.write(ufds.unionSet(friend1, friend2) + "\n");
            }
        }
        pw.close();
    }
}

class UFDS {
    HashMap<String, String> parents;
    HashMap<String, Integer> size;
    HashMap<String, Integer> rank;

    UFDS() {
        this.parents = new HashMap<String, String>();
        this.size = new HashMap<String, Integer>();
        this.rank = new HashMap<String, Integer>();
    }

    void insert(String name) {
        if (!this.parents.containsKey(name) && 
        !this.size.containsKey(name) && 
        !this.rank.containsKey(name)) {
            this.parents.put(name, name);
            this.size.put(name, 1);
            this.rank.put(name, 0);
        }
    }

    String findSet(String name) {
        if (this.parents.get(name).equals(name)) {
            return name;
        } else {
            this.parents.replace(name, findSet(this.parents.get(name)));
            return this.parents.get(name);
        }
    }

    boolean isSameSet(String name1, String name2) {
        return findSet(name1).equals(findSet(name2));
    }

    int unionSet(String name1, String name2) {
        if (!isSameSet(name1, name2)) {
            String parent1 = findSet(name1);
            String parent2 = findSet(name2);
            if (this.rank.get(parent1) > this.rank.get(parent2)) {
                this.parents.replace(parent2, parent1);
                this.size.replace(parent1, 
                this.size.get(parent1) + this.size.get(parent2));
                return this.size.get(findSet(name1));
            } else {
                this.parents.replace(parent1, parent2);
                this.size.replace(parent2, 
                this.size.get(parent1) + this.size.get(parent2));
                if (this.rank.get(parent1) == this.rank.get(parent2)) {
                    this.rank.replace(parent2, this.rank.get(parent2) + 1);
                }
                return this.size.get(findSet(name2));
            }
        }
        return this.size.get(findSet(name1));
    }
}