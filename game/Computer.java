package game;
import java.util.Random;

public class Computer extends Guy{
    int difficulty;
//fields are located in guy class
    Computer(String name, int difficulty,int identity ){
    	this.difficulty = difficulty;
    	this.name = name;
    	this.Identity = identity;
    }
@Override
public int startTurn(){
    
    try {
        Thread.sleep(Question.TIME );
    } catch (InterruptedException e) {}

   
    
    rocksInHand =  new Random().nextInt(numRocks + 1);
   
    System.out.println();
    System.out.println(name + " has chosen his rocks");
    
    return(rocksInHand);
}
//n doit etre le numTotalRocks du main



@Override
 public int Turn(){
		 try {
			    Thread.sleep(Question.TIME );
			} catch (InterruptedException e) {
			    
			}
    
    
	
		   
	if(difficulty == 1){
		    do{
		    	 choice = rocksInHand + new Random().nextInt(RockPlay.rocksInGame - numRocks + 1);
		    }while(RockPlay.previousAnswers.get(1).contains(choice));
	}
	
	
	
	
	if(difficulty ==2){
			int rocksTakenIntoAccount=0;
	 	int target = 0;
	 	int impossibleTarget;
	 	//this whole thing is to change because the structure of the previousAnswers is changed
	 	for(int x = 0; x < RockPlay.previousAnswers.get(1).size();x++){
			
	 		impossibleTarget = RockPlay.previousAnswers.get(1).get(x) - Math.round((RockPlay.rocksInGame-RockPlay.bro[RockPlay.previousAnswers.get(0).get(x)].numRocks)/2);
			//the choice of the person minus the average of the rocks of all the other players is an approximation to what each player is thinking
			if(impossibleTarget <0){
				impossibleTarget = 0;
			}else if(impossibleTarget > RockPlay.bro[RockPlay.previousAnswers.get(0).get(x)].numRocks){
				impossibleTarget =RockPlay.bro[RockPlay.previousAnswers.get(0).get(x)].numRocks;
			}
			
			
			target += impossibleTarget;
			rocksTakenIntoAccount+=RockPlay.bro[RockPlay.previousAnswers.get(0).get(x)].numRocks;
			
		}
	 	
	 	//the previous is added before, the later is in the next line ad his own rocks the lie after that
	 	target += Math.round((RockPlay.rocksInGame-rocksTakenIntoAccount-numRocks)/2); //we add a random number for the rocks not taken into account
	 	target += rocksInHand;
		//if the number is already taken, we circle away from the target until we find a spot
	
		int distance = 0;
		int posNeg = 1;
	
		boolean addDistance = true;
	
		do{
			choice = target + ((-1)^posNeg)*distance;
	
			if(addDistance){
				distance++;
		
			}
	
			addDistance ^= true;
			posNeg++;
			if(choice<0){
				choice =0;
			}
		
		}while(RockPlay.previousAnswers.get(1).contains(choice));
	
	}
	
	if(difficulty == 3){  //this algorythm evaluates each position of players individually
		int prevInfluence=0;
		int rockRemain= RockPlay.rocksInGame;
		int rocks;
		
		for(int x =0; x< RockPlay.previousAnswers.get(0).size();x++){
			rockRemain -= RockPlay.bro[RockPlay.previousAnswers.get(0).get(x)].numRocks;
			
			rocks = RockPlay.previousAnswers.get(1).get(x)-prevInfluence  - Math.round((rockRemain)/2);//his own rocks are not included in the rockRemain
			//his choice, minus previous estimates, minus his rocks, minus the mean of the next players equals his rocks.
			
			if(rocks< 0){
				rocks=0;
			}else if(rocks>  RockPlay.bro[RockPlay.previousAnswers.get(0).get(x)].numRocks){
				rocks = RockPlay.bro[RockPlay.previousAnswers.get(0).get(x)].numRocks;
			}
			
			prevInfluence += rocks;
			
			
		}
		System.out.println(rockRemain);
		int target = prevInfluence + rocksInHand + Math.round((rockRemain-numRocks)/2);
		
		
		int distance = 0;
		int posNeg = 1;
	
		boolean addDistance = true;
	
		do{
			choice = target + ((-1)^posNeg)*distance;
	
			if(addDistance){
				distance++;
		
			}
	
			addDistance ^= true;
			posNeg++;
		
		}while(RockPlay.previousAnswers.get(1).contains(choice)); // how can this work?
		//it seems to work, although checking inside arrays inside previousAnswers
		
	}
	RockPlay.previousAnswers.get(0).add(Identity);
	RockPlay.previousAnswers.get(1).add(choice);
	
	System.out.println();
		    //pour une difficulté plus élevé:
		    //choice = rocksInHand + (int)((n - rocksInHand)/2) + w;
			    if(numRocks != 1 && choice != 1){
			    	System.out.println(name + " (he has " + numRocks + " rocks) : I think there are " + choice + " rocks");
			    }
			    else if (numRocks == 1){
			    	System.out.println(name + " (he has " + numRocks + " rock) : I think there are " + choice + " rocks");
			    }
			    else if(choice == 1){
			    	System.out.println(name + " (he has " + numRocks + " rocks) : I think there is " + choice + " rock");
			    }
			    else{
			    	System.out.println(name + " (he has " + numRocks + " rock) : I think there is " + choice + " rock");
			    }
			   
		    
		    return(choice);
		
	}	
		
	}



