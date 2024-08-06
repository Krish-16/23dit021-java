
import java.util.Scanner;

public class java4 {
    public static void main(String[] args) {
        System.out.println("23DIT021");

        String[] pdl = { " Motor ", " Fan ", " Tube ", " Wire ", " Others " };
        double[] price = { 1000, 500, 200, 100, 300 };
        double[] tax = { 8, 12, 5, (float) 7.5, 3 };

     double T,T1,T2,T3,T4,T5;
     T=T1=T2=T3=T4=T5=0;
        Scanner obj = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nEnter the code number For the products");
            System.out.println("1. Motor");
            System.out.println("2. Fan");
            System.out.println("3. Tube");
            System.out.println("4. Wire");
            System.out.println("5. Others");
            System.out.println("6. Exit");
            choice = obj.nextInt();

            switch (choice) {
                case 1:
                    T1 = price[0] + (0.01 * tax[0]);

                    break;
                case 2:
                    T2 = price[1] + (0.01 * tax[1]);
                    break;
                case 3:
                    T3 = price[2] + (0.01 * tax[2]);
                    break;
                case 4:
                    T4 = price[3] + (0.01 * tax[3]);
                    break;
                case 5:
                    T5 = price[4] + (0.01 * tax[4]);

            }

        } while (choice != 6);
        System.out.println("-------------BILL---------------");
        System.out.println("----------------------------------------------------");
        System.out.println("Product Name" + "\t" + "Price" + "\t");
        System.out.println("----------------------------------------------------");
        if (T1>0){System.out.println("Motor" + "\t\t" + T1);}
        if (T2>0){System.out.println("Fan" + "\t\t" + T2);}
        if (T3>0){System.out.println("Tube" + "\t\t" + T3);}
        if (T4>0){System.out.println("Wire" + "\t\t" + T4);}
        if (T5>0){System.out.println("Others" + "\t\t" + T5);}
        System.out.println("----------------------------------------------------");
        T = T1 + T2 + T3 + T4 + T5;

        System.out.println("\nTotal Bill =   " + T);

    }

}
