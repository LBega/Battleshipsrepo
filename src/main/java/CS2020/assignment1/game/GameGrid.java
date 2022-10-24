package CS2020.assignment1.game;
import java.util.Random;
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
        Random ran = new Random();
        
        int horizontalcoord = ran.nextInt(gameGrid.length);
        int verticalcoord = ran.nextInt(gameGrid[0].length);
        int[][] fullcoords = new int[3][2];

        if(ship.shipOrientation == "horizontal"){
            if(horizontalcoord - 2 < 0){
                for(int coordlooper = 0; coordlooper < 3; coordlooper++){
                    fullcoords[coordlooper][0] = horizontalcoord + coordlooper;
                    fullcoords[coordlooper][1] = verticalcoord;

                    gameGrid[horizontalcoord + coordlooper][verticalcoord] = "*";
                    
                    
                }
            }
            else{
                for(int coordlooper = 0; coordlooper < 3; coordlooper++){
                    fullcoords[coordlooper][0] = horizontalcoord - coordlooper;
                    fullcoords[coordlooper][1] = verticalcoord;
                    
                    gameGrid[horizontalcoord - coordlooper][verticalcoord] = "*";
                    
                    
                }
            }
        }
        else if(ship.shipOrientation == "vertical"){
            if(verticalcoord - 2 < 0){
                for(int coordlooper = 0; coordlooper < 3; coordlooper++){
                    fullcoords[coordlooper][0] = horizontalcoord;
                    fullcoords[coordlooper][1] = verticalcoord + coordlooper;
                    
                    
                    gameGrid[horizontalcoord][verticalcoord + coordlooper] = "*";
                    
                }
            }
            else{
                for(int coordlooper = 0; coordlooper < 3; coordlooper++){
                    fullcoords[coordlooper][0] = horizontalcoord ;
                    fullcoords[coordlooper][1] = verticalcoord - coordlooper;
                    
                    gameGrid[horizontalcoord][verticalcoord - coordlooper] = "*";
                }
            }
        }
        else{
            System.out.println("Error");
        }
        ship.setShipCoordinates(fullcoords);

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
        initializeGrid();
        generateShips(shipCount);
        for(AbstractBattleShip ship: ships){
            placeShip(ship);
        }
    }
}
