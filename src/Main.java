import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            int googleCounter = 0;
            int yandexCounter = 0;
            int linesCounter = 0;
            try{
                FileReader fileReader = new FileReader(path);
                BufferedReader reader =
                        new BufferedReader(fileReader);
                String line;
                while ((line = reader.readLine()) != null) {
                    String agent = "";
                    Matcher matcher = Pattern.compile("\\((.*)\\)").matcher(line);
                    if (matcher.find()) {
                        String firstBrackets = matcher.group(1);
                        String[] parts = firstBrackets.split(";");
                        linesCounter += 1;
                        for (int i = 0; i < parts.length; i++) {
                            parts[i] = parts[i].replace(" ", "");
                        }
                        if (parts.length >= 2) {
                            String fragment = parts[1];
                            int index = fragment.indexOf("/");
                            if (index != -1) agent = fragment.substring(0, index);
                        }
                    }
                    if (agent.equals("YandexBot")) yandexCounter+=1;
                    if (agent.equals("Googlebot")) googleCounter+=1;
                    int length = line.length();
                    if (length > 1024){
                        throw new TooLongStringException("Длина строки больше 1024 символов!");
                    }
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("Доля YandexBot от общего числа: " + proportion(yandexCounter,linesCounter) + "%");
            System.out.println("Доля GoogleBot от общего числа: " + proportion(googleCounter,linesCounter) + "%");
        }
    }
    public static double proportion(int bot, int lines){
        return (double) bot/lines * 100;
    }



}
