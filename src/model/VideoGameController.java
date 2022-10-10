package model;

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
	
	public String showPlayers() {

		String msg = "";

		for (int i = 0; i < players.length; i++) {

			if (players[i] != null) {

				msg += players[i].toString();
			}

		}
		return msg;

	}
	
	
	public boolean registerLevel( int identifierNumber, int passingsPoints) {

		Level newLevel = new Level(identifierNumber, passingsPoints);

		for (int i = 0; i < levels.length; i++) {

			if (levels[i] == null) {

				levels[i] = newLevel;
				return true;
			}

		}

		return false;

	}
	
	public String showLevels() {

		String msg = "";

		for (int i = 0; i < levels.length; i++) {

			if (levels[i] != null) {

				msg += levels[i].toString();
			}

		}
		return msg;

	}
	
	public boolean registerEnemy(String identifier, int enemyType, int pointsLost, int pointsGained) {

		Enemy newEnemy = new Enemy(identifier, enemyType, pointsLost, pointsGained);

		 
		for (int i = 0; i < enemies.length; i++) {

			if (enemies[i] == null) {

				enemies[i] = newEnemy;
				return true;
			}
		}
    
    	return false;

	}
	
	public String showEnemies() {

		String msg = "";

		for (int i = 0; i < enemies.length; i++) {

			if (enemies[i] != null) {

				msg += enemies[i].toString();
			}

		}
		return msg;

	}
	
	public boolean registerTreasure(String treasureName, String imageUrl, int treasureValue, int quantity) {

		Treasure newTreasure = new Treasure(treasureName, imageUrl, treasureValue, quantity);

		 
		for (int i = 0; i < treasures.length; i++) {

			if (treasures[i] == null) {

				treasures[i] = newTreasure;
				return true;
			}
		}
    
    	return false;

	}
	
	public String showTreasures() {

		String msg = "";

		for (int i = 0; i < treasures.length; i++) {

			if (treasures[i] != null) {

				msg += treasures[i].toString();
			}

		}
		return msg;

	}
	
	public boolean assignPlayerLevel(int playerPosition, int score){ 
		
		
		for(int i=0; levels.length;i++) {
		
			if (levels[i].getScore()>=score){
				
				players[playerPosition].setLevelPlayer(levels[i]);
				
				return true;
			}
	
		}
	 return false;
	}
	
	public void assignPlayerScore(int playerPosition, int score){ 

		players[playerPosition].setScore(score);
		
	}
	
	
	public boolean addEnemyToLevel(int number, String name){
		
		Enemy newEnemy = null;
		
		for(int j=0; j<enemies.length;j++){
				
			if(!enemies[j].getIdentifier().equals(name)){
		
		     newEnemy = enemies[j];
			}
		
		}
		
		
		if(newEnemy != null){
				
				return levels[number].addEnemy(newEnemy);
	
			}	
	
		
		return false;
		
	}
	
	
	public boolean addTreasureToLevel(int levelNumber, int treasureNumber){
		
	 return levels[levelNumber].addTreasure(treasures[treasureNumber]);
	 
	}
	
}