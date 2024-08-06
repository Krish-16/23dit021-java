
import java.util.Random;
import java.util.Scanner;

public class java5 {
    public static void main(String[] args) {
        System.out.println("23DIT021");

        Random y=new Random();
        int x=y.nextInt(100);
        Scanner obj= new Scanner(System.in);
        
        
       
        for(int i=0;i<6;i++)
        {
            int k=6-i;
            System.out.println("You have "+  k  +" Chances left ");
            System.out.println("Guess the number between 1 to 100");
            int g=obj.nextInt();
            int min=Math.abs(x-g);
            

        
            if(g==x){
                System.out.println("You won the game");
                break;
            }
            else if(min>30)
            {
                System.out.println("You are far away from the number");
                
            }
            else if(min<30)
            {
                System.out.println("You are near the number");
            }
           
            
        }
        
       

    }
    
}
