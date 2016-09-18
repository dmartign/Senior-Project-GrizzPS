package edu.oakland.test;

/**
 *
 * @author mrkokko
 * GrizzPS
 * Oakland University - CSE 480 Senior Capstone Project
 * Winter 2014
 * Mitchell Kokko, Daniela Martignani, Adeline Miller, Stefan Reich
 */

// class for the graph data structure, linked list part (edges) forming list

public class PathList extends ShellLinkedList
{

    public PathList()
    {
        super();
    }

    public void insert(Paths p)
    {
        PathNode pn = new PathNode(p);
        pn.setNext(headP);
        headP = pn;
    }

    public void insertLast(Paths p)
    {
        PathNode pn = new PathNode(p);
        PathNode currNode = headP;
        while(currNode.getNext() != null)
        {
            currNode=currNode.getNext();
        }
        currNode.setNext(pn);
        currNode.setPath(p);
    }

    public Paths peek(int searchID) throws DataStructureException
    {
        PathNode currNode = headP;
        try{
            while(currNode.getNext() != null)
            {
                if(currNode.getPath().getIdP() == searchID)
                {
                    throw new DataStructureException("Path retrieved: " + currNode.getPath().toString());
                }
                currNode = currNode.getNext();
            }

        }
        catch(DataStructureException dse)
        {
            System.out.println(dse.getMessage());
        }
        if((currNode.getPath().getIdP() == searchID))
        {
            return(currNode.getPath());
        }
        return(null);
    }
}

