import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Task7 extends CrypthText {
    private double precision = 1000;
    private Map<Character, Integer> frequency;
    private int lengthText;

    public Task7(String key, ArrayList<String> sourceText, boolean encode) {
        super(key, sourceText, encode);
        frequency = new HashMap<Character, Integer>();
        this.lengthText = this.sourceText.length();
        for (int i = 0; i < alphabet.length(); i++) {
            frequency.put(alphabet.charAt(i), 0);
        }
        createResultText();
    }

    @Override
    protected void createResultText() {
        for (int i = 0; i < sourceText.length(); i++) {
            if (frequency.containsKey(sourceText.charAt(i))) {
                frequency.put(sourceText.charAt(i), frequency.get(sourceText.charAt(i)) + 1);
            } else {
                System.out.println("Нет символа " + sourceText.charAt(i) + " !!!!!");
            }
        }
        TreeMap<Double, Character> weight = new TreeMap<Double, Character>();
        for (Character key : this.frequency.keySet()) {
            double currentValue = this.frequency.get(key) / (double) this.lengthText;
            weight.put(Math.round(currentValue * precision) / precision, key);
        }
        StringBuilder tmp = new StringBuilder();
        for (Double key : weight.descendingKeySet()) {
            tmp.append(weight.get(key)).append(" => ").append(key).append('\n');
        }
        resultText.add(tmp.toString());
    }
}
