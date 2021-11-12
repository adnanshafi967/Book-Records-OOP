package library;
import java.util.Scanner;
public class Tester{
    public static void main(String[]args){
        Scanner sc =new Scanner(System.in);
        BookRecords p =new BookRecords();
        int selection;
        while(true){
            while(true){
                try{
                    System.out.println("Please, enter:\n1 to Add a Record\n2 to Print the Records\n3 to Delete a Record\n4 to Edit a Record\n5 to exit");
                    selection = sc.nextInt();
                    if(selection!=1 && selection!=2 && selection!=3 && selection!=4 && selection!=5)
                        System.err.println("Wrong Selection! Please, try Again.");
                    else break;
                }
                catch(Exception e){
                    System.err.println("Input Format Mismatch! Please, try Again.");
                    sc.next();
                }
            }
            
            if(selection==1){
                p.AddRecord();
            }
            else if(selection==2){
                p.PrintRecord();
            }
            else if(selection==3){
                p.DeleteRecord();
            }
            else if(selection==4){
                p.EditRecord();
            }
            else if(selection==5){
                System.out.println("Do you wanna save the file?\nEnter: 1 to save");
                int i;
                while(true){
                    try{
                        i = sc.nextInt();
                        if(i!=1)
                            System.err.println("Wrong Selection! Please, try Again.");
                        else break;
                    }
                    catch(Exception e){
                        System.err.println("Input Format Mismatch! Please, try Again.");
                        sc.next();
                    }
                }
                if(i==1){
                    p.saveFile();
                }
                break;
            }
        }
    }
}