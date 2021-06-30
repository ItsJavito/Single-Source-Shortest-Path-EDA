/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packet.algorithms;

/**
 *
 * @author Javier Olazábal
 */
public class FloydWarshall 
{

    public FloydWarshall() {
    }
    
    public int[][] algorithm(int[][] AdMatrix)
    {
        //AdMatrix tiene v+1 indices donde el max indice es v 
        int v = AdMatrix.length - 1;
        int dist[][] = new int[v+1][v+1];
        
        for(int i = 1; i <= v ; i++){
            for(int j = 1; j <= v; j++){
                dist[i][j] = AdMatrix[i][j];
            }
        }
        
        
        for (int k = 1; k <= v; k++)
        {
            for (int i = 1; i <= v; i++)
            {
                for (int j = 1; j <= v; j++)
                {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        
        return dist;
    }
}
