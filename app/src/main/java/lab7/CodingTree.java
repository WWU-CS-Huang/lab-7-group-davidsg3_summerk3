package lab7;

import java.util.BitSet;
import heap.Heap;

public class CodingTree {
    Node head;

    CodingTree(Heap<Node, Integer> frequencies) {
        while (frequencies.size() < 1) {
            Node newGuy = new Node(frequencies.poll(), frequencies.poll());
            frequencies.add(newGuy, newGuy.frequency);
        }
        head = frequencies.poll();
    }

    
}
