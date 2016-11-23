import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SolutionGroupBooking {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT.
         * Your class should be named Solution.
         */
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int f = Integer.valueOf(str[0]);
        int r = Integer.valueOf(str[1]);
        int a=1000000;
        List<Integer> bList = new ArrayList<Integer>();
        str = in.nextLine().split(" ");
        for (int i = 0; i < f; i++) {
            bList.add(Integer.valueOf(str[i]));
        }
        Collections.sort(bList);
        int[] capacityArr = new int[r];
        Integer[] capacityRank = new Integer[r];
        Map<Integer, int[]> roomMap = new HashMap<Integer, int[]>();
        int maxBudget = bList.get(bList.size() - 1);
        int price;
        int ind = 0;
        for (int i = 0; i < r; i++) {
            str = in.nextLine().split(" ");
            price = Integer.valueOf(str[0]);
            if (price <= maxBudget) {
                capacityArr[ind] = Integer.valueOf(str[1]);
                roomMap.put(ind, new int[] { price, capacityArr[ind] });
                capacityRank[ind] = ind;
                ind++;
            }
        }
        capacityArr = Arrays.copyOfRange(capacityArr, 0, ind);
        capacityRank = Arrays.copyOfRange(capacityRank, 0, ind);
        List<Integer> capacityRankList = null;
        Comparator<Integer> gc = new GradeComparator(capacityArr);
        Arrays.sort(capacityRank, gc);
        capacityRankList = new ArrayList<Integer>(Arrays.asList(capacityRank));

        int budget;
        int noOfRooms = 0;
        int size = bList.size();
        while (size > 0) {
            budget = bList.get(0);
            int capacity = -1;
            int index = -1;
            for (int i = 0; i < capacityRankList.size(); i++) {
                int[] pc = roomMap.get(capacityRankList.get(i));
                if (pc[0] <= budget) {
                    index = i;
                    capacity = pc[1];
                    break;
                }
            }
            if(capacity == -1) {
                break;
            }
            for (int i = 0; i < capacity; i++) {
                if (size > 0) {
                    bList.remove(0);
                    size--;
                }
            }
            noOfRooms++;
            capacityRankList.remove(index);

        }
        System.out.println(noOfRooms);
    }
}

class GradeComparator implements Comparator<Integer> {
    private int[] grades;

    public GradeComparator(int[] priceArr) {
        grades = priceArr;
    }

    public int compare(Integer i, Integer j) {
        return Integer.compare(grades[j], grades[i]);
    }
}