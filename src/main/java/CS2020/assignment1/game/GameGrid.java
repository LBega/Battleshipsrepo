package CS2020.assignment1.game;
import java.util.Random;
public class GameGrid extends AbstractGameGrid{

    //populate the grid with "." characters
	public  void initializeGrid (){ // Loops through every possible spot to allocate a "."
            for(int outerloop = 0; outerloop < gameGrid.length; outerloop++){
                for(int innerloop = 0; innerloop< gameGrid[outerloop].length; innerloop++){
                    this.gameGrid[outerloop][innerloop] = ".";
                }
        }
            
        
    }
	

	public  void placeShip (AbstractBattleShip ship) {	// This generates the ship coordinates and places them on the grid
        Random ran = new Random();
        
        int horizontalcoord = ran.nextInt(gameGrid.length);
        int verticalcoord = ran.nextInt(gameGrid[0].length);
        int[][] fullcoords = new int[3][2];

        if(ship.shipOrientation == "horizontal"){
            if(horizontalcoord - 2 < 0){
                for(int coordlooper = 0; coordlooper < 3; coordlooper++){
                    fullcoords[coordlooper][0] = horizontalcoord + coordlooper;
                    fullcoords[coordlooper][1] = verticalcoord;

                    this.gameGrid[horizontalcoord + coordlooper][verticalcoord] = "*";
                    
                    
                }
            }
            else{
                for(int coordlooper = 0; coordlooper < 3; coordlooper++){
                    fullcoords[coordlooper][0] = horizontalcoord - coordlooper;
                    fullcoords[coordlooper][1] = verticalcoord;
                    
                    this.gameGrid[horizontalcoord - coordlooper][verticalcoord] = "*";
                    
                    
                }
            }
        }
        else if(ship.shipOrientation == "vertical"){
            if(verticalcoord - 2 < 0){
                for(int coordlooper = 0; coordlooper < 3; coordlooper++){
                    fullcoords[coordlooper][0] = horizontalcoord;
                    fullcoords[coordlooper][1] = verticalcoord + coordlooper;
                    
                    
                    this.gameGrid[horizontalcoord][verticalcoord + coordlooper] = "*";
                    
                }
            }
            else{
                for(int coordlooper = 0; coordlooper < 3; coordlooper++){
                    fullcoords[coordlooper][0] = horizontalcoord ;
                    fullcoords[coordlooper][1] = verticalcoord - coordlooper;
                    
                    this.gameGrid[horizontalcoord][verticalcoord - coordlooper] = "*";
                }
            }
        }
        else{
            System.out.println("Error");
        }
        ship.setShipCoordinates(fullcoords); // Sets the ship coordinates as the vale of fullcoords

    }
	
	//this should generate ships for both player and the opponent 
	public  void generateShips (int numberOfShips) { // This takes the parameter numberOfShips and for loops through that amount generating a ship for each time it loops
        this.ships = new AbstractBattleShip[numberOfShips];
        for(int looper = 0; looper < numberOfShips; looper++){
            BattleShip tempShip = new BattleShip("Ship " + (looper + 1)); // The name of the ship is defined as looper + 1 as the ships names do not start at 0
            this.ships[looper] = tempShip;
        }
    }   
    public GameGrid(int width, int height, int shipCount){ // Constructor that takes in 3 parameters which initialize the gameGrid, generates the ships and places them on the grid
        this.gameGrid = new String [width][height];     
        initializeGrid();
        generateShips(shipCount);
        for(AbstractBattleShip ship: ships){ // Loops through all of the ships and calls the void that places them all down
            placeShip(ship);
        }
    }
}
