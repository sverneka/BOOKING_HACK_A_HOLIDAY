import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class SolutionWeekendAway1 {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT.
         * Your class should be named Solution.
         */
        Scanner in = new Scanner(System.in);
        int t = Integer.valueOf(in.nextLine());
        for (int a0 = 0; a0 < t; a0++) {
            String[] str = in.nextLine().split(" ");
            int n = Integer.valueOf(str[0]);
            int m = Integer.valueOf(str[1]);
            // route adjacency matrix construction
            String[] strList = null;
            Map<Integer, int[]> minRouteMatrix = new HashMap<Integer, int[]>(n);
            int from=0;
            int to=0;
            int dist=0;
            for (int i = 0; i < m; i++) {
                strList = (in.nextLine()).split(" ");
                from=Integer.valueOf(strList[0]) ;
                to=Integer.valueOf(strList[1]) ;
                dist=Integer.valueOf(strList[2]);
                if(minRouteMatrix.get(from) != null) {
                            if(dist < minRouteMatrix.get(from)[0]) {
                                if(minRouteMatrix.get(from)[0]<minRouteMatrix.get(from)[2]) {
                                    minRouteMatrix.get(from)[1]=minRouteMatrix.get(from)[0];
                                }
                                minRouteMatrix.get(from)[0] = dist;
                            } else if(dist < minRouteMatrix.get(from)[1]) {
                                minRouteMatrix.get(from)[1] = dist;
                            }
                            minRouteMatrix.get(from)[2] = minRouteMatrix.get(from)[0]+minRouteMatrix.get(from)[1];
                } else {
                    minRouteMatrix.put(from, new int[]{dist,1000,dist+1000});
                }
                if(minRouteMatrix.get(to) != null) {
                    if(dist < minRouteMatrix.get(to)[0]) {
                        if(minRouteMatrix.get(to)[0]<minRouteMatrix.get(to)[2]) {
                            minRouteMatrix.get(to)[1]=minRouteMatrix.get(to)[0];
                        }
                        minRouteMatrix.get(to)[0] = dist;
                    } else if(dist < minRouteMatrix.get(to)[1]) {
                        minRouteMatrix.get(to)[1] = dist;
                    }
                    minRouteMatrix.get(to)[2] = minRouteMatrix.get(to)[0]+minRouteMatrix.get(to)[1];
                } else {
                    minRouteMatrix.put(to, new int[]{dist,1000,dist+1000});
                }
            }
            int globalMinDist = 200;
            for (int key : minRouteMatrix.keySet()) {
                if(minRouteMatrix.get(key)[2] < globalMinDist) {
                    globalMinDist = minRouteMatrix.get(key)[2];
                }
            }
            System.out.println(globalMinDist);
        }
    }
    private static void populateRouteMatrix(int[][] routeMatrix) {
        routeMatrix[0][1] = 2;
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
        routeMatrix[3][2] =1;
        
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
        
        
       /* routeMatrix[0][1] =1;
        routeMatrix[1][0] =1;
        routeMatrix[2][0] = 1;
        routeMatrix[0][2] = 1;
        routeMatrix[1][4] = 3;
        routeMatrix[4][1] = 3;
        routeMatrix[2][4] = 3;
        routeMatrix[4][2] = 3;
        routeMatrix[2][3] = 6;
        routeMatrix[3][2] = 6;*/
    }
}