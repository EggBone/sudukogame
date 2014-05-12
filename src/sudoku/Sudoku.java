package sudoku;

/**
 *
 * @author Higbee-Keith
 */

public class Sudoku {

    String welcomeMessage =
              "\n\t***********************************************************************"
            + "\n\t* Welcome to the game of Sudoku!                                      *"       
            + "\n\t* More text should go here...                                         *"
            + "\n\t*                                                                     *"
            + "\n\t* Good Luck!!!                                                        *"
            + "\n\t***********************************************************************"
            + "\n";
    
    public Sudoku() {
        
    }
    
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        sudoku.display();
        
        Grid grid = new Grid();
        grid.displaySize();
        
        Game game = new Game();
        game.displayPlayer();
    }
    
    private void display() {
        System.out.println(this.welcomeMessage);
    }
    
}
