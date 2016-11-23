import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class SolutionHappinessScore {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT.
         * Your class should be named Solution.
         */
        Scanner in = new Scanner(System.in);
        int m = Integer.valueOf(in.nextLine());
        String[] str = in.nextLine().split(" ");
        Map<Integer,Integer> sumMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < m; i++) {
            Map<Integer, Integer> tempMap = new HashMap<Integer,Integer>();
            int num = Integer.valueOf(str[i]);
            for(int key:sumMap.keySet())  {
                tempMap.put(key+num, key+num);
            }
            sumMap.putAll(tempMap);
            sumMap.put(num, num);
        }
        long numOfPrimes = 0;
        for(int k : sumMap.keySet()) {
            if(isPrime(k)) {
                numOfPrimes++;
            }
        }
        System.out.println(numOfPrimes);
    }
    private static boolean isPrime(int n) {
        //check if n is a multiple of 2
        if(n==2) return true;
        if(n==1) return false;
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}