package CS2020.assignment1.game;
import java.util.Random;
public class Game implements GameControls {

       public void playRound (String input){ // This method takes a string in and converts it into a coordinate to check. It then generates a random coordinate for the computer to shoot at
        boolean hasHit = false;
        int[] coordinateHit = {Character.getNumericValue(input.charAt(0)), Character.getNumericValue(input.charAt(2))};
       
        hasHit = hasShipBeenHit(opponentGrid.ships, coordinateHit, opponentGrid);
        System.out.println("Player is attacking");
        if(hasHit == false){
            opponentGrid.gameGrid[coordinateHit[0]][coordinateHit[1]] = "%";
            System.out.println("MISS!!!");
        }
        System.out.println("Computer is attacking");
        this.opponentGrid.printGrid();
    Random ran = new Random();
        int[] computersHit = {ran.nextInt(this.playerGrid.gameGrid.length),ran.nextInt(this.playerGrid.gameGrid[0].length)} ;
        //System.out.println(computersHit[0] + " " + computersHit[1]);
        hasHit = hasShipBeenHit(playerGrid.ships, computersHit, playerGrid);
        if(hasHit == false){
            playerGrid.gameGrid[computersHit[0]][computersHit[1]] = "%";
            System.out.println("MISS!!!");
            
        }
        this.playerGrid.printGrid();
    }


	public boolean hasShipBeenHit(AbstractBattleShip[] ships, int[] coordinateHit, GameGrid gridAffected){ // This is the code that checks the hit
        boolean hasHit = false;
        for(AbstractBattleShip ship: gridAffected.ships){
            if(ship.checkAttack(coordinateHit[0],coordinateHit[1]) == true){
            gridAffected.gameGrid[coordinateHit[0]][coordinateHit[1]] = "X";
            System.out.println("HIT " + ship.name + "!!!");        
            hasHit = true;
            }
             
        }



        return hasHit;
    }
	
    public boolean checkVictory(){ // This function checks the victory by checking the total amount of hits that all the ships can take and comparing it to the amount of hits the ships have taken. If the two numbers are even then all the ships must have sunk
        int totalPossibleHits = this.playerGrid.ships.length * 3;
        
        boolean victory = false;
       
        if(getTotalHits(this.playerGrid.ships) == totalPossibleHits){
            System.out.println("You have lost!");
            victory = true;
        }
        else if(getTotalHits(this.opponentGrid.ships) == totalPossibleHits){
            System.out.println("You have won!");
            victory = true;
        }
        return victory;
    }


	public int getTotalHits(AbstractBattleShip[] ships){ // This function adds all of the ships hits together
        int totalHits = 0;
        for (AbstractBattleShip ship : ships) {
            totalHits += ship.getHits();
            
        }
        return totalHits;
    }
	
	public void exitGame (String input){ // Exits the game
        System.out.println("Exiting game - thank you for playing");
        Runtime.getRuntime().exit(0);
    }
	
	public AbstractGameGrid getPlayersGrid(){
        return playerGrid;
    }
	
	public AbstractGameGrid getOpponentssGrid(){
        return opponentGrid;
    }
    public PlayerGameGrid playerGrid;
    public OpponentGameGrid opponentGrid;
    public Game(int width, int height, int shipCount){ // Constructor that creates the playerGrid and opponentGrid
        this.playerGrid = new PlayerGameGrid(width,height,shipCount);
        this.opponentGrid = new OpponentGameGrid(width,height,shipCount);
        
    }
}