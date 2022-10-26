package CS2020.assignment1.game;
import java.util.Random;
public class Game implements GameControls {

       public void playRound (String input){
    boolean hasHit = false;
        int[] coordinateHit = {Character.getNumericValue(input.charAt(0)), Character.getNumericValue(input.charAt(2))};
       
        hasHit = hasShipBeenHit(opponentGrid.ships, coordinateHit);
        if(hasHit == false){
            opponentGrid.gameGrid[coordinateHit[0]][coordinateHit[1]] = "%";
            System.out.println("MISS!!!");
        }
        this.opponentGrid.printGrid();
    Random ran = new Random();
        //int[] computersHit = {ran.nextInt(this.playerGrid.gameGrid.length),ran.nextInt(this.playerGrid.gameGrid.length)} ;
        //hasHit = hasShipBeenHit(playerGrid.ships, coordinateHit);
        //if(hasHit == false){
        //    opponentGrid.gameGrid[computersHit[0]][computersHit[1]] = "%";
        //    System.out.println("MISS!!!");
        //}
    }
	public boolean hasShipBeenHit(AbstractBattleShip[] ships, int[] coordinateHit){
        boolean hasHit = false;
        for(AbstractBattleShip ship: this.opponentGrid.ships){
            for(int shipCoordCheck = 0; shipCoordCheck < 3; shipCoordCheck++){
                if(ship.shipCoordinates[shipCoordCheck][0] == coordinateHit[0] && ship.shipCoordinates[shipCoordCheck][1] == coordinateHit[1]){
                    opponentGrid.gameGrid[coordinateHit[0]][coordinateHit[1]] = "X";
                    System.out.println("HIT " + ship.name + "!!!");
                    hasHit = true;
                }
            }
        }



        return hasHit;
    }
	
		public boolean checkVictory(){
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
	public int getTotalHits(AbstractBattleShip[] ships){
        int totalHits = 0;
        for (AbstractBattleShip ship : ships) {
            totalHits += ship.getHits();
            
        }
        return totalHits;
    }
	
	public void exitGame (String input){

    }
	
	public AbstractGameGrid getPlayersGrid(){
        return playerGrid;
    }
	
	public AbstractGameGrid getOpponentssGrid(){
        return opponentGrid;
    }
    PlayerGameGrid playerGrid;
    OpponentGameGrid opponentGrid;
    public Game(int width, int height, int shipCount){
        this.playerGrid = new PlayerGameGrid(width,height,shipCount);
        this.opponentGrid = new OpponentGameGrid(width,height,shipCount);
        
    }
}
