package CS2020.assignment1.game;
public class OpponentGameGrid extends GameGrid{
    public void printGrid(){
        System.out.println("Opponent's grid");
        for(int horizontalloop = 0; horizontalloop < gameGrid.length; horizontalloop++){
            for(int verticalloop = 0; verticalloop < gameGrid.length; verticalloop++){
                if(gameGrid[horizontalloop][verticalloop] == "*"){
                    System.out.print(".");
                }
                else{
                  System.out.print(gameGrid[horizontalloop][verticalloop]);  
                }
                
            }   
            System.out.println();
        }
    }
    public OpponentGameGrid(int width, int height, int shipCount){
        super(width, height, shipCount);
    }
}
