package game.rps;


//Ask user for name
//number of game he wants to play
//end of program show score
//if you want to finish the game press "y"
//if you want to play a new game press "n"

//how to construct the project? need to be object oriented
public class RpsRunner {
    public static void main(String[] args) {

        RpsObject rpsObject = new RpsObject();

        System.out.println("\n" + "Welcome to Rock-Paper-Scissors! Please chose one of the 3 options.");
        System.out.println("1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scissors");

        System.out.println("\n" + "Rules:");
        System.out.println("1. Rock beat Scissors");
        System.out.println("2. Paper beat Rock");
        System.out.println("3. Scissors beat Paper");
        System.out.println("4. Tie count as a win for player and computer");

        rpsObject.selectNameForGame();
        rpsObject.selectNumberOfGames();
        rpsObject.gameMethod();
        rpsObject.gameReplay();

    }
}