import java.util.ArrayList;

public abstract class CrypthText {
    protected String key;
    protected String sourceText;
    protected ArrayList<String> resultText;
    protected String alphabet;
    protected boolean encode;

    protected CrypthText() {
    }

    public CrypthText(String key, ArrayList<String> source, boolean encode) {
        this.key = key;
        this.encode = encode;
        this.resultText = new ArrayList<String>();
        StringBuilder tmp = new StringBuilder();
        for (String currentSource : source) {
            tmp.append(currentSource.toLowerCase());
        }
        this.sourceText = tmp.toString();
        generateAlphavet();
    }

    public ArrayList<String> getResultText() {
        return resultText;
    }

    protected abstract void createResultText();

    protected void generateAlphavet() {
        StringBuilder alp = new StringBuilder();
        //формируем алфавит из русских символов
        for (char ch = 'а'; ch <= 'я'; ch++) {
            alp.append(ch);
        }
        //добавляем цифры
        for (char ch = '0'; ch <= '9'; ch++) {
            alp.append(ch);
        }
        //добавляем еще символы: знаки препинания, скобки
        for (char ch = ' '; ch <= '/'; ch++) {
            alp.append(ch);
        }
        for (char ch = ':'; ch <= '?'; ch++) {
            alp.append(ch);
        }
        this.alphabet = alp.toString();
    }

    public void print(char[][] arr) {
        for (char[] anArr : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(anArr[j] + " ");
            }
            System.out.println();
        }
    }

    public String[] getBlocks(String str, int size) {
        return str.split("(?<=\\G.{" + size + "})");
    }

    public String deleteSameSymbols(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (!result.contains(String.valueOf(str.charAt(i)))) {
                result = result.concat(String.valueOf(str.charAt(i)));
            }
        }
        return result;
    }
}
