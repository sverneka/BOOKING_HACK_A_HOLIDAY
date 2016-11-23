import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class SolutionPalindromicSubstrings {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT.
         * Your class should be named Solution.
         */
        Scanner in = new Scanner(System.in);
        int t = Integer.valueOf(in.nextLine());
        Set<Character> aSet = null;
        for(int i=0;i<t;i++) {
            aSet = new HashSet<Character>();
            String str = in.nextLine();
           for(int j=0;j<str.length();j++) {
               aSet.add(str.charAt(j));
           }
           str = in.nextLine();
           boolean palindrome = false;
           for(int j=0;j<str.length();j++) {
               if(aSet.contains(str.charAt(j))) {
                   System.out.println("Yes");
                   palindrome = true;
                   break;
               }
           }
           if(!palindrome) {
               System.out.println("No");
           }
        }

    }
}