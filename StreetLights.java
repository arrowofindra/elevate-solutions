import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class StreetLights {
    static int illuminatedStreetLength(ArrayList<ArrayList<Integer>> list, int n) {
        HashSet<Integer> coOrdinateSet = new HashSet<>(); //store co-ordinates in HashSet to avoid same co-ordinate values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                coOrdinateSet.add(list.get(i).get(j));
            }
        }
        //return the difference between max value to min value of the HashSet to get the illuminated street length
        return Collections.max(coOrdinateSet) - Collections.min(coOrdinateSet);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> coOrdinates = new ArrayList<>();
        int streetLightCount = sc.nextInt();
        for (int i = 0; i < streetLightCount; i++) {
            coOrdinates.add(new ArrayList<>());
            for (int j = 0; j < 2; j++) {
                int readValue = sc.nextInt();
                coOrdinates.get(i).add(j, readValue);
            }
        }
        int streetLength = illuminatedStreetLength(coOrdinates, streetLightCount);
        System.out.println(streetLength);
    }
}

/*
* DRY RUN:
* input: 2
*        (5, 10), (8, 12)
* HashSet values: 5 8 10 12
*                 max: 12, min: 5
* output: 12 - 5 = 7
* */