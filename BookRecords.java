package library;
import java.util.Scanner;
import java.io.FileWriter;  
public class BookRecords{
    Book BookArray[] = new Book[5000];
    int size=0;
    public static int id=1;
    void AddRecord(){
        Scanner sc =new Scanner(System.in);
        if(size==BookArray.length){
            Book a[]= new Book[BookArray.length+BookArray.length];
            for(int i=0;i<size;i++){
                a[i]=BookArray[i];
            }
            BookArray=a;
        }
        System.out.println("Please Enter Book Name");
        String n=sc.next();
        System.out.println("Please Enter Book's Author Name");
        String a=sc.next();
        System.out.println("Please Enter Book's Publisher Name");
        String p=sc.next();
        String i= n.charAt(0)+"||"+a.charAt(0)+"||"+p.charAt(0)+"||"+id;
        BookArray[size]= new Book(n,i,a,p);
        size++;
        id++;
        System.out.println("Addition Complete");
    }
    void PrintRecord(){
        Book a[]= new Book[BookArray.length];
        for(int i=0;i<size;i++){
            a[i]=BookArray[i];
        }
        for(int i=0;i<size;i++){
            char min= a[i].name.charAt(0);
            int minpos= i;
            for(int j=i;j<size;j++){
                if(min>a[j].name.charAt(0)){
                    min=a[j].name.charAt(0);
                    minpos=j;
                }
            }
            if(min!=a[i].name.charAt(0)){
                Book temp=a[i];
                a[i]=a[minpos];
                a[minpos]=temp;
            }
        }
        for(int i=0;i<size;i++){
            System.out.println("Book Name: "+a[i].name+"; ID: "+a[i].id+"; Author: "+a[i].author+"; Publisher: "+a[i].publisher);
        }
    }
    void DeleteRecord(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter a Book's ID");
        String l=sc.next();
        int j=0;
        boolean b=false;
        for(int i=0;i<size;i++){
            if(BookArray[i].id.equals(l)){
                b=true;
                j=i;
                break;
            }
        }
        if(b==true){
            System.out.println("ID: "+BookArray[j].id+" is deleted.");
        }
        else{
            System.out.println("ID: "+l+" does not exist");
        }
        for(int i=j+1;i<size;i++){
            BookArray[i-1]=BookArray[i];
        }
        BookArray[size-1]=null;
        size--;
    }
    void EditRecord(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter a Book's ID");
        String l=sc.next();
        int j=0;
        boolean b=false;
        for(int i=0;i<size;i++){
            if(BookArray[i].id.equals(l)){
                b=true;
                j=i;
                break;
            }
        }
        if(b==true){
            int selection;
            while(true){
                while(true){
                    try{
                        System.out.println("Please, enter:\n1 to ChangeTheBookName\n2 to ChangeAuthorName\n3 to ChangePublisherName\n4 to FinsihEditing");
                        selection = sc.nextInt();
                        if(selection!=1 && selection!=2 && selection!=3 && selection!=4)
                            System.err.println("Wrong Selection! Please, try Again.");
                        else break;
                    }
                    catch(Exception e){
                        System.err.println("Input Format Mismatch! Please, try Again.");
                        sc.next();
                    }
                }
                if(selection==1){
                    System.out.println("Please Enter Book Name");
                    BookArray[j].name=sc.next();
                }
                else if(selection==2){
                     System.out.println("Please Enter Book's Author Name");
                     BookArray[j].author=sc.next();
                }
                else if(selection==3){
                System.out.println("Please Enter Book's Publisher Name");
                BookArray[j].publisher=sc.next();
                }
                else if(selection==4){
                    break;
                }
            }
            System.out.println("Edit Complete");
        }
        else{
            System.out.println("ID: "+l+" does not exist");
        }
    }
    void saveFile(){
        try{    
           FileWriter fw=new FileWriter("D:\\testout.txt");    
           for(int i=0;i<size;i++){
               fw.write("Book Name: "+BookArray[i].name+"; ID: "+BookArray[i].id+"; Author: "+BookArray[i].author+"; Publisher: "+BookArray[i].publisher+"\n");
           }
           fw.close();    
          }catch(Exception e){System.out.println(e);}    
          System.out.println("Saved");    
    }
}