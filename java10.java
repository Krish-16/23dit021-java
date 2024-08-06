import java.util.Scanner;

public class java10 {
    public static void main(String[] args) {
        System.out.println("23DIT021");
        Scanner x=new Scanner(System.in);
        System.out.println("Enter the String: ");
        String y=x.nextLine();
        System.out.println("Length of the String is : "+ y.length());
        System.out.println("Lowercase String is : "+ y.toLowerCase());
        System.out.println("The String after replacing the H by K is : "+y.replace('H', 'K'));
    }
}
