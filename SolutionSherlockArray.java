import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class SolutionSherlockArray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = Integer.valueOf(in.nextLine());
        for(int a0 = 0; a0 < t; a0++){
            int n = Integer.valueOf(in.nextLine());
            String[] strList = (in.nextLine()).split(" ");
            List<Long> numList = new ArrayList<Long>();
            for (String s : strList) {
                numList.add(Long.valueOf(s));
            }
                    Long[] leftSumList = new Long[n];
        Long[] rightSumList = new Long[n];
        long leftSum=0;
        long rightSum=0;
        for(int i=0;i<n;i++) {
            leftSumList[i] = leftSum+numList.get(i);
            leftSum = leftSumList[i];
            rightSumList[n-i-1] = rightSum+numList.get(n-i-1);
            rightSum = rightSumList[n-i-1];
        }
        rightSum=0;
        leftSum=0;
        boolean isEqual = false;
        for(int i=0;i<n;i++) {
            if(i==0) {
                leftSum = 0;
                
            } else {
                leftSum = leftSumList[i-1];
            }
            if(i==n-1) {
                rightSum = 0;
            } else {
                rightSum = rightSumList[i+1];
            }
            if(leftSum == rightSum) {
                isEqual = true;
                break;
            }
        }
        if(isEqual) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        }

    }
}