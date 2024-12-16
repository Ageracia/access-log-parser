import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println ("Введите первое число:") ;
        int num_1 = new Scanner(System.in).nextInt() ;
        System.out.println ("Введите второе число:") ;
        int num_2 = new Scanner(System.in).nextInt() ;
        int sum = num_1 + num_2;
        int difference = num_1 - num_2;
        int multiplication = num_1 * num_2;
        double quotient = (double) num_1 /num_2;
        System.out.println(
                "Сумма чисел равна " + sum + "\n" +
                "Разность чисел равна " + difference + "\n" +
                "Произведение чисел равно " + multiplication + "\n" +
                "Частное чисел равно " + quotient
        );
    }
}
