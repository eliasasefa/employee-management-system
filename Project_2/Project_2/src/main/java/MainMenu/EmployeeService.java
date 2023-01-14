 
package MainMenu;

 
package MainMenu;

import java.util.HashSet;
import java.util.Scanner;

public class EmployeeService {
    
    
    private int getId;
    private int id;
    private String name;
    private String department;
    private int age;
    private String destination;
    private double salary;
 
    
    
    HashSet<Employee> empset=new HashSet<Employee>();
    
    Employee emp1=new Employee(100,"Kuusaa",23,"Software","Developer",25000);

    Employee emp2=new Employee(1010,"Kuusa",39,"Sof","Devel",2500);
    

    Scanner Sc=new Scanner(System.in);
boolean found = false;
   
    public EmployeeService()
    {

        empset.add(emp1);
        empset.add(emp2);
 

    }
    
    public void viewAllEmployee()
    {
        for(Employee emp:empset)
        {
            System.out.println(emp);
        }
        
    }
    public void viewEmp()
    { 
   found=false;
        System.out.println("Enter Your Id");
        int id = Sc.nextInt();
        for(  Employee emp:empset)
        {
            if(emp.getId()==id)
            {  System.out.println(emp);
            found=true; 
        }
    }
        if(!found)
    {
        System.out.println("Employee With this Id Is Not Present");
    }
    }
    public void updateEmployee()
    {
        System.out.println("Enter Id: ");
        id = Sc.nextInt();
        boolean found=false;
        for(Employee emp:empset) {
            if (emp.getId()== id) {
                System.out.println("Enter Name:");
                name = Sc.next();
                System.out.println("Enter Salary: ");
                salary = Sc.nextDouble();
                emp.setName(name);
                emp.setSalary( salary);
                System.out.println("UPDATED DETAILS OF EMPLOYEE ARE:");
                System.out.println(emp);
                found = true;

            }

        }
            if (!found) {
                System.out.println("EMPLOYE IS NOT PRESENT: ");
            } 
            else {
                System.out.println("UPDATED SUCCESSFULLY ");
            }
        }

    public void deleteEmp()
    {
        System.out.println("ENTER ID ");
        id=Sc.nextInt();
         
        EmployeeService delete = null;
        for(Employee emp:empset)
        {
            if(emp.getId()==id)
            {
               emp=null;
               found=true;
            }
        }

        if(!found)
        {
            System.out.println("Employee IS NOT AVAILABLE ");
        }
        else {
            empset.remove(delete);
            System.out.println("EMPLOYEE DELETED SUCCESSFULLY ");
        }
    }

    public void addEmp()
    {
        System.out.println("ENTER  ID ");
        id=Sc.nextInt();
        System.out.println("ENTER NAME: ");
        name=Sc.next();
        System.out.println("ENTER AGE ");
        age=Sc.nextInt();
        System.out.println("ENETER DESIGANATION");
        destination=Sc.next();
        System.out.println("ENTER DEPARTMENT:");
        department=Sc.next();
        System.out.println("ENTER SALARY: ");
        salary=Sc.nextDouble();
        
        Employee emp=new Employee(id,name,age,destination,department, salary);

        empset.add(emp);
        
        System.out.println(emp);
        System.out.println("EMPLOYEE ADDED SUCCESSFULLY ");

    }
 
}
