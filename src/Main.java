import java.io.File;
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
        }
    }

}
