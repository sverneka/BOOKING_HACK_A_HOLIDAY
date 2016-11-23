import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class SolutionMilosDiary {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT.
         * Your class should be named Solution.
         */
        Scanner in = new Scanner(System.in);
        int m = Integer.valueOf(in.nextLine());
        String[] str = in.nextLine().split(" ");
        List<Long> backLogList = new ArrayList<Long>();
        long prevNum=0;
        if(m==1) {
            System.out.println("YES");
        } else {
        for (int i = 0; i < m; i++) {
            long num = Long.valueOf(str[i]);
            if(num>prevNum) {
                long j=prevNum;
                while(j+1<num) {
                    backLogList.add(j+1);
                    j++;
                }
                prevNum = num;
            } else if(num<prevNum) {
                if(!backLogList.isEmpty() && num==backLogList.get(backLogList.size()-1)) {
                    backLogList.remove(backLogList.size()-1);
                } else {
                    System.out.println("NO");
                    break;
                }
            } else {
                System.out.println("NO");
                break;
            }
            if(i==m-1) {
                System.out.println("YES");
            }
        }
    }
    }
}