/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packet.graph;

import java.util.Arrays;

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
   
    public int v,e;
    public Edge edge[];
    public int AdMatrix[][];
    
    public Graph(int V, int E) {
        //numero de vertices 
        this.v = V;
        //numero de arcos
        this.e = E;
        edge = new Edge[E];
        //ingreso de datos
        for(int i = 0; i < e ; i++){
            //cambiar a ingreso por texto
            edge[i] = new Edge();
        }
    }
    public void GenerateAdMatrix(){
        
        AdMatrix = new int[v+1][v+1];
        for(int i = 0; i <= v ; ++i){
            for(int j = 0; j <= v ; ++j){
                if(i != j) AdMatrix[i][j] = 999999999;
                
            }
        }
        
        
        for(int i = 0; i < e ; i++){
            AdMatrix[edge[i].src][edge[i].dst] = edge[i].w;
        }
    }

    @Override
    public String toString() {
        String s = "Nodos: " + Integer.toString(v) + " Arcos: " + Integer.toString(e);
        s += '\n' + "Src\t" + "dst\t" + "w\n"; 
        for(int i = 0; i < e ; ++i){
            s += Integer.toString(edge[i].src) + '\t' + Integer.toString(edge[i].dst) + '\t' + Integer.toString(edge[i].w) + '\n';
        }
        return s;
    }
    
}
