import java.util.ArrayList;

public class Task13 extends CrypthText {
    private char[][] matrix;

    public Task13(ArrayList<String> source, boolean encode) {
        this.encode = encode;
        this.resultText = new ArrayList<String>();
        generateAlphavet();
        int sizeTwo = (int) Math.sqrt(alphabet.length());
        if (Math.sqrt(alphabet.length()) > 0) {
            sizeTwo++;
        }
        matrix = new char[(int) Math.sqrt(alphabet.length())][sizeTwo];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (index < alphabet.length()) {
                    matrix[i][j] = alphabet.charAt(index++);
                }
            }
        }
        print(matrix);
        StringBuilder tmp = new StringBuilder();
        for (String currentSource : source) {
            tmp.append(currentSource.trim());
        }
        this.sourceText = tmp.toString();
        createResultText();
    }

    @Override
    protected void createResultText() {
        StringBuilder tmp = new StringBuilder();
        if (this.encode) {
            for (int i = 0; i < sourceText.length(); i++) {
                int[] current = getIndexByChar(sourceText.charAt(i));
                tmp.append(current[0]).append(" ").append(current[1]).append(" ");
            }
        } else {
            String[] numbers = sourceText.split(" ");
            int index = 0;
            while (index < numbers.length) {
                int one = Integer.parseInt(numbers[index++]);
                int two = Integer.parseInt(numbers[index++]);
                tmp.append(matrix[one][two]);
            }
        }
        resultText.add(tmp.toString().trim());
    }

    private int[] getIndexByChar(char c) {
        int[] result = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == c) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
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
        System.out.println("---------");
    }
}
