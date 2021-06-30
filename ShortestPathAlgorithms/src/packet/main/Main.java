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
import packet.algorithms.FloydWarshall;
import packet.graph.Graph;

/**
 *
 * @author Javier Olazábal
 */
public class Main {
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        /*
        ************************************************************************
            Paso 1: Preparamos el ingreso de la informacion
            del grafo orientado que vamos a trabajar 
            debe estar en un formato tal que:
        
            CantVertices CantArcos
            Origen Destino Peso 
            Origen Destino Peso 
            .... CantArcos veces
        ************************************************************************
        */
        
        File file = new File("test\\Graph.txt");
        Scanner sc = new Scanner(file);
        
        //public Graph(int V, int E)
        int V = sc.nextInt();
        int E = sc.nextInt();
        
        //Ingreso de la info del grafo a través de archivo de texto
        Graph g = new Graph(V,E);
        int z = 0;
        while(sc.hasNextLine()){
            g.edge[z].src = sc.nextInt();
            g.edge[z].dst = sc.nextInt();
            g.edge[z].w = sc.nextInt();
            z++;
        }
        //Generamos la matriz de adyacencia del grafo 
        
        g.GenerateAdMatrix();
        //imprimimos la información que nos viene del archivo del texto
        // para comprobar que sea correcta, podemos obviar esto
        System.out.println(g.toString());
        System.out.println("Matriz Adyacencia");
        printSP(g.AdMatrix);
        
        /*
        ************************************************************************
            Paso 2: Ejectuamos el algoritmo correspondiente

            A continuación haremos la ejecución del algoritmo de Bellman-Ford 
            para el problema de la ruta más corta en todos los nodos del grafo
            Se comenzará instanciando un objeto del algoritmo y después se 
            ejecutará para todos los nodos
        ************************************************************************
        */
        
        //instanciamos un objeto del algoritmo de bellmanFord
        BellmanFord BellmanFord = new BellmanFord();
        
        int[][] distBellman = new int[V+1][V+1];
        
        //Bellman-ford para cada nodo desde 1 hasta el máximo nodo
        for(int i = 1; i <= V ; ++i)
        {
            distBellman[i] = BellmanFord.Algorithm(g, i);
        }
        
        //FloyWarshall algoritmo ejecucion
        
        FloydWarshall floydWarshall = new FloydWarshall();
        int [][] distFloyd = floydWarshall.algorithm(g.AdMatrix);
        
        //mostramos el arreglo con todas las rutas más cortas por todos los nodos del grafo
        System.out.println("Bellman-ford");
        printSP(distBellman);
        
        System.out.println("FloydWarshall");
        printSP(distFloyd);
        
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
                if(dist[i][j] == Integer.MAX_VALUE || dist[i][j] == 999999999){System.out.print("Inf.\t\t"); continue;}
                System.out.print(dist[i][j] + "\t\t");
            }
            System.out.println("\n");
        }
    }
}
