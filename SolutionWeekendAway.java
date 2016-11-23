import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class SolutionWeekendAway {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT.
         * Your class should be named Solution.
         */
        //Scanner in = new Scanner(System.in);
        //int t = Integer.valueOf(in.nextLine());
        int t=1;
        for (int a0 = 0; a0 < t; a0++) {
           // String[] str = in.nextLine().split(" ");
            //int n = Integer.valueOf(str[0]);
            //int m = Integer.valueOf(str[1]);
            // route adjacency matrix construction
            int n=5,m=5;
            int[][] routeMatrix = new int[n][n];
            populateRouteMatrix(routeMatrix);
            String[] strList = null;
            /*for (int i = 0; i < m; i++) {
                strList = (in.nextLine()).split(" ");
                routeMatrix[Integer.valueOf(strList[0]) - 1][Integer.valueOf(strList[1]) - 1] =
                        Integer.valueOf(strList[2]);
                routeMatrix[Integer.valueOf(strList[1]) - 1][Integer.valueOf(strList[0]) - 1] =
                        Integer.valueOf(strList[2]);
            }*/

            for (int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(routeMatrix[i][j] == 0) {
                        routeMatrix[i][j] = 1000;
                    }
                }
            }
            int globalMinDist = 500;
            int maxPossibleDistance = 200;
            for (int i = 0; i < n; i++) {
                int dist=0;
                for (int j = 0; j < n; j++) {
                    dist = 0;
                    if (j == i) {
                        continue;
                    } else {
                        if(routeMatrix[i][j] > maxPossibleDistance) {
                            continue;
                        }
                        dist = routeMatrix[i][j] + findMin(j,i, routeMatrix,n);
                        if(dist > maxPossibleDistance || dist > globalMinDist) {
                            continue;
                        }
                        if(dist < globalMinDist) {
                        globalMinDist = dist;
                        }
                    }
                }
                /*int minBackDist = 500;
                int minBackDistNode = -1;
                for (int j=0;j<n;j++) {
                    dist = 2*routeMatrix[i][j];
                    if(dist > globalMinDist || dist > maxPossibleDistance) {
                        continue;
                    } else {
                        if(dist < minBackDist) {
                            minBackDistNode = j;
                            minBackDist = dist;
                        }
                    }
                    
                }
                if(minBackDist < globalMinDist) {
                    for(int j=0;j<n;j++) {
                        dist = 0;
                        if(j==minBackDistNode) {
                            continue;
                        } else {
                            dist = minBackDist + routeMatrix[i][j];
                            if(dist < globalMinDist) {
                                globalMinDist = dist;
                            }
                        }
                    }
                }*/
            }   
            System.out.println(globalMinDist);
        }
    }
    private static void populateRouteMatrix(int[][] routeMatrix) {
        /*routeMatrix[0][1] = 2;
        routeMatrix[1][0] = 2;
        
        routeMatrix[0][2] = 4;
        routeMatrix[2][0] = 4;
        
        routeMatrix[0][3] = 8;
        routeMatrix[3][0] = 8;
        
        routeMatrix[1][2] = 3;
        routeMatrix[2][1] = 3;
        
        routeMatrix[1][3] = 3;
        routeMatrix[3][1] = 3;
        
        routeMatrix[2][3] =1;
        routeMatrix[3][2] =1;*/
        
        /*routeMatrix[0][1] =1;
        routeMatrix[1][0] =1;
        routeMatrix[2][0] = 2;
        routeMatrix[0][2] = 2;
        routeMatrix[1][4] = 2;
        routeMatrix[4][1] = 2;
        routeMatrix[2][4] = 3;
        routeMatrix[4][2] = 3;
        routeMatrix[2][3] = 1;
        routeMatrix[3][2] = 1;*/
        
        
        routeMatrix[0][1] =1;
        routeMatrix[1][0] =1;
        routeMatrix[2][0] = 1;
        routeMatrix[0][2] = 1;
        routeMatrix[1][4] = 3;
        routeMatrix[4][1] = 3;
        routeMatrix[2][4] = 3;
        routeMatrix[4][2] = 3;
        routeMatrix[2][3] = 6;
        routeMatrix[3][2] = 6;
    }
    private static int findMin(int node,int k, int[][] routeMatrix, int n ) {
        int minDist = 200;
        for(int i=0;i<n;i++){
            if(k==i) {
                continue;
            }
            if(routeMatrix[node][i] < minDist) {
                minDist = routeMatrix[node][i];
            }
        }
        return minDist;
    }
}