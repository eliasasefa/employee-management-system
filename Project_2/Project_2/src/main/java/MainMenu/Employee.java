 
package MainMenu;

import java.util.HashSet;
import java.util.Scanner;
 
public class Employee {
    
    
    
    private int getId;
    private int id;
    private String name;
    private String department;
    private int age;
    private String destination;
    private double salary;
 

    

    public void setId(int id)
{
    this.id=id;
}
public int getId()
{
    return id;
}
    public void setDepartment(String department)
    {
	   this.department=department;
    }
    public String getDepartment()
    {
	   return department;
    }
    public void setDestination(String destination)
    {
	   this.destination=destination;
    }
    public String getDestination()
    {
	   return destination ;
    }
    public void setAge(int age)
    {
	   this.age=age;
    }
    public int getAge()
    {
	   return age;
    }
    public void setSalary(double salary)
    {


	   this.salary=salary;
    }
    public double getSalary()
    {
	   return salary;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getName()
    {
        return name;
    }
    
 
    @Override
    public String toString() {
       return "Employee["+
          
                "id=" + id+
                ", name='" +name+ '\'' +
                ", department='" + department + '\'' +
                ", age=" + age+
                ", destination='" + destination + '\'' +
                ", salary=" + salary +
                ']';
    }
    public Employee(int id, String name,  int age, String destination, String department,double salary)
    { 
    this.id=id;
    this.name=name;
    this.age=age;
    this.destination=destination;
    this.department=department;
    this.salary=salary;

    }
    
        
    

}
