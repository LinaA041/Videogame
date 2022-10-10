package ui;

import model.VideoGameController;

import java.util.Scanner;

 public class VideoGameManager {
	
	public static Scanner sc = new Scanner(System.in);
	public static VideoGameController gameController = new VideoGameController ();
	
	
	public static void main(String[] args){
		
	 level();
		
	 menu();
	 
    }
	
	private static void level(){
		
		
		boolean exit = false;

		while (!exit) {	
		
		System.out.println("Welcome administrator!");
        System.out.println("before you start, please register your levels, please");
		
		System.out.println("1.Record levels");
		System.out.println("2.View registered levels");
	    System.out.println("3.Exit");
		int choice = sc.nextInt();
		
		int count = 0;
			
		 switch (choice) {
			 
			case 1:
			
			while(count<10){
				System.out.println("type the level identifier number ");
				int identifierNumber = sc.nextInt();
				
				System.out.println("type the level identifier number ");
				int passingPoints = sc.nextInt();
				
				if (gameController.registerLevel(identifierNumber,passingPoints)) {

					System.out.println("level successfully registered");

				} else {
					System.out.println("Error,level could not be registered");
				}
			}
             break;
			 
			case 2: 
			System.out.println(gameController.showLevels());
			break;
			
			default:
			if(count!=0){		
				exit = true;
				break;
			}
	        }
			
		}
	}
	
	private static void menu(){
	
		boolean exit = false;

		while (!exit) {	
			
			System.out.println("Type an option\n1.Register Player\n2.Show Players\n3.Register Enemy\n4.Show enemies");
			System.out.println("5.Register Treasure\n6.Show Treasures\n7.Add an enemy to a level\n8.Add a treasure to a level");
			System.out.println("9.modify the player's score\n10.Assign player level\n11.Exit");
			int option = sc.nextInt();
			
		
			switch (option) {
            
			case 1:
			  registerPlayer();
			  break;
			case 2:
			  System.out.println(gameController.showPlayers());
			  break;
			case 3: 
			  registerEnemy();
			   break; 
			case 4: 
			  System.out.println(gameController.showEnemies());
	          break;
			case 5:
			  registerTreasure();
			  break;
			case 6:
			  System.out.println(gameController.showTreasures());
			  break;
			case 7:
			   addEnemyToLevel();
			   break;
			case 8: 
			   addTreasureToLevel();
			   break;
			case 9:
			    //requirement in process 
			   break;
			case 10:
			  //requirement in process
			  break;
			case 11:
				exit = true;
				System.out.println("Thanks for using our system");
				break;
			default:
				System.out.println("You must type a valid option");
				break;
			}
			
		}
		
	}
	
	private static void registerPlayer(){

	  System.out.println("Enter the player's nickname ");
	  sc.nextLine();
	  String nickName = sc.nextLine();

      System.out.println("Enter the player's name");
	  String name = sc.nextLine();

		if (gameController.registerPlayer(nickName, name)) {

			System.out.println("player successfully registered");

		} else {
			System.out.println("Error,player could not be registered");
		}

	}
	
	private static void registerEnemy(){
		
		System.out.println("Type the name of the enemy");
		String identifier = sc.nextLine();
		
		System.out.println("What kind of enemy is it?\n0.OGRO\n1.ABSTRACTOS\n2.JEFES\n3.MAGICOS");
		int enemyType = sc.nextInt();
		
		System.out.println("type the remaining score in case you don't defeat the enemy");
		int pointsLost = sc.nextInt();
		
		System.out.println("type the score you get when defeating it");
		int pointsGained = sc.nextInt();
		
		if (gameController.registerEnemy(identifier, enemyType,pointsLost, pointsGained)) {

			System.out.println("Enemy successfully registered");

		} else {
			System.out.println("Error,enemy could not be registered");
		}

		
	}
	
	private static void registerTreasure(){
		
		System.out.println("Type the name of the treasure ");
		String treasureName = sc.nextLine();
		
		System.out.println("Type the url of the image corresponding to the treasure");
		String imageUrl = sc.nextLine();
		
		System.out.println("What score does this treasure give?");
		int treasureValue = sc.nextInt();
		
		System.out.println("How many treasures will it register for the same level?");
		int quantity = sc.nextInt();
		
		
		if (gameController.registerTreasure(treasureName, imageUrl, treasureValue, quantity)) {

			System.out.println("Treasure successfully registered");

		} else {
			System.out.println("Error,treasure could not be registered");
		}	
		
	}
	
	private static void assignPlayerLevel(){
		
		System.out.println(gameController.showPlayers());
		int playerPosition = sc.nextInt();
		
		System.out.println("Digite el puntaje del jugador");
		int score = sc.nextInt();
		
		if(gameController.assignPlayerLevel(playerPosition,score))
		
	       System.out.println("Player has already been assigned to the corresponding level");

		} else {
			System.out.println("Error, player level could not be assigned");
		}	
		
		
	}
	
		private static void assignPlayerScore(){
		
		System.out.println(gameController.showPlayers());
		int playerPosition = sc.nextInt();
		
		System.out.println("Digite el nuevo puntaje del jugador");
		int score = sc.nextInt();
		
		gameController.assignPlayerLevel(playerPosition,score)
		
	       System.out.println("el puntaje del jugador fue cambiado con exito");

			
		
		
	}
	
	private static void addEnemyToLevel(){
		
		System.out.println(gameController.showLevels());
		
		int number = sc.nextInt();
		
		System.out.println(gameController.showEnemies());
		sc.nextLine();
		String name = sc.nextLine();
		
		if(gameController.addEnemyToLevel(number, name)){
			
		  System.out.println("Enemy was successfully added to the level");
			
		} else {
			
		  System.out.println("Error,enemy could not be added to the level");
			
		}
		
	}
	
	private static void addTreasureToLevel(){
		
		System.out.println(gameController.showLevels());
		
		int levelNumber = sc.nextInt();
		
		System.out.println(gameController.showTreasures());
		sc.nextLine();
		String treasureNumber = sc.nextLine();
		
		if(gameController.addTreasureToLevel(levelNumber, treasureNumber)){
			
		  System.out.println("The treasure was successfully added to the level");
			
		} else {
			
		  System.out.println("Error,treasure could not be added to the level");
			
		}
		
	}
	
	
	
}