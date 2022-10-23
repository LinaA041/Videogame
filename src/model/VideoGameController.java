package model;

import java.util.Random;
 
public class VideoGameController {
	
	
  private Player[] players;
  private Level[] levels;
  private Treasure[] treasures;
  private Enemy [] enemies;
	
	
  public VideoGameController() {
	
	this.players = new Player [20];
	this.treasures = new Treasure [50];
	this.enemies = new Enemy[25];
	this.levels = new Level [10];
	
    }

	/**
	 * Description: this method performs two processes, it registers a player with the necessary parameters,
	 * but it also verifies that the player's nickname is unique. 
	 * pre: The nickname is unique, therefore there should be no players with the same 
	 * nickname within the same level
	 * pos: none
	 * @param nickName String player nickname 
	 * @param name String player's name 
	 * @return true boolean if the player could be registered
	 */ 
	public boolean registerPlayer(String nickName, String name) {

	boolean nickNameIsRegistered = false;

		for (int j = 0; j<players.length && !nickNameIsRegistered;j++){
			
			if (players[j] != null) {
				
				if(players[j].getNickName().equals(nickName)){
				
					nickNameIsRegistered = true;
				
				}
				
			}
			
		}


		Player newPlayer = new Player(nickName, name);
       
		for (int i = 0; i < players.length && !nickNameIsRegistered; i++) {

			if (players[i] == null) {

				players[i] = newPlayer;
				return true;
			}
		}

		return false;

	}
	
	/**
	 * Description: Will scroll through the array of players and display the players within the array.
	 * pre: that there are registered players 
	 * pos: none
	 * @return msg String message with registered players
	 */
	public String showPlayers() {

		String msg = "";

		for (int i = 0; i < players.length; i++) {

			if (players[i] != null) {

				msg += players[i].toString();
			}

		}
		return msg;

	}
	
	
	/**
	 * Description: Records a level with all required parameters
	 * @param identifierNumber int level identifier number
	 * @param passingsPoints int points to pass this level 
	 * @return true boolean if the level could be registered successfully
	 */
	public boolean registerLevel( int identifierNumber, int passingsPoints) {

		Level newLevel = new Level(identifierNumber,1, passingsPoints);

		for (int i = 0; i < levels.length; i++) {

			if (levels[i] == null) {

				levels[i] = newLevel;
				return true;
			}

		}

		return false;

	}
	
	/**
	 * Description: this method determines whether the complexity of the level is high, low or medium, 
	 * taking into account the score given by the treasures and the score subtracted by the enemies of that level.
	 * pre: none
	 * pos:none 
	 * @param levelPosition int the position in the array at which the level for which 
	 * the complexity needs to be found is located 
	 * @return not return
	 */
	public void calculateComplexityLevel (int levelPosition){

		int enemiesPoints = levels[levelPosition].obtainScoreOfEnemies();

		int treasuresPoints = levels[levelPosition].obtainScoreOfTreasures();

		 if(treasuresPoints>enemiesPoints){ 
		  
		    levels[levelPosition].setComplexityLevel(Complexity.LOW); 
		 
		    }else if(treasuresPoints == enemiesPoints){

		    levels[levelPosition].setComplexityLevel(Complexity.MIDDLE);

		    }else{

		    levels[levelPosition].setComplexityLevel(Complexity.HIGH);
            
		    }
	}
	
	/**
	 * Description: Will scroll through the array of levels and display the levels within the array.
	 * pre: that there are registered levels
	 * pos: none
	 * @return msg String message with registered levels
	 */
	public String showLevels() {

		String msg = "";

		for (int i = 0; i < levels.length; i++) {

			if (levels[i] != null) {

				msg += levels[i].toString();
			}

		}
		return msg;

	}
	
	/**
	 * Description:records an enemy with all its attributes 
	 * pre: none
	 * pos: none
	 * @param identifier String enemy identifier name 
	 * @param enemyType int type of enemy
	 * @param pointsLost int subtracting points 
	 * @param pointsGained int points awarded when defeated 
	 * @return true boolean if it was registered correctly 
	 */
	public boolean registerEnemy(String identifier, int enemyType, int pointsLost, int pointsGained) {

		Enemy newEnemy = new Enemy(identifier, enemyType, pointsLost, pointsGained,1,1);

		 
		for (int i = 0; i < enemies.length; i++) {

			if (enemies[i] == null) {

				enemies[i] = newEnemy;
				return true;
			}
		}
    
    	return false;

	}
	
