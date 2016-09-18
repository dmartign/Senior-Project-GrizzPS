package edu.oakland.test;

/**
 *
 * @author mrkokko
 * GrizzPS
 * Oakland University - CSE 480 Senior Capstone Project
 * Winter 2014
 * Mitchell Kokko, Daniela Martignani, Adeline Miller, Stefan Reich
 */

// class for the graph data structure, linked list part (nodes info for the connections, objects info)

public class Paths {
    private int idP;
    private double distance;
    private int idI;

    public Paths(int idP, int idI, double distance) {
        this.idP = idP;
        this.idI = idI;
        this.distance = distance;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int id) {
        this.idP = id;
    }

    public int getIdI() {
        return idI;
    }

    public void setIdI(int idI) {
        this.idI = idI;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paths other = (Paths) obj;
        if (this.idP != other.idP) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Paths{" + "Path id=" + idP + ", to Intersection id=" + idI +", distance=" + distance + '}';
    }


}

