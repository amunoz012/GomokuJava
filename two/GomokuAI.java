 /* implementation of GoPlayer interface.
  *
  *
  *
  *
  *
  * @author Antonio Munoz
  * @version HW 8, #2
  * @bugs
  */


package two;

import java.awt.*;
import java.util.Random;

public class GomokuAI implements GoPlayer {
    private int[] checkHorizontal(Color c, Stone[][] stones) {
        int[] cords = new int[2];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 19; j++) {
                int count = 0;

                if (stones[i][j].getColor() == c) {
                    count++;
                } else {
                    cords[0] = i;
                    cords[1] = j;
                }
                if (stones[i + 1][j].getColor() == c) {
                    count++;
                } else {
                    cords[0] = i + 1;
                    cords[1] = j;
                }
                if (stones[i + 2][j].getColor() == c) {
                    count++;
                } else {
                    cords[0] = i + 2;
                    cords[1] = j;
                }
                if (stones[i + 3][j].getColor() == c) {
                    count++;
                } else {
                    cords[0] = i + 3;
                    cords[1] = j;
                }
                if (stones[i + 4][j].getColor() == c) {
                    count++;
                } else {
                    cords[0] = i + 4;
                    cords[1] = j;
                }

                if (count == 4 && stones[cords[0]][cords[1]]==Stone.EMPTY)
                    return cords;
                else {
                    cords[0] = -1;
                    cords[1] = -1;
                }
            }
        }
        return cords;
    }
    private int[] checkThree(Color c, Stone[][] stones) {
        int[] cords = new int[2];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 19; j++) {
                if( stones[i][j] == Stone.EMPTY && stones[i+1][j].getColor() == c && stones[i+2][j].getColor() == c &&
                        stones[i+3][j].getColor() == c && stones[i+4][j] == Stone.EMPTY){
                    cords[0] = i;
                    cords[1] = j;
                    return cords;
                }
            }
        }
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 15; j++) {
                if( stones[i][j] == Stone.EMPTY && stones[i][j+1].getColor() == c && stones[i][j+2].getColor() == c &&
                        stones[i][j+3].getColor() == c && stones[i][j+4] == Stone.EMPTY){
                    cords[0] = i;
                    cords[1] = j;
                    return cords;
                }
            }
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if( stones[i][j] == Stone.EMPTY && stones[i+1][j+1].getColor() == c && stones[i+2][j+2].getColor() == c &&
                        stones[i+3][j+3].getColor() == c && stones[i+4][j+4] == Stone.EMPTY){
                    cords[0] = i;
                    cords[1] = j;
                    return cords;
                }
            }
        }
        for (int i = 4; i < 19; i++) {
            for (int j = 0; j < 15; j++) {
                if( stones[i][j] == Stone.EMPTY && stones[i-1][j+1].getColor() == c && stones[i-2][j+2].getColor() == c &&
                        stones[i-3][j+3].getColor() == c && stones[i-4][j+4] == Stone.EMPTY){
                    cords[0] = i;
                    cords[1] = j;
                    return cords;
                }
            }
        }
        cords[0] = -1;
        cords[1] = -1;
        return cords;
    }
    private int[] checkVertical(Color c, Stone[][] stones) {
        int[] cords = new int[2];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 15; j++) {
                int count = 0;

                if (stones[i][j].getColor() == c) {
                    count++;
                } else {
                    cords[0] = i;
                    cords[1] = j;
                }
                if (stones[i][j + 1].getColor() == c) {
                    count++;
                } else {
                    cords[0] = i;
                    cords[1] = j + 1;
                }
                if (stones[i][j + 2].getColor() == c) {
                    count++;
                } else {
                    cords[0] = i;
                    cords[1] = j + 2;
                }
                if (stones[i][j + 3].getColor() == c) {
                    count++;
                } else {
                    cords[0] = i;
                    cords[1] = j + 3;
                }
                if (stones[i][j + 4].getColor() == c) {
                    count++;
                } else {
                    cords[0] = i;
                    cords[1] = j + 4;
                }

                if (count == 4 && stones[cords[0]][cords[1]]==Stone.EMPTY)
                    return cords;
                else {
                    cords[0] = -1;
                    cords[1] = -1;
                }
            }
        }
        return cords;
    }
    private int[] checkRightDiag(Color c, Stone[][] stones) {
        int[] cords = new int[2];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                int count = 0;

                if (stones[i][j].getColor() == c) {
                    count++;
                } else {
                    cords[0] = i;
                    cords[1] = j;
                }
                if (stones[i + 1][j + 1].getColor() == c) {
                    count++;
                } else {
                    cords[0] = i + 1;
                    cords[1] = j + 1;
                }
                if (stones[i + 2][j + 2].getColor() == c) {
                    count++;
                } else {
                    cords[0] = i + 2;
                    cords[1] = j + 2;
                }
                if (stones[i + 3][j + 3].getColor() == c) {
                    count++;
                } else {
                    cords[0] = i + 3;
                    cords[1] = j + 3;
                }
                if (stones[i + 4][j + 4].getColor() == c) {
                    count++;
                } else {
                    cords[0] = i + 4;
                    cords[1] = j + 4;
                }

                if (count == 4 && stones[cords[0]][cords[1]]==Stone.EMPTY)
                    return cords;
                else {
                    cords[0] = -1;
                    cords[1] = -1;
                }
            }
        }
        return cords;
    }
    private int[] checkLeftDiag(Color c, Stone[][] stones) {
        int[] cords = new int[2];
        for (int i = 4; i < 19; i++) {
            for (int j = 0; j < 15; j++) {
                int count = 0;

                if (stones[i][j].getColor() == c) {
                    count++;
                } else {
                    cords[0] = i;
                    cords[1] = j;
                }
                if (stones[i - 1][j + 1].getColor() == c) {
                    count++;
                } else {
                    cords[0] = i - 1;
                    cords[1] = j + 1;
                }
                if (stones[i - 2][j + 2].getColor() == c) {
                    count++;
                } else {
                    cords[0] = i - 2;
                    cords[1] = j + 2;
                }
                if (stones[i - 3][j + 3].getColor() == c) {
                    count++;
                } else {
                    cords[0] = i - 3;
                    cords[1] = j + 3;
                }
                if (stones[i - 4][j + 4].getColor() == c) {
                    count++;
                } else {
                    cords[0] = i - 4;
                    cords[1] = j + 4;
                }

                if (count == 4 && stones[cords[0]][cords[1]]==Stone.EMPTY)
                    return cords;
                else {
                    cords[0] = -1;
                    cords[1] = -1;
                }
            }
        }
        return cords;
    }
    @Override
    public Stone checkWinner(Stone[][] stones) {
        for (int i=0; i< 15; i++){
            for (int j=0; j<19; j++){
                if(stones[i][j] != Stone.EMPTY && stones[i][j]==stones[i+1][j] && stones[i][j]==stones[i+2][j] && stones[i][j]==stones[i+3][j] && stones[i][j]==stones[i+4][j]){
                    return stones[i][j];
                }
            }
        }
        for (int i=0; i< 19; i++){
            for (int j=0; j<15; j++){
                if(stones[i][j] != Stone.EMPTY && stones[i][j]==stones[i][j+1] && stones[i][j]==stones[i][j+2] && stones[i][j]==stones[i][j+3] && stones[i][j]==stones[i][j+4]){
                    return stones[i][j];
                }
            }
        }
        for (int i=4; i< 19; i++){
            for (int j=0; j<15; j++){
                if(stones[i][j] != Stone.EMPTY && stones[i][j]==stones[i-1][j+1] && stones[i][j]==stones[i-2][j+2] && stones[i][j]==stones[i-3][j+3] && stones[i][j]==stones[i-4][j+4]){
                    return stones[i][j];
                }
            }
        }
        for (int i=0; i< 15; i++){
            for (int j=0; j<15; j++){
                if(stones[i][j] != Stone.EMPTY && stones[i][j]==stones[i+1][j+1] && stones[i][j]==stones[i+2][j+2] && stones[i][j]==stones[i+3][j+3] && stones[i][j]==stones[i+4][j+4]){
                    return stones[i][j];
                }
            }
        }
        return Stone.EMPTY;
    }

    @Override
    public int[] getMove(Stone[][] stones) {
        int[] cords = new int[2];
        boolean notTaken = true;
        Random r = new Random();

        while (notTaken){
            cords = checkHorizontal(Color.WHITE, stones);
            if(cords[0] >=0){
                return cords;
            }
            cords = checkVertical(Color.WHITE, stones);
            if(cords[0] >=0){
                return cords;
            }
            cords = checkRightDiag(Color.WHITE, stones);
            if(cords[0] >=0){
                return cords;
            }
            cords = checkLeftDiag(Color.WHITE, stones);
            if(cords[0] >=0) {
                return cords;
            }

            cords = checkHorizontal(Color.BLACK, stones);
            if(cords[0] >=0){
                return cords;
            }
            cords = checkVertical(Color.BLACK, stones);
            if(cords[0] >=0){
                return cords;
            }
            cords = checkRightDiag(Color.BLACK, stones);
            if(cords[0] >=0){
                return cords;
            }
            cords = checkLeftDiag(Color.BLACK, stones);
            if(cords[0] >=0){
                return cords;
            }

            cords = checkThree(Color.WHITE, stones);
            if(cords[0] >=0){
                return cords;
            }
            cords = checkThree(Color.BLACK, stones);
            if(cords[0] >=0){
                return cords;
            }

            cords[0] = r.nextInt(19);
            cords[1] = r.nextInt(19);
            if(stones[cords[0]][cords[1]].getColor() ==null){
                return cords;
            }
        }
        cords[0] = cords[1] =-1;

        return cords;
    }
}
