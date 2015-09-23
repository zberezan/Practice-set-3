package Package1;

import java.util.Date;
import java.util.Scanner;

public class Accountmain {
	static Scanner inputs = new Scanner(System.in);

	public static void main(String[] args) {
		double interestrate = .045;
		System.out.println("Please enter your account number:");
		int id = inputs.nextInt();
		System.out.println("account not found creating new account...");
		System.out.println("Enter the amount you are deposting for initial balance");
		double balance = inputs.nextDouble();
		Account accountone = new Account(id, balance);
		System.out.println("New account created with id " + id + " and balance " + accountone.getBalance());
		Date date = new Date();
		System.out.println("created on " + date.toString());
		for (int i = 1; i < 3; i++) {
			System.out.println("What do you what to do? "
					+ "1.deposit, 2.withdraw, 3.check annual/monthly interest rate, 4.info, 5.quit");
			System.out.println("Choose number corisponding with action");
			int input = inputs.nextInt();
			if (input == 1) {
				System.out.println("How much would you like to deposit");
				double deposit = inputs.nextDouble();
				accountone.deposit(deposit);
				System.out.println("Your new balance is " + accountone.getBalance());
				i = 1;
				continue;
			}
			if (input == 2){
				System.out.println("How much would you like to withdraw");
				double withdraw = inputs.nextDouble();
				try {
					accountone.withdraw(withdraw);
				} catch (InsufficientFundsException e) {
					e.printStackTrace();
				}
				System.out.println("Your new balance is " + accountone.getBalance());
				i = 1;
				continue;
			}
			if (input == 3){
				System.out.println("Your interest rate is "+ interestrate);
				System.out.println("Your monthly interest rate is " + interestrate/12);
				i = 1;
				continue;
				
				
			}
			if (input == 4){
				System.out.println("Your account info is:");
				System.out.println("Account ID: "+ id);
				System.out.println("balance: "+ accountone.getBalance());
				System.out.println("annual interest rate: " + interestrate);
				System.out.println("Date created: " + date.toString());
				i = 1;
				continue;
				
			}
			if (input == 5){
				System.out.println("shutting down...");
				i = 3;
			}
			else{
				System.out.println("that is not a correct input try again");
				i = 1;
			}

		}
	}
}