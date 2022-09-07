import java.util.Scanner;

public class CharlesAndTheNecklace {
    static int factorial(int n) {
        return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);
    }
    static int necklaceCount(int n, int min, int max) {
        int coEfficientCount = max - min + 1;
        /*
         * pearlCount = r, coEfficientCount = n, necklaceCount = c
         * nCr + nC(r-1) = (n+1)Cr
         * r = 1, n = 2, c = 2C1
         * r = 2, n = 2, c = 2C2 + 2C1 + 2C1 = 3C2 + 2C1
         * r = 1, n = 3, c = 3C1
         * r = 2, n = 3, c = 3C2 + 3C1 + 3C1 = 4C2 + 3C1
         * r = 3, n = 3, c = 3C3 + 3C2 + 3C1 + 3C2 + 3C1 + 3C1 = 5C3 + 2. 3C1
         * .....
         * r = r, n = n, c = nCr + 2. nC(r-1) + ... + (r-1). nC2 + r. nC1 = (n+r-1)Cr + (r-1). nC1
         * */
        return factorial(coEfficientCount + n - 1) / (factorial(n) * factorial(coEfficientCount - 1)) + (coEfficientCount * (n - 1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pearlCount = sc.nextInt();
        int minCoEfficientValue = sc.nextInt();
        int maxCoEfficientValue = sc.nextInt();
        int count = necklaceCount(pearlCount, minCoEfficientValue, maxCoEfficientValue);
        System.out.println(count);
    }
}

/*
 * DRY RUN:
 * input: 2
 *        9
 *        8
 * output: n = 9 - 8 + 1 = 2, r = 2
 *        factorial(2 + 2 - 1)/ factorial(2) * factorial(2 - 1) = 3
 *        necklaceCount = 3 + (2 - 1) * 2 = 5
 * */