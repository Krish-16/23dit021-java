    import java.util.Scanner;

    public class java3 {
        public static void main(String[] args) {
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter an integer: ");

            long num = scanner.nextLong();
            System.out.println("your entered no is = "+num);

            long [] digits = new long [10];
            for (int i = 9; i >= 0; i--) {
                digits[i] = num % 10;
                num = num / 10;
            }

            System.out.println("System Operator Code is: ");
            printDigits(digits, 0, 2);
            System.out.println("MSC is: ");
            printDigits(digits, 2, 5);
            System.out.println("Unique Code is: ");
            printDigits(digits, 5, 10);
            System.out.println("23DIT021");
        }

        private static void printDigits(long[] digits, int start, int end) {
            for (int i = start; i < end; i++) {
                System.out.print(digits[i]);
            }
            System.out.println();
        }
        
    }