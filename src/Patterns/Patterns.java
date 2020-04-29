package Patterns;
import java.awt.Graphics;
import GUI.game_window;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
/**
 *
 * @author kamil
 */

/*
    class patterns - has methods responsible for placing cells
    in accordance with the selected pattern
*/
public class Patterns {

    int width = game_window.get_Width();
    int height = game_window.get_Height();
    boolean[][] move = new boolean[width*2][height*2];
    
    /*
        this method is constructor which indicates the selected pattern by player
    */
    public boolean[][] Patterns(String nameOfPattern, int x, int y){
        if(nameOfPattern == "queen"){
            p_queen(x, y);
        }
        else if(nameOfPattern == "random"){
            p_random();
        }
        else if(nameOfPattern == "tumbler"){
            p_tumbler(x, y);
        }
       return move;
    }
    
    /*
        method p_queen - sets cells in a given shape
        [*][*][ ][ ][ ]
        [ ][ ][*][ ][ ]
        [ ][ ][ ][*][ ]
        [ ][ ][ ][*][ ]
        [ ][ ][ ][*][ ]
        [ ][ ][*][ ][ ]
        [*][*][ ][ ][ ]
    */
    private void p_queen(int x, int y){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 4; j++){
                move[x+i][y+j] = true;
                if(i == 0 || i == 6){
                    if(j >= 2){
                        move[x+i][y+j] = false;
                    }
                }
                else if(i == 1 || i == 5){
                    if(j < 2 || j ==3 ){
                        move[x+i][y+j] = false;
                    }
                }
                else if(i >= 2 || i <= 4){
                    if(j < 3){
                        move[x+i][y+j] = false;
                    }
                }
                shift_space(i, j, x, y);
            }
        }
    }
    
    /*
        method p_tumbler - sets cells in a given shape
        [ ][*][*][ ][*][*][ ]
        [ ][*][*][ ][*][*][ ]
        [ ][ ][*][ ][*][ ][ ]
        [ ][ ][*][ ][*][ ][ ]
        [*][ ][*][ ][*][ ][*]
        [*][*][ ][ ][ ][*][*]
        [ ][ ][ ][ ][ ][ ][ ]
    */
    private void p_tumbler(int x, int y){
        for(int i = 0; i<6; i++){
            for(int j = 0; j<7; j++){
                move[x+i][y+j] = true;
                if(i < 2){
                    if(j == 0 || j == 3 || j == 6){
                        move[x+i][y+j] = false;
                    }
                }
                else if(i == 2){
                    if(j == 0 || j == 1 || j == 3 || j == 5 || j == 6){
                        move[x+i][y+j] = false;
                     }
                }
                else if(i>2 && i < 5){
                    if(j == 1 || j == 3 || j == 5){
                        move[x+i][y+j] = false;
                    }
                }
                else if(i == 5){
                    if(j >= 2 && j < 5){
                        move[x+i][y+j] = false;
                    }
                }
                shift_space(i, j, x, y);
            }
        }
    }
    
    /*
        method shift_space - moves the appropriate cells to the beginning 
        of the board when they go out of the grid while drawing
    */
    private void shift_space(int i, int j, int x, int y){
        if(x + i < width && y + j< height && move[x+i][y+j]){
            move[x+i][y+j] = true;
        }
        else if(x + i < width && y + j >= height && move[x+i][y+j]){
            move[x+i][j-1] = true;
            move[x+i][y+j] = false;
        }
        else if(x+i >= width && y+j >= height && move[x+i][y+j]){
            move[i-1][j-1] = true;
            move[x+i][y+j] = false;
        }
        else if(x+i >= width && y+j< height && move[x+i][y+j]){
            move[i-1][y+j] = true;
            move[x+i][y+j] = false;
        }
    }
    
    /*
        method random - sets lives cells randomly so that they occupy 50% of all cells
    */
    private void p_random(){
        Set<List<Integer>> cords_set = new HashSet<List<Integer>>();
        int alive = width * height/2;
        Random rand = new Random();
        while(cords_set.size() < alive){
            int x = rand.nextInt(width);
            int y = rand.nextInt(height);
            cords_set.add(Arrays.asList((Integer) x, (Integer) y));
        }
        for(List<Integer> cords: cords_set){
            move[cords.get(0)][cords.get(1)] = true;
        }
    } 
}
