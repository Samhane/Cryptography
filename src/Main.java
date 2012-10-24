import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String inputFilename = "input.txt";
        String outputFilename = "output.txt";

        BufferedReader inputFile = new BufferedReader(new FileReader(inputFilename));
        PrintWriter outFile = new PrintWriter(new File(outputFilename));
        Scanner in = new Scanner(System.in);

        System.out.println("Введите ключ");
        //String key = in.nextLine().trim().toLowerCase();
        String key = "сеннте";

        System.out.println("Кодирование или декодирование? (1 или 0)");
        int encode = in.nextInt();

        ArrayList<String> source = new ArrayList<String>();
        String tmp;
        while ((tmp = inputFile.readLine()) != null) {
            source.add(tmp);
        }
        //Task1 task1 = new Task1(key, source, encode == 1);
        //ArrayList<String> result = task1.getResultText();
        //Task15 task15 = new Task15(key, source, encode == 1);
        //ArrayList<String> result = task15.getResultText();
        System.out.println("Введите k");
        int k = in.nextInt();
        Task3 task3 = new Task3(k, key, source, encode == 1);
        ArrayList<String> result = task3.getResultText();

        for (String currentAnswer : result) {
            outFile.println(currentAnswer);
        }

        outFile.close();
        System.out.println("Проверьте выходной файл " + outputFilename);
    }
}
