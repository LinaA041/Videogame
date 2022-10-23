package ui;

import model.VideoGameController;

import java.util.Scanner;

// Description: this program simulates a video game and the different requirements it may have, such as,
// registering players, adding treasures to a level, knowing the most repeated treasure, among others...

 public class VideoGameManager {
	
	public static Scanner sc = new Scanner(System.in);
	public static VideoGameController gameController = new VideoGameController ();
	
	
	public static void main(String[] args){
		
	 level();
		
	 menu();
	 
    }
	
	/**
	 * Description:is responsible for recording, displaying and storing 
	 * the ten levels with their respective points. 
	 * pre:none
	 * pos: none
	 * @return not return
	 */
	private static void level(){
		
		
		boolean exit = false;
		int count = 0;


		while (!exit) {	
		
		System.out.println("Welcome administrator!");
        System.out.println("before you start, please register your levels, please");
		
		System.out.println("1.Record levels");
		System.out.println("2.View registered levels");
	    System.out.println("3.Exit");
		int choice = sc.nextInt();
	
		 switch (choice) {
			 
			case 1:
			while(count<10){
				System.out.println("type the level identifier number ");
				int identifierNumber = sc.nextInt();
				
				System.out.println("Type the points needed to pass the level  ");
				int passingPoints = sc.nextInt();
				
				if (gameController.registerLevel(identifierNumber,passingPoints)) {

					System.out.println("level successfully registered");
                    count+=1;
				} else {
					System.out.println("Error,level could not be registered");
				}
			} break;
			 
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
	
	/**
	 * Description: Displays by console the possible options that the user can choose from 
	 * pre: none
	 * pos: none
	 * @return not return
	 */
	private static void menu(){
	
		boolean exit = false;

		while (!exit) {	
			
			System.out.println("Type an option\n1.Register Player\n2.Show Players\n3.Register Enemy\n4.Show enemies");
			System.out.println("5.Register Treasure\n6.Show Treasures\n7.Add an enemy to a level\n8.Add a treasure to a level");
			System.out.println("9.modify the player's score\n10.Assign player level\n11.Know the treasures and enemies of a level");
			System.out.println("12.To know the amount of treasure at all levels\n13.To know the amount of one type of enemy at all levels");
			System.out.println("14.Know the most repeated treasure \n15.Know the enemy that gives the highest score and the level where it is located.");
			System.out.println("16.Report the number of consonants found in the names of the enemies in the game\n17.Top 5 players with the highest score");
			System.out.println("18.Exit");
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
			    assignPlayerScore();
			   break;
			case 10:
			    assignPlayerLevel();
			  break;
			case 11:
			    reportTreasuresAndEnemies();
			  break;
			case 12:
			     amountOfATreasure();
			  break;
			case 13:
			    calculateQuantityOfEnemyType();
			  break;
			case 14: 
			   System.out.println(gameController.reportingRepeatedTreasure());
			   break;
			case 15:
			   System.out.println(gameController.obtainEnemyWhoAwardsMostPoints());
			  break;
			case 16:
			  System.out.println(gameController.obtainNumberOfEnemyConsonants());
			  break;
			case 17:
			   System.out.println(gameController.consultTopFivePlayers());
			  break;
			case 18:
				exit = true;
				System.out.println("Thanks for using our system");
				break;
			default:
				System.out.println("You must type a valid option");
				break;
			}
			
		}
		
	}
	
	/**
	 * Description: This metod request by console the data of the player to be registered and 
	 * saves it in the respective array.
	 * pre: none
	 * pos: none
	 * @return: not return
	 */
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
	

	/**
	 * Description:Requests the necessary data to register an enemy and to be able to locate him in the array. 
	 * pre:none
	 * pos:none
	 * @return: not return
	 */
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
	
	 /**
	 * Description: Prompts the user for data about the treasure to be registered 
	 * pre: none
	 * pos: none
	 * return: not return
	 */
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
	
	/**
	 * Description: Places the player in the corresponding level 
	 * pre:none
	 * pos: none
	 * @return not return
	 */
	private static void assignPlayerLevel(){
		
		System.out.println(gameController.showPlayers());
		int playerPosition = sc.nextInt();
	
		System.out.println(gameController.showLevels());
		int levelPosition = sc.nextInt();
		
		System.out.println("Type the player's score");
		int score = sc.nextInt();
		
		gameController.incrementPlayerLevel(playerPosition,levelPosition, score);
		
	       System.out.println("Player has already been assigned to the corresponding level");
	}	
	
	/**
	 * Description: Allows to change the score of the player indicated by the user 
	 * pre:none
	 * pos:none
	 * @return not return
	 */
	private static void assignPlayerScore(){
		
		System.out.println(gameController.showPlayers());
		
		int playerPosition = sc.nextInt();
		
		System.out.println("Digite el nuevo puntaje del jugador");
		int score = sc.nextInt();
		
		gameController.assignPlayerScore(playerPosition,score);
		
	    System.out.println("el puntaje del jugador fue cambiado con exito");
		
	}
	
	/**
	 * Description: Displays the list of existing enemies and places it at the level desired by the user 
	 * pre: none
	 * pos: none 
	 * @return not return 
	 */
	private static void addEnemyToLevel(){
		
		System.out.println(gameController.showLevels());
		
		int numberLevel = sc.nextInt();
		
		System.out.println(gameController.showEnemies());
		
		int enemyPosition = sc.nextInt();
		
		if(gameController.addEnemyToLevel(numberLevel, enemyPosition)){
			
		  System.out.println("Enemy was successfully added to the level");
			
		}else {
			
		  System.out.println("Error,enemy could not be added to the level");
			
		}
		
	}
	
	/**
	 * Description: As the name says, adds or assigns a treasure to a given level 
	 * pre:none
	 * pos:none
	 * @return: no return
	 */
	private static void addTreasureToLevel(){
		
		System.out.println(gameController.showLevels());
		
		int levelNumber = sc.nextInt();
		
		System.out.println(gameController.showTreasures());
		sc.nextLine();
		int treasureNumber = sc.nextInt();
		
		if(gameController.addTreasureToLevel(levelNumber, treasureNumber)){
			
		  System.out.println("The treasure was successfully added to the level");
			
		}else {
			
		  System.out.println("Error,treasure could not be added to the level");
			
		}
		
	}
	
	/**
	 * Description: Gets the report of the number of enemies and treasures located in a level previously
	 * indicated by the user
	 * pre: none
	 * pos: none
	 * @return not return
	 */
	private static void reportTreasuresAndEnemies (){
		
		System.out.println("A continuacion, elija el nivel del cual desea el informe");
		
		System.out.println(gameController.showLevels());
		
		int levelPosition = sc.nextInt();
		
		gameController.reportNumberEnemiesAndLevels(levelPosition);
		
	}
		
	/**
	 * Description:Displays the treasures by console and prompts the user to enter the name of the treasure
	 * for which he/she wishes to know the amount avaible.
	 * pre: none
	 * pos: none
	 * @return not return
	 */
	private static void amountOfATreasure(){
		
		System.out.println(gameController.showTreasures());
		
		System.out.println("Type the name of the treasure you wish to consult");
		String treasureName = sc.nextLine();
		
		gameController.amountOfATreasure(treasureName);
		
	}
	
	/**
	 * Description:Displays by console the existing types of enemies and calls the method that will
	 * calculate the exisiting quantity of such enemy.
	 * pre: none
	 * pos: none
	 * @return no return
	 */
	private static void calculateQuantityOfEnemyType(){
		
		System.out.println("Type in the number that corresponds to the type of enemy you want");
		System.out.println("0.Ogres\n1.Abstracts\n2.Bosses\n3.Magic");
		int enemyType = sc.nextInt();
		
		 System.out.println(gameController.calculateQuantityOfEnemyType(enemyType));
	}
}