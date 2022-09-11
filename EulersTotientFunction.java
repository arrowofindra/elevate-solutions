import java.util.Scanner;

public class EulersTotientFunction {
    static int calculateGCD(int a, int b) {
        if (b == 0)
            return a;
        return calculateGCD(b, a % b);
    }
    static int eulersTotientFunction(int n) {
        int count = 1;
        for (int i = 2; i < n; i++) {
            if (calculateGCD(i, n) == 1)
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        int numCount = eulersTotientFunction(value);
        System.out.println(numCount);
    }
}
