import java.util.ArrayList;

public class Task15 extends CrypthText {
    private String[] strings;

    public Task15(String key, ArrayList<String> source, boolean encode) {
        super(key, source, encode);
        this.strings = new String[2];
        createStrings();
        print(strings);
        for (String currentSource : source) {
            this.sourceText = currentSource;
            createResultText();
        }
    }

    protected void createResultText() {
        StringBuilder workSecret = new StringBuilder();
        for (int i = 0; i < sourceText.length(); i++) {
            if (encode) {
                workSecret.append(this.strings[1].charAt(this.strings[0].indexOf(sourceText.charAt(i))));
            } else {
                workSecret.append(this.strings[0].charAt(this.strings[1].indexOf(sourceText.charAt(i))));
            }
        }
        resultText.add(workSecret.toString());
    }

    private void createStrings() {
        this.strings[0] = this.alphabet;
        this.strings[1] = "";
        StringBuilder twoRow = new StringBuilder();

        for (int i = 0; i < key.length(); i++) {
            if (!strings[1].contains(String.valueOf(key.charAt(i)))) {
                strings[1] = strings[1].concat(String.valueOf(key.charAt(i)));
            }
        }

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
