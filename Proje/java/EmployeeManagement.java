/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lalo
 */

import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;


public class EmployeeManagement{

    long ch=0;
            int id;
    String name;
    float salary;
    long contact_no;
    String email_id;
    Scanner sc=new Scanner(System.in);
    ArrayList<Employee> Gadaa =new ArrayList<Employee>();
    File file=null;
    FileInputStream fis=null;
    ObjectInputStream ois=null;
    FileOutputStream fos=null;
    ObjectOutputStream  oos= null;
    
   
  public  static void display(ArrayList<Employee> Gadaa)
    {  
       
            System.out.println("**************************EMPLOYEE INFORMATIONS **************************");
            System.out.println("        NAME       |  ID      |   SALARY       |  CONTACT_NUMBER     |   EMAIL ID ");
            System.out.println("------------------------------------------------------------------");
            for(Employee e:  Gadaa)
            {
                System.out.print("       "+e.name);
                System.out.print("         "+e.id);
                System.out.print("       "+e.salary);
                System.out.print("       0"+e.contact_no);
                System.out.println("               "+e.email_id);
          
           }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        
          int choice=0;
        Scanner sc=new Scanner(System.in);
EmployeeManagement B=new EmployeeManagement();
        B.File1();
        

        try{
     

B.MainMenu();
    
    do   
    {   
        B.File();
        System.out.println("***************************************************************************");
        System.out.println("***************************************************************************");
        
     System.out.println("        #               ");
     System.out.println("        #              1.  ADD EMPLOYEE TO DATABASE:");
     System.out.println("        #              2.  SEARCH EMPLOYEE BY ID: ");
     System.out.println("        #              3.  EDIT EMPLOYEE DETAILS: ");
     System.out.println("        #              4.  DELETE EMPLOYEE DETAILS:");
     System.out.println("        #              5.  DISPLAY ALL EMPLOYEES WORKING IN THE  COMPANY:");
     System.out.println("        #              6.  DELETE ALL  EMPLOYEES:");
     System.out.println("        #              7.  SORT DATA:");
     System.out.println("        #              8.  ABOUT US()");
     System.out.println("        #              0.  SAVE TO FILE AND EXIT:");
     System.out.println("        #                "); 
     System.out.println("***************************************************************************");
     System.out.println("***************************************************************************");

    try{
    
 System.out.println("\nENTER YOUR CHOICE");
                                        choice =sc.nextInt();
                                       
  
                   

    }catch(InputMismatchException im){
        System.out.println();
    }
     System.out.println();
    switch(choice)
    {
        
        case 1: 
           B. Add();
                                   
            break;
        case 2:
            B.Search();
             System.out.println("\n\n\n\n\nPRESS ANY KEY TO CONTINUE:");
             sc.nextLine();
             sc.nextLine();            
            break;
        case 3:
            B.Update();

            break;
        case 4:
            B.Delete();
           System.out.println("\n\n\n\n\nPRESS ANY KEY TO CONTINUE:");
             sc.nextLine();
             sc.nextLine();
            break;
        case 5:
           B.Display();
           System.out.println("\n\n\n\n\nPRESS ANY KEY TO CONTINUE:");
                                sc.nextLine();
                                sc.nextLine();
            break;
        case 6:
            B.DeleteAll();
           System.out.println("\n\n\n\n\nPRESS ANY KEY TO CONTINUE:");
            sc.nextLine();
             sc.nextLine();
            break;
            
        case 7:
            B.SORTING();
            break;
        case 8:
            B.About_Us();
            break;
    
    }
          
    }while(choice!=0);
        } catch(InputMismatchException e)
        {
            System.out.println("UNSUPPORTED INPUT  RERUN!");
            
            }
    System.out.println(" The File Is Saved. ");
   
    System.out.println("Exiting\n\n\n\n\nExited");
    }   

  
    
