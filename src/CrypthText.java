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
    private String alphabet;
    private char[][] square;

    public void setKey(String key) throws Exception {
        this.key = key;
    }

    public void setTextToCrypth(String textToCrypth) {
        this.textToCrypth = textToCrypth;
    }

    public String crypth() {
        generateAlphavet();
        createSquare();
        print(square);
        return secretText;
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

    private void createSquare() {
        int size = 6;
        this.square = new char[size][size];
        int indexKey = 0;

        int i = 0;
        while (i < square.length) {
            int j = 0;
            while (j < square[i].length) {
                //добавляем в квадрат ключ
                if (key.length() > indexKey) {
                    if (!inSquare(key.charAt(indexKey))) {
                        square[i][j] = key.charAt(indexKey);
                        indexKey++;
                        j++;
                    } else {
                        indexKey++;
                    }
                } else {
                    //добавляем в квадрат остальные символы алфавита
                    int indexAlphavet = 0;
                    for (; i < square.length; i++, j = 0) {
                        while (j < square.length) {
                            if (!inSquare(alphabet.charAt(indexAlphavet))) {
                                square[i][j] = alphabet.charAt(indexAlphavet);
                                indexAlphavet++;
                                j++;
                            } else {
                                indexAlphavet++;
                            }
                        }
                    }
                    break;
                }
            }
            i++;
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

    private boolean inSquare(char symbol) {
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                if (square[i][j] == symbol) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String[] getBlocksByTwoChar(String str) {
        return str.split("(?<=\\G.{2})");
    }
}
