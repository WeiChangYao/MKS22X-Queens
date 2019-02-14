public class QueenBoard{
  private int[][]board;
  private int size;
  public QueenBoard(int size){
    size = size;
    board = new int[size][size];
    for (int i = 0; i < size; i++){
      for (int j = 0; j < size; j++){
        board[i][j] = 0;
      }
    }
  }
  private int getSize(){
    return size;
  }
  private boolean addQueen(int r, int c){
    if(placable(r,c) == true){
      board[r][c] = -1;
      return true;
    }
    return false;
  }
  private boolean removeQueen( int r, int c){
    board[r][c] = 0;
    return true;
  }

  private boolean placable( int r, int c) {
    int i, j;
    //checks left of target for -1
    for (i = 0; i < c; i++){
      if (board[r][i] == -1)
         return false;
    }
    //checks row of target
    for (i = 0; i < board.length; i++){
      if (board[i][c] == -1)
         return false;
    }
    //checks top left diag for -1
    for (i = r, j = c; (i >= 0 && j >= 0); i--, j--){
      if (board[i][j] == -1)
         return false;
    }
    //cheskcs bottom left diag for -1
    for (i = r, j = c; (j >= 0 && i >= board.length); i++, j--){
      if (board[i][j] == -1)
         return false;
       }
    return true;
}

  public String toString(){
    String str = "";
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if(board[i][j] == -1){
          str += "Q ";
        }
        else{
          str += "_ ";
        }
      }
      str += "\n";
    }
    return str;
  }

  public boolean solveR(int col){
    if (col >= board.length){
      return true;
    }
    for (int i = 0; i < board.length; i++){
        if (this.addQueen(i,col)){
          if (solveR(col+1)){
            return true;
          }
          this.removeQueen(i,col);
        } 
      }
      return false;
    }

  public boolean solve(){
    return solveR(0);
  } 

  public static void main(String[] args) {
    QueenBoard k = new QueenBoard(2);
    System.out.println(k);
   /* k.addQueen(2,1);
    System.out.println(k);
    k.addQueen(1,2);
    k.addQueen(2,2);
    k.addQueen(3,2);
    System.out.println(k);
    System.out.println(); */
      k.solve();
      System.out.println(k);
  }

}
