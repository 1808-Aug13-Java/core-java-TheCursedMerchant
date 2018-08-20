package com.revature.banking;

import java.util.Scanner;

public class BankMaster {

	public static void main(String[] args) {
		
		//Application Variables
		Scanner sc = new Scanner(System.in);
		DataMaster dm = new DataMaster();
		Banker bankMan = new Banker();
		String inputStr, emailAddress, username, password;
		boolean signInLoop = true;
		boolean bankMenuLoop =  false;
		
		while(true)
		{
			//Introduction
			System.out.println("Welcome to Francis Banking");
			System.out.println("Are you a new user?");
		
			inputStr = sc.nextLine();
		
			while(signInLoop)
			{ 
				//TODO: Enter credentials
				System.out.println("Please enter your email address: ");
				emailAddress = sc.nextLine();
				System.out.println("Please enter your username: ");
				username = sc.nextLine();
				System.out.println("Please enter your password: ");
				password = sc.nextLine();

				//Check if registering or signing in
				if(inputStr.equals("yes"))
				{
					//TODO: Create Account
					dm.setEmailAddress(emailAddress);
					dm.setUsername(username);
					dm.setPassword(password);
					dm.setBalance(0);
					dm.saveAccount(true);
					System.out.println("Account created!");
					signInLoop = false;
					bankMenuLoop = true;
				}
				else if(inputStr.equals("no"))
				{
					//TODO: Verify Account
					if(dm.verifyAccount(emailAddress, username, password))
					{
						//TODO: Go to bank menu
						signInLoop = false;
						bankMenuLoop = true;
					}
					else
					{
						//TODO: Retry 
						System.out.println("Sorry account not found!");
						System.out.println("Try again?");
						inputStr = sc.nextLine();
						
						//If no close application
						if(inputStr == "n")
						{
							System.exit(0);
						}
						//Else do nothing start loop over
					}
				}
				else
				{
					System.out.println("Invalid input!");
				}
			}

			while(bankMenuLoop)
			{
				//TODO: Menu
				System.out.println("What can we do for you today?");
				displayMenu();
				inputStr = sc.nextLine();

				//Respond to inputs
				switch(inputStr) {

				case "1":
					bankMan.withdraw(dm);
					break;
				case "2":
					bankMan.deposit(dm);
					break;
				case "3":
					bankMan.showBalance(dm);
					break;
				case "4":
					//Signout
					signInLoop = true;
					bankMenuLoop = false;
					break;
				case "5":
					//Exit the program
					System.exit(0);
					break;
				default:
					System.out.println("Invalid input");
					break;
				}
			}
		}
	}
	
	public static void displayMenu()
	{
		System.out.println("1. Make a withdrawal");
		System.out.println("2. Make a deposit");
		System.out.println("3. Show Balance");
		System.out.println("4. Sign Out");
		System.out.println("5. Close Application");
	}

}
