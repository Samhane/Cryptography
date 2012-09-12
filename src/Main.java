import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: karyakinda
 * Date: 06.09.12
 * Time: 12:53
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите ключ");
        String key = in.nextLine().trim();
        //String key = "ключ";

        System.out.println("Кодирование или декодирование? (1 или 0)");
        int decode = in.nextInt();

        String inputFilename = "input.txt";
        String outputFilename = "output.txt";
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(inputFilename)));

        CrypthText cryptho = new CrypthText();
        cryptho.setKey(key);
        cryptho.setSourceText(scanner.nextLine());

        PrintWriter out = new PrintWriter(new File(outputFilename));

        if (decode == 1) {
            //выполняем кодирование
            cryptho.crypth(false);
            out.println(cryptho.getSecretText());
        } else if (decode == 0) {
            //выполняем декодирование
            cryptho.crypth(true);
            out.println(cryptho.getSourceText());
        } else {
            System.out.println("Введен неправльный режим (не кодирование и не декодирование)");
        }

        out.close();
        System.out.println("Проверьте выходной файл " + outputFilename);
    }
}
