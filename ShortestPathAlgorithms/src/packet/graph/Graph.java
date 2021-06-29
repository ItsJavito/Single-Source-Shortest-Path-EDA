/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packet.graph;

import java.util.Scanner;

/**
 *
 * @author Javier Olazábal
 */
public class Graph
{
    /*
        Falta añadir ingreso por texto 
        utilzando scanner por el momento
        NO OLVIDAR
    */
    
    Scanner sc = new Scanner(System.in);
    public int v,e;
    public Edge edge[];

    public Graph(int V, int E) {
        //numero de vertices 
        this.v = V;
        //numero de arcos
        this.e = E;
        //ingreso de datos
        System.out.println("source dest weight");
        for(int i = 0; i < e ; i++){
            //cambiar a ingreso por texto
            System.out.println("Edge" + i + ": ");
            int src = sc.nextInt();
            int dst = sc.nextInt();
            int w = sc.nextInt();
            edge[i] = new Edge(src, dst , w);
        }
    }
}
