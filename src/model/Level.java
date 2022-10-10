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
	
	
	public String toString () {
		
		String msg = "";
		
		msg += "\nLevel info: "
		+"\nIdentifier Number: "+ this.identifierNumber
		+"\nPoints to pass the level: "+this.passingPoints;
		
		return msg;
	}
	
	public boolean addEnemy(Enemy newEnemy){
		
		for(int i=0; i<enemyList.length;i++){
			
			if(enemyList[i]!=null){
			
			    if(enemyList[i].getIdentifier().equals(newEnemy.getIdentifier())){
				
				 return false;
			    }
			
		    }else{
				
				enemyList[i] = newEnemy;
				return true;
				
			}
		
	    }
	    
		return false;
	}
	
	public boolean addTreasure(Treasure newTreasure){
		
		for(int i=0; i<treasureList.length;i++){
			
			if(treasureList[i]==null){
				
				treasureList[i] = newTreasure;
				return true;
				
			}
		
	    }
	    
		return false;
	}
}