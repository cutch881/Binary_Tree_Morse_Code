
/**
 * Name: Decode.
 * 
 * Purpose: to build binary tree and decode strings 
 *
 * @author (Mark Carvalho)
 * 
 * @version (Nov 25 2017)
 */
import java.util.*;
public class Decode<T> 
{
    /**
     * Name:buildTree
     * 
     * Purpose: to build the binary tree 
     * 
     * parm(code:String, root:BinaryTree<T>, nodeMade: BinaryTree <T> )
     * 
     * return: void 
     */
    public void buildTree(String code, BinaryTree <T> root, BinaryTree <T> nodeMade)
    {   

        if(!root.isEmpty()) // if root is not empty
        { 
            if(code.charAt(0) == '.') // if character and it is '.'
            {  
                if(code.length() == 1) //if on the last character
                {
                    root.setLeft(nodeMade); // set left node as the nodeMade 
                }
                else
                {
                    buildTree(code.substring(1),root.getLeft(),nodeMade); // build tree by passing in rest of the string, left subtree and the nodeMade
                }
            }
            else if(code.charAt(0) == '-') // if character and it is '-'
            {
                if(code.length() == 1) // if on the last character
                {
                    root.setRight(nodeMade); // set right node as the nodeMade 
                }
                else
                {
                    buildTree(code.substring(1),root.getRight(),nodeMade);// build tree by passing in rest of the string, right subtree and the nodeMade
                }
            }
        }
    }

    /**
     * Name:buildTree
     * 
     * Purpose: to move through the tree and find a match  
     * 
     * parm(root:BinaryTree<T>, code:String)
     * 
     * return: void 
     */
    public void decode(BinaryTree <T> root, String code)
    {
        if(!root.isEmpty()) // if root is not empty
        { 
            if(code.charAt(0) == '.') // if character and it is '.'
            {  
                if(code.length() == 1) //if on the last character
                {
                    System.out.print(root.getLeft().getRootElement().toString()); // print left node  
                }
                else
                {
                    decode(root.getLeft(), code.substring(1)); // decode by passing in rest of the string, and left subtree
                }
            }
            else if(code.charAt(0) == '-') // if character and it is '-'
            {
                if(code.length() == 1)//if on the last character
                {
                    System.out.print(root.getRight().getRootElement().toString()); // print right node
                }
                else
                {
                    decode(root.getRight(), code.substring(1)); // decode by passing in rest of the string, and right subtree
                }
            }
        }
    }

    /**
     * Name: split
     * 
     * purpose: to split the string of the user 
     * 
     * parm (root:BinaryTree<T>, morse:String)
     */
    public void split(BinaryTree <T> root,String morse)
    { 
        try{
            for (String retval: morse.split("       "))  // split coded string based on 7 spaces 
            {
                for(String coded : retval.split("   ")) // split coded letters based on 3 spaces 
                {
                   decode(root,coded); // passin tree and code letter to find match
                }
                System.out.print(" ");
            }
        }
        catch(StringIndexOutOfBoundsException e) // if StringIndexOutOfBoundsException is found
        {
            System.out.println("    |THIS MORSE CODE WAS PARTIATIALLY OR NOT DECTECTABLE|");

        }
    }
    
     /**
     * Name: print
     * 
     * purpose: print tree in order
     * 
     * parm (tree:BinaryTree<T>)
     */
    public void print(BinaryTree<T> tree)
    {
        Iterator<T> iter = tree.inorder(); 
        while (iter.hasNext()) {
            System.out.print("|" + iter.next().toString()+ "|" + " ");
        } 
    }
}