	/**
	 * Description: Will scroll through the array of enemies and display the enemies within the array.
	 * pre: that there are registered enemies
	 * pos: none
	 * @return msg String message with registered enemies
	 */
	public String showEnemies() {

		String msg = "";

		for (int i = 0; i < enemies.length; i++) {

			if (enemies[i] != null) {

				msg += enemies[i].toString();
			}

		}
		return msg;

	}
	
	/**
	 * Description: Register a treasure by complying with all your parameters 
	 * pre: none
	 * pos: none
	 * @param treasureName String
	 * @param imageUrl String url of the image belonging to said treasure 
	 * @param treasureValue int points awarded by the treasury 
	 * @param quantity int amount of a treasure
	 * @return true boolean if the treasury was successfully registered 
	 */
	public boolean registerTreasure(String treasureName, String imageUrl, int treasureValue, int quantity) {

		Treasure newTreasure = new Treasure(treasureName, imageUrl, treasureValue, quantity,1,1);

		 
		for (int i = 0; i < treasures.length; i++) {

			if (treasures[i] == null) {

				treasures[i] = newTreasure;
				return true;
			}
		}
    
    	return false;

	}
	
	/**
	 * Description: shows the registered treasures
	 * pre: none
	 * pos: none
	 * @return msg String message with registered treasures 
	 */
	public String showTreasures() {

		String msg = "";

		for (int i = 0; i < treasures.length; i++) {

			if (treasures[i] != null) {

				msg += treasures[i].toString();
			}

		}
		return msg;

	}
	
	/**
	 * Description if the player could not pass to the desired level, 
	 * this method indicates how many points are needed to achieve it. 
	 * @param playerPosition int position in the player's arrangement 
	 * @param levelPosition int  position of a level in the array 
	 * @param score int player's score 
	 * @return msg String message indicating whether or not the player has passed a level, in case he/she is
	 * not able to climb to that level, the message will include the points that are missing to pass the level. 
	 */
	public String incrementPlayerLevel(int playerPosition, int levelPosition, int score){

     String msg = "";

      if(assignPlayerLevel(playerPosition, score)){ 
	  
			players[playerPosition].setLevelPlayer(levels[levelPosition]);

            msg = "Player leveled up";
			
		}else{

			msg = "Could not be upgraded, the player lacks"+ (levels[levelPosition].getPassingPoints() - players[playerPosition].getScore())+" points";

        }
		
		return msg;
	}

	
	/**
	 * Description: assigns a level to a player 
	 * @param playerPosition the position of the player to whom you want to assign a level 
	 * @param score int player's score 
	 * @return true boolean if the player has met the required points for that level 
	 */
	public boolean assignPlayerLevel(int playerPosition, int score){ 
		
		 
		for(int i=0;i<levels.length;i++) {
		
			if (levels[i].getPassingPoints()>score){
				
				players[playerPosition].setLevelPlayer(levels[i]);
				
				return true;
			}
	
		}
	 return false;
	}
	
