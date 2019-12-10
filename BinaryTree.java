/**
 * Name: BinaryTree
 * 
 * Author: Mark Carvalho
 * 
 * Date: Nov 25 2017
 */
import java.util.*;

/**
 * BinaryTree partially implements a binary tree.
 * NOTE - you will need to fill in parts of this tree. All the methods that you need to fill in are 
 * at the bottom
 */
public class BinaryTree<T> 
{
    private BTNode<T> root;

    /**
     * Creates an empty binary tree.
     */
    public BinaryTree()   {
        root = null;
    }

    /**
     * Creates a binary tree with the specified element as its root.
     * @param element the object to store in the root node
     */ 

    public BinaryTree (T element)    {
        root = new BTNode<T>(element);
    }

    /**
     * Creates a binary tree with the two specified subtrees.
     * @param element the object to store in the root node
     * @param left the left subtree that should come off the root node
     * @param right the right subtree that should come off the root node
     */
    public BinaryTree (T element, BinaryTree<T> left,  BinaryTree<T> right){
        root = new BTNode<T>(element);
        root.setLeft(left.root);
        root.setRight(right.root);
    }

    /**
     * Returns the element stored in the root of the tree.
     * 
     * @return the element stored in the root of the tree
     * @throws RuntimeException if the tree is empty
     */
    public T getRootElement()    {
        if (root == null)
            throw new RuntimeException ("Get root operation "
                + "failed. The tree is empty.");
        return root.getElement();
    }

    /**
     * Sets the element stored in the root of the tree.
     * 
     * @param value the object to store in the root
     * @throws RuntimeException if the tree is empty
     */
    public void setRootElement(T value){
        if (root == null)
            throw new RuntimeException ("Set root operation "
                + "failed. The tree is empty.");

        root.setElement(value);
    }

    /**
     * Sets left subtree of the root of the tree.
     * 
     * @param newLeft the tree which is to become the left subtree of the root
     * @throws RuntimeException if the tree is empty
     */
    public void setLeft(BinaryTree<T> newLeft)    {
        if (root == null)
            throw new RuntimeException ("Set left operation "
                + "failed. The tree is empty.");
        root.setLeft(newLeft.root);
    }

    /**
     * Sets the right subtree of the root of the tree.
     * 
     * @param newRight the tree which is to become the right subtree of the root
     * @throws RuntimeException if the tree is empty
     */
    public void setRight(BinaryTree<T> newRight)
    {
        if (root == null)
            throw new RuntimeException ("Set Right operation "
                + "failed. The tree is empty.");

        root.setRight(newRight.root);
    }

    /**
     * Satisfies the Iterable interface using an inorder traversal.
     * 
     */
    public Iterator<T> iterator()
    {
        return inorder();
    }

    /****************************************************************************
     ***************************************************************************
     * BELOW ARE THE METHODS THAT YOU NEED TO IMPLEMENT
     *****************************************************************************
     ****************************************************************************/

    /**
     * Returns the left subtree of the root of this tree.
     * 
     * @return the left subtree of the root of this tree.
     * @throws RuntimeException if the tree is empty
     */
    public BinaryTree<T> getLeft()    {
        BinaryTree<T> result = new BinaryTree<T>(); // created new BinaryTree
        
        if (root == null) // if the root is null  throw error 
            throw new RuntimeException ("Get left operation "
                + "failed. The tree is empty.");
             
        else
        {
           result.root = root.getLeft();//result root is = to the left of current root  
        }
        return result;
    }

    /**
     * Returns the right subtree of the root of this tree.
     * 
     * @return the right subtree of the root of this tree.
     * @throws RuntimeException if the tree is empty
     */

    public BinaryTree<T> getRight()    {
        BinaryTree<T> result = new BinaryTree<T>(); // created new BinaryTree
        
        if (root == null) // if the root is null  throw error 
            throw new RuntimeException ("Get Right operation "
                + "failed. The tree is empty.");
        else
        {
               result.root = root.getRight(); //result root is = to the right of current root     
        }
        return result;
    }

    /**
     * Returns the number of elements in this binary tree.
     * 
     * @return the number of elements in this binary tree
     */ 
    public int size()
    {
        int result = 0;         // number of elements in binary tree 
        result = root.count();  // call count method of root  
        return  result;
    }

    /**
     * Determines if tree contains any nodes
     * 
     * @return true if no nodes in tree, else false
     */
    public boolean isEmpty()
    {
        if(root == null) // if root is null 
            return true;
        else
        {
           return false;
        }
    }

    /**
     * Determines if tree is simply a leaf
     * 
     * @return true if no nodes in tree, else false
     */
    public boolean isLeaf()
    {
        boolean check = false;
        
        if (root == null) // if root is null throw error 
            throw new RuntimeException ("Get leaf operation "
                + "failed. The tree is empty.");

        else if(root.getLeft() == null && root.getRight() == null ) // if left node and right node is null node is a leaf 
        {
            check = true; 
        }
        return check;
    }

    /**
     * Populates and returns an iterator containing the elements in
     *  this binary tree using an inorder traversal.
    */
    public Iterator<T> inorder()
    {
        ArrayIterator<T> iter = new ArrayIterator<T>(); 
        root.inorder(iter); // call inoder method of root 
        return iter;
    }
}
