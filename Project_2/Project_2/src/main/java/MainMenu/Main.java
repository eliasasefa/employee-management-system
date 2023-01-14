 
package MainMenu;
 
import java.util.Scanner;
public class Main{


    public static void main(String[] args) {
	   int choice = 0;
	   do {
		  System.out.println("""
 *********************WELCOME   SYSTEM*************************
                       
                       
                                               1.ADD EMPLOYEE  
                                               2.VIEW EMPLOYEE 
                                               3.UDATE EMPLOYEE 
                                               4.DELETE EMPLOYEE 
                                               5.VIEW ALL EMPLOYEE
                                               6.EXIT    """);

		
                                                  Scanner Sc = new Scanner(System.in);
		  EmployeeService service = new EmployeeService();

		 
			 System.out.println("ENTER YOUR CHOICE ");
			 choice = Sc.nextInt();
			 switch (choice) {
                                                                                              case 1:
				    System.out.println("ADD EMPLOYEE ");
				    service.addEmp();
				    break;
				case 2:
				    System.out.println("VIEW EMPLOYEE ");
				    service.viewEmp();
				    break;
				case 3:
				    System.out.println("UDATE EMPLOYEE");
				    service.updateEmployee();
				    break;
				case 4:
				    System.out.println("DELETE EMPLOYEE ");
				    service.deleteEmp();
				    break;
				case 5:
				    System.out.println("VIEW ALL EMPLOYEE");
                                                                                                   service.viewAllEmployee();
				    break;
				case 6:
				    System.out.println("THANK YOU FOR YOUR USING THIS APPLICATION  ");
                                                                                                    System.exit(0);  
				    break;

				default:
				    System.out.println("PLEASE ENTER VALID INPUT ");


			 }
		  
	   } while (choice != 0);
    }
}


