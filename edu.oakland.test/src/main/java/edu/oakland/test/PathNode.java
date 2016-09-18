package edu.oakland.test;

/**
 *
 * @author mrkokko
 * GrizzPS
 * Oakland University - CSE 480 Senior Capstone Project
 * Winter 2014
 * Mitchell Kokko, Daniela Martignani, Adeline Miller, Stefan Reich
 */

// class for the graph data structure, linked list part (edges - going from edge to edge)

public class PathNode {
    private Paths path;
    private PathNode next;

    public PathNode() {
        path=null;
        next=null;
    }

    public PathNode(Paths path) {
        this.path = path;
    }

    public PathNode(Paths path, PathNode next) {
        this.path = path;
        this.next = next;
    }

    public Paths getPath() {
        return path;
    }

    public void setPath(Paths path) {
        this.path = path;
    }

    public PathNode getNext() {
        return next;
    }

    public void setNext(PathNode next) {
        this.next = next;
    }
}

