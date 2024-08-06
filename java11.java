import java.util.Scanner;

public class java11 {
    public static void main(String[] args) {
        System.out.println("23DIT021");
        if (args.length > 0) {
            double pounds = Double.parseDouble(args[0]);
            double rupees = pounds * 100;
            System.out.println(pounds + " Pounds is equal to " + rupees + " Rupees");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Pounds:");
            double pounds = scanner.nextDouble();
            double rupees = pounds * 100;
            System.out.println(pounds + " Pounds is equal to " + rupees + " Rupees");
        }
    }
}