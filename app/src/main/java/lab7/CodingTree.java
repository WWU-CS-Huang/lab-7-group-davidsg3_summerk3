package lab7;

import heap.*;

public class CodingTree {
    Node head;
    HashTable<Character, String> encode;
    HashTable<String, Character> decode;

    CodingTree(HashTable<Character, Integer> frequencies) {
        Heap<Node, Integer> heap = new Heap<Node, Integer>();
        for (HashTable<Character, Integer>.Pair p : frequencies) {
            heap.add(new Node(p.getValue(), p.getKet()), p.getValue());
        }
        while (heap.size() > 1) {
            Node newGuy = new Node(heap.poll(), heap.poll());
            heap.add(newGuy, newGuy.frequency);
        }
        head = heap.poll();
        makeTable(head, "");
    }

    private void makeTable(Node node, String path) {
        if (node.terminates) {
            encode.put(node.letter, path);
            decode.put(path, node.letter);
        }
        else {
            makeTable(node.left, path + "0");
            makeTable(node.right, path + "1");
        }
    }

    public String encode(char letter) {
        return encode.get(letter);
    }

    public Character decode(String path) {
        if (!decode.containsKey(path)) return null;
        return decode.get(path);
    }

}
