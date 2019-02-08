public class QueenBoard{
  private int[][]board;
  public QueenBoard(int size){
    board = new int[size][size];
    for (int i = 0; i < size; i++){
      for (int j = 0; j < size; j++){
        board[i][j] = 0;
      }
    }
  }
  private boolean addQueen(int r, int c){
    board[r][c] = -1;
    return true;
  }
  private boolean removeQueen(int r, int c){
    board[r][c] = 0;
    return true;
  }
  public String toString(){
    String str = "";
    for (int i = 0; i < size; i++){
      for (int j = 0; j < size; j++){
        if(board[i][j] == -1){
          str += 'Q';
        }
        else{
          str += '_';
        }
      }
      str += '/n'
    }
  }
}
