package CS2020.assignment1.game;
import java.util.Scanner;
public class RunGame {
    public static void main(String[] args){ // Main that creates a Game and loops to get each decision made in the game
        Game startGame = new Game(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]));
        System.out.println("Please remember that the grid starts from 0 when selcting the coordinate to hit");
        String userChoice = "";
        Scanner sc = new Scanner(System.in);
        boolean victoryChecker  = false;
        startGame.opponentGrid.printGrid();
        startGame.playerGrid.printGrid();
        while(victoryChecker == false){
           
           try {
            userChoice = sc.nextLine();
            if(userChoice.equals("exit")){
                startGame.exitGame(userChoice);
               }
               else{
                startGame.playRound(userChoice);
               
                victoryChecker = startGame.checkVictory();
               }
    
           } catch (Exception e) {
            System.out.println("Incorrect input");
           }
  
        }
        
        sc.close();
    }
}

