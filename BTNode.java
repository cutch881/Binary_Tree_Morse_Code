/**
 * Name: BTNode 
 * 
 * Author: Mark Carvalho
 * 
 * Version: (Nov 25 2017)
 */
import java.util.*;
public class BTNode<T> 
{
    protected T element;
    protected BTNode<T> left, right;

    //-----------------------------------------------------------------
    //  Creates a new tree node with the specified data.
    //-----------------------------------------------------------------
    public BTNode (T element)
    {
        this.element = element;
        left = right = null;
    }

    //-----------------------------------------------------------------
    //  Returns the element stored in this node.
    //-----------------------------------------------------------------
    public T getElement()
    {
        return element;
    }

    //-----------------------------------------------------------------
    //  Sets the element stored in this node.
    //-----------------------------------------------------------------
    public void setElement (T element)
    {
        this.element = element;
    }

    //-----------------------------------------------------------------
    //  Returns the left subtree of this node.
    //-----------------------------------------------------------------
    public BTNode<T> getLeft()
    {
        return left;
    }

    //-----------------------------------------------------------------
    //  Sets the left child of this node.
    //-----------------------------------------------------------------
    public void setLeft (BTNode<T> left)
    {
        this.left = left;
    }

    //-----------------------------------------------------------------
    //  Returns the right subtree of this node.
    //-----------------------------------------------------------------
    public BTNode<T> getRight()
    {
        return right;
    }

    //-----------------------------------------------------------------
    //  Sets the right child of this node.
    //-----------------------------------------------------------------
    public void setRight (BTNode<T> right)
    {
        this.right = right;
    }

    /** Below are the methods that need completing. You will have to remove UnsupportedOperationException
     *---------------------------------------------------------------------------------------------------
     */

    /**
     *  Returns the element in this subtree that matches the
     *  specified target. Returns null if the target is not found.
     *
    */
    public BTNode<T> find (T target)
    {
        BTNode<T> result = null; 
        if(target.equals(getElement())) // if target is = to the element of this node  return this object 
        {
            result = this;  
        }
        else
        {
            if(getRight() != null ) // if right node != null 
            {
                result = right.find(target); // pass target into find to move through right sub tree 
            }
            if(getLeft() != null) // if left node != null
            {
                result = left.find(target); // pass target into find to move through left sub tree 
            }
        }
        return result;
    }

    /**-----------------------------------------------------------------
     * Returns the number of nodes in this subtree.
     * -----------------------------------------------------------------
    */
    public int count()
    {
        int count = 1; // number of nodes 
        if(getRight()!= null) // if right is not null 
        {
            count += right.count(); // call count to move through right tree 
        }
        if(getLeft() != null) // if left is not null 
        {
            count += left.count();  // call count to move through left tree 
        }
        return count; 
    }

    /**
     *  Performs an inorder traversal on this subtree, updating the
     *  specified iterator. This method does not print anything just
     *  performs the traversal
     *
    */
    public void inorder (ArrayIterator<T> iter)
    {
        if (left != null) // if left is not null 
        {
            left.inorder (iter); // call inorder and move through left tree 
        }
        
        iter.add (element); // add element found in to the array list of the ittrator 
        
        if (right != null) // if right is not null 
        {
            right.inorder (iter); // call inorder and move through right tree 
        }

    }

}