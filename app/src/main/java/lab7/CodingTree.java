package lab7;

import heap.*;

public class CodingTree {
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
        makeTable(heap.poll(), new StringBuilder());
    }

    private void makeTable(Node node, StringBuilder path) {
        if (node.terminates) {
            encode.put(node.letter, path.toString());
            decode.put(path.toString(), node.letter);
        }
        else {
            makeTable(node.left, path.append("0"));
            makeTable(node.right, path.append("1"));
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
