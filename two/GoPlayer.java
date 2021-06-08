package two;

public interface GoPlayer {
    public Stone checkWinner(Stone[][] stones);
    public int[] getMove(Stone[][] stones);
}
