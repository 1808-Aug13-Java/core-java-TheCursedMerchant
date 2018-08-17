package com.revature.quiz;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class QuizMaster {

	public static void main(String[] args) {
		
		ArrayList<String> associateList = new ArrayList<String>();
		ArrayList<String> questionList = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int randAssociate = 0;
		int randQuestion = 0;
		boolean loop = true;
		
		//Fill Lists with associates and questions 
		associateList.add("Cirey");
		associateList.add("Max");
		associateList.add("Jan");
		associateList.add("Charles");
		associateList.add("Austin");
		associateList.add("Julie");
		associateList.add("Cindy");
		
		questionList.add("Why is java awesome?");
		questionList.add("What is the difference between final, finally, and finalize?");
		questionList.add("What is variable shadowing?");
		questionList.add("What are the differences between the Collection subclasses?");
		questionList.add("What does synchronis and asynchronis mean in regard to threads?");
		questionList.add("How do we make a custom class follow a natural order?");
		questionList.add("What is the Reflection package? What is it used for?");
		
		//Intro
		System.out.println("Welcome to the Game! Press any key to start");
		sc.nextLine(); 
		
		while(associateList.size() >= 1 && questionList.size() >= 1)
		{
			randAssociate = rand.nextInt(associateList.size());
			randQuestion = rand.nextInt(questionList.size());
			System.out.println(associateList.get(randAssociate)+ "            " + questionList.get(randQuestion));
			associateList.remove(randAssociate);
			questionList.remove(randQuestion);
			sc.nextLine();
		}
	}

}
