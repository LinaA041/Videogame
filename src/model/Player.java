package model;

public class Player {

private String nickName;
private String name;
private int score;
private int numberLives;
private Level levelPlayer;


	public Player (String nickName, String name){
		
		this.nickName = nickName;
		this.name = name;
		this.score = 10;
		this.numberLives = 5;
		
	}
	
	
	
	public String getNickName (){
		
		return this.nickName;
	}
	
	public void setNickName(String nickName){
		
		this.nickName = nickName;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
	
     this.name = name;
		
	}
	
	public int getScore(){
		return this.score;
	}
	
	public void setScore(int score){
	
     this.score = score;
		
	}
	
	public int getNumberLives(){
		return this.numberLives;
	}
	
	public void setNumberLives(int numberLives){
	
     this.numberLives = numberLives;
		
	}
	
	public Level getLevelPlayer(){
		return this.levelPlayer;
	}
	
	public void setLevelPlayer(Level levelPlayer){
	
     this.levelPlayer = levelPlayer;
		
	}
	
	public String toString(){
		
		String msg = "";
		
		msg += "\nPlayer info: "
		+"\nPlayer Nickname : "+ this.nickName
		+"\nPlayer name: "+this.name
		+"\nScore: "+this.score
		+"\nNumber of lives: "+this.numberLives;
		
		return msg;
	}



}