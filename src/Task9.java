import java.util.ArrayList;

public class Task9 extends CrypthText {
    private int a;
    private int c;
    private int initial;

    public Task9(int a, int c, int initial, ArrayList<String> sourceText, boolean encode) {
        super("", sourceText, encode);
        this.a = a;
        this.c = c;
        this.initial = initial;
        generateKey();
        createResultText();
        StringBuilder tmp = new StringBuilder();
        for (String currentSource : resultText) {
            tmp.append(currentSource.toLowerCase());
        }
        this.sourceText = tmp.toString();
        createResultText();
    }

    @Override
    protected void createResultText() {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < sourceText.length(); i++) {
            int indexAppend = alphabet.indexOf(sourceText.charAt(i)) ^ alphabet.indexOf(this.key.charAt(i));
            answer.append(alphabet.charAt(indexAppend));
        }
        resultText.add(answer.toString());
    }

    private void generateKey() {
        StringBuilder currentKey = new StringBuilder();
        currentKey.append(this.initial);
        for (int i = 0; i < sourceText.length(); i++) {
            int index = (this.a * alphabet.indexOf(currentKey.charAt(i)) + this.c) % alphabet.length();
            currentKey.append(alphabet.charAt(index));
        }
        this.key = currentKey.toString();
    }
}
