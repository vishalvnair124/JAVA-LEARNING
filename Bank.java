import java.util.Scanner;
class BankAccount{
	int accId;
	String accName;
	int accBalance;
	String accPhone;
	String accEmail;
	
	int getBalance(BankAccount[] acc ,int accId){
	return acc[accId].accBalance;
	}
	void getAccountInfo(BankAccount[] acc,int i){
	System.out.println("Wellcome to Bank of 124Tech");
	System.out.println("Account id      :"+acc[i].accId);
	System.out.println("Name            :"+acc[i].accName);
	System.out.println("Your balance    :"+getBalance(acc ,acc[i].accId));
	System.out.println("Your phone      :"+acc[i].accPhone);
	System.out.println("Your email      :"+acc[i].accEmail);
	}
	
	void transferMoney(BankAccount[] acc,int i){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter money which you are transfering      :");
		int money = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter account ID which you are transfering :");
		int id = sc.nextInt();
		sc.nextLine();
		if((acc[i].accBalance - money) > 0){
			 acc[i].accBalance -= money;
			 acc[id].accBalance += money;
			 System.out.println("Your money amount "+ money +" Succesfully transfered,Your Cureent balance "+acc[i].accBalance);
		 }else{
			 System.out.println("Insufficien balance. you can't withdraw money");
	   }
	}
	void withdraw(BankAccount[] acc,int i){
	Scanner sc = new Scanner(System.in);
	
     System.out.println("Enter money which you are withdrawing :");
	 int money = sc.nextInt();
	 sc.nextLine();
	 if((acc[i].accBalance - money) > 0){
		 acc[i].accBalance -= money;
		 System.out.println("Your money amount "+ money +" Succesfully withdrawed,Cureent balance "+acc[i].accBalance);
     }else{
		 System.out.println("Insufficien balance.");
	 }
	}
	void deposit(BankAccount[] acc,int i){	
	Scanner sc = new Scanner(System.in);
	 System.out.println("Enter money which you are depositing :");
	 int money = sc.nextInt();
	 sc.nextLine();
	 acc[i].accBalance += money;
	}
	void newAccount(int numOfAcc){	
	Scanner sc = new Scanner(System.in);
	System.out.println("Wellcome to Bank of 124Tech");
	System.out.println("Your account id           : "+numOfAcc);
	this.accId = numOfAcc;
	System.out.print("Enter your Name           : ");
	this.accName = sc.nextLine();
	System.out.print("Enter your intial balance : ");
	this.accBalance = sc.nextInt();
	sc.nextLine();
	System.out.print("Enter your phone          : ");
	this.accPhone = sc.nextLine();
	System.out.print("Enter your email          : ");
	this.accEmail = sc.nextLine();
	}
}
class Bank{
	static void clearScreen(){
		System.out.print("\033[H\033[2J");
        System.out.flush();
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		BankAccount[] bank = new BankAccount[100];
		System.out.println("Wellcome to Bank of 124Tech");
		int op = -1 ,numOfAcc = 0 ,accNo = 0 ;
		while(op != 0){
			System.out.println("Enter what you want");
			op = sc.nextInt();
			switch(op){
			case 0:
			      System.out.println("Good bye from, Bank of 124Tech");
			case 1:
			      clearScreen();
			      numOfAcc++;
			      bank[numOfAcc] = new BankAccount();
			      bank[numOfAcc].newAccount(numOfAcc);
			      break;
			case 2:
			      clearScreen();
			      System.out.println("Enter account number you want :");
			      accNo = sc.nextInt();
			      bank[numOfAcc].getAccountInfo(bank, accNo);
			      break;
			case 3:
			      clearScreen();
			      System.out.println("Enter account number you want :");
			      accNo = sc.nextInt();
			      bank[numOfAcc].transferMoney(bank, accNo);
			      break;
			case 4:
			      clearScreen();
			      System.out.println("Enter account number you want :");
			      accNo = sc.nextInt();
			      bank[numOfAcc].withdraw(bank, accNo);
			      break;
			case 5:
			      clearScreen();
			      System.out.println("Enter account number you want :");
			      accNo = sc.nextInt();
			      bank[numOfAcc].deposit(bank, accNo);
			      break;
			default:
			      System.out.println("Please Select a correct option!");
			}
			
		}
	}
}
