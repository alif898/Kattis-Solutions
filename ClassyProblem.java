/**
 * @author Alif Naufal Farrashady A0218302U
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.StringBuilder;

public class ClassyProblem {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(
            new OutputStreamWriter(System.out)));
        
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            ArrayList<Person> personList = new ArrayList<Person>();
            int n = Integer.parseInt(br.readLine());
            while (n > 0) {
                String[] input = br.readLine().split(" ");
                String name = input[0].substring(0, input[0].length() - 1);
                String[] classes = input[1].split("-");
                String[] nextClasses = new String[10];
                int index = 0;
                for (int i = classes.length - 1; i >= 0; i--) {
                    nextClasses[index] = classes[i];
                    index ++;
                }
                personList.add(new Person(name, nextClasses));
                n -= 1;
            }
            Collections.sort(personList);
            String result = "";
            for (Person nextPerson : personList) {
                result += nextPerson.getName() + "\n";
            }
            result += "==============================";
            if (!(t == 1)) {
                result += "\n";
            }
            pw.write(result);
            t -= 1;
        }
        pw.close();       
    }
}

class Person implements Comparable<Person> {
    private final String name;
    private final String[] classes;

    Person(String name, String[] classes) {
        this.name = name;
        this.classes = classes;
    }

    String getName() {
        return this.name;
    }

    String[] getClasses() {
        return this.classes;
    }
    
    static int getRank(String rank) {
        if (rank == null) {
            return 3;
        }
        if (rank.equals("upper")) {
            return 4;
        } else if (rank.equals("middle")) {
            return 3;
        } else if (rank.equals("lower")) {
            return 2;
        } else {
            return 1;
        }
    }

    @Override
    public int compareTo(Person other) {
        int counter = 0;
        while (counter < 10) {
            int thisRank = Person.getRank(this.getClasses()[counter]);
            int otherRank = Person.getRank(other.getClasses()[counter]);
            if (thisRank == otherRank) {
                counter += 1;
            } else {
                return otherRank - thisRank;
            }
        }
        return this.getName().compareTo(other.getName());
    }
}