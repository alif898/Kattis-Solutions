/**
 * @author Alif Naufal Farrashady A0218302U
 */

import java.io.*;

public class JoinStrings {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        
        int n = io.getInt();
        TailedLinkedList[] listArray = new TailedLinkedList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            TailedLinkedList nextList = new TailedLinkedList();
            nextList.addNode(new HelperNode(io.getWord()));
            listArray[i] = nextList;
        }
        int resultIndex = 1;
        for (int j = 1; j < n; j++) {
            int a = io.getInt();
            int b = io.getInt();
            listArray[a].addList(listArray[b]);
            resultIndex = a;
        }
        listArray[resultIndex].print(io);
        io.close();
    }
}

class HelperNode {
    String string;
    HelperNode next;

    HelperNode(String string) {
        this.string = string;
        this.next = null;
    }

    void addNext(HelperNode next) {
        if (this.next == null) {
            this.next = next;
        } else {
            this.next.addNext(next);
        }
    }
}

class TailedLinkedList {
    HelperNode head;
    HelperNode tail;
    int size;

    TailedLinkedList() {
        size = 0;
    }
    
    void addNode(HelperNode node) {
        node.addNext(this.head);
        this.head = node;
        this.tail = head;
        size ++;
    }

    void addList(TailedLinkedList other) {
        tail.next = other.head;
        other.head = null;
        tail = other.tail;
        size += other.size;
    }

    void print(Kattio io) {
        HelperNode current = head;
        io.write(current.string);
        for (int i = 1; i < size; i++) {
            current = current.next;
            io.write(current.string);
        }
    }
}