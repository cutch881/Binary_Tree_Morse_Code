/**
 * Name: FileReaderAndProcessor .
 * 
 * purpose: read file and process user option 
 * 
 * @author (Mark Carvalho)
 * 
 * @version (Nov 25 2017)
 */
import java.util.*;
import java.io.*;
public class FileReaderAndPocessor<T>
{

    /**
     * Name: readAndProcess 
     *
     * purpose: read file and process user option
     *
     * @param option:String 
     * 
     * @return void 
     */
    public void readAndProcess(String option)throws IOException
    {   Scanner input = new Scanner (System.in); // scanner object 
        Encode encode = new Encode(); // encode object 
        Decode decode = new Decode(); // decode object 
        String letter = ""; // letter obtained from file 
        String code = "" ;  // code obtained from file for letter 
        File myFile = new File("codes.txt"); // file object 
        Scanner inputFile = new Scanner(myFile); // scanner object 
        BinaryTree <T> root = new <T> BinaryTree ("TrueRoot"); //BinaryTree object 
        
        while (inputFile.hasNext()) // while to file has a next line 
        {
            letter = inputFile.next().toLowerCase(); // turn letter to lower case 
            code = inputFile.next();   
            
            if(option.equalsIgnoreCase("d")) // if option d 
            {
                BinaryTree <T> nodeMade = new <T> BinaryTree (letter); // create new node 
                decode.buildTree(code,root,nodeMade ); // build tree 
            }
            
            if(option.equalsIgnoreCase("e")) // if option e 
            {
                char ch = letter.charAt(0); // get character of letter 
                int pos = ch - 'a';         // sub ch from 'a' to get position 
                encode.storeCodes(pos,code); // store codes 
            }
        }
        inputFile.close(); // file closed 
        
        if(option.equalsIgnoreCase("d")) // if option d 
        {
            System.out.print("Enter your code here to decode:");
            String morse = input.nextLine();  // users moese code 
            System.out.print("Decoded to: ");
            decode.split(root,morse); // split and return decoded string 
            System.out.println();
            //*root.size();// print tree size.  
            //*decode.print(root); //print tree inorder.
        }
       
        if(option.equalsIgnoreCase("e")) //if option e 
        {   System.out.print("Enter your text here to encode:");
            String text = input.nextLine(); // text entered by user 
            System.out.print("Encoded to: ");
            encode.encodeString(text); // print encoded string 
        }
    }
}
