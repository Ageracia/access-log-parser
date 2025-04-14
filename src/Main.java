import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        while (true) {
            System.out.print("Введите путь к файлу: ");
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();
            if (!fileExists){
                System.out.println("Такого файла не существует!");
                continue;
            }
            else if (isDirectory){
                System.out.println("Это директория!");
                continue;
            }
            count++;
            System.out.println("Путь указан верно!\nЭто файл номер " + count);

            int linesCounter = 0;
            int maxLength = 0;
            int minLength = Integer.MAX_VALUE;
            try{
                FileReader fileReader = new FileReader(path);
                BufferedReader reader =
                        new BufferedReader(fileReader);
                String line;
                while ((line = reader.readLine()) != null) {
                    linesCounter+=1;
                    int length = line.length();
                    if (length > maxLength) maxLength = length;
                    if (length < minLength) minLength = length;
                    if (length > 1024){
                        throw new TooLongStringException("Длина строки больше 1024 символов!");
                    }
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("Количество строк: " + linesCounter);
            System.out.println("Длина самой длинной строки: " + maxLength);
            System.out.println("Длина самой короткой строки " + minLength);
        }
    }



}
