import java.util.ArrayList;
import java.util.Random;

public class Task11 extends CrypthText {
    private StringBuilder workingKey;
    private int firstSymbol;

    public Task11(String key, ArrayList<String> source, boolean encode) {
        super(key, source, encode);
        workingKey = new StringBuilder();
        firstSymbol = getRandomBetween(0, key.length());
        createResultText();
    }

    @Override
    protected void createResultText() {
        StringBuilder result = new StringBuilder();
        workingKey.append(key.charAt(firstSymbol));
        int indexKey = 0;

        //шифровка
        for (int i = 0; i < sourceText.length(); i++) {
            int symbol1 = alphabet.indexOf(sourceText.charAt(i));
            int symbol2 = alphabet.indexOf(workingKey.charAt(indexKey++));
            int current = (symbol1 + symbol2) % alphabet.length();

            workingKey.append(alphabet.charAt(current));
            result.append(alphabet.charAt(current));
        }
        resultText.add(result.toString());
        resultText.add("-----");

        //дешифровка
        sourceText = result.toString();
        result = new StringBuilder();
        indexKey = 0;
        for (int i = 0; i < sourceText.length(); i++) {
            int symbol1 = alphabet.indexOf(sourceText.charAt(i));
            int symbol2 = alphabet.indexOf(workingKey.charAt(indexKey++));
            int current = (symbol1 - symbol2) % alphabet.length();
            current = current > 0 ? current : alphabet.length() + current;
            result.append(alphabet.charAt(current % alphabet.length()));
        }
        resultText.add(result.toString());
        resultText.add("----");
    }

    private static int getRandomBetween(int min, int max) {
        Random random = new Random();
        int res = random.nextInt(max);
        return res < min ? res + min : res;
    }
}
