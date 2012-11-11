import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class Task17 {
    private ArrayList<String> result;

    public Task17(ArrayList<String> number) {
        result = new ArrayList<String>();
        for (String current : number) {
            createAnagram(current);
        }
    }

    private void createAnagram(String number) {
        ArrayList<String> allNumber = new ArrayList<String>();
        for (int i = 0; i < number.length(); i++) {
            allNumber.add(String.valueOf(number.charAt(i)));
        }
        Collections.sort(allNumber);

        Deque<String> answer = new ArrayDeque<String>();
        for (int i = 0; i < number.length(); i++) {
            String toRemove = null;
            for (String current : allNumber) {
                if (!current.equals(String.valueOf(number.charAt(i)))) {
                    answer.addLast(current);
                    toRemove = current;
                    break;
                }
            }

            if (toRemove != null) {
                allNumber.remove(toRemove);
            } else {
                //костыль, но работает
                if (allNumber.size() == 1 && i > 0 && !allNumber.get(0).equals(String.valueOf(number.charAt(i - 1)))) {
                    String tmp = answer.removeLast();
                    answer.addLast(allNumber.get(0));
                    allNumber.remove(0);
                    answer.addLast(tmp);
                } else {
                    answer.clear();
                    answer.addLast("Для данного числа не существет анаграммы");
                }
                break;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String current : answer) {
            builder.append(current);
        }
        result.add(number + " -> " + builder.toString());
    }

    public ArrayList<String> getResultText() {
        return result;
    }
}
