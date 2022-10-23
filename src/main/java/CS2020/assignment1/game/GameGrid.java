package CS2020.assignment1.game;
public class GameGrid extends AbstractGameGrid{

    //populate the grid with "." characters
	public  void initializeGrid (){
            for(int outerloop = 0; outerloop < gameGrid.length; outerloop++){
                for(int innerloop = 0; innerloop< gameGrid[outerloop].length; innerloop++){
                    gameGrid[outerloop][innerloop] = ".";
                }
        }
            
        
    }
	
	//this should place the ship on the grid using "*" symbol
	public  void placeShip (AbstractBattleShip ship) {
        
    }
	
	//this should generate ships for both player and the opponent 
	public  void generateShips (int numberOfShips) {
        this.ships = new AbstractBattleShip[numberOfShips];
        for(int looper = 0; looper < numberOfShips; looper++){
            BattleShip tempShip = new BattleShip("Ship " + (looper + 1));
            this.ships[looper] = tempShip;
        }
    }   
    public GameGrid(int width, int height, int shipCount){
        this.gameGrid = new String [width][height];
        generateShips(shipCount);
        initializeGrid();
    }
}
