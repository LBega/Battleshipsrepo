package CS2020.assignment1.game;
import java.util.Random;
public class BattleShip extends AbstractBattleShip{
    public boolean checkAttack (int row,int column){
        boolean attackHit = false;
        if(hits == 3){
            attackHit = false;
        }
        else{
        for(int outerloop = 0; outerloop < shipCoordinates.length; outerloop++){
                    if(row == shipCoordinates[outerloop][0] && column == shipCoordinates[outerloop][1]){
                        hits++;
                        attackHit = true;
            }
        }
    } 
    return attackHit;
    }	
	
	public String getName(){
        return name;
    }

	public int getHits(){
        return hits;
    }
	
	public String getShipOrientation(){

        return shipOrientation;
    }
	
	public void setHits(int numberOfHits) {
        hits = numberOfHits;

    }
	
	public int[][] getShipCoordinates() {

        return shipCoordinates;
    }
	
	public void setShipCoordinates(int [][] coordinates) {
        shipCoordinates = coordinates;

    }
    public BattleShip(String incomingname){
        name = incomingname;
        Random ran = new Random();
        int flipInt = ran.nextInt(2);
        if(flipInt == 1){
            shipOrientation = "horizontal";
        }
        else{
            shipOrientation = "vertical";
        }
    }
}
