import java.util.ArrayList;
import java.util.Collections;

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
        ArrayList<Character> allNumber = new ArrayList<Character>();
        for (int i = 0; i < this.number.length(); i++) {
            allNumber.add(this.number.charAt(i));
        }
        Collections.sort(allNumber);
        StringBuilder answer = new StringBuilder();
        int indexNumber = 0;
        for (Character current : allNumber) {
            if (current != this.number.charAt(indexNumber++)) {
                answer.append(current);
            } else {
                //TODO ставить сюда другие цифры
                //и еще непонятно, как обрабатывать цифры типа 777
            }
        }
        System.out.println(answer);
        System.out.println(allNumber);
    }

    public ArrayList<String> getResultText() {
        return result;
    }
}
