package CS2020.assignment1.game;
import java.util.Random;
public class BattleShip extends AbstractBattleShip{

    public boolean checkAttack (int row,int column){ // This function checks that the shot that is passed in does not hit the BattleShip on any of its coordinates 
        boolean attackHit = false; // Boolean that is returned at the end
        if(hits == 3){ // Checks that the ship has not already taken 3 hits
            attackHit = false;
        }
        else{
        for(int outerloop = 0; outerloop < shipCoordinates.length; outerloop++){
                    if(row == shipCoordinates[outerloop][0] && column == shipCoordinates[outerloop][1]){ // Checks the coordinate of the ship against the shot passed in
                        this.hits++; // Increments hits variable
                        attackHit = true; // Makes the function return true
            }
        }
    } 
    return attackHit;
    }	
	
	public String getName(){
        return this.name;
    }

	public int getHits(){
        return this.hits;
    }
	
	public String getShipOrientation(){

        return this.shipOrientation;
    }
	
	public void setHits(int numberOfHits) {
        this.hits = numberOfHits;

    }
	
	public int[][] getShipCoordinates() {

        return this.shipCoordinates;
    }
	
	public void setShipCoordinates(int [][] coordinates) {
        this.shipCoordinates = coordinates;

    }
    public BattleShip(String incomingname){ // Constructor for BattleShip
        this.name = incomingname; // Variable name is set to the string entered when calling this constructor
        Random ran = new Random();
        int flipInt = ran.nextInt(2); // flipint generates an integer of either 1 or 0 which determines if the ship is horizontal or vertical
        if(flipInt == 1){
            this.shipOrientation = "horizontal";
        }
        else{
            this.shipOrientation = "vertical";
        }
    }
}
