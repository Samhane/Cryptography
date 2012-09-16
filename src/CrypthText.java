import java.util.ArrayList;

public abstract class CrypthText {
    protected String key;
    protected String sourceText;
    protected ArrayList<String> resultText;
    protected String alphabet;
    protected boolean encode;

    protected CrypthText() {
    }

    public ArrayList<String> getResultText() {
        return resultText;
    }

    protected abstract void createResultText();

    protected void generateAlphavet() {
        StringBuilder alp = new StringBuilder();
        //формируем алфавит из русских символов
        for (int i = 1072; i < 1104; i++) {
            alp.append((char) i);
        }
        //добавляем еще символы
        for (int i = 32; i < 64; i++) {
            alp.append((char) i);
        }
        this.alphabet = alp.toString();
    }
}
