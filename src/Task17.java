import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class Task17 {
    private String number;
    private ArrayList<String> result;

    public Task17(ArrayList<String> number) {
        result = new ArrayList<String>();
        StringBuilder tmp = new StringBuilder();
        for (String current : number) {
            tmp.append(current);
        }
        this.number = tmp.toString();
        createAnagram();
    }

    private void createAnagram() {
        //TODO что делать с числами < 10 ?
        //TODO что делать с числами типа 777 ?
        ArrayList<Character> allNumber = new ArrayList<Character>();
        for (int i = 0; i < this.number.length(); i++) {
            allNumber.add(this.number.charAt(i));
        }
        Collections.sort(allNumber);

        StringBuilder answer = new StringBuilder();
        int indexNumber = 0;
        Deque<Character> dequeWithNumbers = new ArrayDeque<Character>();
        dequeWithNumbers.addAll(allNumber);

        while (!dequeWithNumbers.isEmpty() && indexNumber < this.number.length()) {
            Character first = dequeWithNumbers.getFirst();
            if (first != this.number.charAt(indexNumber)) {
                indexNumber++;
                answer.append(first);
                dequeWithNumbers.removeFirst();
            } else {
                dequeWithNumbers.removeFirst();
                Character tmp = dequeWithNumbers.removeFirst();
                dequeWithNumbers.addFirst(first);
                dequeWithNumbers.addFirst(tmp);
            }
        }

        result.add(number);
        result.add(answer.toString());
    }

    public ArrayList<String> getResultText() {
        return result;
    }
}
