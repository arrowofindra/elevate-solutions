import java.util.ArrayList;
import java.util.Scanner;

public class Zombies {
    static int calculateGCD(int a, int b) {
        if (b == 0)
            return a;
        return calculateGCD(b, a % b);
    }
    static boolean checkCoPrime(int a, int b) {
        return calculateGCD(a, b) == 1;
    }
    static int findPerfectCityIndex(ArrayList<Integer> list, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (checkCoPrime(list.get(i), list.get(i+1)) && list.get(i) > list.get(i+1))
                return i; //return index if ith and (i+1)th element are co prime and list[i] > list[i+1]
        }
        return 0; //else return 0
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> zombiePercentage = new ArrayList<>();
        int cityCount = sc.nextInt();
        for (int i = 0; i < cityCount; i++) {
            int readValue = sc.nextInt();
            zombiePercentage.add(i, readValue);
        }
        int perfectCityIndex = findPerfectCityIndex(zombiePercentage, cityCount);
        System.out.println(perfectCityIndex);
    }
}
/*
 * DRY RUN:
 * input: 6
 *        1 1 3 6 7 3
 * list[5] and list[6] are co prime and list[5] > list[6]
 * output: 5
 * */