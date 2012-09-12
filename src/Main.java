import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String inputFilename = "input.txt";
        String outputFilename = "output.txt";

        Scanner inputFile = new Scanner(new BufferedReader(new FileReader(inputFilename)));
        PrintWriter outFile = new PrintWriter(new File(outputFilename));
        Scanner in = new Scanner(System.in);

        System.out.println("Введите ключ");
        String key = in.nextLine().trim();

        System.out.println("Кодирование или декодирование? (1 или 0)");
        int encode = in.nextInt();

        String source = inputFile.nextLine().trim();
        CrypthText cryptho = new CrypthText(key, source, encode == 1);
        outFile.println(cryptho.getResultText());

        outFile.close();
        System.out.println("Проверьте выходной файл " + outputFilename);
    }
}