	/**
	 * Description: Modifies the score of a given player 
	 * pre: none
	 * pos: none
	 * @param playerPosition int position player's position in the arrangement
	 * @param score int the new player score 
	 * @return no return 
	 */
	public void assignPlayerScore(int playerPosition, int score){ 

		players[playerPosition].setScore(score);
		
	}
	
	
	/**
	 * Description:is in charge of adding a certain enemy to a certain level and placing it randomly inside it, 
	 * also when it is added to a specific level it allows to calculate its complexity. 
	 * pre: none
	 * pos: none
	 * @param numberLevel int position in the array where the level to which you want to add the enemy is located 
	 * @param enemyPosition int position in the array where the enemy to be added is located 
	 * @return true boolean if the enemy could be added to the level 
	 */
	public boolean addEnemyToLevel(int numberLevel, int enemyPosition){
		
		Random position = new Random();
		
		int positionX = position.nextInt(1280);
	
	    int positionY = position.nextInt(720);
	
	    enemies[enemyPosition].setPositionX(positionX);
	
	    enemies[enemyPosition].setPositionY(positionY);
		
		calculateComplexityLevel(numberLevel);
	
		return levels[numberLevel].addEnemy(enemies[enemyPosition]);	

	}
	
	
	/**
	 * Description: this method performs several actions, the main one is to add a treasure to a level, however,
	 * it also randomly generates the location of the treasure and helps to calculate the complexity of the level 
	 * to which it will be added.
	 * pre: none
	 * pos: none
	 * @param levelNumber int position in the array where the level to which we want to add a treasure is located 
	 * @param treasureNumber int position in the treasury arrangement we wish to add 
	 * @return boolean if the treasure was successfully added to the level 
	 */
	public boolean addTreasureToLevel(int levelNumber, int treasureNumber){
			
		Random position = new Random ();
		
		int positionX = position.nextInt(1280);
		
		int positionY = position.nextInt(720);
		
		treasures[treasureNumber].setPositionX(positionX);
		
		treasures[treasureNumber].setPositionY(positionY);
		
		calculateComplexityLevel(levelNumber);
		
		
		return levels[levelNumber].addTreasure(treasures[treasureNumber]);
		 
	}
	
	/**
	 * Description: Will calculate the most repeated treasure and the number of times it is repeated. 
	 * pre:none
	 * pos:none
	 * @return msg2 String message indicating the most repeated treasure 
	 */
	public String reportingRepeatedTreasure(){
		
		int count = 0;
		
		String msg = "";
		
		String msg2 = "";
		
		for(int i=0; i<levels.length;i++){
			
			for(int j=0;j<levels[i].getTreasureList().length;j++){
				
				if(levels[i].getTreasureList()[j]!=null){
				
				    if(count<=levels[i].getTreasureList()[j].getQuantity()){
				
			         msg = levels[i].getTreasureList()[j].getTreasureName();
				     
					 count = levels[i].getTreasureList()[j].getQuantity();
			        }
				
				}
				
			}	
			
		}
		
		 msg2 += "The most repeated treasure is: "+msg+" repeating "+count;
		
		 
		return msg2;
	}
	
	
	/**
	 * Description: Calculates the existing quantity of a specific treasure previously indicated by the user 
	 * pre:none
	 * pos:none
	 * @param treasureName String name of the treasure for which the amount is required
	 * @return msg String message with the existing amount of this treasure 
	 */
	public String amountOfATreasure(String treasureName ){
		
		int count = 0;
		
		String msg = "";
		
		for(int i=0; i<levels.length;i++){
			
			if(levels[i].getTreasureList()[i]!=null){
				
				count = count+levels[i].calculateAmountOfTreasure(treasureName);
			}
		
		}
		 msg += "The treasure is: "+count+"at all levels";
		
		 
		return msg;
	}
	
	/**
	 * Description: Calculates the specific quantity of an enemy type, previously specified by the user 
	 * pre: that the number indicated belongs to some type of enemy
	 * @param enemyType int number corresponding to the type of enemy
	 * @return msg String message with the specific quantity of that type of enemy 
	 */
	public String calculateQuantityOfEnemyType(int enemyType){
		
		int count = 0;
		
		String msg = "";
		
		 for (int i=0; i<levels.length;i++) {

            if (levels[i]!= null) {
				
                count = count + levels[i].obtainQuantityEnemyType(enemyType);

            }
        }
		
		msg += "The number of enemies of this type is in all levels is: "+count;
		
		return msg;
	}
	
	/**
	 * Description: Will show the enemies and treasures added to a level previously indicated by the user. 
	 * pre: none
	 * pos:none
	 * @param levelPosition int level of which we want to know its treasures and enemies. 
	 * @return msg3 String message displaying the enemies and treasures of a certain level 
	 */
	public String reportNumberEnemiesAndLevels(int levelPosition){
		
		String msg = "";
		
		String msg2 = "";
		
		String msg3 = "";
		
		for(int i=0; i<levels.length;i++){
			
			for(int j=0;j<levels[i].getTreasureList().length;j++){
				
				if(levels[i].getTreasureList()[j]!=null){
				
			         msg += levels[i].getTreasureList()[j].getTreasureName()+", ";
			        
				}
				
			}
				
			for(int j=0;j<levels[i].getEnemyList().length;j++){
				
				if(levels[i].getEnemyList()[j]!=null){
				
			         msg2 += levels[i].getEnemyList()[j].getIdentifier()+", ";
			        
				}
				
			}	
			
		}
		
		 msg3+= "The treasures of this level are: "+msg+", and the enemies of this level are "+msg2;
		
		return msg3;
		
	}
	

