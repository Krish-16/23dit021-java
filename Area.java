import java.util.Scanner;
public class Area {
    float length,breadth;
    Area(float l,float b)
    {
        length=l;
        breadth=b;
    }
    float returnArea(float length,float breadth)
    {
        return length*breadth;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter length of triangle: ");
        float l = input.nextFloat();
        System.out.println("Enter breadth of triangle: ");
        float b = input.nextFloat();
        Area a = new Area(l, b);
        float area = a.returnArea(l, b);
        System.out.println("The area of triangle is: "+area);
        System.out.println("23DIT021");
    }
}
