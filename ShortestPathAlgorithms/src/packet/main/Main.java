/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packet.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import packet.algorithms.BellmanFord;
import packet.graph.Graph;

/**
 *
 * @author Javier Olazábal
 */
public class Main {
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        File file = new File("test\\Graph.txt");
        Scanner sc = new Scanner(file);
        int src = 1;
//        public Graph(int V, int E)
        int V = sc.nextInt();
        int E = sc.nextInt();
        /*
            Ingreso de la info del grafo a través de archivo de texto
        */
        Graph g = new Graph(V,E);
        int z = 0;
        while(sc.hasNextLine()){
            g.edge[z].src = sc.nextInt();
            g.edge[z].dst = sc.nextInt();
            g.edge[z].w = sc.nextInt();
            z++;
        }
        
        System.out.println(g.toString());
        
        BellmanFord BellmanFord = new BellmanFord();
        
        int[][] distBellman = new int[V+1][V+1];
        
        //Bellman-ford para cada nodo desde 1 hasta el máximo nodo
        for(int i = 1; i <= V ; ++i)
        {
            distBellman[i] = BellmanFord.Algorithm(g, i);
        }
        
        printSP(distBellman);
        
    }
    
    public static void printSP(int[][] dist)
    {
        System.out.print("Node\t\t");
        for(int i = 1; i < dist.length ; ++i){
            System.out.print(i + "\t\t");
        }
        System.out.println("\n");
        for(int i = 1; i < dist.length ; ++i){
            System.out.print(i + "\t\t");
            for(int j = 1; j < dist[i].length ; ++j){
                if(dist[i][j] == Integer.MAX_VALUE){System.out.print("Infinite\t\t"); continue;}
                System.out.print(dist[i][j] + "\t\t");
            }
            System.out.println("\n");
        }
    }
}
