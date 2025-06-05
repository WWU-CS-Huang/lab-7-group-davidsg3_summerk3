//Authors: Ash Summers and Blaire Davidson
//Date: May 29th 2025
//Description: Lab 7

package lab7;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import heap.*;

public class Huffman {

    //heap with nodes to ints
    HashTable<Character, Integer> frequency;

    public static void main (String[]args){
        String fileName = args[0];
        File file = new File(fileName);
        Scanner sc;

        try{
            sc = new Scanner(file);
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        String string = sc.next();

        if(string == null){
            throw new IllegalArgumentException();
        }

        Huffman h = new Huffman();
        h.makeFrequencyMap(string);
        CodingTree codingTree = new CodingTree(h.frequency);

        //call encode on the string
        String encoded = h.encode(string, codingTree);

        if(string.length() < 100){
            System.out.println(string);
            System.out.println(encoded);
            //print decoded bitstring
        }

        //print boolean comparing string and decoded string

        //print compression ratio
    }

    //encodes a string and returns bits
    public String encode(String string, CodingTree codingTree){
       StringBuilder bits = new StringBuilder();
       for(int i = 0; i < string.length(); i++){
          bits.append(codingTree.encode(string.charAt(i)));

       }
        return bits.toString();
    }

    public String decode(String bits, CodingTree tree) {
        StringBuilder message = new StringBuilder();
        int i = 0;
        int j = 1;
        while (i < bits.length()) {
            while (tree.decode(bits.substring(i, j)) == null) {
                j++;
            }
            message.append(tree.decode(bits.substring(i, j)));
            i = j;
            j++;
        }
        return message.toString();
    }

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
