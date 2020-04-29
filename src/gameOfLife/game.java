package gameOfLife;
import GUI.game_window;
import GUI.start_window;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author kamil
 */

/*
 *  class game -  contains game engine and method main 
 *  it describes the methods of moving living cells
 */
public class game {
    int width = game_window.get_Height();
    int height = game_window.get_Height();
    boolean[][] currentMove = game_window.get_currentMove();
    boolean play = game_window.get_info_play();
    boolean[][] nextMove = new boolean[width][height];
    
    
    /*
        this method checks the number of living neighbors 
        that decides whether the cell will live or die
    */
    protected boolean transitions(int i, int j){
        int neighbors = 0;
        /*
        [*][*][*]
        [ ][ ][ ]
        [ ][ ][ ]
        */
        if(i > 0){
            if(currentMove[i-1][j]) neighbors++; 
            if(j>0) if(currentMove[i-1][j-1]) neighbors++;
            if(j<width-1) if(currentMove[i-1][j+1]) neighbors++;
        }
        /*
        [ ][ ][ ]
        [ ][ ][ ]
        [*][*][*]
        */
        if(i < height-1){
            if(currentMove[i+1][j]) neighbors++;
            if(j>0) if(currentMove[i+1][j-1]) neighbors++;
            if(j<width-1) if(currentMove[i+1][j+1]) neighbors++;
        }
        
        /*
        [ ][ ][ ]
        [*][ ][*]
        [ ][ ][ ]
        */
        if(j>0) if(currentMove[i][j-1]) neighbors++;
        if(j<width-1) if(currentMove[i][j+1]) neighbors++;
        
        if(neighbors == 3) return true; // for all cell whose 2 neighbours -> cell become alive
        if(currentMove[i][j] && neighbors == 2) return true; //for cell whose alive and has 2 neighbors -> cell is still alive
        return false; // for other cells whose have fewer than 2 or more than 3 neighbors 
    }
    
    /*
        this method desrcibe next move 
    */
    public boolean[][] run_nextMove(){
        if(play){
            for(int i = 0; i < width; i++){
                for(int j = 0; j < height; j++){
                    nextMove[i][j] = transitions(i, j);
                }
            }
            for(int i = 0; i < width; i++){
                for(int j = 0; j < height; j++){
                    currentMove[i][j] = nextMove[i][j];
                }
            }
        }
        return currentMove;
    }
    
    public static void main(String args[]){
        start_window main_window = new start_window();
        main_window.setVisible(true);
    }
    
}
