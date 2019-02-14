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
    for (i = r, j = c; (j >= 0 && i < board.length); i++, j--){
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
    if (board[0][0] != 0){
      throw new IllegalStateException();
    }
    if (board.length == 2 || board.length == 3){
      return false;
    }
    return solveR(0);
  } 
 
  public void clear(){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board.length; j++){
        board[i][j] = 0;
      }
    }
  }
  
  public int countHelp(int col, int c){
    if (col >= board.length){
      c++;
    }
    for (int i = 0; i < board.length; i++){
        if (this.addQueen(i,col)){
          if (solveR(col+1)){
            c++;
            clear();
         }
          this.removeQueen(i,col);
        } 
      }
      return c;
  }
  
  public int countSolutions(){
    if (board[0][0] != 0){
      throw new IllegalStateException();
    }
    if (board.length == 2 || board.length == 3){
      return 0;
    }
    //real stuff
    return countHelp(0,0);
  }


  public static void main(String[] args) {
    QueenBoard k = new QueenBoard(4);
    System.out.println(k.countSolutions());

  }

}
