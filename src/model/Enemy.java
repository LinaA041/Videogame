package model;


public class Enemy {
	
private String identifier;
private Type enemyType;
private int pointsLost;
private int pointsGained;
private int positionX;
private int positionY;
	
  
	public Enemy (String identifier, int enemyType, int pointsLost, int pointsGained){
		
		this.identifier = identifier;
		this.enemyType = Type.values()[enemyType];
		this.pointsLost = pointsLost;
		this.pointsGained = pointsGained;
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	
	public String getIdentifier(){
		
		return this.identifier;
	}
	
	public void setIdentifier(String identifier){
		
		this.identifier = identifier;
	}
	
	public Type getEnemyType(){
		
		return this.enemyType;
	}
	
	public void setEnemyType(Type enemyType){
	
     this.enemyType = enemyType;
		
	}
	
	public int getPointsLost(){
		return this.pointsLost;
	}
	
	
	public void setPointsLost(int pointsLost){
	
     this.pointsLost = pointsLost;
		
	}
	
	public int getPointsGained(){
		return this.pointsGained;
	}
	
	
	public void setPointsGained(int pointsGained){
	
     this.pointsGained = pointsGained;
		
	}
	
	public int getPositionX(){
		
		return this.positionX;
	}
	
	
	public void setPositionX(int positionX){
	
     this.positionX = positionX;
		
	}
	
	
	public int getPositionY(){
		return this.positionY;
	}
	
	
	public void setPositionY(int positionY ){
	
     this.positionY = positionY;
		
	}
	
	
	public String toString () {
		
		String msg = "";
		
		msg += "\nEnemy info: "
		+"\nEnemy identifier : "+ this.identifier
		+"\nEnemy type: "+this.enemyType
		+"\nSubtracting points : "+this.pointsLost
		+"\nPoints it awards  : "+ this.pointsGained;
		
		return msg;
	}
	
	
	
}