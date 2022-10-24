package CS2020.assignment1.game;
public class PlayerGameGrid extends GameGrid{
    public void printGrid(){
        System.out.println("Player's grid");
        for(int horizontalloop = 0; horizontalloop < gameGrid.length; horizontalloop++){
            for(int verticalloop = 0; verticalloop < gameGrid.length; verticalloop++){
                System.out.print(gameGrid[horizontalloop][verticalloop]);
            }   
            System.out.println();
        }
    }
    public PlayerGameGrid(int width, int height, int shipCount){
        super(width, height, shipCount);
    }
}
