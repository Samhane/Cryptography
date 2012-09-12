/**
 * Created with IntelliJ IDEA.
 * User: samhane
 * Date: 10.09.12
 * Time: 18:44
 * To change this template use File | Settings | File Templates.
 */
public class CrypthText {
    private String key;

    public String getSourceText() {
        return sourceText;
    }

    public String getSecretText() {
        return secretText;
    }

    private String sourceText;
    private String secretText;
    private String alphabet;
    private char[][] square;

    public void setKey(String key) throws Exception {
        this.key = key;
    }

    public void setSourceText(String sourceText) {
        this.sourceText = sourceText;
    }

    public void crypth(boolean decode) {
        generateAlphavet();
        createSquare();
        //print(square);
        if (!decode) {
            createSecretText();
        } else {
            createSourceText();
        }
    }

    private void createSourceText() {
        String[] textToWork = getBlocksByTwoChar(sourceText);
        StringBuilder workSecret = new StringBuilder();

        for (String current : textToWork) {
            if (current.length() == 1) {
                //попался одиночный символ, нужно его дополнить чем нить, например пробелом
                current = current.concat(" ");
            }
            //смотрим как стоят два символа и кодируем их
            int[] positionFirst = getColumnAndRow(current.charAt(0));
            int[] positionTwo = getColumnAndRow(current.charAt(1));

            if (positionFirst[0] == positionTwo[0] || positionFirst[1] == positionTwo[1]) {
                //стоят в одной строке или столбце
                workSecret.append(appendFromIdenticalToDecode(positionFirst));
                workSecret.append(appendFromIdenticalToDecode(positionTwo));
            } else {
                workSecret.append(square[positionFirst[0]][positionTwo[1]]);
                workSecret.append(square[positionTwo[0]][positionFirst[1]]);
            }
        }

        sourceText = workSecret.toString();
    }

    private void createSecretText() {
        String[] textToWork = getBlocksByTwoChar(sourceText);
        StringBuilder workSecret = new StringBuilder();

        for (String current : textToWork) {
            if (current.length() == 1) {
                //попался одиночный символ, нужно его дополнить чем нить, например пробелом
                current = current.concat(" ");
            }
            //смотрим как стоят два символа и кодируем их
            int[] positionFirst = getColumnAndRow(current.charAt(0));
            int[] positionTwo = getColumnAndRow(current.charAt(1));

            if (positionFirst[0] == positionTwo[0] || positionFirst[1] == positionTwo[1]) {
                //стоят в одной строке или столбце
                workSecret.append(appendFromIdentical(positionFirst));
                workSecret.append(appendFromIdentical(positionTwo));
            } else {
                workSecret.append(square[positionFirst[0]][positionTwo[1]]);
                workSecret.append(square[positionTwo[0]][positionFirst[1]]);
            }
        }

        secretText = workSecret.toString();
    }

    private char appendFromIdentical(int[] position) {
        if ((position[1] + 1) < square.length) {
            return square[position[0]][position[1] + 1];
        } else {
            return square[position[0] + 1][0];
        }
    }

    private char appendFromIdenticalToDecode(int[] position) {
        if ((position[1] - 1) >= 0) {
            return square[position[0]][position[1] - 1];
        } else {
            return square[position[0] - 1][square.length - 1];
        }
    }

    private int[] getColumnAndRow(char symbol) {
        //получаем столбец и строку символа в квадрате
        //0 - столбец, 1 - строка
        int[] result = new int[2];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                if (square[i][j] == symbol) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return null;
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
