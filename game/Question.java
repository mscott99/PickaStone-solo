package game;

import java.util.Scanner;

public class Question {
	//Why is the constant time in this class? It had to be somewhere
	
	final static public int TIME =150;
	static Scanner scanner= new Scanner(System.in);
	static Scanner scannerLine = new Scanner(System.in); //the scanner first scanner desnt work for
	static Scanner instructionsScanner = new Scanner(System.in);
	private static int minInt;               // line reading, leave a comment if you know why
	private static int maxInt;
	
	
	

	//used with recursion in questionInt. Recursion is actually used if their is an error from the user
	static private int findInt(){
	
		if(scanner.hasNextInt()){
		     int answer= scanner.nextInt();
			
			     if(answer<=maxInt&& answer>=minInt){
			    	 
			    	 
			    	 return(answer);
				
				}
		}else{
			scanner.next();  //here, we want it to run only if scanner.nextInt did'nt. the last part of the code we want it to run anyways
		}
		System.out.println("Sorry, the answer is not valid. Try again:");
		           
		return(findInt());
		
		//avoid error
		
		
	}
		//used only for the instructions question
	static private String findString(){
		
		     String answer= instructionsScanner.nextLine();
		     
			     if("yes".equals(answer)){
			    	 
			    	 return(
						 
"This is a game where each players, at the start of each round, chooses a certain" + '\n' +
"number of rocks from the ones he posesses(3 at the start) and places them in his" + '\n' +
"'hand'. He therefore can choose between taking 0, 1, 2 or 3 rocks at the beginning" + '\n' +
"of the first round. Then, each player tries to guess at their turn the total amount" + '\n' +
"of rocks chosen by all players(including themselves). A player cannot guess a number" + '\n' +
"if it has already been guessed previously by another player. If your guess is" + '\n' +
"accurate, you win the round, which means that you loose a rock from your stack. At" + '\n' +
"the start of the next round, you will have one less rock from which yu can choose" + '\n' +
"choose. For example, after winning a total of one round, your possible choices become" + '\n' +
"limited to 0, 1 or 2 rocks at the beginning of your round. If you are able to loose" + '\n' +
"all your rocks before any other player, you win the game."+ '\n' + '\n' +

"When playing in the command line, enter your answers to the displayed questions" + '\n' +
"in numbers or in letters, depending on the question, then press enter. This version" + '\n' +
"of the game only plays with one human player and as many computers as you wish.");

                                }else if("no".equals(answer)){
                                        return("");
	}	else{
			
			System.out.println("Sorry, the answer is not valid. Try again:");
			return(findString());
			//here, we want it to run only if scanner.nextInt did'nt. the last part of the code we want it to run anyways
		}
		
	}
		
	
	

	static int questionInt(String question, int low, int high){
		  //stored as fields to be used by the recursion functions
		 try {
		        Thread.sleep(Question.TIME);
		    } catch (InterruptedException e) {
		    }
		
		minInt = low;
		maxInt = high;
		System.out.println();
		System.out.println(question);
		
		return(findInt());
	
	}



//this doesnt need recursion; there is no risk 
	static String questionString(String n){
     
		//pause before asking, question; program is more friendly
		
		
		System.out.println();
		System.out.println(n);
     
      
      return(scannerLine.nextLine()); 
 }
	
	
	
	
	static void questionInstructions(){
		try {
	        Thread.sleep(Question.TIME);
	    } catch (InterruptedException e) {}
		System.out.println();
		
		System.out.println("This is the Pick-a-Stone solo game. Do you need instructions? (answer: yes or no)");
		
		String result = findString();
		
		if("".equals(result)==false){
		
			System.out.println(result);
		}
	}
}




