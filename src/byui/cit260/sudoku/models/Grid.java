package byui.cit260.sudoku.models;
import byui.cit260.sudoku.controls.GameDifficultyControl;
import java.io.Serializable;
import static java.lang.Math.random;
import java.util.*;

/**
 *
 * @author Keith Higbee, Jae Dillree, Josiah Hendricks, Jessie Gomez, Daniel Allen
 */

public class Grid implements Serializable {
    //declare constants
    static final int TOTAL_CELLS = 81;

    //declare variables and arrays
    private int[][] solution;
    private int[][] tempGame;
    private int[][] game;  //generate game array
    private Solution newSolution = new Solution();
    //List<Integer> gameCells = new ArrayList<Integer>();
    
    //constructor    
    public Grid(){        
    }

    public int[][] getSolution() {
        return solution;
    }

    public void setSolution(int[][] solution) {
        this.solution = solution;
    }

    public int[][] getTempGame() {
        return tempGame;
    }

    public void setTempGame(int[][] tempGame) {
        this.tempGame = tempGame;
    }

    public int[][] getGame() {
        return game;
    }

    public void setGame(int[][] game) {
        this.game = game;
    }

    //public List<Integer> getGameCells() {
    //    return gameCells;
    //}

    //public void setGameCells(List<Integer> gameCells) {
    //    this.gameCells = gameCells;
    //}
    
    public void newGame() {        
        //create a valid puzzle solution using setter method
        //call Solution class.createSolution method and pass new array and index = 0
        setSolution(newSolution.createSolution(new int[9][9], 0));
        
        //tempGame = newSolution.copySolution(solution);
        //create a copy of the solution and assign to tempGame
        setTempGame(getSolution());
        
        //displays the tempGame (copy of solution)
        //FOR DEBUGGING PURPOSES ONLY
        //print the copied solution to the screen
        //for (int j = 0; j < tempGame.length; j++) {
        //        for (int k = 0; k < tempGame[j].length; k++) {
        //            System.out.print(tempGame[j][k] + " ");
        //        }
        //        System.out.println();
        //    }
        //System.out.println();
        //*/
        
        //get difficulty - not currently working
        GameDifficultyControl gameDifficulty = new GameDifficultyControl();
        int dif = gameDifficulty.getDifficultyLevel();
        
        //temporary difficultyLevel
        int d = 36;
        
        //game = createGame(tempGame, gameCells); 
        createGame(getTempGame(), d);
        //setGame(game);
    }
    
    //createGame method -- new
    private int[][] createGame(int[][] tmpGame, int difficulty) {
        Random rand = new Random();
        for(int i = 0; i < difficulty; i++){   
            int iRand = rand.nextInt(9); //get random number up to 9
            int jRand = rand.nextInt(9); //get random number up to 9
            if (tmpGame[iRand][jRand] == 0)
                continue;
            else
                tmpGame[iRand][jRand] = 0;
        }
        setGame(tmpGame); 
        //displays the tmpGame (tempGame with zeroes)
        //FOR DEBUGGING PURPOSES ONLY
        //print the game to the screen
        //System.out.println("This is a copy of the solution with zeroes "
        //        + "replacing random elements");
        //for (int j = 0; j < tmpGame.length; j++) {
        //        for (int k = 0; k < tmpGame[j].length; k++) {
        //            System.out.print(tmpGame[j][k] + " ");
        //        }
        //        System.out.println();
        //    }
        //System.out.println();
        return game;
    }
 
    /*private void arrayShuffle() {
        //create new Integer array
        Integer[] numbers = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        //Shuffle integer array
        Collections.shuffle(Arrays.asList(numbers));
        
        System.out.print("Array looks like this = ");
        //for-each loop to print out elements in the numbers array
        for (int num : numbers) {
            System.out.print(num + ", ");
        }
        System.out.println(); //line break
        
        //for-each loop to print out elements in the numbers array
        for (int num : numbers) {
            int indexOfNum = Arrays.asList(numbers).indexOf(num);
            System.out.println("Index " + indexOfNum + " contains: " + num); 
        }
    }*/
}
