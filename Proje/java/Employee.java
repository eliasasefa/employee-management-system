/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lalo
 */

import java.io.Serializable;
@SuppressWarnings("Serial")
public class Employee implements Serializable{
    
    int id;
    String name;
    float salary;
    long contact_no;
    String email_id;
public Employee(int id,String name,float salary,long contact_no,String email_id)
{
    this.id=id;
    this.name=name;
    this.salary=salary;
    this.contact_no=contact_no;
    this.email_id=email_id;
}   

    
    
}
 

