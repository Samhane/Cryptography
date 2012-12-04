import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
        result.add(number + " -> " + getAnswer(allNumber, number) + "\n");
    }

    public String getAnswer(ArrayList<String> allNumber, String original) {
        String[] answer = new String[original.length()];
        boolean[] used = new boolean[original.length()];
        Arrays.fill(used, false);
        while (!allNumber.isEmpty()) {
            ArrayList<String> toRemove = new ArrayList<String>();
            ArrayList<String> toSave = new ArrayList<String>();
            for (String currentNumber : allNumber) {
                for (int i = 0; i < answer.length; i++) {
                    if (!currentNumber.equals(String.valueOf(original.charAt(i)))) {
                        if (!used[i]) {
                            answer[i] = currentNumber;
                            used[i] = true;
                            toRemove.add(currentNumber);
                            break;
                        }
                    }
                }
            }
            if (toRemove.isEmpty()) {
                for (String currentNumber : allNumber) {
                    for (int i = answer.length - 1; i >= 0; i--) {
                        if (!currentNumber.equals(String.valueOf(original.charAt(i)))
                                && !currentNumber.equals(answer[i])) {
                            String save = null;
                            if (answer[i] != null) {
                                save = answer[i];
                            }
                            answer[i] = currentNumber;
                            used[i] = true;
                            toRemove.add(currentNumber);
                            if (save != null) {
                                toSave.add(save);
                            }
                            break;
                        }
                    }
                }
                if (toSave.isEmpty() && toRemove.isEmpty()) {
                    answer = null;
                    break;
                } else {
                    if (!toSave.isEmpty()) {
                        allNumber.addAll(toSave);
                    }
                    if (!toRemove.isEmpty()) {
                        allNumber.removeAll(toRemove);
                    }
                }
            } else {
                for (String remove : toRemove) {
                    allNumber.remove(remove);
                }
            }

        }
        if (answer != null) {
            StringBuilder builder = new StringBuilder();
            for (String anAnswer : answer) {
                builder.append(anAnswer);
            }
            return builder.toString();
        }
        return "Нет анаграммы";
    }

    public ArrayList<String> getResultText() {
        return result;
    }
}