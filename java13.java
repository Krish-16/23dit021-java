import java.util.Scanner;
 class date{
    int year,day,month;
    Scanner input = new Scanner(System.in);
    date()
    {
       year =2024;
       day = 12;
       month = 3;
    }
    void setday()
    {
        System.out.println("Enter day: ");
        day = input.nextInt();
    }
    void setmonth()
    {        System.out.println("Enter month: ");
        month = input.nextInt();
    }
    void setyear()
    {
        System.out.println("Enter year: ");
        year = input.nextInt();
    }       
    void getday()
    {
        System.out.println("Day: "+day );
    }
    void getmonth()
    {
        System.out.println("month: "+month );
    }
    void getyear()
    {
        System.out.println("year: "+year );
    }
    void DisplayDate()
    {
        System.out.println("Date: "+month+"/"+day+"/"+year);
    }
}
public class java13{
    public static void main(String[] args) {
        date d1=new date();
        d1.getday();
        d1.getmonth();
        d1.getyear();
        d1.DisplayDate();
        date d2=new date();
        d2.setday();
        d2.setmonth();
        d2.setyear();
        d2.getday();
        d2.getmonth();
        d2.getyear();
        d2.DisplayDate();
        System.out.println("\n23DIT021");    }
}
