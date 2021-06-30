/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packet.main;

import java.util.Scanner;
import packet.algorithms.BellmanFord;
import packet.graph.Graph;

/**
 *
 * @author Javier Olazábal
 */
public class Main {
    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int src = 0;
//        public Graph(int V, int E)
        int V = sc.nextInt();
        int E = sc.nextInt();
        
        Graph g = new Graph(V,E);
        
        BellmanFord BellmanFord = new BellmanFord();
        
        int[] distBellman = BellmanFord.Algorithm(g , src);
        System.out.println("Distancia desde nodo " + src);
        
        for(int i = 0; i < distBellman.length ; i++){
            System.out.print("Nodo " + i + ": ");
            System.out.println(distBellman[i]);
        }
        
    }
}
