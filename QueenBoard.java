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
  
  /*private boolean placable( int r, int c) { 
    for (int i = r-1; i >= 0; i--) {
      if(board[i][c] == -1){
        return false;
      }
    }
    for (int i = r-1, j = c-1; i >= 0 && j >= 0; i--, j--) {
      if(board[i][j] == -1){
        return false;
      }
    }
    for (int i = r-1, j = c+1; i >= 0 && j < board.length; i--, j++) {
      if(board[i][j] == 1){
        return false;
      }
    }
    return true; 
  } */
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
  
  public static boolean solveR(QueenBoard bord, int col){
    if (col >= bord.getSize()){
      return true;
    }
    for (int i = 0; i < bord.getSize(); i++){
        if (bord.addQueen(i,col)){
          bord.addQueen(i,col);
          if (solveR(bord, col+1)){
            return true;
          }
        }
        else{
          bord.removeQueen(i,col);
        } 
      }
      return false;
    }
  
 /* public boolean solve(){
    return solveR(board, 0);
  } */
  
 /* public static void main(String[] args) {
    QueenBoard k = new QueenBoard(2);
    System.out.println(k);
    System.out.println();
    if (solveR(k,0) == true){
      solveR(k,0);
      System.out.println(k);
    }
  } */

}