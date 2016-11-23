import java.util.Scanner;

class SolutionMaximizeTheSum {

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
            int k = Integer.valueOf(str[1]);
            String[] a = in.nextLine().split(" ");
            String[] b = in.nextLine().split(" ");
            long sum = 0L;
            long max = 0;
            long maxbi = 0;
            long ai;
            long bi;
            if (k == 0) {
                for (int i = 0; i < n; i++) {
                    sum += (Long.valueOf(a[i]) * Long.valueOf(b[i]));
                }
            } else {
                for (int i = 0; i < n; i++) {
                    ai = Long.valueOf(a[i]);
                    bi = Long.valueOf(b[i]);
                    if (Math.abs(bi) > max) {
                        max = Math.abs(bi);
                        maxbi = bi;
                    }
                    sum += (ai * bi);
                }
                long m = Math.abs(maxbi);
                sum += (k * m);
            }
            System.out.println(sum);
        }

    }
}