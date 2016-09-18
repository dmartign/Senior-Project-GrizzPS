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

// class for the graph data structure, linked list part, only implemented to go from an IntersectionNode to all the path nodes connected to it

public class IntersectionNode{
    private Intersections intersect;
    private IntersectionNode nextI;
    private PathNode nextP;
    private boolean visited;

    public IntersectionNode()
    {
        intersect=null;
        nextI=null;
        nextP=null;
    }

    public IntersectionNode(Intersections intersection)
    {
        intersect=intersection;
        nextI=null;
        nextP=null;
    }

    public IntersectionNode(Intersections intersect, IntersectionNode next) {
        this.intersect = intersect;
        this.nextI = next;
        nextP=null;
    }

    public IntersectionNode(Intersections intersect, IntersectionNode nextI, PathNode nextP) {
        this.intersect = intersect;
        this.nextI = nextI;
        this.nextP = nextP;
    }

    public Intersections getIntersect() {
        return intersect;
    }

    public void setIntersect(Intersections intersect) {
        this.intersect = intersect;
    }

    public IntersectionNode getNextI() {
        return nextI;
    }

    public void setNextI(IntersectionNode next) {
        this.nextI = next;
    }

    public PathNode getNextP() {
        return nextP;
    }

    public void setNextP(PathNode nextP) {
        this.nextP = nextP;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

}

