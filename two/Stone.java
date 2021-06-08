package two;

import java.awt.*;

public enum Stone {
    EMPTY, BLACK, WHITE;

    Color getColor(){
        if (this == BLACK){
            return Color.black;
        }
        else if (this == WHITE){
            return Color.white;
        }
        else if (this == EMPTY){
            return null;
        }
        else{
            return null;
        }
    }
}
