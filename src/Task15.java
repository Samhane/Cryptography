import java.util.ArrayList;

public class Task15 {
    private String key;
    private String sourceText;
    private ArrayList<String> resultText;
    private String alphabet;
    private String[] strings;
    private boolean encode;

    public ArrayList<String> getResultText() {
        return resultText;
    }

    public Task15(String key, ArrayList<String> source, boolean encode) {
        this.key = key;
        this.encode = encode;
        this.resultText = new ArrayList<String>();
        this.strings = new String[2];
        generateAlphavet();
        createStrings();
        print(strings);
        for (String currentSource : source) {
            this.sourceText = currentSource;
            createResultText();
        }
    }

    private void createResultText() {
        StringBuilder workSecret = new StringBuilder();
        resultText.add(workSecret.toString());
    }

    private void generateAlphavet() {
        StringBuilder alp = new StringBuilder();
        //формируем алфавит из русских символов
        for (int i = 1072; i < 1104; i++) {
            alp.append((char) i);
        }
        //добавляем еще символы
        for (int i = 32; i < 57; i++) {
            alp.append((char) i);
        }
        this.alphabet = alp.toString();
    }

    private void createStrings() {
        this.strings[0] = this.alphabet;
        StringBuilder twoRow = new StringBuilder();
        strings[1] = key;
        for (int i = 0; i < alphabet.length(); i++) {
            if (!strings[1].contains(String.valueOf(alphabet.charAt(i)))) {
                twoRow.append(alphabet.charAt(i));
            }
        }
        strings[1] = strings[1].concat(twoRow.toString());
    }

    private void print(String[] arr) {
        for (String anArr : arr) {
            System.out.println(anArr);
        }
    }
}
