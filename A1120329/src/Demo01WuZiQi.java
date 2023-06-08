import java.util.Scanner;
public class Demo01WuZiQi {
 //1.建立一個15*15的棋盤
 public static String[][] board = new String[15][15];
 public static Scanner scanner = new Scanner(System.in);
 public static int player = 0;
  public static void main(String[] args) {
  initBoard();   //2.初始化棋盤
  printBoard();  //3.列印棋盤
  startGame();   //4.開始遊戲 }
  private static void startGame() {
  while (!isGameOver()) {
   if (player % 2 == 0) { //黑方下棋
    System.out.println(">>>請黑方下棋");
    playChess("●");
   } else {    //白方下棋
    System.out.println(">>>請白方下棋");
    playChess("○");
   }
   player++;
  }
  System.out.println("Game Over");
 }
  
  public static void initBoard() {
	  for(int i= 0;i< board.length; i++) {
	  for(int j=0;j<board[i].length; j++) {
	      board[i][j] = "+";
	     }  } }
	  

  
 private static boolean isGameOver() {
  for (int x = 0; x < board.length; x++) {
   for (int y = 0; y < board[x].length; y++) {
    if(!board[x][y].equals("+")){
     //向右
     if (y < 11) {
      if(board[x][y].equals(board[x][y+1])
        && board[x][y].equals(board[x][y+2])
        && board[x][y].equals(board[x][y+3])
        && board[x][y].equals(board[x][y+4]))
      {
       return true;
      }     }
     //向下
     if (x < 11) {
      if(board[x][y].equals(board[x+1][y])
        && board[x][y].equals(board[x+2][y])
        && board[x][y].equals(board[x+3][y])
        && board[x][y].equals(board[x+4][y]))
      {
       return true;      }     }
     //向右下
     if (x < 11 && y < 11) {
      if(board[x][y].equals(board[x+1][y+1])
        && board[x][y].equals(board[x+2][y+2])
        && board[x][y].equals(board[x+3][y+3])
        && board[x][y].equals(board[x+4][y+4]))
      {
       return true;      }     }
     //向右上
     if (x > 3 && y < 11) {
      if(board[x][y].equals(board[x-1][y+1])
        && board[x][y].equals(board[x-2][y+2])
        && board[x][y].equals(board[x-3][y+3])
        && board[x][y].equals(board[x-4][y+4]))
      {
       return true;      }     }    }   }  }
  return false;
 }
 private static void playChess(String chess) {
  System.out.print(">>>請輸入棋子的座標：");
  int x = scanner.nextInt() - 1;
  int y = scanner.nextInt() - 1;
  if (board[x][y].equals("+")) {
   board[x][y] = chess;
   printBoard();
  } else {
   System.out.println(">>>此處已有棋  子，請重新輸入");
   player--;
  } }
public static void printBoard() {
 System.out.print(" ");
  //列印列號
 for (int i = 1; i <= board.length; i++) {
  System.out.printf("%-3d",i);
 }
 System.out.println();
 for (int i = 0; i < board.length; i++) {
  //列印行號
  System.out.printf("%-3d",i + 1);
  //列印每一行的棋盤
  for (int j = 0; j < board[i].length; j++){
   System.out.print(board[i][j] + " ");
   }
   System.out.println();
  }
 } 
  }

