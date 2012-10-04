import java.util.ArrayList;

public class Task3 extends CrypthText {
    private int k;
    private int l;
    private char[][] table;

    public Task3(int k, int l, String key, ArrayList<String> source, boolean encode) {
        this.k = k;
        this.l = l;
        this.key = deleteSameSymbols(key);
        this.encode = encode;
        this.resultText = new ArrayList<String>();
        table = new char[k][l];
        generateAlphavet();
        StringBuilder tmp = new StringBuilder();
        for (String currentSource : source) {
            tmp.append(currentSource.trim());
        }
        this.sourceText = tmp.toString();
        createResultText();
        print(table);
    }

    @Override
    protected void createResultText() {
        StringBuilder workSecret = new StringBuilder();
        String[] blocks = getBlocks(this.sourceText, (this.k * this.l));
        int indexSource = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = this.sourceText.charAt(indexSource++);
            }
        }
        resultText.add(workSecret.toString());
    }

    private String deleteSameSymbols(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (!result.contains(String.valueOf(str.charAt(i)))) {
                result = result.concat(String.valueOf(str.charAt(i)));
            }
        }
        return result;
    }

    private void print(char[][] arr) {
        for (char[] anArr : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(anArr[j] + " ");
            }
            System.out.println();
        }
    }

    private String[] getBlocks(String str, int size) {
        return str.split("(?<=\\G.{" + size + "})");
    }
}
