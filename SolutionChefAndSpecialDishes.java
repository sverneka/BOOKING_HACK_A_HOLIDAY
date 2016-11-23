import java.util.Scanner;

class SolutionChefAndSpecialDishes {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT.
         * Your class should be named Solution.
         */
        Scanner in = new Scanner(System.in);
        int t = Integer.valueOf(in.nextLine());
        char c;
        for (int a0 = 0; a0 < t; a0++) {
            StringBuilder str = new StringBuilder(in.nextLine());
            boolean isDoubleString = false;
            if(str.length() % 2 == 0) {
                if(str.substring(0, str.length()/2).equals(str.substring(str.length()/2))){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else if(str.length() == 1) {
                System.out.println("NO");
            }else {
                for(int i=0;i<str.length();i++) {
                    c = str.charAt(i);
                    str.deleteCharAt(i);
                    if(str.substring(0, str.length()/2).equals(str.substring(str.length()/2))){
                        System.out.println("YES");
                        isDoubleString = true;
                        break;
                    } else {
                        str.insert(i, c);
                        if(i<str.length()/2 && c!=str.charAt(i+str.length()/2) && c!=str.charAt(i+1+str.length()/2)) {
                            break;
                        }
                    }
                    
                }
                if(!isDoubleString) {
                    System.out.println("NO");
                }
            }
        }

    }
}