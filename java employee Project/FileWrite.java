
import java.io.FileWriter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author eliasasefa 
 */
 
public class FileWrite {
    public  void Mmain() 
    {  
               String jn="Amanaummaa";
       
        try {FileWriter fw= new FileWriter("C:\\Users\\Lalo\\Desktop\\Abdii.txt");
            fw.write(jn);
          
        } catch (Exception e) {
            System.out.println(e);
        }
        
          
           }
    public static void main(String[] args) {
         FileWrite nm=new FileWrite();
         nm.Mmain();
    }
}
