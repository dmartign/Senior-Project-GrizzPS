package edu.oakland.test;


import java.util.Iterator;

/**
 *
 * @author mrkokko
 * GrizzPS
 * Oakland University - CSE 480 Senior Capstone Project
 * Winter 2014
 * Mitchell Kokko, Daniela Martignani, Adeline Miller, Stefan Reich
 */

// class for the graph data structure, linked list part, forming the list

public class IntersectionList extends ShellLinkedList
{

    public IntersectionList()
    {
        super();
    }

    public void insert(Intersections i)
    {
        IntersectionNode in = new IntersectionNode(i);
        in.setNextI(headI);
        headI = in;
        numberOfItems++;
    }

    public void insertLast(Intersections i)
    {
        IntersectionNode in = new IntersectionNode(i);
        IntersectionNode currNode = headI;
        while(currNode.getNextI() != null)
        {
            currNode=currNode.getNextI();
        }
        currNode.setNextI(in);
        currNode.setIntersect(i);
        numberOfItems++;
    }

    public void insertNode(IntersectionNode in)
    {
        in.setNextI(headI);
        headI = in;
        numberOfItems++;
    }

    public void insertPath(IntersectionNode i, Paths p)
    {
        //if(i.getIntersect().getId()==p.getIdI())
        //{
        PathNode pn = new PathNode(p);
        PathNode next = i.getNextP();
        pn.setNext(next);
        //next=pn;
        i.setNextP(pn);
        //}
    }

    public Intersections peek(int searchID) throws DataStructureException
    {
        IntersectionNode currNode = headI;
        try{
            while(currNode.getNextI() != null)
            {
                if(currNode.getIntersect().getId() == searchID)
                {
                    throw new DataStructureException("Intersection retrieved: " + currNode.getIntersect().toString());
                }
                currNode = currNode.getNextI();
            }

        }
        catch(DataStructureException dse)
        {
            System.out.println(dse.getMessage());
        }
        if((currNode.getIntersect().getId() == searchID))
        {
            return(currNode.getIntersect());
        }
        return(null);
    }



}


