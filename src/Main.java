import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String inputFilename = "input.txt";
        String outputFilename = "output.txt";

        BufferedReader inputFile = new BufferedReader(new FileReader(inputFilename));
        PrintWriter outFile = new PrintWriter(new File(outputFilename));
        Scanner in = new Scanner(System.in);

        System.out.println("Введите ключ");
        String key = in.nextLine().trim().toLowerCase();

        System.out.println("Кодирование или декодирование? (1 или 0)");
        int encode = in.nextInt();

        StringBuilder stringBuilder = new StringBuilder();
        String tmp;
        while ((tmp = inputFile.readLine()) != null) {
            stringBuilder.append(tmp);
        }
        String source = stringBuilder.toString().toLowerCase();
        CrypthText cryptho = new CrypthText(key, source, encode == 1);
        outFile.println(cryptho.getResultText());

        outFile.close();
        System.out.println("Проверьте выходной файл " + outputFilename);
    }
}
