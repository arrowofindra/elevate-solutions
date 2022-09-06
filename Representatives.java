import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Representatives {
    static void selectRepresentativeByMarks(ArrayList<Integer> list, int n, int k) {
        list.sort(Collections.reverseOrder()); //sort ArrayList in reverse order
        for (int i = k-1; i >= 0; i--) {
            System.out.print(list.get(i) + " "); //print first k elements
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> marks = new ArrayList<>();
        int studentCount = sc.nextInt();
        for (int i = 0; i < studentCount; i++) {
            int readValue = sc.nextInt();
            marks.add(i, readValue);
        }
        int representativeCount = sc.nextInt();
        selectRepresentativeByMarks(marks, studentCount, representativeCount);
    }
}

/*
* DRY RUN:
* input: 10
*        950 477 55 602 881 302 859 438 551 382
*        3
* reverse sorted list: 950 881 859 602 551 477 438 382 302 55
* output: 859 881 950
* */