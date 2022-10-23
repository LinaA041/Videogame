package model;

public class Level{

private  int identifierNumber;
private int passingPoints;
private Complexity complexityLevel;
private Enemy [] enemyList;
private Treasure [] treasureList;
	
	public Level(int identifierNumber,int complexityLevel, int passingPoints){
		
		this.identifierNumber = identifierNumber;
		this.passingPoints = passingPoints;
		this.complexityLevel = Complexity.values()[complexityLevel];
		this.enemyList = new Enemy [25]; 
		this.treasureList = new Treasure [50];  
	}
	
	public int getIdentifierNumber (){
		
		return this.identifierNumber;
	}
	
	public void setIdentifierNumber(int identifierNumber){
		
		this.identifierNumber = identifierNumber;
	}
	
	public int getPassingPoints(){
		return this.passingPoints;
	}
	
	public void setPassingPoints(int passingPoints){
	
     this.passingPoints = passingPoints;
		
	}
	
	public Complexity getComplexityLevel(){
		
		return this.complexityLevel;
	}
	
	public void setComplexityLevel(Complexity complexityLevel){
		
		this.complexityLevel = complexityLevel;
		
	}
	
	public Treasure [] getTreasureList(){
		
		return this.treasureList;
	}
	
	public void setTreasureList(Treasure [] treasureList){
		
	  this.treasureList = treasureList;
		
	}
	
	public Enemy [] getEnemyList(){
		
		return this.enemyList;
	}
	
	public void setEnemyList(Enemy[] enemyList){
		
		this.enemyList = enemyList;
	}
	
	
	public String toString () {
		
		String msg = "";
		
		msg += "\nLevel info: "
		+"\nIdentifier Number: "+ this.identifierNumber
		+"\nPoints to pass the level: "+this.passingPoints;
		
		return msg;
	}
	
	/**
	 * Description: verifies that the same enemy does not exist within the same level 
	 * pre: none
	 * pos: none
	 * @param myEnemy Enemy object to be checked
	 * @return true boolean
	 * @return false boolean 
	 */
	public boolean checkEnemy(Enemy myEnemy){
		
		for(int i=0; i<enemyList.length;i++){
			
			if(enemyList[i]!=null){
			
				
				 return enemyList[i].getIdentifier().equals(myEnemy.getIdentifier());
			    }
			
		    }
		
		
		return false;
		
	}
	
	/**
	 * Description: Adds an enemy to a given level 
	 * pre: none
	 * pos: none
	 * @param newEnemy Enemy object to be added to the level
	 * @return true boolean if the enemy was added to level
	 * @return false boolean if the enemy could not be added to the level 
	 */
	public boolean addEnemy(Enemy newEnemy){
		
		for(int i=0; i<enemyList.length;i++){
			
			if(checkEnemy(newEnemy)){
				
				return false;
			}
			else {
				
				if(enemyList[i]==null){
				
				enemyList[i] = newEnemy;
				return true;
				
				}
				
			}
		
	    }
	    
		return false;
	}
	
	/**
	 * Description:Adds a treasure to a given level 
	 * pre: none
	 * pos: none 
	 * @param newTreasure Treasure object to be added to the level 
	 * @return true boolean whether the treasure could be added to that specific level 
	 * @return false boolean if the treasure could not be added to that specific level 
	 */
	public boolean addTreasure(Treasure newTreasure){
		
		for(int i=0; i<treasureList.length;i++){
			
			if(treasureList[i]==null){
				
				treasureList[i] = newTreasure;
				return true;
				
			}
		
	    }
	    
		return false;
	}
	

	/**
	 * Description: Calculates the score of the treasures of a level
	 * pre:none 
	 * pos:none
	 * @return score int score awarded by the treasures of a level
	 */
	public int obtainScoreOfTreasures(){
		
     int score = 0;
	 
	    for(int i=0; i<treasureList.length;i++){
		 
		 score = score +treasureList[i].getTreasureValue();
		 
	    }
		
		return score;
		
	}
	
	/**
	 * Description: As its name says, the method seeks to obtain the score of the enemies of a level.
	 * pre: none
	 * pos: none
	 * @return score int score subtracted by the enemies of a level 
	 */
	public int obtainScoreOfEnemies(){
		
     int score = 0;
	 
	    for(int i=0; i<enemyList.length;i++){
		 
		 score = score +enemyList[i].getPointsLost();
		 
	    }
		
		return score;
		
	}
	
	/**
	 * Description: calculates the number of corresponding treasures 
	 * pre: none 
	 * pos: none
	 * @param treasureName String the name of the treasure for which you wish to know the amount.
	 * @return amount int the amount of treasures with that name.
	 */
	public int calculateAmountOfTreasure(String treasureName){
        
		int amount =0;
		
        for( int i=0; i<treasureList.length; i++){
           
		   if(treasureList[i]!=null && treasureList[i].getTreasureName().equalsIgnoreCase(treasureName)){
                
				amount++;
            }
        }
        return amount;

    }
	
    /**
	 * Description: Assesses the existing quantity of any type of enemy 
	 * pre: none 
	 * pos: none 
     * @param enemyType int number corresponding to the type of enemy
     * @return count int the existing quantity of that specific enemy 
     */
    public int obtainQuantityEnemyType(int enemyType){
        
		int count = 0;
        
		Type enemy = null;
		
        switch(enemyType){
            case 0:
                enemy = Type.OGRES;
                break;
            case 1:
                enemy = Type.ABSTRACTS;
                break;
            case 2: 
                enemy = Type.BOSSES;
                break;
            case 3:
                enemy = Type.MAGIC; 
                break; 
            default:
             System.out.println("type a valid option");	
                break;			 
        }
			
			
        for( int i=0; i<enemyList.length;i++){
            
			if( enemyList[i]!=null && enemyList[i].getEnemyType()==enemy){ 
                    
				count++;
				
            }
		}
		 return count; 
    }
	

}

