import java.util.Scanner;
public class Employee {
    Scanner input = new Scanner(System.in);
    String name;
    String lastname;
    double msalary;
    Employee(String nam, String lnam, double salary)
    {
        name = nam;
        lastname =lnam;
        msalary = salary;
    }
    void set()
    {
        System.out.println("Enter Your first name: ");
        name = input.nextLine();
        System.out.println("Enter your last name: ");
        lastname = input.nextLine();
        System.out.println("Enter monthly salary: ");
        msalary =input.nextDouble();
    }
    void get()
    {
        System.out.println("First name: "+name+"\nLast name: "+lastname+"\nMonthly Salary: "+msalary);
    }
    void salary()
    {
        double ysalary = msalary*12;
        ysalary = ysalary + ((10*ysalary)/100); 
        System.out.println("The yearly salary is: "+ ysalary);
    }
    public static void main(String[] args) {
        Employee e1 = new Employee("Krish","Kamani",8000);
        Employee e2 = new Employee(null, null, 0);
        e1.get();
        e1.salary();
        e2.set();
        e2.get();
        e2.salary();
        System.out.println("\n23DIT021");
    }
}



