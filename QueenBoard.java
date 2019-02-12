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
    for (int i = 0; i < c; i++) 
      if (board[r][i] != -1) {
        board[r][i] = board[r][i] + 1;
      }
    for (int i = 0; i < board.length; i++) 
      if (board[i][c] != -1) {
        board[i][c] = board[i][c] + 1;
      }
    for (int i = r, int j = c; i>=0 && j>=0; i--;) {
      if (board[i][j] != -1) {
        board[i][j] += 1;
        j--;
      }
    }

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
          str += "Q ";
        }
        if(board[i][j] > 0){
          str += "x ";
        } 
        else{
          str += "_ ";
        }
      }
      str += "\n";
    }
    return str;
  }

  public static void main(String[] args) {
    QueenBoard k = new QueenBoard(8);
    System.out.println(k);
    System.out.println();
    k.addQueen(1,1);
    System.out.println(k);
    //k.removeQueen(1,1);
    //System.out.println(k);
  }

}
