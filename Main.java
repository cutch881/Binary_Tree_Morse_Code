/**
 * Name: Main.
 *
 * @author (Mark Carvalho)
 * @version (Nov 25 2017)
 */
import java.util.*;
import java.io.*;
public class Main
{

    public static void main (String args[])throws IOException
    {
         FileReaderAndPocessor readAndProcess = new FileReaderAndPocessor(); // FileReaderAndPocessor object 
         Scanner input = new Scanner(System.in); // scanner object 
         String option = ""; // option entered by user 
         System.out.println("Welcome To The Morse Code Meachine");
         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
         while(!option.equalsIgnoreCase("q")) // while q is not entered keep running 
         {
         System.out.println("To encode enter E or e");
         System.out.println("To decode enter D or d");
         System.out.println("To quit enter Q or q");
         System.out.println("Any other string typed will redirect you to the menu");
         System.out.print("Enter your option:");
         option = input.nextLine(); // get user option 
         if(!option.equalsIgnoreCase("q")) // if not q 
            readAndProcess.readAndProcess(option); //pass option in the read method
         System.out.println();
        }
 
    }
}
