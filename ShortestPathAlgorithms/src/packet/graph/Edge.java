/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packet.graph;

/**
 *
 * @author Javier Olazábal
 */
public class Edge {
    
    private int src, dst, w;

    public Edge(int src, int dst, int w) {
        this.src = src;
        this.dst = dst;
        this.w = w;
    }

    public int getSrc() {
        return src;
    }

    public int getDst() {
        return dst;
    }

    public int getW() {
        return w;
    }
    
}
