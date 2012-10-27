import java.util.ArrayList;
import java.util.Arrays;

public class Task3 extends CrypthText {
    private int k;
    private int l;
    private char[][] table;
    private int[] indexesInAlphavetOrder;

    public Task3(int k, String key, ArrayList<String> source, boolean encode) {
        this.k = k;
        this.key = deleteSameSymbols(key);
        this.l = this.key.length();
        indexesInAlphavetOrder = new int[this.l];
        this.encode = encode;
        this.resultText = new ArrayList<String>();
        generateAlphavet();
        createAlphavetOrderingIndex();
        StringBuilder tmp = new StringBuilder();
        for (String currentSource : source) {
            tmp.append(currentSource.trim());
        }
        this.sourceText = tmp.toString();
        createResultText();
    }

    @Override
    protected void createResultText() {
        StringBuilder workSecret = new StringBuilder();
        String[] blocks = getBlocks(this.sourceText, (this.k * this.l));
        if (this.encode) {
            for (int i = 0; i < blocks.length; i++) {
                workSecret.append(encode(blocks[i]));
            }
        } else {
            for (int i = 0; i < blocks.length; i++) {
                workSecret.append(decode(blocks[i]));
            }
        }

        resultText.add(workSecret.toString());
    }

    private String decode(String block) {
        int sizeTwo = block.length() / l;
        if (block.length() % l > 0) {
            sizeTwo++;
        }
        table = new char[sizeTwo][l];
        int indexBlock = 0;
        for (int i = 0; i < indexesInAlphavetOrder.length; i++) {
            for (int m = 0; m < table.length; m++) {
                if (block.length() > indexBlock) {
                    table[m][indexesInAlphavetOrder[i]] = block.charAt(indexBlock++);
                } else {
                    table[m][indexesInAlphavetOrder[i]] = '&';
                }
            }
        }
        print(table);

        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                tmp.append(table[i][j] == '&' ? "" : table[i][j]);
            }
        }
        return tmp.toString();
    }

    private String encode(String block) {
        int sizeTwo = block.length() / l;
        if (block.length() % l > 0) {
            sizeTwo++;
        }
        table = new char[sizeTwo][l];
        int indexBlock = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (block.length() > indexBlock) {
                    table[i][j] = block.charAt(indexBlock++);
                } else {
                    table[i][j] = '&';
                }
            }
        }
        print(table);

        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < indexesInAlphavetOrder.length; i++) {
            for (int j = 0; j < table.length; j++) {
                tmp.append(table[j][indexesInAlphavetOrder[i]]);
            }
        }
        return tmp.toString();
    }

    private void createAlphavetOrderingIndex() {
        char[] tmp = key.toCharArray();
        Arrays.sort(tmp);
        for (int i = 0; i < tmp.length; i++) {
            indexesInAlphavetOrder[i] = key.indexOf(tmp[i]);
        }
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
            for (int j = 0; j < anArr.length; j++) {
                System.out.print(anArr[j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < key.length(); i++) {
            System.out.print(key.charAt(i) + " ");
        }
        System.out.println();
        System.out.println("---------");
    }

    private String[] getBlocks(String str, int size) {
        return str.split("(?<=\\G.{" + size + "})");
    }
}
