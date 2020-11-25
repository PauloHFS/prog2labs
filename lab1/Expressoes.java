import java.util.Scanner;

public class Expressoes {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Integer x = input.nextInt();

        System.out.println("dobro: " + x * 2 + ", triplo: " + x * 3);

        input.close();
    }

}