
import java.util.Scanner;

public class java6 {
    public static void main(String[] args) {
        System.out.println("23DIT021");
        Scanner x=new Scanner(System.in);
        System.out.println("Enter the input you want to: ");
        String input=x.nextLine();
        int y=input.length();
        if(y>3)
        {
            
            for(int k=0;k<3;k++)
            {
                System.out.print(input.substring(0, 3));
            }
        }
        else{
            for(int k=0;k<3;k++)
            {
                System.out.print(input.substring(0, y));
            }
        }


    }
    
}
