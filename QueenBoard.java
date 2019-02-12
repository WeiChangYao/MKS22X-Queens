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
    for (i = 0; i < c; i++){
      if (board[r][i] == -1)
         return false; 
    }
    for (i = r, j = r; (i >= 0 && j >= 0); i--, j--){
      if (board[i][j] == -1) 
         return false; 
    }
    for (i=r, j=c; (j >= 0 && i >= 0); i++, j--){
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
  
  public static boolean solveR(int col)
    if col >= size{
      return true
    }
    for (int i = 0; i < size; i++){
      if (addQueen){
        if solveR(col+1){
          return true;
        }
        else{
          removeQueen;
        }
      }
    }
    return false
  }
  
  public static void main(String[] args) {
    QueenBoard k = new QueenBoard(4);
    System.out.println(k);
    System.out.println();
    k.addQueen(1,1);
    System.out.println(k);
    if(k.placable( 1,-1) == false){
      System.out.println("hi");
    }
  }

}
