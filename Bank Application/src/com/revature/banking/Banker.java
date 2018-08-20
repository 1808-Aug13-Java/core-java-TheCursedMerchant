package com.revature.banking;

import java.util.InputMismatchException;
import java.util.Scanner;

//Deals with all banking operations 
public class Banker {
	
	
	public void deposit(DataMaster dm)
	{
		//Deposit money into account balance
		Scanner sc = new Scanner(System.in);
		double depositAmnt;
		double balance = dm.getBalance();
		//Withdraw money from account balance 
		System.out.println("How much would you like to deposit?");
		
		try {
			depositAmnt = sc.nextDouble();
			dm.setBalance(balance + depositAmnt);
			dm.saveAccount(false);
			System.out.println("Money deposited!");
			showBalance(dm);
		}catch(InputMismatchException e){
			e.getMessage();
			System.out.println("Please enter a valid dollar amount!");
		}
	}
	
	public void withdraw(DataMaster dm)
	{
		Scanner sc = new Scanner(System.in);
		double withdrawAmnt;
		double balance = dm.getBalance();
		//Withdraw money from account balance 
		System.out.println("How much would you like to withdraw?");
		
		try {
			withdrawAmnt = sc.nextDouble();

			if(dm.getBalance() - withdrawAmnt > 0)
			{
				dm.setBalance(balance - withdrawAmnt);
				dm.saveAccount(false);
				System.out.println("Money Withdrawn!");
				showBalance(dm);
			}
			else
			{
				System.out.println("Not enough funds! Transaction cancelled!");
			}
		} catch(InputMismatchException e) {
			e.getMessage();
			System.out.println("Please enter a valid dollar amount!");
			withdraw(dm);
		}
	}
	
	public void showBalance(DataMaster dm)
	{
		//Display the accounts current balance 
		System.out.println("Your current Balance is: $" + dm.getBalance());
	}

}
