import java.util.*;
import java.io.*;
/**
 * Write a description of class Encode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Encode
{
    private String[] codes  = new String [26]; // array that holds codes
    /**
     * Name: storeCodes
     * 
     * Purpose: get codes from file and store in to array
     * 
     * parm(index:int, code:String)
     * 
     * return:void 
     */
    public void storeCodes (int index, String code) throws IOException
    {   
        codes [index] = code; //code being set into proprer index in codes array
    }
     /**
     * Name: encode 
     * 
     * Purpose: match characters of thing typed in by used to codes in array
     * 
     * parm(letter:char)
     * 
     * return:String 
     */
    public String encode(char letter)
    {   String code = " "; // code returned from array
        int pos = letter - 'a'; // find position of letter passed in
        code = codes[pos].toString(); // return code based on pos 
        return code;
    }
    /**
     * Name: encodeString 
     * 
     * Purpose:Get string from user so it can be broken down and encoded 
     * 
     * parm(setence:String)
     * 
     * return:void 
     */
    public void encodeString(String sentence)
    {
        String toLowerCase = sentence.toLowerCase(); // turns sentence to lower case 
        int length = sentence.length(); // length of the setence 
        int count = 0;  
        while(count < length) // while count is less than the length of the setence 
        {
          char parts = toLowerCase.charAt(count); // get the letter at the index of the string 
          if(parts == ' ') // if space is dected 
          {
              System.out.print("    "); // print 4 spaces in addition to the 3 spaces to indicate word seperation
          }
          else
          {
            System.out.print(encode(parts)+"   ");  // return encoded string 
          }
          count++; // count incerment 
        }
        System.out.println();
    }  
}
