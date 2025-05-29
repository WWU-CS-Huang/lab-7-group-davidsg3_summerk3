package lab7;

public class Node {
    Node left;
    Node right;
    int frequency;
    char letter;
    boolean terminates;

    Node(int frequency, char letter) {
        this.frequency = frequency;
        this.letter = letter;
        terminates = true;
    }

    Node(Node left, Node right) {
        this.frequency = left.frequency + right.frequency;
        this.left = left;
        this.right = right;
    }
}