	/**
	 * Description:consists of comparing the different points that the enemies give each other, 
	 * until you get the enemy that is above the rest, in terms of the score it gives.
	 * pre: none
	 * pos: none
	 * @return msg String message indicating the name of the highest scoring player and 
	 * his position with respect to the level arrangement 
	 */
	public String obtainEnemyWhoAwardsMostPoints(){
			
		int points=0;
		int level=0;
        String msg="";
		
		int enemy = 0;

        for(int i=0; i<levels.length; i++){
			
            for(int j=0; j<levels[i].getEnemyList().length; j++){
               
			   if(levels[i].getEnemyList()[j]!=null){
                    
					if(levels[i].getEnemyList()[j].getPointsGained()>points){
                       
					   points = levels[i].getEnemyList()[j].getPointsGained();
					   level =i;
					   enemy=j;
                    }
                }
            }
        }
		if(levels[level].getEnemyList()[enemy]!=null){
			
			msg = "the highest-scoring enemy is: "+levels[level].getEnemyList()[enemy].getIdentifier() + " and is located at the level: " + (level+1);
		}
        
        return msg;
	}

	
	/**
	 * Description: calculates the number of consonants that can be found in enemy names 
	 * pre: there must be registered enemies
	 * pos: none
	 * @return msg String message indicating the number of consonants present in the enemies' names 
	 */
	public String obtainNumberOfEnemyConsonants(){
		
		String msg ="";

		String identifier = "";
		String [] consonants ={"b","c","d","f","g","h","j","k","l","m","n","ñ","p","q","r","s","t","v","w","x","y","z"};
		int count=0;

		for(int i=0;i<enemies.length;i++){
          
			if(enemies[i]!=null){
            
				identifier = enemies[i].getIdentifier();

                identifier = identifier.toLowerCase();
                
				for(int j=0;j<identifier.length();j++){
                
				String consonant = identifier.substring(j,j+1);
                   
				  for(int k=0;k<consonants.length;k++){
                     
					if(consonant.equals(consonants[k])){
						
						count +=1;
						
						k = consonants.length;
					   }
                    }
				}
			}

		}
        
		msg += "the number of consonants found in the names of the enemies is:"+count;
		return msg;
	}
	
	/**
	 * Description: Allows you to consult the players with the highest score and places them in the top five
	 * pre: that there are registered players 
	 * pos: none
	 * @return msg String message that will display the players and their respective scores. 
	 */
	public String consultTopFivePlayers(){

		String msg="Top Five Players: \n";
			
		Player[] copyPlayers = players; 
		
		Player[] topPlayers  = new Player[5];
		
		boolean out = false;
		   
		int i = 0;	
		
		while(i<5){
    
        topPlayers[i] = findMax(copyPlayers);
                       
 		    for(int j=0; j<copyPlayers.length && !out;j++){
         
		     if(topPlayers[i]==copyPlayers[j]){
           
		        copyPlayers[j] = null;
                            
				   out =true;
             
			 }
                        
		    }
                        
			 i++;
                      
			 out = false;
        }
						
		if (topPlayers[0]!= null) {
				
			for (i = 0; i < topPlayers.length; i++) {
					
				if (topPlayers[i] != null) {
						
				    msg += i + 1 + " " + topPlayers[i].getNickName() + " - " + topPlayers[i].getScore()+ " points\n";
					
					}
				}
			}

			return msg;
	}
	

	/**
	 * Description: calculates the player with the highest score 
	 * pre: that there are registered players
	 * pos: none
	 * @param Players Player arrangement of players 
	 * @return bestPlayer Player the player with the highest score
	 */

	public Player findMax(Player []Players){
    
	int max = 0;
	
	Player bestPlayer = null;
	
		for (int i = 0; i<players.length; i++){
			
			if(players[i]!=null && players[i].getScore()>max){
			
				bestPlayer = players[i];
				max = bestPlayer.getScore();
			  
			
			}      
		}
		  
	  return bestPlayer;
    }

}
