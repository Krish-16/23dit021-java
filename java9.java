
import java.util.Scanner;

public class java9{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Your string: ");
        String str = input.nextLine();
        System.out.println("Length of your string is " + str.length());
        int l = 0;
        try {
            for (int i = 0; str.charAt(i) != '\0'; i++) {
                l++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // TODO: handle exception
        }
        System.out.println("Length of your string is " + l);
        System.out.println("Your string in UPPER-case: " + str.toUpperCase());
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 97 && array[i] <= 122) {
                array[i] = (char) (array[i] - 32);
            }
        }
        String upper = new String(array);
        System.out.println("Your string in UPPER-case: " + upper);
        System.out.println("Your string in lower-case: " + str.toLowerCase());
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 65 && arr[i] <= 90) {
                arr[i] = (char) (arr[i] + 32);
            }
        }
        String lower = new String(arr);
        System.out.println("Your string in lower-case: " + lower);
        String s = "";
        int n = str.length();
        for (int i = 0; i < n; i++) {
            s = s + str.charAt(n - 1 - i);
        }
        System.out.println("Printing the reversed array: " + s);
        System.out.println("\n23DIT021");
    }
}
