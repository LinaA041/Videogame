package model;

public class Treasure {
	
private String treasureName;
private String imageUrl;
private int treasureValue;
private int quantity;
private int positionX;
private int positionY;

	public Treasure(String treasureName, String imageUrl, int treasureValue, int quantity, int positionX, int positionY ){
		
		this.treasureName = treasureName;
		this.imageUrl = imageUrl;
		this.treasureValue = treasureValue;
		this.quantity = quantity;
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	
	public String getTreasureName(){
		
		return this.treasureName;
	}
	
	public void setTreasureName(String treasureName){
		
		this.treasureName = treasureName;
	}
	
	public String getImageUrl(){
		
		return this.imageUrl;
	}
	
	public void setImageUrl(String imageUrl){
	
     this.imageUrl = imageUrl;
		
	}
	
	public int getTreasureValue(){
		return this.treasureValue;
	}
	
	
	public void setTreasureValue(int treasureValue){
	
     this.treasureValue = treasureValue;
		
	}
	
	public int getQuantity(){
		return this.quantity;
	}
	
	
	public void setQuantity(int quantity){
	
     this.quantity = quantity;
		
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
		
		msg += "\nTreasure info: "
		+"\nTreasure name: "+ this.treasureName
		+"\nUrl of the image: "+this.imageUrl
		+"\nTreasure Value: "+this.treasureValue
		+"\nQuantity: "+this.quantity;
		
		return msg;
	}

}
