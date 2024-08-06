
import java.util.Scanner;

public class java7 {
    public static void main(String[] args) {
     System.out.println("23DIT021");
     Scanner x=new Scanner(System.in);
     
     //String a="1 2 3";
     int[] a=new int[5];
     for(int j=0;j<5;j++)
     {
        System.out.print("Enter value:");
        a[j]=x.nextInt();
     }
     int k=0;
     for(int j=0;j<5;j++)
     {
        
        if(a[j]==9)
        {
            k++;
        }
     }
     System.out.println("Number of 9's : "+k);
     
          

    }
}
