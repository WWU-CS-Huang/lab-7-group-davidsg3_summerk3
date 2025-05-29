package lab7;
import java.util.HashMap;

public class Huffman {

    //hashMap with characters to ints
    HashMap<Character, Integer> frequency;

    public void makeFrequencyMap (String input){
        frequency = new HashMap<Character, Integer>();

        char[] inputArray = input.toCharArray();
        for(char character : inputArray){
           //if character exists
           //casting as an int because I think I can?
           Integer count = frequency.get(character);
           if(count != null){
               //put back in map with count + 1
               frequency.put(character, count + 1);
           }
           else{
               frequency.put(character, 1);
           }
       }
    }


}
