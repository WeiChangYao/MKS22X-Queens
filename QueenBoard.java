public class QueenBoard{
  private char[][]board;
  public QueenBoard(int size){
    board = new int[size][size];
  }
  private boolean addQueen(int r, int c){
    board[r][c] = 'Q';
    return true;
  }
}
