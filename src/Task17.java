import java.util.ArrayList;
import java.util.Arrays;

public class Task17 {
    private ArrayList<String> result;

    public Task17(ArrayList<String> number) {
        result = new ArrayList<String>();
        for (String current : number) {
            createAnagram(current);
        }
    }

    private void createAnagram(String number) {
        int orNum = Integer.parseInt(number);
        int[] p = new int[number.length()];
        int i = p.length - 1;
        while (orNum > 0) {
            p[i--] = orNum % 10;
            orNum /= 10;
        }

        int[] original = Arrays.copyOf(p, p.length);

        boolean anagram = false;
        while (nextPermutation(p)) {
            if (checkNumber(original, p)) {
                anagram = true;
                break;
            }
        }
        if (anagram) {
            StringBuilder answer = new StringBuilder();
            for (int aP : p) {
                answer.append(aP);
            }
            result.add(number + "\n" + answer.toString() + "\n");
        } else {
            result.add(number + " -> " + "Нет анаграммы");
        }
    }

    public ArrayList<String> getResultText() {
        return result;
    }

    public boolean nextPermutation(int[] p) {
        for (int a = p.length - 2; a >= 0; --a)
            if (p[a] < p[a + 1])
                for (int b = p.length - 1; ; --b)
                    if (p[b] > p[a]) {
                        int t = p[a];
                        p[a] = p[b];
                        p[b] = t;
                        for (++a, b = p.length - 1; a < b; ++a, --b) {
                            t = p[a];
                            p[a] = p[b];
                            p[b] = t;
                        }
                        return true;
                    }
        return false;
    }

    private boolean checkNumber(int[] original, int[] current) {
        for (int i = 0; i < original.length; i++) {
            if (original[i] == current[i]) {
                return false;
            }
        }
        return true;
    }
}
