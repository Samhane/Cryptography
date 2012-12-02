import java.util.ArrayList;
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
        result.add(number + " -> " + getAnswer(allNumber, number));
    }

    public String getAnswer(ArrayList<String> allNumber, String original) {
        String[] answer = new String[original.length()];
        boolean weWork = true;
        int used = 0;
        while (!allNumber.isEmpty() && weWork) {
            String toRemove = null;

            for (int i = used; i < original.length(); i++) {
                for (String currentInserting : allNumber) {
                    String tmp = String.valueOf(original.charAt(i));
                    if (!currentInserting.equals(tmp)) {
                        answer[i] = currentInserting;
                        toRemove = currentInserting;
                        used++;
                        break;
                    }
                }
                if (toRemove != null) {
                    allNumber.remove(toRemove);
                } else {
                    for (int j = answer.length - 1; j >= 0; j--) {
                        if (answer[i] != null) {
                            for (String insertTwo : allNumber) {
                                String tmp = String.valueOf(original.charAt(j));
                                if (!insertTwo.equals(tmp)) {
                                    String save = answer[j];
                                    answer[j] = insertTwo;
                                    toRemove = insertTwo;
                                    allNumber.add(save);
                                    used++;
                                    break;
                                }
                            }
                            if (toRemove != null) {
                                allNumber.remove(toRemove);
                                break;
                            } else {
                                weWork = false;
                            }
                        }
                    }
                    if (toRemove != null) {
                        allNumber.remove(toRemove);
                        break;
                    } else {
                        weWork = false;
                    }
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        if (!allNumber.isEmpty()) {
            builder.append("Нет анаграммы");
        } else {
            for (String anAnswer : answer) {
                if (anAnswer != null) {
                    builder.append(anAnswer);
                } else {
                    builder = new StringBuilder("Нет анаграммы");
                    break;
                }
            }
        }

        return builder.toString();
    }

    public ArrayList<String> getResultText() {
        return result;
    }
}