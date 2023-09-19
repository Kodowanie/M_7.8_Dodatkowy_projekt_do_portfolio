package game.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsObject implements RpsInterface {


    //All necessary variable for program to work
    Scanner scanner = new Scanner(System.in);

    String numberOfGames;
    int numberOfGamesInt;

    String playerMove;
    String playAgain;

    int gamesCounter = 0;
    int playerWin = 0;
    int computerWin = 0;


    public void selectNameForGame(){
        System.out.print("\n" + "Provide player name: ");
        String playerName = scanner.nextLine();
    }


    public void selectNumberOfGames(){
        while(true){
            System.out.print("\n" + "Select number of game you want to play: ");
            numberOfGames = scanner.nextLine();

            if (numberOfGames.matches(".*\\d.*")){
                break;
            }else {
                System.out.println("Illegal value");
            }
        }
        numberOfGamesInt = Integer.parseInt(numberOfGames);
    }


    public void gameMethod(){
        //Select R-P-S
        while (true) {
            while (numberOfGamesInt > gamesCounter) {

                gamesCounter++;
                String comptureMove = rps[new Random().nextInt(rps.length)];

                //Loop check if correctly select R-P-S and if not show "Illegal move"
                while (true) {
                    //Select R-P-S for loop
                    System.out.println("\n" + "Game # " + gamesCounter);
                    System.out.print("Select your number: ");
                    playerMove = scanner.nextLine();
                    if (playerMove.equals("1") || playerMove.equals("2") || playerMove.equals("3")) {
                        break;
                    }
                    System.out.println("Illegal move");
                }

                System.out.println("Computer move: " + comptureMove);

                //Loop to check dependencies R-P-S(what win and lose against what)
                if (playerMove.equals(comptureMove)) {
                    System.out.println("Tie");
                    playerWin++;
                    computerWin++;
                } else if (playerMove.equals("1")) {
                    if (comptureMove.equals("2")) {
                        System.out.println("You loose");
                        computerWin++;
                    } else if (comptureMove.equals("3")) {
                        System.out.println("You win");
                        playerWin++;
                    }
                } else if (playerMove.equals("2")) {
                    if (comptureMove.equals("3")) {
                        System.out.println("You loose");
                        computerWin++;
                    } else if (comptureMove.equals("1")) {
                        System.out.println("You win");
                        playerWin++;
                    }
                } else if (playerMove.equals("3")) {
                    if (comptureMove.equals("1")) {
                        System.out.println("You loose");
                        computerWin++;
                    } else if (comptureMove.equals("2")) {
                        System.out.println("You win");
                        playerWin++;
                    }
                }

                //Count computer and player score
                System.out.println("\n" + "Player win " + playerWin + " times");
                System.out.println("Computer win " + computerWin + " times");

            }
            break;
        }
    }


    public void gameReplay(){
        while(true) {
            //When loop end ask if player want to play again or end the game
            System.out.println("\n" + "Do you want to play again?(y)" + "\n"
                    + "or do you want to end the game?(n)");

            //Loop to ask if user want to play again
            playAgain = scanner.nextLine();

            if (playAgain.equals("y")) {
                gamesCounter = 0;
                gameMethod();
            } else if (playAgain.equals("n")) {
                break;
            } else if (playAgain.equals(playAgain)) {
                System.out.println("Illegal argument");
            }
        }
    }


}
