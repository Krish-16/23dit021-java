import java.util.Scanner;
public class Complex {
    int img,real;
    Complex() {}
    Complex(int r,int i)
    {
        img =i;
        real =r; }
    void returnSum(Complex c1,Complex c2)
    {        int R = c1.real+ c2.real;
        int I = c1.img+c2.img;
        System.out.println("Sum of given two numbers is: ");
        Print(R, I);
    }
    void returnDiff(Complex c1,Complex c2)
    {
        int R = c1.real-c2.real;
        int I = c1.img-c2.img;
        System.out.println("Difference of given two numbers is: ");
        Print(R, I);
    }
    void returnPro(Complex c1,Complex c2)
    {        int r = (c1.real*c2.real)-(c1.img*c2.img);
        int i = (c1.real*c2.img)+(c1.img*c2.real);
        System.out.println("Product of given two numbers is: ");
        Print(r, i);
    }
    void Print(int r, int i)
    {      if (i<0) {
            System.out.println(r+" - "+Math.abs(i)+"i");
        }
        else{            System.out.println(r+" + "+i+"i");
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int r1,i1;
        System.out.println("Enter real part of first complex number: ");
        r1 = input.nextInt();
        System.out.println("Enter the imaginary part of first complex number: ");
        i1 =input.nextInt();
        Complex c1 = new Complex(r1,i1);
        System.out.println("Enter real part of second complex number: ");
        r1 = input.nextInt();
        System.out.println("Enter the imaginary part of second complex number: ");
        i1 =input.nextInt();
        Complex c2 = new Complex(r1, i1);
        Complex c3 = new Complex();
        c3.returnSum(c1, c2);
        c3.returnDiff(c1, c2);
        c3.returnPro(c1, c2);
        System.out.println("23DIT021");
    }
}
