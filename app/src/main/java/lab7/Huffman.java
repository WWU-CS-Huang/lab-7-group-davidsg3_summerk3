package lab7;
import java.util.HashMap;
import heap.Heap;
import heap.HashTable;

public class Huffman {

    //heap with nodes to ints
    HashTable<Character, Integer> frequency;

    public void makeFrequencyMap (String input){
        frequency = new HashTable<Character, Integer>();

        char[] inputArray = input.toCharArray();
        for(char character : inputArray){
            Integer count = frequency.get(character);
           //if character exists
            if(count != null){
                frequency.put(character, count + 1);
            }
           else{
               frequency.put(character, 1);
           }
       }
    }

}
