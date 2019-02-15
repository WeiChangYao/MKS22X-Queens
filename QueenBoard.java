public class QueenBoard{
  private int[][]board;
  private int size;
  private int count;
  public QueenBoard(int size){
    size = size;
    count = 0;
    board = new int[size][size];
    for (int i = 0; i < size; i++){
      for (int j = 0; j < size; j++){
        board[i][j] = 0;
      }
    }
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
    //checks row of target for -1
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
    if (col >= board.length){  //when it's past last col, return true
      return true;
    }
    for (int i = 0; i < board.length; i++){ 
        if (this.addQueen(i,col)){
          if (solveR(col+1)){ //goes through all columns and rows
            return true;
         }
          this.removeQueen(i,col); //back tracks itf it's false
        } 
      }
      return false;
    }

  public boolean solve(){
    if (board[0][0] != 0){
      throw new IllegalStateException();
    }
    if (board.length == 2 || board.length == 3){ //2 or 3 sized boards are false
      return false;
    }
    return solveR(0);
  } 
 
  public void clear(){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board.length; j++){ //loop through and set 0
        board[i][j] = 0;
      }
    }
  }
  
  public boolean countHelp(int col){
    if (col >= board.length){
      count++;
      return true;
    }
    boolean reset = false;
    for (int i = 0; i < board.length; i++){
        if (addQueen(i,col)){
          if (countHelp(col+1)){    //loops though combinations and if it's true, add to count
            reset = true;
         }
          removeQueen(i,col);
        } 
      }
    return reset;
  }

  
  public int countSolutions(){
    if (board[0][0] != 0){
      throw new IllegalStateException();
    }
    if (board.length == 2 || board.length == 3){ //2 and 3 sized boards are 0
      return 0;
    }
    countHelp(0);
    return count;
  }


  public static void main(String[] args) {
    QueenBoard k = new QueenBoard(5);
    System.out.println(k.countSolutions());
  } 

}
