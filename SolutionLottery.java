import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class SolutionLottery {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT.
         * Your class should be named Solution.
         */
        Scanner in = new Scanner(System.in);
        String str[] = in.nextLine().split(" ");
        int T=Integer.valueOf(str[0]);
        int H=Integer.valueOf(str[1]);
        Map<Integer,Map<Integer,Integer>> htMap = new HashMap<Integer, Map<Integer,Integer>>();
        int n;
        int h;
        int[] hotelTicket = new int[H];
        Integer[] hotelRank = new Integer[H];
        for(int i=0;i<H;i++) {
            hotelRank[i] = i;
            Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
            htMap.put(i, tempMap);
        }
        Map<Integer,Integer> availableTMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < T; i++) {
            availableTMap.put(i, i);
            str = in.nextLine().split(" ");
            n=Integer.valueOf(str[0]);
            for(int j=1;j<=n;j++) {
                h=Integer.valueOf(str[j])-1;
                htMap.get(h).put(i,i); 
                hotelTicket[h] += 1;
            }
        }
        Comparator<Integer> gc = new GradeComparatorReverse(hotelTicket);
        Arrays.sort(hotelRank, gc);
        List<Integer> hotelRankList = new ArrayList<Integer>(Arrays.asList(hotelRank));
        int hotelSize = H;
        Map<Integer,Integer> tMap=null;
        int paidHotel = 0;
        while(hotelSize>0) {
            //hotel with least tickets
            int hotel = hotelRankList.get(0);
            if(hotelTicket[hotel] > 0) {
            tMap = htMap.get(hotel);
            Integer ticket= tMap.keySet().iterator().next();
            for(int key : htMap.keySet()) {
                if(htMap.get(key).containsKey(ticket)) {
                    htMap.get(key).remove(ticket);
                    hotelTicket[key] -= 1;
                }
            }
            availableTMap.remove(ticket);
            hotelSize--;
            if(availableTMap.isEmpty()) {
                paidHotel += hotelSize;
                break;
            }
            } else {
                paidHotel++;
                hotelSize--;
            }
            hotelRankList.remove(0);
            Integer[] tempArray = new Integer[hotelRankList.size()];
            for(int k=0;k<tempArray.length;k++) {
                tempArray[k] = hotelRankList.get(k);
            }
            Arrays.sort(tempArray, gc);
            hotelRankList = new ArrayList<Integer>(Arrays.asList(hotelRank));
            htMap.remove(hotel);
        }
        System.out.println(paidHotel);
    }
}
class GradeComparatorReverse implements Comparator<Integer> {
    private int[] grades;

    public GradeComparatorReverse(int[] priceArr) {
        grades = priceArr;
    }

    public int compare(Integer i, Integer j) {
        return Integer.compare(grades[i], grades[j]);
    }
}