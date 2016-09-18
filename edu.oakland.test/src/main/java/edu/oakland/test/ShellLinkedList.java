package edu.oakland.test;
/**
 *
 * @author mrkokko
 * GrizzPS
 * Oakland University - CSE 480 Senior Capstone Project
 * Winter 2014
 * Mitchell Kokko, Daniela Martignani, Adeline Miller, Stefan Reich
 */

// class for the graph data structure, linked list part

public abstract class ShellLinkedList{
    protected IntersectionNode headI;
    protected PathNode headP;
    protected int numberOfItems;

    public ShellLinkedList()
    {
        headI = new IntersectionNode();
        headP = new PathNode();
        numberOfItems = 0;
    }

    public int getNumberOfItems()
    {
        return(numberOfItems);
    }

    public boolean isEmpty()
    {
        if(numberOfItems==0)
        {
            return(true);
        }
        return(false);
    }

    @Override
    public String toString()
    {
        String m = "";
        IntersectionNode currINode = headI;
        PathNode currPNode = headP;
        while(currINode.getNextI() != null)
        {
            m += (currINode.getIntersect().toString() + "\n");
            currINode=currINode.getNextI();
        }
        if(currINode==null)
        {
            m="";
        }
        return("Number of intersection nodes in the list: " + numberOfItems + "\n" + m);
    }
}

