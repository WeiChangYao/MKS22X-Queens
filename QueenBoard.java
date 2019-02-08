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
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if(board[i][j] == -1){
          str += 'Q';
        }
        else{
          str += '_';
        }
      }
      str += "\n";
    }
    return str;
  }

  public static void main(String[] args) {
    QueenBoard k = new QueenBoard(8);
    System.out.println(k);
  }

}
