/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packet.algorithms;

import packet.graph.Graph;

/**
 *
 * @author Javier Olazábal
 */
public class BellmanFord 
{
    public BellmanFord() {
    }
    
    public int[] Algorithm(Graph grafo, int src)
    {
        //cantidad de vertices y arcos en el grafo
        int V = grafo.v;
        int e = grafo.e;
        //arreglo de distancias desde el nodo src a los demás nodos 
        int dist[] = new int[V+1];
        
        for(int i = 0; i<= V; i++){
            //Por definicion del algoritmo empezamos todos los nodos
            //en infinito
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        
        for (int i = 1; i <= V; i++)
        {
            for(int j = 0; j < e; j++){
                int u = grafo.edge[j].src;
                int v = grafo.edge[j].dst;
                int w = grafo.edge[j].w;
                if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
                {
                    dist[v] = dist[u] + w;
                }
            }
        }
        
        /*
        NO SE HA IMPLEMENTADO LA COMPROBACION DE CICLOS NEGATIVOS
        YA QUE NO ES NECESARIO PARA LA REALIZACION DEL PROYECTO
        */
        return dist;
    }
}   
