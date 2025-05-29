package lab7;
import java.util.HashMap;
import heap.Heap;
import heap.HashTable;

public class Huffman {

    //heap with nodes to ints
    Heap<Node, Integer> frequency;

    public void makeFrequencyMap (String input){
        frequency = new Heap<Node, Integer>();

        char[] inputArray = input.toCharArray();
        for(char character : inputArray){
            Node node = new Node(character);
           //if character exists
            if(frequency.contains())

           if(count != null){
               //put back in map with count + 1
               frequency.add(character, count + 1);
           }
           else{
               frequency.add(character, 1);
           }
       }
    }


}
