import java.io.BufferedReader;
import java.io.FileReader;
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
        //String key = in.nextLine().trim();
        String key = "ключ";

        String filename = "input.txt";
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)));

        CrypthText cryptho = new CrypthText();
        cryptho.setKey(key);
        cryptho.setTextToCrypth(scanner.nextLine());

        System.out.println(cryptho.crypth());
    }
}
