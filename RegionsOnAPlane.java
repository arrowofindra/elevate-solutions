import java.util.Scanner;

public class RegionsOnAPlane {
    static int regionCount(int n) {
        /*
        * no. of lines = 1, no. regions, L(1) = 2
        * no. of lines = 2, no. regions, L(2) = 4
        * no. of lines = 3, no. regions, L(3) = 7 ...
        * So, L(2) - L(1) = 2
        *     L(3) - L(2) = 3
        *     L(4) - l(3) = 4
        * +   ...............
        * ---------------------
        * L(n) - L(n-1) + L(n-1) + .... - L(2) + L(2) - L(1) = 2 + 3 + 4 + .... + n
        * L(n) - L(1) = 2 + 3 + 4 + ... + n
        * L(n) = L(1) + 2 + 3 + 4 + ... + n
        * L(n) = 2 + 2 + 3 + 4 + ... + n
        * L(n) = 1 + 1 + 2 + 3 + 4 + ... + n = 1 + (n * (n + 1) / 2)
        * */
        return n * (n + 1) / 2 + 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lineCount = sc.nextInt();
        int regions = regionCount(lineCount);
        System.out.println(regions);
    }
}

/*
 * DRY RUN:
 * input: 4
 * output: (4 * (4 + 1)) / 2 + 1 = 11
 * */