import java.util.Scanner;

public class java2 {
    private static final String[] LETTERS = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static final String[] MORSE_CODES = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----."};
    
    public static void main(String[] args) {
        System.out.println("23DIT021");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1 to convert string to Morse code, 2 to convert Morse code to string:");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Enter a string to convert to Morse code:");
            String input = scanner.next().toUpperCase();
            String morseCode = convertStringToMorse(input);
            System.out.println("Morse code: " + morseCode);
        } else if (choice == 2) {
            System.out.println("Enter a Morse code to convert to string:");
            String morseCode = scanner.next();
            String string = convertMorseToString(morseCode);
            System.out.println("String: " + string);
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    private static String convertStringToMorse(String input) {
        StringBuilder morseCode = new StringBuilder();
        for (char c : input.toCharArray()) {
            for (int i = 0; i < LETTERS.length; i++) {
                if (String.valueOf(c).equals(LETTERS[i])) {
                    morseCode.append(MORSE_CODES[i]).append(" ");
                    break;
                }
            }
        }
        return morseCode.toString().trim();
    }

    private static String convertMorseToString(String morseCode) {
        StringBuilder string = new StringBuilder();
        String[] morseCodeArray = morseCode.split(" ");
        for (String code : morseCodeArray) {
            for (int i = 0; i < MORSE_CODES.length; i++) {
                if (code.equals(MORSE_CODES[i])) {
                    string.append(LETTERS[i]);
                    break;
                }
            }
        }
        return string.toString();
    }
}