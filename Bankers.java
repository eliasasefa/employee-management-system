
package  operating;
 import java.util.Scanner;
   
public class Bankers{
   static Scanner scan = new Scanner(System.in);
    static Bankers bankers =new Bankers();
    private static int need[][],allocate[][],max[][],avail[][],np,nr;
     /* 
     np is number of process
     nr is number of resources
    */
    private void input(){
        Scanner sc = new Scanner(System.in);
            System.out.print("Enter number of processes:_");
            np=sc.nextInt(); 
            System.out.print("Enter number of resources:_");
            nr=sc.nextInt();  
              //initializing arrays
            need=new int[np][nr];
            max=new int[np][nr];
            allocate=new int[np][nr];
            avail=new int[1][nr];
            
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("*****Enter allocation matrix*****\n");
            for(int i=0;i<np;i++)
                for(int j=0;j<nr;j++){
                    System.out.print("Enter Allocation  of process "+i+" resource "+j+"_");
                    allocate[i][j]=sc.nextInt();  
                }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\n****Enter maximum resource****");
            for(int i=0;i<np;i++)
                for(int j=0;j<nr;j++){
                    System.out.print("Enter Maximum  of process "+i+" resource "+j+"_");
                    max[i][j]=sc.nextInt(); 
                }
            
            System.out.println("\n****Enter available resources****");
            for(int j=0;j<nr;j++){
                System.out.print("Enter Available resource["+j+"]_");
                avail[0][j]=sc.nextInt();  
                
            }
  }
    //calculating need matrix
    private int[][] calc_need(){
       for(int i=0;i<np;i++)
         for(int j=0;j<nr;j++)  
          need[i][j]=max[i][j]-allocate[i][j];
       
       return need;
    }
 
    private boolean check(int i){
       for(int j=0;j<nr;j++) 
       if(avail[0][j]<need[i][j])
          return false;
   
    return true;
    }

    public void isSafe(){
       boolean done[]=new boolean[np];
       int[] safeSequence=new int[np];
       int j=0;

       while(j<np){
       boolean allocated=false;
       for(int i=0;i<np;i++)
        if(!done[i] && check(i))
        {
        for(int k=0;k<nr;k++)
             avail[0][k]=avail[0][k]-need[i][k]+max[i][k];
             System.out.println("Allocated process : "+i);
             allocated=done[i]=true;
    
             safeSequence[j]=i;
           
               j++;
        }
          if(!allocated)
              break;
       }
       if(j==np)
       {
        System.out.println("\n ALL PROCESSES ARE SAFELY ALLOCATED");
        System.out.println("\nTHE SAFE SEQUENCE OF RESOURCE ALLOCATION FOR PROCESSES");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for(int i=0;i<np;i++){
            System.out.print("process "+safeSequence[i]+" --> ");
       }
  }
        else
        System.out.println("All proceess can't be allocated safely");
    }
    public static void menu(){
        System.out.println("");
       System.out.print("****************************************************************\n"+
                                      "*    DEADLOCK AVOIDANCE ALGORITM \n"+
                                      "*\n"+
                                      "*    THIS PROGRAM IMPLEMENTS BANKERS ALGORITHM \n"+
                                      "*    NAME    ELIAS ASEFA\n"+
                                      "*    ID.NO    0917/13\n"+
                                      "****************************************************************\n");
        System.out.println("");
        System.out.println("");
    }
    void display(){
         bankers.input();
         System.out.println("\n*****Allocation of processes*****\n");
            for(int i=0;i<np;i++){
                    System.out.print("process  "+i+"--> ");
                for(int j=0;j<nr;j++){
                    System.out.print(bankers.max[i][j]+"   ");
                }
                System.out.println();
            }
            
         System.out.println("\n*****Maximum request of processes*****\n");
            for(int i=0;i<np;i++){
                System.out.print("process  "+i+"--> ");
                for(int j=0;j<nr;j++){
                    System.out.print(bankers.allocate[i][j]+"   ");
                }
                System.out.println();
            }
            
            System.out.println("\n*****Available resources*****");
            for(int j=0;j<nr;j++){
                System.out.print("  "+bankers.avail[0][j]+"   ");
            }
         bankers.calc_need();
         
         System.out.println("\n*****Resource Need of processes*****\n");
            for(int i=0;i<np;i++){
                System.out.print("process  "+i+"--> ");
                for(int j=0;j<nr;j++){
                    System.out.print(bankers.need[i][j]+"   ");
                }
                System.out.println();
            }
            
        System.out.println("************************************");
         bankers.isSafe();
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        menu();
        System.out.println("\nTHIS PROGRAM WORKS BASED ON MATRIX OPERATIONS AND INPUT-OUTPUT OF \n"+
             "THIS PROGRAM IS BASED ON MATRIX, SO PLEASE TRY TO TAKE INPUT BY MATRIX FORMAT\n");
        char choice;
        
        do{
            bankers.display();
            System.out.println();
            System.out.print("\nEnter any key to continue, or (x)  to exit program__");
            choice = sc.next().charAt(0);
          }while(choice != 'x' && choice != 'X');
        
     System.out.println("\nprogram ended safely");
    }
}