    public void Add(){
        int z=1;
            do{
            System.out.println("\n\nEnter Id ");
                     id=sc.nextInt();
                     
                    for(Employee E:Gadaa)
                    {
                        if(id==E.id){
                            
                        System.out.println("\n\nThis ID Is Already Exist!\n\nEnter Another:");
                          id=0;
                          Add();
                         return;
                    }
                    }
             System.out.println("Enter Name");
                           sc.nextLine();
            name=sc.nextLine();
            System.out.println("Enter Salary ");
            salary=sc.nextFloat();
            System.out.println("Enter Contact_No. ");
            contact_no=sc.nextInt();
            System.out.println("Enter Email Id ");
                                sc.nextLine();
            email_id=sc.nextLine();
            
            Gadaa.add(new Employee(id,name ,salary,contact_no,email_id));
            
            
                System.out.println("DATA IS INSERTED SUCCESSFULLY \n\n\nPRESS ANY NUMBER TO CONTINUE\n\nPRESS ZERO NUMBER TO EXIT");
                z=sc.nextInt();
             
  }while(z!=0);}
    public void Search()
    {
        
                if(Gadaa.isEmpty()){
        System.out.println("  EMPTY DATA!");
       return;
        }
                
        
            System.out.println("Enter Employee Id To Search ");
            id=sc.nextInt();
            int i=0;
            for(Employee e: Gadaa)
            {
                if(id==e.id)
                {
            
            System.out.println(" THE SEARCHED DETAILS\n");
            System.out.print("ID: "+e.id);
            System.out.print("   NAME: "+e.name);
            System.out.print("   SALARY: "+e.salary);
            System.out.print("   CONTACT INFO: "+e.contact_no);
            System.out.println("    EMAIL: "+e.email_id);
                    
                    i++;
                    
                }
            }
            if(i==0)
            {
                System.out.println("\nEMPLOYEE DETAILS ARE NOT AVAILABLE ");
            }
    }
    public void Update()
    {              if(Gadaa.isEmpty()){
        System.out.println("YOU DON'T HAVE DATA TO UPDATE ");
       return;
        }
        
            System.out.println("\n Enter Employee ID You Want To Edit ");
            id=sc.nextInt();
            int j=0;
            for(Employee e: Gadaa)
            {
                if(id==e.id)
                {
                    j++;
                 int ch1=0;
                do{
                   
                    
                    System.out.println("*****************************************************");
                    
                    System.out.println("******** EDIT EMPLOYEE HERE: *******");
                    
                                       
                       System.out.println("                   1. EDIT EMPLOYEE ID");
                       System.out.println("                   2. EDIT NAME");
                       System.out.println("                   3. EDIT SALARY");
                       System.out.println("                   4. EDIT CONTACT NUMBER");
                       System.out.println("                   5. EDIT EMAIL ID");
                       System.out.println("                   6. SAVE");
                       System.out.println("*****************************************************");
                       System.out.println("CHOOSE TO EDIT  ");
                    ch1=sc.nextInt();
                    switch(ch1)
                    {
                        case 1:
                            System.out.println("\n Enter New Id ");
                            e.id=sc.nextInt();
            System.out.println(" THE UPDATED DETAILS");               
            System.out.print("ID:   "+e.id);
            System.out.print("   NAME:   "+e.name);
            System.out.print("   SALARY:   "+e.salary);
            System.out.print("   CONTACT INFO:   "+e.contact_no);
            System.out.println("   EMAIL:   "+e.email_id);
                            break;
                            
                            
                        case 2:
                            
                            System.out.println("Enter New  Name ");
                                              sc.nextLine();
                            e.name=sc.nextLine();
            System.out.println(" THE UPDATED DETAILS");          
            System.out.print("ID:   "+e.id);
            System.out.print("   NAME:   "+e.name);
            System.out.print("   SALARY:   "+e.salary);
            System.out.print("   CONTACT INFO:   "+e.contact_no);
            System.out.println("   EMAIL:   "+e.email_id);
                            break;
                            
                            
                        case 3:
                            System.out.println("Enter New  Salary ");
                            e.salary=sc.nextFloat();
            System.out.println(" THE UPDATED DETAILS");              
            System.out.print("ID:   "+e.id);
            System.out.print("   NAME:   "+e.name);
            System.out.print("   SALARY:   "+e.salary);
            System.out.print("   CONTACT INFO:   "+e.contact_no);
            System.out.println("   EMAIL:   "+e.email_id);
                            break;
                            
                            
                        case 4:
                            System.out.println("Enter New  Contact ");
                            e.contact_no=sc.nextInt();
            System.out.println(" THE UPDATED DETAILS");       
            System.out.print("ID:   "+e.id);
            System.out.print("   NAME:   "+e.name);
            System.out.print("   SALARY:   "+e.salary);
            System.out.print("   CONTACT INFO:   "+e.contact_no);
            System.out.println("   EMAIL:   "+e.email_id);
                            break;
                            
                            
                        case 5:
                            
                            System.out.println("Enter New Email ");
                                                    sc.nextLine();
                           e. email_id=sc.nextLine();
            System.out.println(" THE UPDATED DETAILS");
            System.out.print("ID:   "+e.id);
            System.out.print("   NAME:   "+e.name);
            System.out.print("   SALARY:   "+e.salary);
            System.out.print("   CONTACT INFO:   "+e.contact_no);
            System.out.println("   EMAIL:   "+e.email_id);
                            break;
                       
                    }
                    j++;
                }
                while(ch1!=6);
               if(j>0)
                        System.out.println(" THE FILE IS SAVED");
                  
            }
            
            }
            if(j==0)
            {
                System.out.println("THIS ID DOES NOT EXIST!! ");
            }
          
    }
    public void Delete()
    {       if(Gadaa.isEmpty()){
        System.out.println(" NO DATA TO DELETE ");
       return;
        }
     
            System.out.println("Enter Employee Id To Delete ");
            id=sc.nextInt();
            int k=0;
            try{
                for(Employee e:  Gadaa)
                {
                    if(id==e.id)
                    {
            System.out.println(" THIS FILE IS  GOING TO BE DELETED");
            System.out.print("ID:   "+e.id);
            System.out.print("   NAME:   "+e.name);
            System.out.print("   SALARY:   "+e.salary);
            System.out.print("   CONTACT INFO:   "+e.contact_no);
            System.out.println("   EMAIL:   "+e.email_id);
                        System.out.println("Are You Sure To Delete This Employee Info ?   y/n");
                       char y;
                        y=sc.next().charAt(0);
                        if(y==('Y'|'y'))
                        {
                        Gadaa.remove(e);
                            System.out.println("EMPLOYEE DELETED SUCCESSFULLY ");
                        k++;
                      
                        }
                   
                    }
                }
                if(k==0)
                {
                    System.out.println("\nTHIS ID DOES NOT EXIST!! ");
                    
                    
                }
            }
            catch(Exception ex)
            {
                System.out.println();
            }
        
    }
    @SuppressWarnings("unchecked")
    public void Display()
    {  

        if(Gadaa.isEmpty()){
        System.out.println("THERE IS NO DATA  TO DISPLAY ");
       return;
        }
        {
        
            try{
                Gadaa=(ArrayList<Employee>)ois.readObject();
                 }   catch(ClassNotFoundException | IOException e2)
            {
                System.out.println();
            }
            display(Gadaa);
                }
        
            
    }
    @SuppressWarnings("unchecked")
    public void File1()
    {
        
        
    try{
        file=new File("C:\\Users\\Lalo\\Documents\\NetBeansProjects\\EmployeeLis1.txt");
        if(file.exists())
        {
            fis=new FileInputStream(file);
        ois=new ObjectInputStream(fis);
        Gadaa=(ArrayList<Employee>)ois.readObject();
          }
        
    }catch(IOException | ClassNotFoundException exp)
    {
        System.out.println(exp);
    }
    }
    public void File()
    {
        
        
            try{
              
                fos=new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(Gadaa);
      
            }catch(IOException e1)
            {
            }catch(Exception e2)
            {
            }
            finally{
                try{
                    fis.close();
                    ois.close();
                  
                       fos.close();
                      oos.close();
                } catch(IOException e1)
                {
                }
            }
            
           
        
           
    }
    public void DeleteAll()
    {            if(Gadaa.isEmpty()){
        System.out.println("ALREADY THERE IS NO DATA!");
       return;
        }
        Gadaa.clear();
        System.out.println("ALL FILES ARE DELETED SUCCESSFULLY ");
   
    }
      public void MainMenu()
    {   System.out.println("\n\n\n\n\n");
        System.out.println("*********************HARAMAYA UNIVERSITY***********************************");
        System.out.println("");
        System.out.println("");
        System.out.println("            COLLEGE OF COMPUTING AND INFORMATICS");
        System.out.println("");
        System.out.println("");
        System.out.println("             DEPARTMENT OF SOFTWARE ENGINEERING");
        System.out.println("");
        System.out.println("");    
        System.out.println("            WELCOME TO EMPLOYEE MANAGEMENT SYSTEM\n");
      
         
      
             
    }
    
      
      public void SORTING()
      {int choice;
      do{
          System.out.println("1. SORT BY ID ASCENDING ");
          System.out.println("2. SORT BY ID DESCENDING ");
          System.out.println("3. SORT BY NAME ASCENDING ");
          System.out.println("4. SORT BY NAME DESCENDING ");
          System.out.println("5. SORT BY SALARY ASCENDING ");
          System.out.println("0. EXIT ");
                    
          System.out.println("Enter Your Choice");
          choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                          Collections.sort(Gadaa, new Comparator<Employee>(){
                          public int compare(Employee e1, Employee e2){
                         return e1.id-e2.id;
                         }
                              });
                        Display();
                         break;
                case 2:
                          Collections.sort(Gadaa, new Comparator<Employee>(){
                             public int compare(Employee e1, Employee e2){
                           return e2.id-e1.id;
                                  }
                               });
                          Display();
                             break;
                case 3:
                               Collections.sort(Gadaa, new Comparator<Employee>(){
                                 public int compare(Employee e1, Employee e2){
                                     return e1.name.compareTo(e2.name);
                                 }
                                    });
                           Display();
                             break;
                 case 4:
                             Collections.sort(Gadaa, new Comparator<Employee>(){
                               public int compare(Employee e1, Employee e2){
                                 return e2.name.compareTo(e1.name);
                                 }
                                    });
                           Display();
                              break;
                case 5:
                          Collections.sort(Gadaa, new Comparator<Employee>(){
                           public int compare(Employee e1, Employee e2){
                           return (int) (e1.salary-e2.salary);
                               }
                           });
                          Display();
                    break;


            }
            
      }while(choice!=0);
        
      }
      
      void About_Us()
      {     MainMenu();
          System.out.println("\n\n          ID NUMBER |  STUDENT NAME   ");
          System.out.println("      1. 0917/13      ELIAS ASEFA");
          System.out.println("      2. 2817/13      YADUMA LECHISA");
          System.out.println("      3. 1539/13      KALEB ALEBACHEW");
          System.out.println("      4. 1260/13      GEZAHEGN LEMI");
          System.out.println("      5. 1157/13      FIRISAT DESALEGN\n\n");
          System.out.println("***************************************************************************");
             System.out.println("\n\n\n\nPRESS ANY KEY TO CONTINUE:");
             sc.nextLine();

      }
}