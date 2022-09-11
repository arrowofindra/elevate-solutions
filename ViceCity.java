import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class ViceCity {
    static ArrayList<Integer> nextPositions(int pos, int endPos) {
        ArrayList<Integer> nextPos = new ArrayList<>();
        nextPos.add(pos + 1);
        nextPos.add((pos + endPos/2) % endPos);
        return nextPos;
    }
    static int countSequences(int startPos, int endPos) {
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> yetToVisit = new Stack<>();
        int sequence = 0;
        int tempPos = startPos;
        do {
            ArrayList<Integer> nextPos = nextPositions(tempPos, endPos);
            tempPos = nextPos.get(0);
            if (!visited.contains(nextPos.get(1)))
                yetToVisit.add(nextPos.get(1));
            if (tempPos != endPos && !visited.contains(tempPos))
                visited.add(tempPos);
            else if(tempPos == endPos) {
                sequence++;
                tempPos = yetToVisit.pop();
            }
            else
                tempPos = yetToVisit.pop();
        } while (!yetToVisit.isEmpty());
        return sequence;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int policePos = sc.nextInt();
        int thiefPos = sc.nextInt();
        int count = countSequences(policePos, thiefPos);
        System.out.println(count);
    }
}
