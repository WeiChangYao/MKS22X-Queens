public class QueenBoard{
  private char[][]board;
  public QueenBoard(int size){
    board = new char[size][size];
    for (int i = 0; i < size; i++){
      for (int j = 0; j < size; j++){
        board[i][j] = '_';
      }
    }
  }
  private boolean addQueen(int r, int c){
    board[r][c] = 'Q';
    return true;
  }
}
