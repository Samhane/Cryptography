import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Task7 extends CrypthText {
    private double precision;
    private Map<Character, Double> frequency;
    private int lengthText;

    public Task7(String key, ArrayList<String> sourceText, boolean encode) {
        super(key, sourceText, encode);
        this.alphabet = this.alphabet.substring(0, 31);
        precision = 1000;
        frequency = new HashMap<Character, Double>();
        this.lengthText = 0;
        for (int i = 0; i < alphabet.length(); i++) {
            frequency.put(alphabet.charAt(i), 0.0);
        }
        createResultText();
    }

    @Override
    protected void createResultText() {
        for (int i = 0; i < sourceText.length(); i++) {
            if (frequency.containsKey(sourceText.charAt(i))) {
                frequency.put(sourceText.charAt(i), frequency.get(sourceText.charAt(i)) + 1);
                this.lengthText++;
            } else {
                System.out.println("Нет символа " + sourceText.charAt(i));
            }
        }

        for (Character key : frequency.keySet()) {
            double current = frequency.get(key);
            if (current != 0.0) {
                current = current / (double) this.lengthText;
                resultText.add(key + " => " + (Math.round(current * precision) / precision));
            }
        }
        Collections.sort(resultText);
    }
}
