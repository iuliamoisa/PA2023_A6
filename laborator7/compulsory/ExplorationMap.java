package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExplorationMap {
    private final List<Token>[][] matrix = new List[4][4];
    //Cell should be a wrapper or alias for List<Token>
    ExplorationMap(){
       for(int i = 0; i < 4; i++)
           for(int j = 0; j < 4; j++)
               matrix[i][j] = new ArrayList<>();
    }
    public boolean visit(
            int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            if (matrix[row][col].isEmpty() == true) {// if the cell is not visited
                List<Token> extractedTokens = robot.explore.getMem().extractTokens(4);// the robot extract tokens
                matrix[row][col].addAll(extractedTokens);// store the tokens in the cell (it becomes visited)
                System.out.println(robot.getName() + ": Tokens extracted successfully.");
            }
            else {
                System.out.println(robot.getName() + ": Couldn't extract tokens");
            }
            return existUnvisitedCells(matrix);
        }

    }
    public boolean existUnvisitedCells(List<Token>[][] matrix){
        for(int i = 0 ; i < 4; i++)
            for(int j = 0; j < 4; j++){
                if(matrix[i][j].isEmpty() == true)
                    return true;
            }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder ceva = new StringBuilder();
        for( int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++){
                ceva.append(matrix[i][j].toString());
                ceva.append(" ");
            }
        return "ExplorationMap{"+ ceva +"}";
    }
}
