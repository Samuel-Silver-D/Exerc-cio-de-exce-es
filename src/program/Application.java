package program;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import entities.exceptions.DomainException;

public class Application {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			Double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
			Account acc = new Account(number, holder, balance, withdrawLimit);
			
			System.out.println();
			System.out.print("Are you going to make a withdrawal or a deposit(w/d)?");
			char ch = sc.next().charAt(0);
			if (ch == 'w') {
			System.out.print("Enter amount for withdraw: ");
			Double amount = sc.nextDouble();
			acc.withdraw(amount);
			}
			else if(ch == 'd') {
				System.out.print("Enter amount for deposit: ");
				Double amount = sc.nextDouble();
				acc.deposit(amount);	
			}
			System.out.println("New balance: " + acc);
	        sc.close();
		}
		catch(InputMismatchException e){
			System.out.println("Invalid characters!");
		}
		catch(DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
	}

}
