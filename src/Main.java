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

        int numberOfTask = 7;

        int k;
        ArrayList<String> result = new ArrayList<String>();
        switch (numberOfTask) {
            case 1:
                //done
                Task1 task1 = new Task1(key, source, encode == 1);
                result = task1.getResultText();
                break;
            case 3:
                //done
                System.out.println("Введите k");
                k = in.nextInt();
                Task3 task3 = new Task3(k, key, source, encode == 1);
                result = task3.getResultText();
                break;
            case 5:
                //done
                System.out.println("Введите k");
                k = in.nextInt();
                System.out.println("Введите n");
                int n = in.nextInt();
                Task5 task5 = new Task5(n, k, key, source, encode == 1);
                result = task5.getResultText();
                break;
            case 7:
                Task7 task7 = new Task7("", source, encode == 1);
                result = task7.getResultText();
                break;
            case 9:
                break;
            case 11:
                //done
                Task11 task11 = new Task11(key, source, encode == 1);
                result = task11.getResultText();
                break;
            case 13:
                //done
                Task13 task13 = new Task13(key, source, encode == 1);
                result = task13.getResultText();
                break;
            case 15:
                //done
                Task15 task15 = new Task15(key, source, encode == 1);
                result = task15.getResultText();
                break;
            case 17:
                break;
        }

        for (String currentAnswer : result) {
            outFile.println(currentAnswer);
        }

        outFile.close();
        System.out.println("Проверьте выходной файл " + outputFilename);
    }
}
