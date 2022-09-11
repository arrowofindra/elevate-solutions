import java.util.*;

public class MajorityElement {
    static int findMajorityElement(ArrayList<Integer> list, int n) {
        HashMap<Integer,Integer> elementFrequency = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!elementFrequency.containsKey(list.get(i)))
                elementFrequency.put(list.get(i), 1);
            else
                elementFrequency.put(list.get(i), elementFrequency.get(list.get(i)) + 1);
        }
        int majorityElement = Collections.max(elementFrequency.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        if (elementFrequency.get(majorityElement) > n/2)
            return majorityElement;
        else return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> elementList = new ArrayList<>();
        int numCount = sc.nextInt();
        for (int i = 0; i < numCount; i++) {
            int readValue = sc.nextInt();
            elementList.add(i, readValue);
        }
        int majorityElement = findMajorityElement(elementList, numCount);
        System.out.println(majorityElement);
    }
}
