import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Fishes {
    static void satiateHunger(ArrayList<ArrayList<Integer>> list, int n, int m, int q){
        HashMap<Integer, Integer> fishIndexToSize = new HashMap<>();
        ArrayList<Integer> belongTo = new ArrayList<>();
        for (int i = 0; i < q; i++) {
           int methodIndex = list.get(i).get(0);
           if (methodIndex == 1) {
               if (!fishIndexToSize.containsKey(list.get(i).get(1)))
                   fishIndexToSize.put(list.get(i).get(1), 2);
               else
                   fishIndexToSize.put(list.get(i).get(1),fishIndexToSize.get(list.get(i).get(1)) + 1);
               belongTo.add(list.get(i).get(1));
           }
           else if (methodIndex == 2) {
               if (fishIndexToSize.get(list.get(i).get(1)) > fishIndexToSize.get(list.get(i).get(2)))
                   Collections.replaceAll(belongTo, list.get(i).get(2), list.get(i).get(1));
               else
                   Collections.replaceAll(belongTo, list.get(i).get(1), list.get(i).get(2));
           }
        }
        for (Integer integer : belongTo) {
            System.out.print(integer + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> methodsToSatiateHunger = new ArrayList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int queryCount = sc.nextInt();
        for (int i = 0; i < queryCount; i++) {
            methodsToSatiateHunger.add(new ArrayList<>());
            for (int j = 0; j < 3; j++) {
                int readValue = sc.nextInt();
                methodsToSatiateHunger.get(i).add(j,readValue);
            }
        }
        satiateHunger(methodsToSatiateHunger, n, m, queryCount);
    }
}
