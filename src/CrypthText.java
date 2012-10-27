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
}
