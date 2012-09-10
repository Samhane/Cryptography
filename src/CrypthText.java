/**
 * Created with IntelliJ IDEA.
 * User: samhane
 * Date: 10.09.12
 * Time: 18:44
 * To change this template use File | Settings | File Templates.
 */
public class CrypthText {
    private String key;
    private String textToCrypth;
    private String secretText;
    private StringBuilder alphabet;
    private char[][] square;

    public void setKey(String key) throws Exception {
        if (key.length() > 36) {
            throw new Exception("Слишком длинный ключ");
        }
        this.key = key;
    }

    public void setTextToCrypth(String textToCrypth) {
        this.textToCrypth = textToCrypth;
    }

    public String crypth() {
        String result = "";
        generateAlphavet();


        String alph = alphavit.toString();
        for (int k = 0; k < alph.length(); k++) {
            result[i][j++] = alph.charAt(k);
            if (j == size || j > size) {
                j = 0;
                i++;
            }
        }
        for (int k = i; k < result.length; k++) {
            for (int l = j; l < result[i].length; l++) {
                result[i][j] = ' ';
            }
        }

        return result;
    }

    private void generateAlphavet() {
        for (int i = 1072; i < 1103; i++) {
            this.alphabet.append((char) i);
        }
    }

    private void createSquare() {
        int size = 6;
        this.square = new char[size][size];
        int i = 0, j = 0;
        for (int l = 0; l < key.length(); l++) {
            this.square[i][j++] = key.charAt(l);
            if (j == size) {
                j = 0;
                i++;
            }
            //удалить из алфавита уже занятые ключом символы
            this.alphabet.deleteCharAt(this.alphabet.indexOf(String.valueOf(this.key.charAt(l))));
        }
    }

    private void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static String[] getBlocksByTwoChar(String str) {
        return str.split("(?<=\\G.{2})");
    }
}
