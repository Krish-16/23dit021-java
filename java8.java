
import java.util.Scanner;

public class java8 {
   
    public static void main(String[] args) {
        
        Scanner x=new Scanner(System.in);
        int n;
        
        System.out.println("Enter the String");
        String g=x.nextLine();
        Scanner no=new Scanner(System.in);
        System.out.println("Enter the number of times you wanna repeat a letter of string");
        n=no.nextInt();
        int y;
        y=g.length();
        System.out.println("The output is : ");
        for(int i=0;i<y;i++)
        {
            for(int k=0;k<n;k++){
                System.out.print(g.charAt(i));
            }
        }
    
    }
    
}
