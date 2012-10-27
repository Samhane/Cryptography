import java.util.ArrayList;

public class Task1 extends CrypthText {
    private char[][] square;

    public Task1(String key, ArrayList<String> source, boolean encode) {
        this.key = key;
        this.encode = encode;
        this.resultText = new ArrayList<String>();
        generateAlphavet();
        createSquare();
        //print(square);
        for (String currentSource : source) {
            this.sourceText = currentSource;
            createResultText();
        }
    }

    protected void createResultText() {
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
                if (this.encode) {
                    workSecret.append(appendFromIdentical(positionFirst));
                    workSecret.append(appendFromIdentical(positionTwo));
                } else {
                    workSecret.append(appendFromIdenticalToDecode(positionFirst));
                    workSecret.append(appendFromIdenticalToDecode(positionTwo));
                }
            } else {
                workSecret.append(square[positionFirst[0]][positionTwo[1]]);
                workSecret.append(square[positionTwo[0]][positionFirst[1]]);
            }
        }

        resultText.add(workSecret.toString());
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

    private boolean inSquare(char symbol) {
        for (char[] aSquare : square) {
            for (int j = 0; j < square.length; j++) {
                if (aSquare[j] == symbol) {
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
