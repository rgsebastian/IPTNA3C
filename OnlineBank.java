
package mainbank;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class OnlineBank {
    
        static double payAmount;
        static String Mail;
  
        // Robert Sebastian "Method 3"
    public static boolean Account(Customer customer) {
           
            boolean GMV=false;
	while(!GMV){	
		System.out.println("Enter Your Password (Q to quit):");
		Scanner user = new Scanner(System.in);
                String Password = user.nextLine(); 
               
                if (Password.equalsIgnoreCase(customer.password)) {
			GMV=true;
                       System.out.println("Continue"); 
                        
		}else if (Password.contains("q") || Password.contains("Q")) {break; }
                else{System.out.print("WRONG PASSWORD, PLEASE TRY AGAIN! \n");
                }
	} 
            return GMV;
    }
    
        // Robert Sebastian "Method 4"
        public static void Choose(Customer customer, Account acc) {
            
            Scanner user = new Scanner(System.in);
        System.out.println("\tWelcome to OBTS\n");
        System.out.println("1-Sign In"
         + " \n2-Sign Up ");
        String choice = user.nextLine();
        
        
         if(choice.equals("1")) {
            boolean pininsystem = Account(customer);              
		if(pininsystem==true){
			Transaction(customer, acc);
		} 
		
                
         }
         if (choice.equals("2")) {
                System.out.println("First Name and Last Name:");
                customer.pName = user.nextLine();
                System.out.println("Address:");
                customer.Address= user.nextLine();
                System.out.println("Contact Number:");  
                customer.ContactNum= user.nextLine();
                System.out.println("Account Number:");  
                customer.AccountNum= user.nextLine();
                 System.out.println("Password:");
                customer.password= user.nextLine();
                System.out.println("Enter the Amount Of deposit:");  
                acc.balance= user.nextInt();
               
                System.out.println("CONGRATULATIONS! YOUR ACCOUNT HAS BEEN CREATED.");
                System.out.println("\n-----------------------------------------------");
                Login(customer, acc);           
       }
       }
        
        
        //Daisy Joy Dulay "Method 5"
        public static void Login(Customer customer, Account acc){
            
         Scanner user = new Scanner(System.in);
        System.out.println("\nPlease choose an action");
            System.out.println("1 - Sign in ,2 - Quit ");
            System.out.println("Enter the you number choose:");
            int log  = user.nextInt();
        switch (log) {
        
            case 1:
                System.out.println("\n Welcome "+ customer.pName+" please enter your password bellow!!!");
            boolean pininsystem = Account(customer);               
		if(pininsystem==true){
			Transaction(customer, acc);
		}
                       
            case 2:
                break;
        
        }
        }
       
        
        //Daisy Joy Dulay "Method 6"
	public static void Transaction(Customer customer, Account acc) {
            
             Scanner user = new Scanner(System.in);
        System.out.println("\nAccount Name Holder: " + customer.pName);
        System.out.println("------------------------------------");   
            System.out.println("\nPlease choose an action");
            System.out.println("1 - Show Balance ,2 - Show User Profile , 3 - Pay Bills");
            System.out.println("Enter the you number choose:");
            int userChoice  = user.nextInt();
            System.out.println("");
            
            switch (userChoice) {
                case 1:
                    System.out.println("\nAccount Name Holder: " + customer.pName);
                    System.out.println("YOUR CURRENT BALANCE IS " + acc.balance);
                    System.out.println("\n----------------------------------------");
                    System.out.println("Thank you for banking with us!");
                    break;
                case 2:
                    System.out.println("\nUser Profiles");
                    System.out.println("Name:"+ customer.pName);
                    System.out.println("Address:"+ customer.Address);
                    System.out.println("Contact Number:"+ customer.ContactNum);
                    System.out.println("Account Number:"+customer.AccountNum);
                    System.out.println("\n----------------------------------------");
                    System.out.println("Thank you for banking with us!");
                    break;
                case 3:
                    while(userChoice==3){
                    System.out.println("Enter the amount:");
                    double payAmount = user.nextDouble();
                    
                    if (payAmount > acc.balance) {
                       System.out.println("\nINSUFFICIENT BALANCE, PLEASE TRY AGAIN!");
                      
                    } else{ acc.balance -= payAmount; SendTo(customer, acc); break;}     
                    }  
            }
        }
        
        
        //Daisy Joy Dulay "Method 7"
        public static void SendTo(Customer customer, Account acc) {
             Scanner user = new Scanner(System.in);
            
            System.out.println("\nChoose where we send the Reciept ");
                    System.out.println(" 1- send to Email account \n "
                    +"2-send to contact No.");
                    System.out.println("Enter the number you choose:"); 
                   String Sendto =user.nextLine();
                if(Sendto.equals("1")){
                                Email(customer, acc);
                
                }if(Sendto.equals("2")){
                    SendToContactNumber(customer, acc);
                }
         }
        
        
        //Iris Phoebe Dizon "Method 8"
        public static void Email(Customer customer, Account acc) {
            Scanner user = new Scanner(System.in);
            System.out.println("\nPlease enter your email:");
            String Mail =user.nextLine();
            
            System.out.println("\nThe Reciept will send to your email:"+ Mail);
            SendToEmail(customer, acc);
        }
        
        //Iris Phoebe Dizon "Method 9"
        public static void SendToEmail(Customer customer, Account acc) {
                        System.out.println("\n\t\tReciept ");
                        System.out.println("----------------------------------------");
                        System.out.println("\nSan Isidro Branch, Tarlac City, Tarlac");
                            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                                Date dateobj = new Date();
                                Calendar calobj = Calendar.getInstance();           /*Get Current Date*/
                        System.out.println(df.format(calobj.getTime()));
                        System.out.println("PAYMENT IS SUCCESSFUL");
                        System.out.println("Account Number: "+customer.AccountNum);  /*Get account Number*/
                        System.out.println("Available balance: " + acc.balance);     /*Get the balance left*/ 
                        System.out.println("\n----------------------------------------");
                          System.out.println("Thank you for banking with us!");
                    }
        //Iris Phoebe Dizon "Method 10"
        public static void SendToContactNumber(Customer customer, Account acc) {
                        System.out.println("The Reciept will send to your Contact No.:"+ customer.ContactNum);  /*Get contact Number*/
                        System.out.println("\n\t\tReciept ");
                        System.out.println("--------------------------------------");
                        System.out.println("\nSan Isidro Branch, Tarlac City, Tarlac");
                            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                                Date dateobj = new Date();
                                Calendar calobj = Calendar.getInstance();       /*Get Cuurrent date*/
                        System.out.println(df.format(calobj.getTime()));
                        System.out.println("PAYMENT IS SUCCESSFUL");
                        System.out.println("Account Number: "+customer.AccountNum);             /*Get account Number*/
                        System.out.println("Available balance: " + acc.balance);                /*Get the balance left*/
                        System.out.println("\n----------------------------------------");
                          System.out.println("Thank you for banking with us!");
            
                    }
}
